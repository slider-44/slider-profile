package com.acsp.common.constants;


public enum ApplicationStage {

  FOR_DOCUMENT_ENTRY("FOR DOCUMENT ENTRY", ""),
  NEEDING_FURTHER_DOCUMENTS("NEEDING FURTHER DOCUMENTS", ""),
  FOR_APPROVAL("FOR APPROVAL", ""),
  REJECTED("REJECTED", ""),
  CANCELLED("CANCELLED", ""),
  FOR_LON_SIGNING("FOR LON SIGNING", ""),
  FOR_SALES_PROCESSING("FOR SALES PROCESSING", ""),
  SALES_PROCESSED("SALES PROCESSED", ""),
  UNKOWN("FOR DOCUMENT ENTRY", "");
  
  String name;
  
  String description;

  private ApplicationStage(String name, String description) {
    this.name = name;
    this.description = description;
  }
  
  public String getName() {
  
    return name;
  }
  
  public String getDescription() {
  
    return description;
  }
  
}