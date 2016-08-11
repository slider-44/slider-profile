package com.acsp.cic.batch.constants;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

/**
 * Created by elaguardia on 03/23/2016.
 */

@Component
public class IndividualConstantField {

	private static final String recordType = "ID";

	private static final String branchCode = "";

	private static final String title = "";

	private static final String suffix = "";

	private static final String nickName = "";

	private static final String previousLastName = "";

	private static final String placeOfBirth = "";

	private static final String birthCountry = "";

	private static final String resident = "1";

	private static final String civilStatus = "";

	private static final String dependantsCount = "";

	private static final String carsOwned = "";

	private static final String spouseFirstName = "";

	private static final String spouseLastName = "";

	private static final String spouseMiddleName = "";

	private static final String motherMaidenFirstName = "";

	private static final String motherMaidenLastName = "";

	private static final String motherMaidenMiddleName = "";

	private static final String fatherFirstName = "";

	private static final String fatherLastName = "";

	private static final String fatherMiddleName = "";

	private static final String fatherSuffix = "";

	private static final String addressType1 = "MI";

	private static final String streetNo1 = "";

	private static final String postalCode1 = "";

	private static final String subdivision1 = "";

	private static final String baranggay1 = "";

	private static final String city1 = "";

	private static final String province1 = "";

	private static final String country1 = "";

	private static final String houseOwnerLease1 = "";

	private static final String occupiedSince1 = "";

	private static final String addressType2 = "AI";

	private static final String fullAddress2 = "";

	private static final String streetNo2 = "";

	private static final String postalCode2 = "";

	private static final String subdivision2 = "";

	private static final String baranggay2 = "";

	private static final String city2 = "";

	private static final String province2 = "";

	private static final String country2 = "";

	private static final String houseOwnerLease2 = "";

	private static final String occupiedSince2 = "";
	
	private static final String idtype1 = "";
	
	private static final String idtype2 = "";
	
	private static final String idtype3 = "";
	
	private static final String idtypenum1 = "";

	private static final String idtypenum2 = "";
	
	private static final String idtypenum3 = "";
	
	private static final String idTypeIssueDate1 = "";
	
	private static final String idTypeIssueCountry1 = "";
	
	private static final String idTypeExpiryDate1 = "";
	
	private static final String idTypeIssuedBy1 = "";
	
	private static final String idTypeIssueDate2 = "";
	
	private static final String idTypeIssueCountry2 = "";
	
	private static final String idTypeExpiryDate2 = "";
	
	private static final String idTypeIssuedBy2 = "";
	
	private static final String idTypeIssueDate3 = "";
	
	private static final String idTypeIssueCountry3 = "";
	
	private static final String idTypeExpiryDate3 = "";
	
	private static final String idTypeIssuedBy3 = "";

	private static final String contactType1 ="3";
	
	private static final String employmentorpTin ="";
	
	private static final String employmentPsic ="";
	
	private static final String employmentAnnualMontlyIndicator ="";
	
	private static final String employmentCurrency ="";
	
	private static final String employmentDateHiredFrom ="";
	
	private static final String employmentDateHiredTo ="";
	
	private static final String occupation ="";
	
	private static final String soleTraderName1 ="";
	
	private static final String soleTraderAddressType1 ="";
	
	private static final String soleTraderFullAddress1 ="";
	
	private static final String soleTraderStreetNo1 ="";
	
	private static final String soleTraderPostalCode1 ="";
	
	private static final String soleTraderSubdivision1 ="";
	
	private static final String soleTraderBrgy1 ="";
	
	private static final String soleTraderBrgy2 ="";

	private static final String soleTraderCity1 ="";
	
	private static final String soleTraderProvince1 ="";
	
	private static final String soleTraderCountry1 ="";
	
	private static final String soleTraderHouseOwnerLease1 ="";
	
	private static final String soleTraderOccupiedSince1 ="";
	
	private static final String soleTraderAddressType2 ="";
	
	private static final String soleTraderFullAddress2 ="";
	
	private static final String soleTraderStreetNo2 ="";
	
	private static final String soleTraderPostalCode2 ="";
	
	private static final String soleTraderSubdivision2 ="";
	
	private static final String soleTraderCity2 ="";
	
	private static final String soleTraderProvince2 ="";
	
	private static final String soleTraderCountry2 ="";
	
	private static final String soleTraderHouseOwnerLease2 ="";
	
	private static final String soleTraderOccupiedSince2 ="";
	
	private static final String soleTraderIdentification1 ="";

	private static final String soleTraderIdentificationNum1 ="";
	
	private static final String soleTraderIdentification2 ="";
	
	private static final String soleTraderIdentificationNum2 ="";
	
	private static final String soleTraderContactType1 ="";

	private static final String soleTraderContactType2 ="";
	
	private static final String soleTraderContactValue1 ="";
	
	private static final String soleTraderContactValue2 ="";
	
	
	public String getSoletradercontacttype1() {
		return soleTraderContactType1;
	}

	public String getSoletradercontacttype2() {
		return soleTraderContactType2;
	}

	public String getSoletradercontactvalue1() {
		return soleTraderContactValue1;
	}

	public String getSoletradercontactvalue2() {
		return soleTraderContactValue2;
	}
	
	public  String getSoletraderidentification1() {
		return soleTraderIdentification1;
	}

	public  String getSoletraderidentificationnum1() {
		return soleTraderIdentificationNum1;
	}

	public  String getSoletraderidentification2() {
		return soleTraderIdentification2;
	}

	public  String getSoletraderidentificationnum2() {
		return soleTraderIdentificationNum2;
	}
	
	public  String getSoletraderbrgy1() {
		return soleTraderBrgy1;
	}

	public  String getSoletraderbrgy2() {
		return soleTraderBrgy2;
	}
	
	public String getIdtypenum1() {
		return idtypenum1;
	}

	public String getIdtypenum2() {
		return idtypenum2;
	}
	
	public String getIdtype1() {
		return idtype1;
	}

	public String getIdtype2() {
		return idtype2;
	}

	public String getSoleTraderFullAddress2() {
		return soleTraderFullAddress2;
	}

	public String getSoleTraderStreetNo2() {
		return soleTraderStreetNo2;
	}

	public String getSoleTraderPostalCode2() {
		return soleTraderPostalCode2;
	}

	public String getSoleTraderSubdivision2() {
		return soleTraderSubdivision2;
	}

	public String getSoleTraderCity2() {
		return soleTraderCity2;
	}

	public String getSoleTraderProvince2() {
		return soleTraderProvince2;
	}

	public String getSoleTraderCountry2() {
		return soleTraderCountry2;
	}

	public String getSoleTraderHouseOwnerLease2() {
		return soleTraderHouseOwnerLease2;
	}

	public String getSoleTraderOccupiedSince2() {
		return soleTraderOccupiedSince2;
	}

	public String getSoleTraderAddressType2() {
		return soleTraderAddressType2;
	}
	
	public String getSoleTraderFullAddress1() {
		return soleTraderFullAddress1;
	}

	public String getSoleTraderStreetNo1() {
		return soleTraderStreetNo1;
	}

	public String getSoleTraderPostalCode1() {
		return soleTraderPostalCode1;
	}

	public String getSoleTraderSubdivision1() {
		return soleTraderSubdivision1;
	}

	public String getSoleTraderCity1() {
		return soleTraderCity1;
	}

	public String getSoleTraderProvince1() {
		return soleTraderProvince1;
	}

	public String getSoleTraderCountry1() {
		return soleTraderCountry1;
	}

	public String getSoleTraderHouseOwnerLease1() {
		return soleTraderHouseOwnerLease1;
	}

	public String getSoleTraderOccupiedSince1() {
		return soleTraderOccupiedSince1;
	}

	public String getSoleTraderName1() {
		return soleTraderName1;
	}

	public String getSoleTraderAddressType1() {
		return soleTraderAddressType1;
	}

	public  String getOccupation() {
		return occupation;
	}
	
	public  String getEmploymentDateHiredTo() {
		return employmentDateHiredTo;
	}
	
	public  String getEmploymentDateHiredFrom() {
		return employmentDateHiredFrom;
	}
	
	public  String getEmploymentCurrency() {
		return employmentCurrency;
	}
	
	public  String getEmploymentAnnualMontlyIndicator() {
		return employmentAnnualMontlyIndicator;
	}
	
	public  String getEmploymentPsic() {
		return employmentPsic;
	}
	
	public  String getEmploymentCorpTin() {
		return employmentorpTin;
	}
	
	
	public  String getContactType1() {
		return contactType1;
	}
	
	public  String getIdTypeIssueDate1() {
		return idTypeIssueDate1;
	}

	public  String getIdTypeIssueCountry1() {
		return idTypeIssueCountry1;
	}

	public  String getIdTypeExpiryDate1() {
		return idTypeExpiryDate1;
	}

	public  String getIdTypeIssuedBy1() {
		return idTypeIssuedBy1;
	}

	public  String getIdTypeIssueDate2() {
		return idTypeIssueDate2;
	}

	public  String getIdTypeIssueCountry2() {
		return idTypeIssueCountry2;
	}

	public  String getIdTypeExpiryDate2() {
		return idTypeExpiryDate2;
	}

	public  String getIdTypeIssuedBy2() {
		return idTypeIssuedBy2;
	}

	public  String getIdTypeIssueDate3() {
		return idTypeIssueDate3;
	}

	public  String getIdTypeIssueCountry3() {
		return idTypeIssueCountry3;
	}

	public  String getIdTypeExpiryDate3() {
		return idTypeExpiryDate3;
	}

	public  String getIdTypeIssuedBy3() {
		return idTypeIssuedBy3;
	}

	public String getIdType3() {
		return idtype3;
	}

	public String getIdTypeNum3() {
		return idtypenum3;
	}

	public String getHouseOwnerLease2() {
		return houseOwnerLease2;
	}

	public String getOccupiedSince2() {
		return occupiedSince2;
	}

	public String getStreetNo2() {
		return streetNo2;
	}

	public String getPostalCode2() {
		return postalCode2;
	}

	public String getSubdivision2() {
		return subdivision2;
	}

	public String getBaranggay2() {
		return baranggay2;
	}

	public String getCity2() {
		return city2;
	}

	public String getProvince2() {
		return province2;
	}

	public String getCountry2() {
		return country2;
	}

	public String getFullAddress2() {
		return fullAddress2;
	}

	public String getAddressType2() {
		return addressType2;
	}

	public String getOccupiedSince1() {
		return occupiedSince1;
	}

	public String getHouseownerLease1() {
		return houseOwnerLease1;
	}

	public String getPostalCode1() {
		return postalCode1;
	}

	public String getCountry1() {
		return country1;
	}

	public String getStreetNo1() {
		return streetNo1;
	}

	public String getSubdivision1() {
		return subdivision1;
	}

	public String getBaranggay1() {
		return baranggay1;
	}

	public String getCity1() {
		return city1;
	}

	public String getProvince1() {
		return province1;
	}

	public String getAddressType1() {
		return addressType1;
	}

	public String getRecordType() {
		return recordType;
	}

	

	public String getBranchCode() {
		return branchCode;
	}

	public String getSubjectRefDate() {
		DateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
		Date date = new Date();
		return dateFormat.format(date);

	}

	public String getTitle() {
		return title;
	}

	public String getSuffix() {
		return suffix;
	}

	public String getNickName() {
		return nickName;
	}

	public String getPreviousLastName() {
		return previousLastName;
	}

	public String getPlaceOfBirth() {
		return placeOfBirth;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public String getResident() {
		return resident;
	}

	public String getCivilStatus() {
		return civilStatus;
	}

	public String getDependantsCount() {
		return dependantsCount;
	}

	public String getCarsOwned() {
		return carsOwned;
	}

	public String getSpouseFirstName() {
		return spouseFirstName;
	}

	public String getSpouseLastName() {
		return spouseLastName;
	}

	public String getSpouseMiddleName() {
		return spouseMiddleName;
	}

	public String getMotherMaidenFirstName() {
		return motherMaidenFirstName;
	}

	public String getMotherMaidenLastName() {
		return motherMaidenLastName;
	}

	public String getMotherMaidenMiddleName() {
		return motherMaidenMiddleName;
	}

	public String getFatherFirstName() {
		return fatherFirstName;
	}

	public String getFatherLastName() {
		return fatherLastName;
	}

	public String getFatherMiddleName() {
		return fatherMiddleName;
	}

	public String getFatherSuffix() {
		return fatherSuffix;
	}

}
