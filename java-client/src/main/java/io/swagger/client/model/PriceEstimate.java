package io.swagger.client.model;

import com.fasterxml.jackson.annotation.JsonValue;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;


/**
 * PriceEstimate
 */
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-07-05T07:19:17.650Z")
public class PriceEstimate   {
  
  private String productId = null;
  private String currencyCode = null;
  private String displayName = null;
  private String estimate = null;
  private BigDecimal lowEstimate = null;
  private BigDecimal highEstimate = null;
  private BigDecimal surgeMultiplier = null;

  
  /**
   * Unique identifier representing a specific product for a given latitude & longitude. For example, uberX in San Francisco will have a different product_id than uberX in Los Angeles
   **/
  public PriceEstimate productId(String productId) {
    this.productId = productId;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Unique identifier representing a specific product for a given latitude & longitude. For example, uberX in San Francisco will have a different product_id than uberX in Los Angeles")
  @JsonProperty("product_id")
  public String getProductId() {
    return productId;
  }
  public void setProductId(String productId) {
    this.productId = productId;
  }


  /**
   * [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code.
   **/
  public PriceEstimate currencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "[ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code.")
  @JsonProperty("currency_code")
  public String getCurrencyCode() {
    return currencyCode;
  }
  public void setCurrencyCode(String currencyCode) {
    this.currencyCode = currencyCode;
  }


  /**
   * Display name of product.
   **/
  public PriceEstimate displayName(String displayName) {
    this.displayName = displayName;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Display name of product.")
  @JsonProperty("display_name")
  public String getDisplayName() {
    return displayName;
  }
  public void setDisplayName(String displayName) {
    this.displayName = displayName;
  }


  /**
   * Formatted string of estimate in local currency of the start location. Estimate could be a range, a single number (flat rate) or \"Metered\" for TAXI.
   **/
  public PriceEstimate estimate(String estimate) {
    this.estimate = estimate;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Formatted string of estimate in local currency of the start location. Estimate could be a range, a single number (flat rate) or \"Metered\" for TAXI.")
  @JsonProperty("estimate")
  public String getEstimate() {
    return estimate;
  }
  public void setEstimate(String estimate) {
    this.estimate = estimate;
  }


  /**
   * Lower bound of the estimated price.
   **/
  public PriceEstimate lowEstimate(BigDecimal lowEstimate) {
    this.lowEstimate = lowEstimate;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Lower bound of the estimated price.")
  @JsonProperty("low_estimate")
  public BigDecimal getLowEstimate() {
    return lowEstimate;
  }
  public void setLowEstimate(BigDecimal lowEstimate) {
    this.lowEstimate = lowEstimate;
  }


  /**
   * Upper bound of the estimated price.
   **/
  public PriceEstimate highEstimate(BigDecimal highEstimate) {
    this.highEstimate = highEstimate;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Upper bound of the estimated price.")
  @JsonProperty("high_estimate")
  public BigDecimal getHighEstimate() {
    return highEstimate;
  }
  public void setHighEstimate(BigDecimal highEstimate) {
    this.highEstimate = highEstimate;
  }


  /**
   * Expected surge multiplier. Surge is active if surge_multiplier is greater than 1. Price estimate already factors in the surge multiplier.
   **/
  public PriceEstimate surgeMultiplier(BigDecimal surgeMultiplier) {
    this.surgeMultiplier = surgeMultiplier;
    return this;
  }
  
  @ApiModelProperty(example = "null", value = "Expected surge multiplier. Surge is active if surge_multiplier is greater than 1. Price estimate already factors in the surge multiplier.")
  @JsonProperty("surge_multiplier")
  public BigDecimal getSurgeMultiplier() {
    return surgeMultiplier;
  }
  public void setSurgeMultiplier(BigDecimal surgeMultiplier) {
    this.surgeMultiplier = surgeMultiplier;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    PriceEstimate priceEstimate = (PriceEstimate) o;
    return Objects.equals(this.productId, priceEstimate.productId) &&
        Objects.equals(this.currencyCode, priceEstimate.currencyCode) &&
        Objects.equals(this.displayName, priceEstimate.displayName) &&
        Objects.equals(this.estimate, priceEstimate.estimate) &&
        Objects.equals(this.lowEstimate, priceEstimate.lowEstimate) &&
        Objects.equals(this.highEstimate, priceEstimate.highEstimate) &&
        Objects.equals(this.surgeMultiplier, priceEstimate.surgeMultiplier);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, currencyCode, displayName, estimate, lowEstimate, highEstimate, surgeMultiplier);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PriceEstimate {\n");
    
    sb.append("    productId: ").append(toIndentedString(productId)).append("\n");
    sb.append("    currencyCode: ").append(toIndentedString(currencyCode)).append("\n");
    sb.append("    displayName: ").append(toIndentedString(displayName)).append("\n");
    sb.append("    estimate: ").append(toIndentedString(estimate)).append("\n");
    sb.append("    lowEstimate: ").append(toIndentedString(lowEstimate)).append("\n");
    sb.append("    highEstimate: ").append(toIndentedString(highEstimate)).append("\n");
    sb.append("    surgeMultiplier: ").append(toIndentedString(surgeMultiplier)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

