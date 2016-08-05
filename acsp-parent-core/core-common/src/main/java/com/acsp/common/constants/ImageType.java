package com.acsp.common.constants;


public enum ImageType {
  APPLICATION_FORM((byte) 0, "APPLICATION FORM"),
  ID_PROOF((byte) 1, "ID PROOF"),
  PROOF_OF_BILLING((byte) 2, "PROOF OF BILLING"),
  PROOF_OF_INCOME((byte) 3, "PROOF OF INCOME"),
  HOUSE_SKETCH((byte) 4, "HOUSE SKETCH"),
  CUSTOMER_IMAGE((byte) 5, "CUSTOMER IMAGE"),
  SUPPORTING_DOCUMENTS((byte) 6, "SUPPORTING DOCUMENTS"),
  SSS_PROOF((byte) 7, "SSS PROOF"),
  SIGNED_LON((byte) 8, "SIGNED LON"),
  PRODUCT_RECEIPT((byte) 9, "PRODUCT RECEIPT");
  
  private Byte code;
  
  private String name;
  
  private ImageType(Byte code, String name) {
    this.code = code;
    this.name = name;
  }

  public Byte getCode() {

    return this.code;
  }

  public String getName() {

    return this.name;
  }

  public static ImageType byCode(Byte code) {

    if( code == null ) {
      return null;
    }
    
    for ( ImageType imageType : ImageType.values() ) {
      if ( imageType.code == code ) {
        return imageType;
      }
    }

    return null;
  }
  
  public static String getNameByCode(Byte code) {
    ImageType imageType = byCode(code);
    return imageType == null ? null : imageType.name;
  }
}
