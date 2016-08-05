package com.acsp.cic.batch.data.stream;

import static org.jooq.impl.DSL.inline;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.DSL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.constants.InstallmentConstantField;
import com.acsp.cic.batch.data.stream.DataStream;

@Component
public class InstallmentDataStream implements DataStream {

	@Autowired
	protected DSLContext jooq;
	
	@Value("${cic.providercode}")
	private String providercode;
	
	@Value("${cic.contracttype}")
	private String contracttype;
	
	private Field<?>[] generateSQLInLine(int[] status) {
		 Field<?>[] fields = new Field[status.length];
		 for (int i = 0; i < status.length; i++)
		        fields[i] =  inline(status[i]);
		 
		 return fields;
	}
	
	@Override
	public Stream <Record> getStream() {
		return selectSubmissionDataFile().stream();
	}
	
	private Result<Record> selectSubmissionDataFile() {
		
		Date dt = new Date();
		String date_format = "yyyyMMdd";
		SimpleDateFormat sdf = new SimpleDateFormat(date_format);
		String cd = sdf.format(dt);
		String currentdate = "'" + cd.substring(0,6) + "'";
		
		
		String CONTRACTPHASE= ",CASE WHEN AGREEMENTSTATUS = '4' OR AGREEMENTSTATUS='1' OR AGREEMENTSTATUS='2' THEN 'AC'"
				+ " WHEN AGREEMENTSTATUS=8 OR AGREEMENTSTATUS='14' THEN 'RN'"
				+ " WHEN AGREEMENTSTATUS IN (6,11) THEN 'CL'"
				+ " WHEN AGREEMENTSTATUS=5 THEN 'CA' END CONTRACTPHASE";
		
		String CONTRACTSTATUS = ",CASE WHEN T_AGREEMENT.AGREEMENTSTATUS = '9' THEN 'RP'"
				+ " WHEN T_AGREEMENT.AGREEMENTSTATUS=8 THEN 'WO'"
				+ " WHEN (T_CREDIT.DELAYSTATUS>0 AND T_CREDIT.DELAYSTATUS <=7) THEN 'PD' END CONTRACTSTATUS";
		
		String STARTDATE= ",TO_CHAR(TO_DATE(T_AGREEMENT.SALEDATE,'YYYYMMDD'), 'DDMMYYYY') STARTDATE";
		
		String REQUESTDATE= ",TO_CHAR(TO_DATE(T_AGREEMENT.AGREEMENTDATE,'YYYYMMDD'), 'DDMMYYYY') REQUESTDATE";
		
		String CONTRACTENDPLANNEDDATE= ",CASE WHEN T_AGREEMENT.AGREEMENTSTATUS IN (4,1,2,6,5,11) "
			+ "THEN TO_CHAR(TO_DATE(T_PAYSTAGESAGREEMENT.HPLASTDAY,'YYYYMMDD'), 'DDMMYYYY') END CONTRACTENDPLANNEDDATE";
			
		
		String OVERDUE = ",CASE WHEN DELAYSTATUS IN (0,1,2,3) THEN DELAYSTATUS"
				+ " WHEN DELAYSTATUS IN (4,5,6) THEN 4"
				+ " WHEN DELAYSTATUS = 7 THEN CASE WHEN OVERDUECOUNT >= 7 AND OVERDUECOUNT<13 THEN 5 ELSE 6 END"
				+ " WHEN DELAYSTATUS IN (8,9) THEN 0"
				+ " WHEN DELAYSTATUS = 11 THEN 0 "
				+ " END OVERDUEDAYS";
	
		 String SQLMain = "(SELECT T_AGREEMENT.AGREEMENTCD,M_CUSTOMER.CUSTOMERCD"
				+ CONTRACTPHASE + CONTRACTSTATUS  + CONTRACTENDPLANNEDDATE + STARTDATE + REQUESTDATE
				+ ",ROUND(T_PAYSTAGESAGREEMENT.HPPRICE,0) AS HPPRICE"
				+ ",ROUND(T_PAYSTAGESAGREEMENT.FINANCEPRICE) FINANCEPRICE"
				+ ",T_PAYSTAGESAGREEMENT.NUMBEROFINSTALMENT AS NUMBEROFINSTALLMENT"
				+ ",TO_CHAR(TO_DATE(T_PAYSTAGESAGREEMENT.HPFIRSTDAY,'YYYYMMDD'), 'DDMMYYYY') HPFIRSTDAY"
				//+ ",ROUND(T_PAYSTAGESAGREEMENT.MONTHLYPAYMENT) AS MONTHLYPAYMENT"
				+ " FROM T_AGREEMENT"
				+ " INNER JOIN T_PAYSTAGESAGREEMENT ON T_AGREEMENT.AGREEMENTCD =T_PAYSTAGESAGREEMENT.AGREEMENTCD"
				+ " LEFT JOIN M_CUSTOMER ON M_CUSTOMER.CUSTOMERCD = T_AGREEMENT.CUSTOMERCD"
				+ " LEFT JOIN T_CREDIT ON T_CREDIT.AGREEMENTCD = T_AGREEMENT.AGREEMENTCD"
				+ " WHERE T_AGREEMENT.AGREEMENTTYPE = 1 AND T_AGREEMENT.AGREEMENTSTATUS NOT IN (3,14)) MAIN";
		 
		 String SQLLastPaymentDate = "(SELECT DISTINCT T_CREDIT.AGREEMENTCD, TO_CHAR(TO_DATE(T_CREDIT.LASTPAYMENTDATE,'YYYYMMDD'), 'DDMMYYYY') AS LASTPAYMENTDATE "
				 + " FROM T_CREDIT INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_CREDIT.AGREEMENTCD) TBLLastPaymentDate";
		 
		 String SQLMonthlyPaymentAmount = "(SELECT T_PAYMENT.AGREEMENTCD,ROUND(AVG(T_PAYMENT.PAYMENT)) MONTHLYPAYMENT"
					+ " FROM T_PAYMENT INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_PAYMENT.AGREEMENTCD"
					+ " WHERE AGREEMENTSTATUS IN (1,2,4,5,6) "
					+ " GROUP BY T_PAYMENT.AGREEMENTCD) TBLMonthlyPaymentAmount";
		 
		 String SQLContactEndActualDate = "(SELECT DISTINCT T_PAYMENT.AGREEMENTCD,TO_CHAR(TO_DATE(MAX(T_PAYMENT.PAYMENTDATE),'YYYYMMDD'), 'DDMMYYYY') AS CONTRACTENDACTUAL"
				 + " FROM T_PAYMENT INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_PAYMENT.AGREEMENTCD"
				 + " GROUP BY T_PAYMENT.AGREEMENTCD) TBLContactEndActualDate";
		 
		 /*String SQLContactEndActualDate = "(SELECT AGREEMENTCD"
		 		 + " ,CASE WHEN AGREEMENTSTATUS IN (6,11,5) THEN CONTRACTENDACTUAL ELSE NULL END CONTRACTENDACTUAL FROM"
		 		 + " (SELECT DISTINCT  T_PAYMENT.AGREEMENTCD,T_AGREEMENT.AGREEMENTSTATUS"
		 		 + " ,TO_CHAR(TO_DATE(MAX(T_PAYMENT.PAYMENTDATE),'YYYYMMDD'), 'DDMMYYYY') AS CONTRACTENDACTUAL"
		 		 + "  FROM T_PAYMENT INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_PAYMENT.AGREEMENTCD"
				 + " GROUP BY T_PAYMENT.AGREEMENTCD, T_AGREEMENT.AGREEMENTSTATUS)) TBLContactEndActualDate";*/
		 
		 String SQLLastPaymentAmount = "(SELECT T_MONTHLYCREDIT.AGREEMENTCD"
			 		+ ",ROUND(SUM(REALPAYPRINCIPAL+REALPAYINTEREST+REALPAYCOMPENSATION+REALPAYCOLLECTIONCHARGE+COMPENSATION)) LASTPAYMENTAMOUNT"
			 		+ " FROM T_MONTHLYCREDIT"
			 		+ " INNER JOIN (  SELECT MAX(T_MONTHLYCREDIT.PAYMENTYEARMONTH) AS LASTPAYMENT"
			 		+ " ,T_MONTHLYCREDIT.AGREEMENTCD"
			 		+ " FROM T_MONTHLYCREDIT LEFT JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_MONTHLYCREDIT.AGREEMENTCD"
			 		+ " AND T_AGREEMENT.AGREEMENTSTATUS IN (1,2,4,5,6) AND T_MONTHLYCREDIT.REALPAYPRINCIPAL > 0"
			 		+ " GROUP BY T_MONTHLYCREDIT.AGREEMENTCD) TABLE1"
			 		+ " ON TABLE1.LASTPAYMENT = T_MONTHLYCREDIT.PAYMENTYEARMONTH AND TABLE1.AGREEMENTCD = T_MONTHLYCREDIT.AGREEMENTCD"
			 		+ " GROUP BY T_MONTHLYCREDIT.AGREEMENTCD) TBLLastPaymentAmount";
		 
		 String SQLOustandingBalance ="(SELECT DISTINCT TABLE1.AGREEMENTCD"
			  		+ ",ROUND(SUM(PRINCIPAL+INTEREST+COMPENSATION+COLLECTION)) BALANCE "
			  		+ " FROM ( SELECT T_AGREEMENT.AGREEMENTCD"
			  		+ ",SUM(BALANCEPRINCIPALTOTAL) PRINCIPAL,SUM(BALANCEINTERESTTOTAL) INTEREST"
			  		+ ",SUM(BALANCECOMPENSATION) COMPENSATION,SUM(BALANCECOLLECTIONCHARGE) COLLECTION"
			  		+ " FROM T_CREDITDETAIL"
			  		+ " INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_CREDITDETAIL.AGREEMENTCD"
			  		+ " WHERE T_AGREEMENT.AGREEMENTSTATUS IN (1,2,4)"
			  		+ " GROUP BY T_AGREEMENT.AGREEMENTCD)TABLE1"
			  		+ " GROUP BY AGREEMENTCD) TBLOustandingBalance";
		 
		 String SQLOustandingPaymentNumber = "(SELECT AGREEMENTCD"
			 		+ ",CASE WHEN NUMOFINSTALLMENT IS NULL THEN NUMBEROFINSTALMENT"
			 		+ " WHEN PRINCIPAL = 0 THEN 0 ELSE OUSTANDINGPAYMENTNUM"
			 		+ " END REMAININGINSTALLMENTS"
			 		+ " FROM (SELECT T_PAYSTAGESAGREEMENT.AGREEMENTCD"
			 		+ ",T_PAYSTAGESAGREEMENT.NUMBEROFINSTALMENT"
			 		+ ",TABLE1.NUMOFINSTALLMENT"
			 		+ ",(T_PAYSTAGESAGREEMENT.NUMBEROFINSTALMENT-TABLE1.NUMOFINSTALLMENT) OUSTANDINGPAYMENTNUM"
			 		+ ",SUM(BALANCEPRINCIPALTOTAL) PRINCIPAL"
			 		+ " FROM T_PAYSTAGESAGREEMENT"
			 		+ " INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_PAYSTAGESAGREEMENT.AGREEMENTCD"
			 		+ " INNER JOIN T_CREDITDETAIL ON T_CREDITDETAIL.AGREEMENTCD = T_PAYSTAGESAGREEMENT.AGREEMENTCD"
			 		+ " LEFT JOIN (SELECT COUNT(*) NUMOFINSTALLMENT ,T_MONTHLYCREDIT.AGREEMENTCD"
			 		+ " FROM T_MONTHLYCREDIT INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_MONTHLYCREDIT.AGREEMENTCD"
			 		+ " INNER JOIN T_PAYSTAGESAGREEMENT ON T_PAYSTAGESAGREEMENT.AGREEMENTCD = T_MONTHLYCREDIT.AGREEMENTCD"
			 		+ " WHERE T_AGREEMENT.AGREEMENTSTATUS IN (1,2,4)"
			 		+ " AND T_MONTHLYCREDIT.REALPAYPRINCIPAL >= T_MONTHLYCREDIT.NEEDPAYPRINCIPAL"
			 		+ " AND T_MONTHLYCREDIT.PAYMENTTIMES <= T_PAYSTAGESAGREEMENT.NUMBEROFINSTALMENT"
			 		+ " GROUP BY T_MONTHLYCREDIT.AGREEMENTCD) TABLE1"
			 		+ " ON TABLE1.AGREEMENTCD = T_AGREEMENT.AGREEMENTCD"
			 		+ " WHERE T_AGREEMENT.AGREEMENTSTATUS IN (1,2,4)"
			 		+ " GROUP BY T_PAYSTAGESAGREEMENT.AGREEMENTCD,T_PAYSTAGESAGREEMENT.NUMBEROFINSTALMENT"
			 		+ ",TABLE1.NUMOFINSTALLMENT, (T_PAYSTAGESAGREEMENT.NUMBEROFINSTALMENT-TABLE1.NUMOFINSTALLMENT))) TBLOustandingPaymentNumber";
			 	 
				  
			  String SQLOverDueCountAndAmount = "(SELECT TABLE1.AGREEMENTCD,TABLE1.OVERDUECOUNT,ROUND(TABLE2.OVERDUEAMOUNT) OVERDUEAMOUNT"
				  		+ " FROM ( SELECT COUNT(*) OVERDUECOUNT, T_MONTHLYCREDIT.AGREEMENTCD FROM T_MONTHLYCREDIT"
				  		+ " INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_MONTHLYCREDIT.AGREEMENTCD"
				  		+ " INNER JOIN T_PAYSTAGESAGREEMENT ON T_PAYSTAGESAGREEMENT.AGREEMENTCD = T_MONTHLYCREDIT.AGREEMENTCD"
				  		+ " WHERE T_AGREEMENT.AGREEMENTSTATUS NOT IN (8,9) "
				  		+ " AND T_MONTHLYCREDIT.REALPAYPRINCIPAL < T_MONTHLYCREDIT.NEEDPAYPRINCIPAL"
				  		+ " AND PAYMENTYEARMONTH<= "  + currentdate
				  		+ " GROUP BY T_MONTHLYCREDIT.AGREEMENTCD) TABLE1"
				  		+ " INNER JOIN ( SELECT SUM( NEEDPAYPRINCIPAL + NEEDPAYCOLLECTIONCHARGE) OVERDUEAMOUNT,AGREEMENTCD"
				  		+ " FROM T_MONTHLYCREDIT WHERE PAYMENTYEARMONTH = " + currentdate + " GROUP BY AGREEMENTCD) TABLE2"
				  		+ " ON TABLE1.AGREEMENTCD = TABLE2.AGREEMENTCD) TBLOverDueCountAndAmount";
			  
		
			  String SQLOverDueDays = "(SELECT AGREEMENTCD " + OVERDUE
				  		+ " FROM (SELECT T_MONTHLYCREDIT.AGREEMENTCD,COUNT(*) OVERDUECOUNT,DELAYSTATUS"
				  		+ " FROM T_AGREEMENT"
				  		+ " INNER JOIN T_PAYSTAGESAGREEMENT ON T_PAYSTAGESAGREEMENT.AGREEMENTCD = T_AGREEMENT.AGREEMENTCD"
				  		+ " INNER JOIN T_CREDIT ON T_CREDIT.AGREEMENTCD = T_PAYSTAGESAGREEMENT.AGREEMENTCD"
				  		+ " LEFT JOIN T_MONTHLYCREDIT ON T_MONTHLYCREDIT.AGREEMENTCD = T_PAYSTAGESAGREEMENT.AGREEMENTCD"
				  		+ " AND T_MONTHLYCREDIT.REALPAYPRINCIPAL < T_MONTHLYCREDIT.NEEDPAYPRINCIPAL"
				  		+ " AND PAYMENTYEARMONTH<= "  + currentdate
				  		+ " GROUP BY T_MONTHLYCREDIT.AGREEMENTCD, DELAYSTATUS)) TBLOverDueDays";
			  
			
			  String SQLNextPayment = "(SELECT T_MONTHLYCREDIT.AGREEMENTCD,"
				  		+ " ROUND(NEEDPAYPRINCIPAL + NEEDPAYINTEREST + NEEDPAYCOMPENSATION + NEEDPAYCOLLECTIONCHARGE + COMPENSATION) NEXTPAYMENT"
				  		+ " FROM T_MONTHLYCREDIT INNER JOIN T_AGREEMENT ON T_AGREEMENT.AGREEMENTCD = T_MONTHLYCREDIT.AGREEMENTCD"
				  		+ " AND PAYMENTYEARMONTH= "  + currentdate 
				  		+ " AND AGREEMENTSTATUS NOT IN (6,5) ORDER BY PAYMENTTIMES ASC) TBLNextPayment";
			  
			  String SQLNextPaymentDate = "(SELECT AGREEMENTCD, CASE WHEN AGREEMENTSTATUS IN (6,11,5) THEN NULL ELSE PAYMENTDATE END NEXTPAYMENTDATE"
				  		+ " FROM ( SELECT CONCAT(SUBSTR(HPFIRSTDAY,7,2), TO_CHAR(SYSDATE,'MMYYYY'))"
				  		+ " PAYMENTDATE,AGREEMENTSTATUS,T_AGREEMENT.AGREEMENTCD"
				  		+ " FROM T_PAYSTAGESAGREEMENT INNER JOIN T_AGREEMENT ON" 
				  		+ " T_AGREEMENT.AGREEMENTCD = T_PAYSTAGESAGREEMENT.AGREEMENTCD)) TBLNextPaymentDate";
			
		Table<Record> NESTED = jooq
				.select(DSL.field("MAIN.AGREEMENTCD").as("AGREEMENTCD"))
				.select(DSL.field("MAIN.CUSTOMERCD").as("PROVIDER_SUBJECT_NUM"))
				.select(DSL.field("MAIN.AGREEMENTCD").as("PROVIDER_CONTRACT_NUM"))
				.select(DSL.field("MAIN.CONTRACTPHASE").as("CONTRACT_PHASE"))
				.select(DSL.field("MAIN.CONTRACTSTATUS").as("CONTRACT_STATUS"))
				.select(DSL.field("MAIN.REQUESTDATE").as("CONTRACT_REQUEST_DATE"))
				.select(DSL.field("MAIN.STARTDATE").as("CONTRACT_START_DATE"))
				.select(DSL.field("MAIN.CONTRACTENDPLANNEDDATE").as("CONTRACT_END_PLANNED_DATE"))
				.select(DSL.field("MAIN.FINANCEPRICE").as("FINANCED_AMOUNT"))
				.select(DSL.field("MAIN.NUMBEROFINSTALLMENT").as("NUMBER_OF_INSTALLMENT"))
				.select(DSL.field("MAIN.HPFIRSTDAY").as("FIRST_PAYMENT_DATE"))
				//.select(DSL.field("MAIN.MONTHLYPAYMENT").as("MONTHLY_PAYMENT"))
				.select(DSL.field("TBLNextPaymentDate.NEXTPAYMENTDATE").as("NEXT_PAYMENT_DATE"))
				.select(DSL.field("TBLLastPaymentDate.LASTPAYMENTDATE").as("LAST_PAYMENT_DATE"))
				//.select(DSL.field("TBLContactEndActualDate.CONTRACTENDACTUAL").as("CONTRACT_END_ACTUAL_DATE"))
				.select(DSL.field("TBLLastPaymentAmount.LASTPAYMENTAMOUNT").as("LAST_PAYMENT_AMOUNT"))
				.select(DSL.field("TBLOustandingBalance.BALANCE").as("OUSTANDING_BALANCE"))
				.select(DSL.field("TBLOustandingPaymentNumber.REMAININGINSTALLMENTS").as("OUSTANDING_PAYMENT_NUM"))
				.select(DSL.field("TBLNextPayment.NEXTPAYMENT").as("NEXT_PAYMENT"))
				.select(DSL.field("TBLOverDueCountAndAmount.OVERDUECOUNT").as("OVERDUE_PAYMENT_NUM"))
				.select(DSL.field("TBLOverDueCountAndAmount.OVERDUEAMOUNT").as("OVERDUE_PAYMENT_AMOUNT"))
				.select(DSL.field("TBLOverDueDays.OVERDUEDAYS").as("OVERDUE_DAYS"))
				.from(SQLMain)			
				.leftJoin(SQLLastPaymentDate).on(DSL.field("TBLLastPaymentDate.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLMonthlyPaymentAmount).on(DSL.field("TBLMonthlyPaymentAmount.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				//.leftJoin(SQLContactEndActualDate).on(DSL.field("TBLContactEndActualDate.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLLastPaymentAmount).on(DSL.field("TBLLastPaymentAmount.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLOustandingBalance).on(DSL.field("TBLOustandingBalance.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLOustandingPaymentNumber).on(DSL.field("TBLOustandingPaymentNumber.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLOverDueCountAndAmount).on(DSL.field("TBLOverDueCountAndAmount.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLOverDueDays).on(DSL.field("TBLOverDueDays.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLNextPayment).on(DSL.field("TBLNextPayment.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.leftJoin(SQLNextPaymentDate).on(DSL.field("TBLNextPaymentDate.AGREEMENTCD").equal(DSL.field("MAIN.AGREEMENTCD")))
				.asTable("NESTED");
		 
		
		return getDerivedTable(NESTED);
		
	}
	
	private Result<Record> getDerivedTable(Table<Record> NESTED) {
		
		InstallmentConstantField installmentConstantField = new InstallmentConstantField();
		
		Field<String> recordType = DSL.val(installmentConstantField.getRecordType());
		Field<String> providerCode = DSL.val(providercode);
		Field<String> branchCode = DSL.val(installmentConstantField.getBranchCode());
		Field<String> subjectReferenceDate = DSL.val(installmentConstantField.getContractReferenceDate());
		Field<String> role = DSL.val(installmentConstantField.getRole());
		Field<String> contractType = DSL.val(contracttype);
		Field<String> currency = DSL.val(installmentConstantField.getCurrency());
		Field<String> originalcurrency = DSL.val(installmentConstantField.getOriginalCurrency());
		Field<String> reorganizedCreditCode = DSL.val(installmentConstantField.getReorganizedCreditCode());
		Field<String> boardResolutionFlag = DSL.val(installmentConstantField.getBoardResolutionFlag());
		Field<String> transactionType = DSL.val(installmentConstantField.getTransactionType());
		Field<String> creditPurpose = DSL.val(installmentConstantField.getCreditPurpose());
		Field<String> paymentPeriodicity = DSL.val(installmentConstantField.getPaymentPeriodicity());
		Field<String> methodOfPayment = DSL.val(installmentConstantField.getMethodOfPayment());
		Field<String> newUsedCode = DSL.val(installmentConstantField.getNewUsedCode());
		Field<String> goodType = DSL.val(installmentConstantField.getGoodType());
		Field<String> goodValue = DSL.val(installmentConstantField.getGoodValue());
		Field<String> goodBrand = DSL.val(installmentConstantField.getGoodBrand());
		Field<String> manufacturingDate = DSL.val(installmentConstantField.getManufacturingDate());
		Field<String> registrationNum = DSL.val(installmentConstantField.getRegistrationNum());
		
		Field<String> providerGuaranteeNum1 = DSL.val(installmentConstantField.getProviderGuaranteeNum1());
		Field<String> providerSubjNoGuarantor1 = DSL.val(installmentConstantField.getProviderSubjNoGuarantor1());
		Field<String> guarantorName1 = DSL.val(installmentConstantField.getGuarantorName1());
		Field<String> guaranteedAmount1 = DSL.val(installmentConstantField.getGuaranteedAmount1());
		Field<String> currencyGuarantee1 = DSL.val(installmentConstantField.getCurrencyGuarantee1());
		Field<String> validityStartDate1 = DSL.val(installmentConstantField.getCurrencyGuarantee1());
		Field<String> validityEndDate1 = DSL.val(installmentConstantField.getValidityEndDate1());
		Field<String> guaranteeType1 = DSL.val(installmentConstantField.getGuaranteeType1());
		Field<String> assetCode1 = DSL.val(installmentConstantField.getAssetCode5());
		Field<String> assetDescription1 = DSL.val(installmentConstantField.getAssetDescription1());
		Field<String> assetLocation1 = DSL.val(installmentConstantField.getAssetLocation1());
		Field<String> assetAppraisedValue1 = DSL.val(installmentConstantField.getAssetAppraisedValue1());
		Field<String> assetRegistryExternalLink1 = DSL.val(installmentConstantField.getAssetRegistryExternalLink1());
		Field<String> customerType1 = DSL.val(installmentConstantField.getCustomerType1());
	
	
		Field<String> providerGuaranteeNum2 = DSL.val(installmentConstantField.getProviderGuaranteeNum2());
		Field<String> providerSubjNoGuarantor2 = DSL.val(installmentConstantField.getProviderSubjNoGuarantor2());
		Field<String> guarantorName2 = DSL.val(installmentConstantField.getGuarantorName2());
		Field<String> guaranteedAmount2 = DSL.val(installmentConstantField.getGuaranteedAmount2());
		Field<String> currencyGuarantee2 = DSL.val(installmentConstantField.getCurrencyGuarantee2());
		Field<String> validityStartDate2 = DSL.val(installmentConstantField.getValidityStartDate2());
		Field<String> validityEndDate2 = DSL.val(installmentConstantField.getValidityEndDate2());
		Field<String> guaranteeType2 = DSL.val(installmentConstantField.getGuaranteeType2());
		Field<String> assetCode2 = DSL.val(installmentConstantField.getAssetCode2());
		Field<String> assetDescription2 = DSL.val(installmentConstantField.getAssetDescription2());
		Field<String> assetLocation2 = DSL.val(installmentConstantField.getAssetLocation2());
		Field<String> assetAppraisedValue2 = DSL.val(installmentConstantField.getAssetAppraisedValue2());
		Field<String> assetRegistryExternalLink2 = DSL.val(installmentConstantField.getAssetRegistryExternalLink2());
		Field<String> customerType2 = DSL.val(installmentConstantField.getCustomerType2());
	
		Field<String> providerGuaranteeNum3 = DSL.val(installmentConstantField.getProviderGuaranteeNum3());
		Field<String> providerSubjNoGuarantor3 = DSL.val(installmentConstantField.getProviderSubjNoGuarantor3());
		Field<String> guarantorName3 = DSL.val(installmentConstantField.getGuarantorName3());
		Field<String> guaranteedAmount3 = DSL.val(installmentConstantField.getGuaranteedAmount3());
		Field<String> currencyGuarantee3 = DSL.val(installmentConstantField.getCurrencyGuarantee3());
		Field<String> validityStartDate3 = DSL.val(installmentConstantField.getValidityStartDate3());
		Field<String> validityEndDate3 = DSL.val(installmentConstantField.getValidityEndDate3());
		Field<String> guaranteeType3 = DSL.val(installmentConstantField.getGuaranteeType3());
		Field<String> assetCode3 = DSL.val(installmentConstantField.getAssetCode3());
		Field<String> assetDescription3 = DSL.val(installmentConstantField.getAssetDescription3());
		Field<String> assetLocation3 = DSL.val(installmentConstantField.getAssetLocation3());
		Field<String> assetAppraisedValue3 = DSL.val(installmentConstantField.getAssetAppraisedValue3());
		Field<String> assetRegistryExternalLink3 = DSL.val(installmentConstantField.getAssetRegistryExternalLink3());
		Field<String> customerType3 = DSL.val(installmentConstantField.getCustomerType3());
		
		Field<String> providerGuaranteeNum4 = DSL.val(installmentConstantField.getProviderGuaranteeNum4());
		Field<String> providerSubjNoGuarantor4 = DSL.val(installmentConstantField.getProviderSubjNoGuarantor4());
		Field<String> guarantorName4 = DSL.val(installmentConstantField.getGuarantorName4());
		Field<String> guaranteedAmount4 = DSL.val(installmentConstantField.getGuaranteedAmount4());
		Field<String> currencyGuarantee4 = DSL.val(installmentConstantField.getCurrencyGuarantee4());
		Field<String> validityStartDate4 = DSL.val(installmentConstantField.getValidityStartDate4());
		Field<String> validityEndDate4 = DSL.val(installmentConstantField.getValidityEndDate4());
		Field<String> guaranteeType4 = DSL.val(installmentConstantField.getGuaranteeType4());
		Field<String> assetCode4 = DSL.val(installmentConstantField.getAssetCode4());
		Field<String> assetDescription4 = DSL.val(installmentConstantField.getAssetDescription4());
		Field<String> assetLocation4 = DSL.val(installmentConstantField.getAssetLocation4());
		Field<String> assetAppraisedValue4 = DSL.val(installmentConstantField.getAssetAppraisedValue4());
		Field<String> assetRegistryExternalLink4 = DSL.val(installmentConstantField.getAssetRegistryExternalLink4());
		Field<String> customerType4 = DSL.val(installmentConstantField.getCustomerType4());
		
		Field<String> providerGuaranteeNum5 = DSL.val(installmentConstantField.getProviderGuaranteeNum5());
		Field<String> providerSubjNoGuarantor5 = DSL.val(installmentConstantField.getProviderSubjNoGuarantor5());
		Field<String> guarantorName5 = DSL.val(installmentConstantField.getGuarantorName5());
		Field<String> guaranteedAmount5 = DSL.val(installmentConstantField.getGuaranteedAmount5());
		Field<String> currencyGuarantee5 = DSL.val(installmentConstantField.getCurrencyGuarantee5());
		Field<String> validityStartDate5 = DSL.val(installmentConstantField.getValidityStartDate5());
		Field<String> validityEndDate5 = DSL.val(installmentConstantField.getValidityEndDate5());
		Field<String> guaranteeType5 = DSL.val(installmentConstantField.getGuaranteeType5());
		Field<String> assetCode5 = DSL.val(installmentConstantField.getAssetCode5());
		Field<String> assetDescription5 = DSL.val(installmentConstantField.getAssetDescription5());
		Field<String> assetLocation5 = DSL.val(installmentConstantField.getAssetLocation5());
		Field<String> assetAppraisedValue5 = DSL.val(installmentConstantField.getAssetAppraisedValue5());
		Field<String> assetRegistryExternalLink5 = DSL.val(installmentConstantField.getAssetRegistryExternalLink5());
		Field<String> customerType5 = DSL.val(installmentConstantField.getCustomerType5());
		
		Field<String> providerGuaranteeNum6 = DSL.val(installmentConstantField.getProviderGuaranteeNum6());
		Field<String> providerSubjNoGuarantor6 = DSL.val(installmentConstantField.getProviderSubjNoGuarantor6());
		Field<String> guarantorName6 = DSL.val(installmentConstantField.getGuarantorName6());
		Field<String> guaranteedAmount6 = DSL.val(installmentConstantField.getGuaranteedAmount6());
		Field<String> currencyGuarantee6 = DSL.val(installmentConstantField.getCurrencyGuarantee6());
		Field<String> validityStartDate6 = DSL.val(installmentConstantField.getValidityStartDate6());
		Field<String> validityEndDate6 = DSL.val(installmentConstantField.getValidityEndDate6());
		Field<String> guaranteeType6 = DSL.val(installmentConstantField.getGuaranteeType6());
		Field<String> assetCode6 = DSL.val(installmentConstantField.getAssetCode6());
		Field<String> assetDescription6 = DSL.val(installmentConstantField.getAssetDescription6());
		Field<String> assetLocation6 = DSL.val(installmentConstantField.getAssetLocation6());
		Field<String> assetAppraisedValue6 = DSL.val(installmentConstantField.getAssetAppraisedValue6());
		Field<String> assetRegistryExternalLink6 = DSL.val(installmentConstantField.getAssetRegistryExternalLink6());
		Field<String> customerType6 = DSL.val(installmentConstantField.getCustomerType6());
		
		Field<String> providerSubjNoLinkedSubj1 = DSL.val(installmentConstantField.getProviderSubjNoLinkedSubj1());
		Field<String> subjectRole1 = DSL.val(installmentConstantField.getSubjectRole1());
		Field<String> nameOfLinkSubj1 = DSL.val(installmentConstantField.getNameOfLinkSubj1());
		
		Field<String> providerSubjNoLinkedSubj2 = DSL.val(installmentConstantField.getProviderSubjNoLinkedSubj2());
		Field<String> subjectRole2 = DSL.val(installmentConstantField.getSubjectRole2());
		Field<String> nameOfLinkSubj2 = DSL.val(installmentConstantField.getNameOfLinkSubj2());
		
		Field<String> providerSubjNoLinkedSubj3 = DSL.val(installmentConstantField.getProviderSubjNoLinkedSubj3());
		Field<String> subjectRole3 = DSL.val(installmentConstantField.getSubjectRole3());
		Field<String> nameOfLinkSubj3 = DSL.val(installmentConstantField.getNameOfLinkSubj3());
		
		Field<String> providerSubjNoLinkedSubj4 = DSL.val(installmentConstantField.getProviderSubjNoLinkedSubj4());
		Field<String> subjectRole4 = DSL.val(installmentConstantField.getSubjectRole4());
		Field<String> nameOfLinkSubj4 = DSL.val(installmentConstantField.getNameOfLinkSubj4());
		
		Field<String> providerSubjNoLinkedSubj5 = DSL.val(installmentConstantField.getProviderSubjNoLinkedSubj5());
		Field<String> subjectRole5 = DSL.val(installmentConstantField.getSubjectRole5());
		Field<String> nameOfLinkSubj5 = DSL.val(installmentConstantField.getNameOfLinkSubj5());
		
		Field<String> providerSubjNoLinkedSubj6 = DSL.val(installmentConstantField.getProviderSubjNoLinkedSubj6());
		Field<String> subjectRole6 = DSL.val(installmentConstantField.getSubjectRole6());
		Field<String> nameOfLinkSubj6 = DSL.val(installmentConstantField.getNameOfLinkSubj6());
		
		return jooq
				.select(recordType.as("ID"))
			 	.select(providerCode.as("PROVIDER_CODE"))
			 	.select(branchCode.as("BRANCH_CODE"))
			 	.select(subjectReferenceDate.as("CONTRACT_REFERENCE_DATE"))
			 	.select(NESTED.field("PROVIDER_SUBJECT_NUM"))
			 	.select(role.as("ROLE"))
			 	.select(NESTED.field("PROVIDER_CONTRACT_NUM"))
				.select(contractType.as("CONTRACT_TYPE"))
				.select(NESTED.field("CONTRACT_PHASE"))
				.select(NESTED.field("CONTRACT_STATUS"))
				.select(currency.as("CURRENCY"))
				.select(originalcurrency.as("ORIGINAL_CURRENCY"))
				.select(NESTED.field("CONTRACT_START_DATE"))
				.select(NESTED.field("CONTRACT_REQUEST_DATE"))
				.select(NESTED.field("CONTRACT_END_PLANNED_DATE"))
				//.select(NESTED.field("CONTRACT_END_ACTUAL_DATE"))
				.select(NESTED.field("LAST_PAYMENT_DATE"))
				.select(reorganizedCreditCode.as("REORGANIZED_CREDIT_CODE"))
				.select(boardResolutionFlag.as("BOARD_RESOLUTION_FLAG"))
				.select(NESTED.field("FINANCED_AMOUNT"))
				.select(NESTED.field("NUMBER_OF_INSTALLMENT"))
				.select(transactionType.as("TRANSACTION_TYPE"))
				.select(creditPurpose.as("CREDIT_PURPOSE"))
				.select(paymentPeriodicity.as("PAYMENT_PERIODICITY"))
				.select(methodOfPayment.as("PAYMENT_METHOD"))
				//.select(NESTED.field("MONTHLY_PAYMENT"))
			 	.select(NESTED.field("FIRST_PAYMENT_DATE"))
			 	.select(NESTED.field("LAST_PAYMENT_AMOUNT"))
			 	.select(NESTED.field("NEXT_PAYMENT_DATE"))
				.select(NESTED.field("NEXT_PAYMENT"))
				.select(NESTED.field("OUSTANDING_PAYMENT_NUM"))
				.select(NESTED.field("OUSTANDING_BALANCE"))
				.select(NESTED.field("OVERDUE_PAYMENT_NUM"))
				.select(NESTED.field("OVERDUE_PAYMENT_AMOUNT"))
			    .select(NESTED.field("OVERDUE_DAYS"))
			    .select(goodType.as("GOOD_TYPE"))
			    .select(goodValue.as("GOOD_VALUE"))
				.select(newUsedCode.as("NEW_USED_CODE"))
				.select(goodBrand.as("GOOD_BRAND"))
				.select(manufacturingDate.as("MANUFACTURING_DATE"))
				.select(registrationNum.as("REGISTRATION_NUMBER"))
				
				.select(providerGuaranteeNum1.as("PROVIDER_GUARANTEE_NUM_1"))
				.select(providerSubjNoGuarantor1.as("PROVIDER_SUBJ_NO_GURANTOR_1"))
				.select(guarantorName1.as("GUARANTOR_NAME_1"))
				.select(guaranteedAmount1.as("GUARANTEED_AMOUNT_1"))
				.select(currencyGuarantee1.as("CURRENCY_GUARANTEE_1"))
				.select(validityStartDate1.as("VALIDITY_START_DATE1"))
				.select(validityEndDate1.as("VALIDITY_END_DATE_1"))
				.select(guaranteeType1.as("GUARANTEE_TYPE_1"))
				.select(assetCode1.as("ASSET_CODE_1"))
				.select(assetDescription1.as("ASSET_DESCRIPTION_1"))
				.select(assetLocation1.as("ASSET_LOCATION_1"))
				.select(assetAppraisedValue1.as("ASSET_APPRAISED_VALUE_1"))
				.select(assetRegistryExternalLink1.as("ASSET_REGISTRY_EXTERNAL_LINK_1"))
				.select(customerType1.as("CUSTOMER_TYPE_1"))
				
				.select(providerGuaranteeNum2.as("PROVIDER_GUARANTEE_NUM_2"))
				.select(providerSubjNoGuarantor2.as("PROVIDER_SUBJ_NO_GURANTOR_2"))
				.select(guarantorName2.as("GUARANTOR_NAME_2"))
				.select(guaranteedAmount2.as("GUARANTEED_AMOUNT_2"))
				.select(currencyGuarantee2.as("CURRENCY_GUARANTEE_2"))
				.select(validityStartDate2.as("VALIDITY_START_DATE2"))
				.select(validityEndDate2.as("VALIDITY_END_DATE_2"))
				.select(guaranteeType2.as("GUARANTEE_TYPE_2"))
				.select(assetCode2.as("ASSET_CODE_2"))
				.select(assetDescription2.as("ASSET_DESCRIPTION_2"))
				.select(assetLocation2.as("ASSET_LOCATION_2"))
				.select(assetAppraisedValue2.as("ASSET_APPRAISED_VALUE_2"))
				.select(assetRegistryExternalLink2.as("ASSET_REGISTRY_EXTERNAL_LINK_2"))
				.select(customerType2.as("CUSTOMER_TYPE_2"))
				
				.select(providerGuaranteeNum3.as("PROVIDER_GUARANTEE_NUM_3"))
				.select(providerSubjNoGuarantor3.as("PROVIDER_SUBJ_NO_GURANTOR_3"))
				.select(guarantorName3.as("GUARANTOR_NAME_3"))
				.select(guaranteedAmount3.as("GUARANTEED_AMOUNT_3"))
				.select(currencyGuarantee3.as("CURRENCY_GUARANTEE_3"))
				.select(validityStartDate3.as("VALIDITY_START_DATE3"))
				.select(validityEndDate3.as("VALIDITY_END_DATE_3"))
				.select(guaranteeType3.as("GUARANTEE_TYPE_3"))
				.select(assetCode3.as("ASSET_CODE_3"))
				.select(assetDescription3.as("ASSET_DESCRIPTION_3"))
				.select(assetLocation3.as("ASSET_LOCATION_3"))
				.select(assetAppraisedValue3.as("ASSET_APPRAISED_VALUE_3"))
				.select(assetRegistryExternalLink3.as("ASSET_REGISTRY_EXTERNAL_LINK_3"))
				.select(customerType3.as("CUSTOMER_TYPE_3"))
				
				.select(providerGuaranteeNum4.as("PROVIDER_GUARANTEE_NUM_4"))
				.select(providerSubjNoGuarantor4.as("PROVIDER_SUBJ_NO_GURANTOR_4"))
				.select(guarantorName4.as("GUARANTOR_NAME_4"))
				.select(guaranteedAmount4.as("GUARANTEED_AMOUNT_4"))
				.select(currencyGuarantee4.as("CURRENCY_GUARANTEE_4"))
				.select(validityStartDate4.as("VALIDITY_START_DATE4"))
				.select(validityEndDate4.as("VALIDITY_END_DATE_4"))
				.select(guaranteeType4.as("GUARANTEE_TYPE_4"))
				.select(assetCode4.as("ASSET_CODE_4"))
				.select(assetDescription4.as("ASSET_DESCRIPTION_4"))
				.select(assetLocation4.as("ASSET_LOCATION_4"))
				.select(assetAppraisedValue4.as("ASSET_APPRAISED_VALUE_4"))
				.select(assetRegistryExternalLink4.as("ASSET_REGISTRY_EXTERNAL_LINK_4"))
				.select(customerType4.as("CUSTOMER_TYPE_4"))
				
				.select(providerGuaranteeNum5.as("PROVIDER_GUARANTEE_NUM_5"))
				.select(providerSubjNoGuarantor5.as("PROVIDER_SUBJ_NO_GURANTOR_5"))
				.select(guarantorName5.as("GUARANTOR_NAME_5"))
				.select(guaranteedAmount5.as("GUARANTEED_AMOUNT_5"))
				.select(currencyGuarantee5.as("CURRENCY_GUARANTEE_5"))
				.select(validityStartDate5.as("VALIDITY_START_DATE5"))
				.select(validityEndDate5.as("VALIDITY_END_DATE_5"))
				.select(guaranteeType5.as("GUARANTEE_TYPE_5"))
				.select(assetCode5.as("ASSET_CODE_5"))
				.select(assetDescription5.as("ASSET_DESCRIPTION_5"))
				.select(assetLocation5.as("ASSET_LOCATION_5"))
				.select(assetAppraisedValue5.as("ASSET_APPRAISED_VALUE_5"))
				.select(assetRegistryExternalLink5.as("ASSET_REGISTRY_EXTERNAL_LINK_5"))
				.select(customerType5.as("CUSTOMER_TYPE_5"))
				
				.select(providerGuaranteeNum6.as("PROVIDER_GUARANTEE_NUM_6"))
				.select(providerSubjNoGuarantor6.as("PROVIDER_SUBJ_NO_GURANTOR_6"))
				.select(guarantorName6.as("GUARANTOR_NAME_6"))
				.select(guaranteedAmount6.as("GUARANTEED_AMOUNT_6"))
				.select(currencyGuarantee6.as("CURRENCY_GUARANTEE_6"))
				.select(validityStartDate6.as("VALIDITY_START_DATE6"))
				.select(validityEndDate6.as("VALIDITY_END_DATE_6"))
				.select(guaranteeType6.as("GUARANTEE_TYPE_6"))
				.select(assetCode6.as("ASSET_CODE_6"))
				.select(assetDescription6.as("ASSET_DESCRIPTION_6"))
				.select(assetLocation6.as("ASSET_LOCATION_6"))
				.select(assetAppraisedValue6.as("ASSET_APPRAISED_VALUE_6"))
				.select(assetRegistryExternalLink6.as("ASSET_REGISTRY_EXTERNAL_LINK_6"))
				.select(customerType6.as("CUSTOMER_TYPE_6"))
				
				.select(providerSubjNoLinkedSubj1.as("PROVIDER_SUBJ_LINKED_1"))
				.select(subjectRole1.as("SUBJECT_ROLE_1"))
				.select(nameOfLinkSubj1.as("NAME_OF_LINKED_SUBJECT_1"))
				
				.select(providerSubjNoLinkedSubj2.as("PROVIDER_SUBJ_LINKED_2"))
				.select(subjectRole2.as("SUBJECT_ROLE_2"))
				.select(nameOfLinkSubj2.as("NAME_OF_LINKED_SUBJECT_2"))
				
				.select(providerSubjNoLinkedSubj3.as("PROVIDER_SUBJ_LINKED_3"))
				.select(subjectRole3.as("SUBJECT_ROLE_3"))
				.select(nameOfLinkSubj3.as("NAME_OF_LINKED_SUBJECT_3"))
				
				.select(providerSubjNoLinkedSubj4.as("PROVIDER_SUBJ_LINKED_4"))
				.select(subjectRole4.as("SUBJECT_ROLE_4"))
				.select(nameOfLinkSubj4.as("NAME_OF_LINKED_SUBJECT_4"))
				
				.select(providerSubjNoLinkedSubj5.as("PROVIDER_SUBJ_LINKED_5"))
				.select(subjectRole5.as("SUBJECT_ROLE_5"))
				.select(nameOfLinkSubj5.as("NAME_OF_LINKED_SUBJECT_5"))
				
				.select(providerSubjNoLinkedSubj6.as("PROVIDER_SUBJ_LINKED_6"))
				.select(subjectRole6.as("SUBJECT_ROLE_6"))
				.select(nameOfLinkSubj6.as("NAME_OF_LINKED_SUBJECT_6"))
			 	.from(NESTED)
				.fetch();
		
	}

}
