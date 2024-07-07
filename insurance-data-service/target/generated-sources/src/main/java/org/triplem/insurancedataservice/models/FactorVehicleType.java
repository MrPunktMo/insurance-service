package org.triplem.insurancedataservice.models;

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
 * Factor of a vehicle type
 */

@Schema(name = "FactorVehicleType", description = "Factor of a vehicle type")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T16:24:06.632090700+02:00[Europe/Berlin]")
public class FactorVehicleType {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("type")
  private String type;

  @JsonProperty("factor")
  private Float factor;

  public FactorVehicleType id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
  */
  @NotNull 
  @Schema(name = "id", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public FactorVehicleType type(String type) {
    this.type = type;
    return this;
  }

  /**
   * Get type
   * @return type
  */
  @NotNull 
  @Schema(name = "type", requiredMode = Schema.RequiredMode.REQUIRED)
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public FactorVehicleType factor(Float factor) {
    this.factor = factor;
    return this;
  }

  /**
   * Get factor
   * @return factor
  */
  @NotNull 
  @Schema(name = "factor", requiredMode = Schema.RequiredMode.REQUIRED)
  public Float getFactor() {
    return factor;
  }

  public void setFactor(Float factor) {
    this.factor = factor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    FactorVehicleType factorVehicleType = (FactorVehicleType) o;
    return Objects.equals(this.id, factorVehicleType.id) &&
        Objects.equals(this.type, factorVehicleType.type) &&
        Objects.equals(this.factor, factorVehicleType.factor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, type, factor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FactorVehicleType {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    type: ").append(toIndentedString(type)).append("\n");
    sb.append("    factor: ").append(toIndentedString(factor)).append("\n");
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

