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
 * Factor set by the kilometrage
 */

@Schema(name = "FactorKilometrage", description = "Factor set by the kilometrage")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-07-07T16:24:06.632090700+02:00[Europe/Berlin]")
public class FactorKilometrage {

  @JsonProperty("id")
  private Integer id;

  @JsonProperty("from")
  private Integer from;

  @JsonProperty("to")
  private Integer to;

  @JsonProperty("factor")
  private Float factor;

  public FactorKilometrage id(Integer id) {
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

  public FactorKilometrage from(Integer from) {
    this.from = from;
    return this;
  }

  /**
   * Get from
   * @return from
  */
  @NotNull 
  @Schema(name = "from", requiredMode = Schema.RequiredMode.REQUIRED)
  public Integer getFrom() {
    return from;
  }

  public void setFrom(Integer from) {
    this.from = from;
  }

  public FactorKilometrage to(Integer to) {
    this.to = to;
    return this;
  }

  /**
   * Get to
   * @return to
  */
  
  @Schema(name = "to", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
  public Integer getTo() {
    return to;
  }

  public void setTo(Integer to) {
    this.to = to;
  }

  public FactorKilometrage factor(Float factor) {
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
    FactorKilometrage factorKilometrage = (FactorKilometrage) o;
    return Objects.equals(this.id, factorKilometrage.id) &&
        Objects.equals(this.from, factorKilometrage.from) &&
        Objects.equals(this.to, factorKilometrage.to) &&
        Objects.equals(this.factor, factorKilometrage.factor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, from, to, factor);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class FactorKilometrage {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    from: ").append(toIndentedString(from)).append("\n");
    sb.append("    to: ").append(toIndentedString(to)).append("\n");
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

