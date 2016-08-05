package com.acsp.common.dto;

public class Error {

  public String fieldName;

  public String fieldError;

  /**
   * Constructs an Error instance with fieldName and fieldError.
   * @param fieldName Name of the field (usually the name attribute of an HTML field).
   * @param fieldError Error message to be associated with the fieldName.
   */
  public Error(String fieldName, String fieldError) {
    super();
    this.fieldName = fieldName;
    this.fieldError = fieldError;
  }

  public String getFieldName() {

    return fieldName;
  }

  public void setFieldName(String fieldName) {

    this.fieldName = fieldName;
  }

  public String getFieldError() {

    return fieldError;
  }

  public void setFieldError(String fieldError) {

    this.fieldError = fieldError;
  }

}
