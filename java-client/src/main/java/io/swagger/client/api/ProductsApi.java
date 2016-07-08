package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.model.*;
import io.swagger.client.Pair;

import io.swagger.client.model.Product;
import io.swagger.client.model.Error;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-07-05T07:19:17.650Z")
public class ProductsApi {
  private ApiClient apiClient;

  public ProductsApi() {
    this(Configuration.getDefaultApiClient());
  }

  public ProductsApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Product Types
   * The Products endpoint returns information about the *Uber* products offered at a given location. The response includes the display name and other details about each product, and lists the products in the proper display order. 
   * @param latitude Latitude component of location. (required)
   * @param longitude Longitude component of location. (required)
   * @return List<Product>
   * @throws ApiException if fails to make API call
   */
  public List<Product> productsGet(Double latitude, Double longitude) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'latitude' is set
    if (latitude == null) {
      throw new ApiException(400, "Missing the required parameter 'latitude' when calling productsGet");
    }
    
    // verify the required parameter 'longitude' is set
    if (longitude == null) {
      throw new ApiException(400, "Missing the required parameter 'longitude' when calling productsGet");
    }
    
    // create path and map variables
    String localVarPath = "/products".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "latitude", latitude));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "longitude", longitude));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<Product>> localVarReturnType = new GenericType<List<Product>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
}
