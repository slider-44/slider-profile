package com.acsp.common.constants;


public enum IDType {
  SSS_GSIS((byte) 1, "SSS/GSIS"),
  TIN((byte) 2, "TIN"),
  PRC((byte) 6, "PRC"),
  PASSPORT((byte) 5, "PASSPORT"),
  DRIVERS_LICENSE((byte) 7, "DRIVER'S LICENSE "),
  COMPANY_ID((byte) 8, "COMPANY ID"),
  OWWA_CARD((byte) 9, "OWWA CARD"),
  UMID((byte) 10, "UMID"),
  SENIOR_CITIZEN_CARD((byte) 11, "SENIOR CITIZEN CARD"),
  BRGY_CERT((byte) 12, "BRGY CERT"),
  POSTAL_ID((byte) 13, "POSTAL ID"),
  VOTERS_ID((byte) 14, "VOTER'S ID"),
  NBI_CLEARANCE((byte) 15, "NBI CLEARANCE"),
  POLICE_CLEARANCE((byte) 16, "POLICE CLEARANCE"),
  OFW_ID((byte) 17, "OFW ID"),
  SEAMANS_BOOK((byte) 18, "SEAMAN'S BOOK'"),
  ALIEN_IMMIGRANT_CO_REG((byte) 19, "ALIEN/IMMIGRANT CO REG"),
  NCWDP((byte) 20, "NCWDP"),
  GOCC_ID_AFP_HDMF((byte) 21, "GOCC ID AFP/HDMF"),
  DSWD_CERT((byte) 22, "DSWD CERT"),
  IBP_ID((byte) 23, "IBP ID"),
  COMPANY_ID_2((byte) 24, "COMPANY ID"),
  SCHOOL_ID((byte) 25, "SCHOOL ID"),
  PHILHEALTH((byte) 26, "PHILHEALTH"),
  DIPLOMAT((byte) 27, "DIPLOMAT"),
  PLRA((byte) 28, "PLRA"),
  DSWD_CERT_2((byte) 29, "DSWD CERT"),
  MAJOR_CREDIT_CARD((byte) 30, "MAJOR CREDIT CARD"),
  FIREARMS_LICENSE((byte) 31, "FIREARMS LICENSE"),
  WORK_PERMIT((byte) 32, "WORK PERMIT"),
  AFP_PNP_RETIREE_ID((byte) 33, "AFP/PNP RETIREE ID"),
  SIRV((byte) 34, "SIRV"),
  PAGIBIG_ID((byte) 35, "PAG-IBIG ID"),
  CUSTOMER_CODE((byte) 3, "CUSTOMER CODE"),
  EXPRESS_CARD_MEMBER((byte) 4, "EXPRESS CARD MEMBER");

  private Byte code;
  
  private String name;
  
  private IDType(Byte code, String name) {
    this.code = code;
    this.name = name;
  }

  public int getCode() {

    return this.code;
  }

  public String getName() {

    return this.name;
  }

  public static IDType byCode(Byte code) {

    if( code == null ) {
      return null;
    }
    
    for ( IDType idType : IDType.values() ) {
      if ( idType.code == code ) {
        return idType;
      }
    }

    return null;
  }
  
  public static String getNameByCode(Byte code) {
    IDType idType = byCode(code);
    return idType == null ? null : idType.name;
  }
  
}
