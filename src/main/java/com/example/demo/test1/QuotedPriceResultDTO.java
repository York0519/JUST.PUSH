package com.example.demo.test1;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder(toBuilder = true)
public class QuotedPriceResultDTO {

  private Integer distanceSortValue;

  private Double countryDistance;

  @Override
  public String toString() {
    return this.getDistanceSortValue() + " " + this.getCountryDistance();
  }

  public boolean validate() {
    return null == this;
  }
}
