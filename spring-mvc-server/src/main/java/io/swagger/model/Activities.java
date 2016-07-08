package io.swagger.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.Activity;
import java.util.ArrayList;
import java.util.List;

import io.swagger.annotations.*;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


@ApiModel(description = "")
@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringMVCServerCodegen", date = "2016-07-05T07:39:20.306Z")
public class Activities  {
  
  private Integer offset = null;
  private Integer limit = null;
  private Integer count = null;
  private List<Activity> history = new ArrayList<Activity>();

  /**
   * Position in pagination.
   **/
  @ApiModelProperty(value = "Position in pagination.")
  @JsonProperty("offset")
  public Integer getOffset() {
    return offset;
  }
  public void setOffset(Integer offset) {
    this.offset = offset;
  }

  /**
   * Number of items to retrieve (100 max).
   **/
  @ApiModelProperty(value = "Number of items to retrieve (100 max).")
  @JsonProperty("limit")
  public Integer getLimit() {
    return limit;
  }
  public void setLimit(Integer limit) {
    this.limit = limit;
  }

  /**
   * Total number of items available.
   **/
  @ApiModelProperty(value = "Total number of items available.")
  @JsonProperty("count")
  public Integer getCount() {
    return count;
  }
  public void setCount(Integer count) {
    this.count = count;
  }

  /**
   **/
  @ApiModelProperty(value = "")
  @JsonProperty("history")
  public List<Activity> getHistory() {
    return history;
  }
  public void setHistory(List<Activity> history) {
    this.history = history;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Activities activities = (Activities) o;
    return Objects.equals(offset, activities.offset) &&
        Objects.equals(limit, activities.limit) &&
        Objects.equals(count, activities.count) &&
        Objects.equals(history, activities.history);
  }

  @Override
  public int hashCode() {
    return Objects.hash(offset, limit, count, history);
  }

  @Override
  public String toString()  {
    StringBuilder sb = new StringBuilder();
    sb.append("class Activities {\n");
    
    sb.append("  offset: ").append(offset).append("\n");
    sb.append("  limit: ").append(limit).append("\n");
    sb.append("  count: ").append(count).append("\n");
    sb.append("  history: ").append(history).append("\n");
    sb.append("}\n");
    return sb.toString();
  }
}
