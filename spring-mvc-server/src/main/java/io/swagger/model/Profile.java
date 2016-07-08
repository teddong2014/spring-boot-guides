package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-07-05T07:39:20.306Z")
public class Profile  {
  
  private String firstName = null;
  private String lastName = null;
  private String email = null;
  private String picture = null;
  private String promoCode = null;

  /**
   * First name of the Uber user.
   **/
  @ApiModelProperty(value = "First name of the Uber user.")
  @JsonProperty("first_name")
  public String getFirstName() {
    return firstName;
  }
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Last name of the Uber user.
   **/
  @ApiModelProperty(value = "Last name of the Uber user.")
  @JsonProperty("last_name")
  public String getLastName() {
    return lastName;
  }
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Email address of the Uber user
   **/
  @ApiModelProperty(value = "Email address of the Uber user")
  @JsonProperty("email")
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }

  /**
   * Image URL of the Uber user.
   **/
  @ApiModelProperty(value = "Image URL of the Uber user.")
  @JsonProperty("picture")
  public String getPicture() {
    return picture;
  }
  public void setPicture(String picture) {
    this.picture = picture;
  }

  /**
   * Promo code of the Uber user.
   **/
  @ApiModelProperty(value = "Promo code of the Uber user.")
  @JsonProperty("promo_code")
  public String getPromoCode() {
    return promoCode;
  }
  public void setPromoCode(String promoCode) {
    this.promoCode = promoCode;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Profile profile = (Profile) o;
    return Objects.equals(firstName, profile.firstName) &&
        Objects.equals(lastName, profile.lastName) &&
        Objects.equals(email, profile.email) &&
        Objects.equals(picture, profile.picture) &&
        Objects.equals(promoCode, profile.promoCode);
  }

  @Override
  public int hashCode() {
    return Objects.hash(firstName, lastName, email, picture, promoCode);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Profile {\n");
    
    sb.append("  firstName: ").append(firstName).append("\n");
    sb.append("  lastName: ").append(lastName).append("\n");
    sb.append("  email: ").append(email).append("\n");
    sb.append("  picture: ").append(picture).append("\n");
    sb.append("  promoCode: ").append(promoCode).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
