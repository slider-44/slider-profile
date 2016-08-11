package com.acsp.cic.batch.data.stream;

import static com.acsp.core.rs.db.tables.MCustomer.M_CUSTOMER;
import static com.acsp.core.rs.db.tables.Identification.IDENTIFICATION;
import static com.acsp.core.rs.db.tables.TAgreement.T_AGREEMENT;


import java.util.stream.Stream;

import org.jooq.DSLContext;
import org.jooq.Field;
import org.jooq.Record;
import org.jooq.Result;
import org.jooq.Table;
import org.jooq.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.acsp.cic.batch.constants.IndividualConstantField;


/**
 * Created by elaguardia on 03/22/2016.
 * 08/01/2016 : Modified to fix duplicates and add home as contact type
 */
@Component
public class IndividualDataStream implements DataStream {

	
	@Autowired
	protected DSLContext jooq;
	
	@Value("${cic.providercode}")
	private String providercode;
	
	
	@Override
	public Stream <Record> getStream() {
		return selectSubmissionDataFile().stream();
	}
	
	private Result<Record> selectSubmissionDataFile() {
		
	    Field<?> SEX = DSL.field("CASE WHEN SEX = 1 THEN 'M'" 
				   + "ELSE 'F' END");
	    
	    Field<?> NATIONALITY= DSL.field("CASE WHEN NATIONALITY = 'FILIPINO' OR NATIONALITY = 'FIL' THEN 'PH' ELSE '' END");
	    
	    Field<?> BIRTHPLACE= DSL.field("CASE WHEN BIRTHPLACE IS NULL THEN '' ELSE BIRTHPLACE END");
	    
		Field<?> BITHDATE= DSL.field("TO_CHAR(TO_DATE(BIRTHDAY,'YYYYMMDD'), 'DDMMYYYY')");
		
		Field<?> FULLADDRESS1= DSL.field("nowstreet || ',' || nowaddress || ',' || city  || ',' ||  nowzipcode");
		
		Field<?> FULLADDRESS2= DSL.field("nowstreet || ',' || nowaddress || ',' || city  || ',' ||  nowzipcode");
		
		Field<?> EMPLOYMENTTRADENAME= DSL.field("CASE WHEN CORPNAME='NA' THEN '' ELSE CORPNAME END");
		
		Field<?> CORPTEL= DSL.field("CASE WHEN CORPTEL+1=1 THEN '' ELSE CORPTEL END");
		
		Field<?> CONTACT_TYPE_1= DSL.field("CASE WHEN MOBILENO IS NOT NULL  THEN '3' ELSE '' END");
		
		Field<?> CONTACT_TYPE_2= DSL.field("CASE WHEN HOMETEL IS NOT NULL  THEN '1' ELSE '' END");
		
		Field<?> OCCUPATION_STATUS= DSL.field("CASE WHEN EMPLOYMENTSTYPE = '1' AND (EMPLOYMENTSTATUS='REGULAR' OR EMPLOYMENTSTATUS='PERMANENT') THEN '1'"
				+ "WHEN EMPLOYMENTSTYPE=3 and (EMPLOYMENTSTATUS='REGULAR' OR EMPLOYMENTSTATUS='PERMANENT') THEN '3'"
				+ "WHEN EMPLOYMENTSTYPE=2 THEN '5' END");

		
		Table<Record> NESTED = jooq 
				
				.selectDistinct(T_AGREEMENT.CUSTOMERCD.as("PROVIDER_SUBJECT_NUM"))
				.select(M_CUSTOMER.FIRSTNAME.as("FIRST_NAME"))
				.select(M_CUSTOMER.SURNAME.as("LAST_NAME"))
				.select(M_CUSTOMER.MIDDLENAME.as("MIDDLE_NAME"))
				.select(SEX.as("GENDER"))
				.select(BITHDATE.as("BIRTHDAY"))
				.select(BIRTHPLACE.as("BIRTHPLACE"))
				.select(NATIONALITY.as("NATIONALITY"))
				.select(FULLADDRESS1.as("ADDRESS1"))
				.select(FULLADDRESS2.as("ADDRESS2"))
				.select(IDENTIFICATION.IDCARDTYPE.as("IDENTIFICATION_1"))
				.select(IDENTIFICATION.IDCARDNO.as("IDENTIFICATION_NUM_1"))
				.select(IDENTIFICATION.IDCARDTYPE2.as("IDENTIFICATION_2"))
				.select(IDENTIFICATION.IDCARDNO2.as("IDENTIFICATION_NUM_2"))
				.select(IDENTIFICATION.IDCARDTYPE3.as("IDENTIFICATION_3"))
				.select(IDENTIFICATION.IDCARDNO3.as("IDENTIFICATION_NUM_3"))
				
				
				.select(IDENTIFICATION.IDCARDTYPE3.as("IDTYPE_1"))
				.select(IDENTIFICATION.IDCARDNO3.as("IDTYPE_NUM_1"))
				.select(IDENTIFICATION.IDCARDTYPE4.as("IDTYPE_2"))
				.select(IDENTIFICATION.IDCARDNO4.as("IDTYPE_NUM_2"))
				.select(CONTACT_TYPE_1.as("CONTACT_TYPE_1"))
				.select(M_CUSTOMER.MOBILENO.as("CONTACT_VALUE_1"))
				.select(CONTACT_TYPE_2.as("CONTACT_TYPE_2"))
				.select(M_CUSTOMER.HOMETEL.as("CONTACT_VALUE_2"))
				.select(EMPLOYMENTTRADENAME.as("EMPLOYMENT_TRADE_NAME"))
				.select(CORPTEL.as("EMPLOYMENT_PHONE"))
				.select(M_CUSTOMER.SALARY.as("GROSS_INCOME"))
				.select(OCCUPATION_STATUS.as("OCCUPATION_STATUS"))
				.from(M_CUSTOMER)
				.join(T_AGREEMENT)
				.on(T_AGREEMENT.CUSTOMERCD.equal(M_CUSTOMER.CUSTOMERCD))
				.join(IDENTIFICATION)
				.on(M_CUSTOMER.CUSTOMERCD.equal(IDENTIFICATION.CUSTOMERCD))
				.asTable("NESTED");
					
	
		return getDerivedTable(NESTED);
		
	}
	
	private Result<Record> getDerivedTable(Table<Record> NESTED) {
		IndividualConstantField constantField = new IndividualConstantField();
		
		Field<String> recordType = DSL.val(constantField.getRecordType());
		Field<String> providerCode = DSL.val(providercode);
		Field<String> branchCode = DSL.val(constantField.getBranchCode());
		Field<String> subjectReferenceDate = DSL.val(constantField.getSubjectRefDate());
		Field<String> title = DSL.val(constantField.getTitle());
		Field<String> suffix = DSL.val(constantField.getSuffix());
		Field<String> nickName = DSL.val(constantField.getNickName());
		Field<String> previousLastName = DSL.val(constantField.getPreviousLastName());
		Field<String> birthCountry = DSL.val(constantField.getBirthCountry());
		Field<String> resident = DSL.val(constantField.getResident());
		Field<String> civilStatus = DSL.val(constantField.getCivilStatus());
		Field<String> dependantsCount = DSL.val(constantField.getDependantsCount());
		Field<String> carsOwned = DSL.val(constantField.getCarsOwned());
		Field<String> spouseFirstName = DSL.val(constantField.getSpouseFirstName());
		Field<String> spouseLastName = DSL.val(constantField.getSpouseLastName());
		Field<String> spouseMiddleName = DSL.val(constantField.getSpouseMiddleName());
		Field<String> motherMaidenFirstName = DSL.val(constantField.getMotherMaidenFirstName());
		Field<String> motherMaidenLastName = DSL.val(constantField.getMotherMaidenLastName());
		Field<String> motherMaidenMiddleName = DSL.val(constantField.getMotherMaidenMiddleName());
		Field<String> fatherFirstName = DSL.val(constantField.getFatherFirstName());
		Field<String> fatherLastName = DSL.val(constantField.getFatherLastName());
		Field<String> fatherMiddleName = DSL.val(constantField.getFatherMiddleName());
		Field<String> fatherSuffix = DSL.val(constantField.getFatherSuffix());
		Field<String> addressType1 = DSL.val(constantField.getAddressType1());
		Field<String> streetNo1 = DSL.val(constantField.getStreetNo1());
		Field<String> postalCode1 = DSL.val(constantField.getPostalCode1());
		Field<String> subdivision1 = DSL.val(constantField.getSubdivision1());
		Field<String> baranggay1 = DSL.val(constantField.getBaranggay1());
		Field<String> city1 = DSL.val(constantField.getCity1());
		Field<String> province1 = DSL.val(constantField.getProvince1());
		Field<String> country1 = DSL.val(constantField.getCountry1());
		Field<String> houseOwnerLease1 = DSL.val(constantField.getHouseownerLease1());
		Field<String> occupiedSince1 = DSL.val(constantField.getOccupiedSince1());
		Field<String> addressType2 = DSL.val(constantField.getAddressType2());
		Field<String> fullAddress2 = DSL.val(constantField.getFullAddress2());
		Field<String> streetNo2 = DSL.val(constantField.getStreetNo2());
		Field<String> postalCode2 = DSL.val(constantField.getPostalCode2());
		Field<String> subdivision2 = DSL.val(constantField.getSubdivision2());
		Field<String> baranggay2 = DSL.val(constantField.getBaranggay2());
		Field<String> city2 = DSL.val(constantField.getCity2());
		Field<String> province2 = DSL.val(constantField.getProvince2());
		Field<String> country2 = DSL.val(constantField.getCountry2());
		Field<String> houseOwnerLease2 = DSL.val(constantField.getHouseOwnerLease2());
		Field<String> occupiedSince2 = DSL.val(constantField.getOccupiedSince2());
		Field<String> idtype1 = DSL.val(constantField.getIdtype1());
		Field<String> idtype2 = DSL.val(constantField.getIdtype2());
		Field<String> idtype3 = DSL.val(constantField.getIdType3());
		Field<String> idtypenum1 = DSL.val(constantField.getIdtypenum1());
		Field<String> idtypenum2 = DSL.val(constantField.getIdtypenum2());
		Field<String> idtypenum3 = DSL.val(constantField.getIdTypeNum3());
		Field<String> idTypeIssueDate1 = DSL.val(constantField.getIdTypeIssueDate1());
		Field<String> idTypeIssueDate2 = DSL.val(constantField.getIdTypeIssueDate2());
		Field<String> idTypeIssueDate3 = DSL.val(constantField.getIdTypeIssueDate3());
		Field<String> idTypeIssueCountry1 = DSL.val(constantField.getIdTypeIssueCountry1());
		Field<String> idTypeIssueCountry2 = DSL.val(constantField.getIdTypeIssueCountry2());
		Field<String> idTypeIssueCountry3 = DSL.val(constantField.getIdTypeIssueCountry3());
		Field<String> idTypeExpiryDate1 = DSL.val(constantField.getIdTypeExpiryDate1());
		Field<String> idTypeExpiryDate2 = DSL.val(constantField.getIdTypeExpiryDate2());
		Field<String> idTypeExpiryDate3 = DSL.val(constantField.getIdTypeExpiryDate3());
		Field<String> idTypeIssuedBy1 = DSL.val(constantField.getIdTypeIssuedBy1());
		Field<String> idTypeIssuedBy2 = DSL.val(constantField.getIdTypeIssuedBy2());
		Field<String> idTypeIssuedBy3 = DSL.val(constantField.getIdTypeIssuedBy3());
		Field<String> corpTin = DSL.val(constantField.getEmploymentCorpTin());
		Field<String> corpPSIC = DSL.val(constantField.getEmploymentPsic());
		Field<String> employmentAnnualMontlyIndicator = DSL.val(constantField.getEmploymentAnnualMontlyIndicator());
		Field<String> employmentCurrency = DSL.val(constantField.getEmploymentCurrency());
		Field<String> employmentDateHiredFrom = DSL.val(constantField.getEmploymentDateHiredFrom());
		Field<String> employmentDateHiredTo = DSL.val(constantField.getEmploymentDateHiredTo());
		Field<String> occupation = DSL.val(constantField.getOccupation());
		Field<String> soleTraderName1 = DSL.val(constantField.getSoleTraderName1());
		Field<String> soleTraderAddressType1 = DSL.val(constantField.getSoleTraderAddressType1());
		Field<String> soleTraderAddressType2 = DSL.val(constantField.getSoleTraderAddressType2());
		Field<String> soleTraderFullAddress1 = DSL.val(constantField.getSoleTraderFullAddress1());
		Field<String> soleTraderFullAddress2 = DSL.val(constantField.getSoleTraderFullAddress2());
		Field<String> soleTraderStreetNo1 = DSL.val(constantField.getSoleTraderStreetNo1());
		Field<String> soleTraderStreetNo2 = DSL.val(constantField.getSoleTraderStreetNo2());
		Field<String> soleTraderPostalCode1 = DSL.val(constantField.getSoleTraderPostalCode1());
		Field<String> soleTraderPostalCode2 = DSL.val(constantField.getSoleTraderPostalCode2());
		Field<String> soleTraderSubdivision1 = DSL.val(constantField.getSoleTraderSubdivision1());
		Field<String> soleTraderSubdivision2 = DSL.val(constantField.getSoleTraderSubdivision2());
		Field<String> soleTraderBrgy1 = DSL.val(constantField.getSoletraderbrgy1());
		Field<String> soleTraderBrgy2 = DSL.val(constantField.getSoletraderbrgy2());
		Field<String> soleTraderCity1 = DSL.val(constantField.getSoleTraderCity1());
		Field<String> soleTraderCity2 = DSL.val(constantField.getSoleTraderCity2());
		Field<String> soleTraderProvince1 = DSL.val(constantField.getSoleTraderProvince1());
		Field<String> soleTraderProvince2 = DSL.val(constantField.getSoleTraderProvince2());
		Field<String> soleTraderCountry1 = DSL.val(constantField.getSoleTraderCountry1());
		Field<String> soleTraderCountry2 = DSL.val(constantField.getSoleTraderCountry2());
		Field<String> soleTraderHouseOwnerLease1 = DSL.val(constantField.getSoleTraderHouseOwnerLease1());
		Field<String> soleTraderHouseOwnerLease2 = DSL.val(constantField.getSoleTraderHouseOwnerLease2());
		Field<String> soleTraderOccupiedSince1 = DSL.val(constantField.getSoleTraderOccupiedSince1());
		Field<String> soleTraderOccupiedSince2 = DSL.val(constantField.getSoleTraderOccupiedSince2());
		
		Field<String> soleTraderIdentification1 = DSL.val(constantField.getSoletraderidentification1());
		Field<String> soleTraderIdentification2 = DSL.val(constantField.getSoletraderidentification2());
		Field<String> soleTraderIdentificationNum1 = DSL.val(constantField.getSoletraderidentificationnum1());
		Field<String> soleTraderIdentificationNum2 = DSL.val(constantField.getSoletraderidentificationnum2());
		
		Field<String> soleTraderContactType1 = DSL.val(constantField.getSoletradercontacttype1());
		Field<String> soleTraderContactType2 = DSL.val(constantField.getSoletradercontacttype2());
		Field<String> soleTraderContactValue1 = DSL.val(constantField.getSoletradercontactvalue1());
		Field<String> soleTraderContactValue2 = DSL.val(constantField.getSoletradercontactvalue2());
		
		
		return jooq
				.select(recordType.as("ID"))
			 	.select(providerCode.as("PROVIDER_CODE"))
			 	.select(branchCode.as("BRANCH_CODE"))
			 	.select(subjectReferenceDate.as("SUBJECT_REFERENCE_DATE"))
				.select(NESTED.field("PROVIDER_SUBJECT_NUM"))
				.select(title.as("TITLE"))
				.select(NESTED.field("FIRST_NAME"))
				.select(NESTED.field("LAST_NAME"))
				.select(NESTED.field("MIDDLE_NAME"))
				.select(suffix.as("SUFFIX"))
            	.select(nickName.as("NICK_NAME"))
            	.select(previousLastName.as("PREVIOUS_LAST_NAME"))
            	.select(NESTED.field("GENDER"))
            	.select(NESTED.field("BIRTHDAY"))
            	.select(NESTED.field("BIRTHPLACE"))
                .select(birthCountry.as("BIRTH_COUNTRY"))
            	.select(NESTED.field("NATIONALITY"))
                .select(resident.as("RESIDENT"))
                .select(civilStatus.as("CIVIL_STATUS"))
                .select(dependantsCount.as("DEPENDANTS_COUNT"))
                .select(carsOwned.as("CARS_OWNED"))
                .select(spouseFirstName.as("SPOUSE_FIRST_NAME"))
                .select(spouseLastName.as("SPOUSE_LAST_NAME"))
                .select(spouseMiddleName.as("SPOUSE_MIDDLE_NAME"))
                .select(motherMaidenFirstName.as("MOTHER_MAIDEN_FIRST_NAME"))
                .select(motherMaidenLastName.as("MOTHER_MAIDEN_LAST_NAME"))
                .select(motherMaidenMiddleName.as("MOTHER_MAIDEN_MIDDLE_NAME"))
                .select(fatherFirstName.as("FATHER_MAIDEN_FIRST_NAME"))
                .select(fatherLastName.as("FATHER_MAIDEN_LAST_NAME"))
                .select(fatherMiddleName.as("FATHER_MAIDEN_MIDDLE_NAME"))
                .select(fatherSuffix.as("FATHER_SUFFIX"))
                
                .select(addressType1.as("ADDRESS_TYPE_1"))
                .select(NESTED.field("ADDRESS1"))
                .select(streetNo1.as("STREET_NO_1"))
                .select(postalCode1.as("POSTAL_CODE_1"))
                .select(subdivision1.as("SUBDIVISION_1"))
                .select(baranggay1.as("BARANGGAY_1"))
                .select(city1.as("CITY_1"))
                .select(province1.as("PROVINCE_1"))
                .select(country1.as("COUNTRY_1"))
                .select(houseOwnerLease1.as("HOUSE_OWNER_LEASE_1"))
                .select(occupiedSince1.as("OCCUPIED_SINCE_1"))
                
                .select(addressType2.as("ADDRESS_TYPE_2"))
                .select(NESTED.field("ADDRESS2"))
                //.select(fullAddress2.as("FULL_ADDRESS_2"))
                .select(streetNo2.as("STREET_NO_2"))
                .select(postalCode2.as("POSTAL_CODE_2"))
                .select(subdivision2.as("SUBDIVISION_2"))
                .select(baranggay2.as("BARANGGAY_2"))
                .select(city2.as("CITY_2"))
                .select(province2.as("PROVINCE_2"))
                .select(country2.as("COUNTRY_2"))
                .select(houseOwnerLease2.as("HOUSE_OWNER_LEASE_2"))
                .select(occupiedSince2.as("OCCUPIED_SINCE_2"))
                .select(NESTED.field("IDENTIFICATION_1"))
                .select(NESTED.field("IDENTIFICATION_NUM_1"))
                
                .select(NESTED.field("IDENTIFICATION_2"))
                .select(NESTED.field("IDENTIFICATION_NUM_2"))
                
                .select(NESTED.field("IDENTIFICATION_3"))
                .select(NESTED.field("IDENTIFICATION_NUM_3"))
                
                .select(idtype1.as("IDTYPE_1"))
                .select(idtypenum1.as("IDTYPE_NUM_1"))
                .select(idTypeIssueDate1.as("IDTYPE_ISSUE_1"))
                .select(idTypeIssueCountry1.as("IDTYPE_ISSUE_COUNTRY_1"))
                .select(idTypeExpiryDate1.as("IDTYPE_EXPIRY_1"))
                .select(idTypeIssuedBy1.as("IDTYPE_ISSUED_1"))
                
                
                .select(idtype2.as("IDTYPE_2"))
                .select(idtypenum2.as("IDTYPE_NUM_2"))
                .select(idTypeIssueDate2.as("IDTYPE_ISSUE_2"))
                .select(idTypeIssueCountry2.as("IDTYPE_ISSUE_COUNTRY_2"))
                .select(idTypeExpiryDate2.as("IDTYPE_EXPIRY_2"))
                .select(idTypeIssuedBy2.as("IDTYPE_ISSUED_2"))
                
                .select(idtype3.as("IDTYPE_3"))
                .select(idtypenum3.as("IDTYPE_NUM_3"))   
                .select(idTypeIssueDate3.as("IDTYPE_ISSUE_3"))
                .select(idTypeIssueCountry3.as("IDTYPE_ISSUE_COUNTRY_3"))
                .select(idTypeExpiryDate3.as("IDTYPE_EXPIRY_3"))
                .select(idTypeIssuedBy3.as("IDTYPE_ISSUED_3"))
                
                .select(NESTED.field("CONTACT_TYPE_1"))
                .select(NESTED.field("CONTACT_VALUE_1"))
                .select(NESTED.field("CONTACT_TYPE_2"))
                .select(NESTED.field("CONTACT_VALUE_2"))
                
                .select(NESTED.field("EMPLOYMENT_TRADE_NAME"))
                .select(corpTin.as("EMPLOYMENT_TIN"))
                .select(NESTED.field("EMPLOYMENT_PHONE"))
                .select(corpPSIC.as("CORP_PSIC"))
                .select(corpPSIC.as("GROSS_INCOME"))
                .select(employmentAnnualMontlyIndicator.as("ANNUAL_MONTHLY_INDICATOR"))
                .select(employmentCurrency.as("EMPLOYMENT_CURRENCY"))
                .select(NESTED.field("OCCUPATION_STATUS"))
                .select(employmentDateHiredFrom.as("DATE_HIRED_FROM"))
                .select(employmentDateHiredTo.as("DATE_HIRED_TO"))
                .select(occupation.as("OCCUPATION"))
                
                .select(soleTraderName1.as("SOLE_TRADER_NAME_1"))
                
                .select(soleTraderAddressType1.as("SOLE_TRADER_ADDRESS_TYPE_1"))
                .select(soleTraderFullAddress1.as("SOLE_TRADER_FULL_ADDRESS_1"))
                .select(soleTraderStreetNo1.as("SOLE_TRADER_STREET_NO_1"))
                .select(soleTraderPostalCode1.as("SOLE_TRADER_POSTAL_CODE_1"))
                .select(soleTraderSubdivision1.as("SOLE_TRADER_SUBDIVISION_1"))
                .select(soleTraderBrgy1.as("SOLE_TRADER_BRGY_1"))
                .select(soleTraderCity1.as("SOLE_TRADER_CITY_1"))
                .select(soleTraderProvince1.as("SOLE_TRADER_PROVINCE_1"))
                .select(soleTraderCountry1.as("SOLE_TRADER_COUNTRY_1"))
                .select(soleTraderHouseOwnerLease1.as("SOLE_HOUSE_OWNER_LEASE_1"))
                .select(soleTraderOccupiedSince1.as("SOLE_TRADER_OCCUPIED_SINCE_1"))
                
                .select(soleTraderAddressType2.as("SOLE_TRADER_ADDRESS_TYPE_2"))
                .select(soleTraderFullAddress2.as("SOLE_TRADER_FULL_ADDRESS_2"))
                .select(soleTraderStreetNo2.as("SOLE_TRADER_STREET_NO_2"))
                .select(soleTraderPostalCode2.as("SOLE_TRADER_POSTAL_CODE_2"))
                .select(soleTraderSubdivision2.as("SOLE_TRADER_SUBDIVISION_2"))
                .select(soleTraderBrgy2.as("SOLE_TRADER_BRGY_2"))
                .select(soleTraderCity2.as("SOLE_TRADER_CITY_2"))
                .select(soleTraderProvince2.as("SOLE_TRADER_PROVINCE_2"))
                .select(soleTraderCountry2.as("SOLE_TRADER_COUNTRY_2"))
                .select(soleTraderHouseOwnerLease2.as("SOLE_HOUSE_OWNER_LEASE_2"))
                .select(soleTraderOccupiedSince2.as("SOLE_TRADER_OCCUPIED_SINCE_2"))
                
                .select(soleTraderIdentificationNum1.as("SOLE_TRADER_ID_NUM_1"))
                .select(soleTraderIdentification1.as("SOLE_TRADER_ID_1"))
              
                .select(soleTraderIdentificationNum2.as("SOLE_TRADER_ID_NUM_2"))
                .select(soleTraderIdentification2.as("SOLE_TRADER_ID_2"))
             
                
                .select(soleTraderContactType1.as("SOLE_TRADER_CONTACT_TYPE_1"))
                .select(soleTraderContactType2.as("SOLE_TRADER_CONTACT_TYPE_2"))
              
                .select(soleTraderContactValue1.as("SOLE_TRADER_CONTACT_VALUE_1"))
                .select(soleTraderContactValue2.as("SOLE_TRADER_CONTACT_VALUE_2"))
             
				.from(NESTED)
				//.where(NESTED.field("CONTACT_TYPE_1").isNotNull().and(NESTED.field("CONTACT_TYPE_2").isNotNull()))
				//.orderBy(NESTED.field("PROVIDER_SUBJECT_NUM"))
				.fetch();
		
	
		
		
	}

}
