package com.tsystems.spots.models;

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
 * Resonse to the requested fee
 */

@Schema(name = "FeeResponse", description = "Resonse to the requested fee")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-02T18:10:48.810394500+02:00[Europe/Berlin]")
public class FeeResponse {

  @JsonProperty("amount")
  private Float amount;

  @JsonProperty("kilometrage")
  private Integer kilometrage;

  @JsonProperty("region")
  private String region;

  @JsonProperty("vehicleType")
  private String vehicleType;

  @JsonProperty("createdOn")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate createdOn;

  public FeeResponse amount(Float amount) {
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

  public FeeResponse kilometrage(Integer kilometrage) {
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

  public FeeResponse region(String region) {
    this.region = region;
    return this;
  }

  /**
   * Get region
   * @return region
  */
  @NotNull 
  @Schema(name = "region", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getRegion() {
    return region;
  }

  public void setRegion(String region) {
    this.region = region;
  }

  public FeeResponse vehicleType(String vehicleType) {
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

  public FeeResponse createdOn(LocalDate createdOn) {
    this.createdOn = createdOn;
    return this;
  }

  /**
   * Get createdOn
   * @return createdOn
  */
  @NotNull @Valid 
  @Schema(name = "createdOn", requiredMode = Schema.RequiredMode.REQUIRED)
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
    FeeResponse feeResponse = (FeeResponse) o;
    return Objects.equals(this.amount, feeResponse.amount) &&
        Objects.equals(this.kilometrage, feeResponse.kilometrage) &&
        Objects.equals(this.region, feeResponse.region) &&
        Objects.equals(this.vehicleType, feeResponse.vehicleType) &&
        Objects.equals(this.createdOn, feeResponse.createdOn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(amount, kilometrage, region, vehicleType, createdOn);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FeeResponse {\n");
    sb.append("    amount: ").append(toIndentedString(amount)).append("\n");
    sb.append("    kilometrage: ").append(toIndentedString(kilometrage)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
    sb.append("    vehicleType: ").append(toIndentedString(vehicleType)).append("\n");
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

