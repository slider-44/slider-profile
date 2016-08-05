package com.acsp.common.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.validation.FieldError;

public class BaseResponseDTO {

  private boolean responseSuccess;

  private String responseMessage;

  private List<Error> responseErrors;

  public BaseResponseDTO() {}

  public boolean isResponseSuccess() {

    return responseSuccess;
  }

  public void setResponseSuccess(boolean responseSuccess) {

    this.responseSuccess = responseSuccess;
  }

  public String getResponseMessage() {

    return responseMessage;
  }

  public void setResponseMessage(String responseMessage) {

    this.responseMessage = responseMessage;
  }

  public List<Error> getResponseErrors() {

    return responseErrors;
  }

  public void setResponseErrors(List<Error> responseErrors) {

    this.responseErrors = responseErrors;
  }

  /**
   * Add an error message.
   * 
   * @param fieldName name of field to associate error
   * @param fieldError error message
   */
  public void addError(String fieldName, String fieldError) {

    if ( this.responseErrors == null ) {
      this.responseErrors = new ArrayList<>();
    }

    this.responseErrors.add(new Error(fieldName, fieldError));

  }

  /**
   * Add errors from spring validations.
   * 
   * @param fieldErrors List of FieldError
   */
  public void addFieldErrors(List<FieldError> fieldErrors) {

    if ( fieldErrors == null ) {
      return;
    }

    fieldErrors.stream()
               .forEach(fieldError -> this.addError(fieldError.getField(),
                                                    fieldError.getDefaultMessage()));
  }
  public static class Builder {

    private boolean responseSuccess;

    private String responseMessage;

    private List<Error> responseErrors = new ArrayList<>();

    /**
     * Set here the processing status (usually after controller method
     * invocation). 
     * @param responseSuccess true if Success, false otherwise.
     * @return The instance of the builder.
     */
    public Builder withResponseSuccess(boolean responseSuccess) {

      this.responseSuccess = responseSuccess;
      return this;
    }

    /**
     * Set here the message that will be sent back to the caller (REST call).
     * This is usually set when error occur but can also be set when a message is needed
     * even if the operation is successful.
     * @param responseMessage Message to be sent back to caller.
     * @return The instance of the builder.
     */
    public Builder withResponseMessage(String responseMessage) {

      this.responseMessage = responseMessage;
      return this;
    }

    /**
     * Set here the error message that will be associated with a specific property.
     * @param fieldName Name of the field (usually the name attribute of an HTML field).
     * @param fieldError Error message to be associated with the fieldName.
     * @return The instance of the builder.
     */
    public Builder addResponseError(String fieldName, String fieldError) {

      this.responseErrors.add(new Error(fieldName, fieldError));
      return this;
    }

    public BaseResponseDTO build() {

      return new BaseResponseDTO(this);
    }

  }

  protected BaseResponseDTO(Builder builder) {
    this.responseSuccess = builder.responseSuccess;
    this.responseMessage = builder.responseMessage;
    this.responseErrors = builder.responseErrors;
  }

}
