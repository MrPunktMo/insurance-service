package org.triplem.insurancedataservice.models;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.time.LocalDate;
import org.springframework.format.annotation.DateTimeFormat;
import org.openapitools.jackson.nullable.JsonNullable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Fee for the insurance
 */

@Schema(name = "Fee", description = "Fee for the insurance")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T16:24:06.632090700+02:00[Europe/Berlin]")
public class Fee {

  @JsonProperty("amount")
  private Float amount;

  @JsonProperty("kilometrage")
  private Integer kilometrage;

  @JsonProperty("postalCode")
  private String postalCode;

  @JsonProperty("vehicleType")
  private String vehicleType;

  @JsonProperty("user")
  private String user;

  @JsonProperty("createdOn")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate createdOn;

  public Fee amount(Float amount) {
    this.amount = amount;
    return this;
  }

  /**
   * Get amount
   * @return amount
  */
  @NotNull 
  @Schema(name = "amount", requiredMode = Schema.RequiredMode.REQUIRED)
  public Float getAmount() {
    return amount;
  }

  public void setAmount(Float amount) {
    this.amount = amount;
  }

  public Fee kilometrage(Integer kilometrage) {
    this.kilometrage = kilometrage;
    return this;
  }

  /**
   * Get kilometrage
   * @return kilometrage
  */
  @NotNull 
  @Schema(name = "kilometrage", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getKilometrage() {
    return kilometrage;
  }

  public void setKilometrage(Integer kilometrage) {
    this.kilometrage = kilometrage;
  }

  public Fee postalCode(String postalCode) {
    this.postalCode = postalCode;
    return this;
  }

  /**
   * Get postalCode
   * @return postalCode
  */
  @NotNull 
  @Schema(name = "postalCode", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getPostalCode() {
    return postalCode;
  }

  public void setPostalCode(String postalCode) {
    this.postalCode = postalCode;
  }

  public Fee vehicleType(String vehicleType) {
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

  public Fee user(String user) {
    this.user = user;
    return this;
  }

  /**
   * Get user
   * @return user
  */
  @NotNull 
  @Schema(name = "user", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public Fee createdOn(LocalDate createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * Get createdOn
   * @return createdOn
  */
  @Valid 
  @Schema(name = "createdOn", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public LocalDate getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(LocalDate createdOn) {
    this.createdOn = createdOn;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Fee fee = (Fee) o;
    return Objects.equals(this.amount, fee.amount) &&
        Objects.equals(this.kilometrage, fee.kilometrage) &&
        Objects.equals(this.postalCode, fee.postalCode) &&
        Objects.equals(this.vehicleType, fee.vehicleType) &&
        Objects.equals(this.user, fee.user) &&
        Objects.equals(this.createdOn, fee.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, kilometrage, postalCode, vehicleType, user, createdOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Fee {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    kilometrage: ").append(toIndentedString(kilometrage)).append("\n");
    sb.append("    postalCode: ").append(toIndentedString(postalCode)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
    sb.append("    user: ").append(toIndentedString(user)).append("\n");
    sb.append("    createdOn: ").append(toIndentedString(createdOn)).append("\n");
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

