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
 * Factor set by the region
 */

@Schema(name = "FactorRegion", description = "Factor set by the region")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T16:24:06.632090700+02:00[Europe/Berlin]")
public class FactorRegion {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("region")
  private String region;

  @JsonProperty("factor")
  private Float factor;

  public FactorRegion id(Integer id) {
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

  public FactorRegion region(String region) {
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

  public FactorRegion factor(Float factor) {
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
    FactorRegion factorRegion = (FactorRegion) o;
    return Objects.equals(this.id, factorRegion.id) &&
        Objects.equals(this.region, factorRegion.region) &&
        Objects.equals(this.factor, factorRegion.factor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, region, factor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FactorRegion {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    region: ").append(toIndentedString(region)).append("\n");
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

