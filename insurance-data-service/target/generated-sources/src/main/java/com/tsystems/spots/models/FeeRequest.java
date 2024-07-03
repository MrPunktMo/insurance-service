package com.tsystems.spots.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Request for calculating the insurance fee
 */

@Schema(name = "FeeRequest", description = "Request for calculating the insurance fee")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-02T18:10:48.810394500+02:00[Europe/Berlin]")
public class FeeRequest {

  @JsonProperty("kilometrage")
  private Integer kilometrage;

  @JsonProperty("vehicleType")
  private String vehicleType;

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("userName")
  private String userName;

  public FeeRequest kilometrage(Integer kilometrage) {
    this.kilometrage = kilometrage;
    return this;
  }

  /**
   * Get kilometrage
   * minimum: 0
   * @return kilometrage
  */
  @NotNull @Min(0) 
  @Schema(name = "kilometrage", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getKilometrage() {
    return kilometrage;
  }

  public void setKilometrage(Integer kilometrage) {
    this.kilometrage = kilometrage;
  }

  public FeeRequest vehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
    return this;
  }

  /**
   * Get vehicleType
   * @return vehicleType
  */
  @NotNull 
  @Schema(name = "vehicleType", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getVehicleType() {
    return vehicleType;
  }

  public void setVehicleType(String vehicleType) {
    this.vehicleType = vehicleType;
  }

  public FeeRequest postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  @NotNull @Pattern(regexp = "^[0-9]{5}") 
  @Schema(name = "postalCode", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public FeeRequest userName(String userName) {
    this.userName = userName;
    return this;
  }

  /**
   * Get userName
   * @return userName
  */
  @NotNull 
  @Schema(name = "userName", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getUserName() {
    return userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FeeRequest feeRequest = (FeeRequest) o;
    return Objects.equals(this.kilometrage, feeRequest.kilometrage) &&
        Objects.equals(this.vehicleType, feeRequest.vehicleType) &&
        Objects.equals(this.postalCode, feeRequest.postalCode) &&
        Objects.equals(this.userName, feeRequest.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(kilometrage, vehicleType, postalCode, userName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeeRequest {\n");
    sb.append("    kilometrage: ").append(toIndentedString(kilometrage)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    userName: ").append(toIndentedString(userName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

