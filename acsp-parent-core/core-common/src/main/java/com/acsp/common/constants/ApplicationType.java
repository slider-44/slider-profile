package com.acsp.common.constants;

public enum ApplicationType {

  REGULAR((byte) 1, "REGULAR"),
  FAST_LANE((byte) 2, "FAST LANE"),
  SALARY_DEDUCTION((byte) 3, "SALARY DEDUCTION"),
  RESTRUCTURING((byte) 4, "RESTRUCTURING");

  private Byte code;

  private String name;

  private ApplicationType(Byte code, String name) {
    this.code = code;
    this.name = name;
  }

  public int getCode() {

    return this.code;
  }

  public String getName() {

    return this.name;
  }

  public static ApplicationType byCode(Byte code) {

    if( code == null ) {
      return null;
    }
    
    for ( ApplicationType applicationType : ApplicationType.values() ) {
      if ( applicationType.code == code ) {
        return applicationType;
      }
    }

    return null;
  }
  
  public static String getNameByCode(Byte code) {
    ApplicationType applicationType = byCode(code);
    return applicationType == null ? null : applicationType.name;
  }
  
}
