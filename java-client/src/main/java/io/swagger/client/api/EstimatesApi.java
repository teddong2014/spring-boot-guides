package io.swagger.client.api;

import com.sun.jersey.api.client.GenericType;

import io.swagger.client.ApiException;
import io.swagger.client.ApiClient;
import io.swagger.client.Configuration;
import io.swagger.client.model.*;
import io.swagger.client.Pair;

import io.swagger.client.model.Error;
import io.swagger.client.model.PriceEstimate;
import io.swagger.client.model.Product;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.JavaClientCodegen", date = "2016-07-05T07:19:17.650Z")
public class EstimatesApi {
  private ApiClient apiClient;

  public EstimatesApi() {
    this(Configuration.getDefaultApiClient());
  }

  public EstimatesApi(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  public ApiClient getApiClient() {
    return apiClient;
  }

  public void setApiClient(ApiClient apiClient) {
    this.apiClient = apiClient;
  }

  /**
   * Price Estimates
   * The Price Estimates endpoint returns an estimated price range for each product offered at a given location. The price estimate is provided as a formatted string with the full price range and the localized currency symbol.&lt;br&gt;&lt;br&gt;The response also includes low and high estimates, and the [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code for situations requiring currency conversion. When surge is active for a particular product, its surge_multiplier will be greater than 1, but the price estimate already factors in this multiplier. 
   * @param startLatitude Latitude component of start location. (required)
   * @param startLongitude Longitude component of start location. (required)
   * @param endLatitude Latitude component of end location. (required)
   * @param endLongitude Longitude component of end location. (required)
   * @return List<PriceEstimate>
   * @throws ApiException if fails to make API call
   */
  public List<PriceEstimate> estimatesPriceGet(Double startLatitude, Double startLongitude, Double endLatitude, Double endLongitude) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'startLatitude' is set
    if (startLatitude == null) {
      throw new ApiException(400, "Missing the required parameter 'startLatitude' when calling estimatesPriceGet");
    }
    
    // verify the required parameter 'startLongitude' is set
    if (startLongitude == null) {
      throw new ApiException(400, "Missing the required parameter 'startLongitude' when calling estimatesPriceGet");
    }
    
    // verify the required parameter 'endLatitude' is set
    if (endLatitude == null) {
      throw new ApiException(400, "Missing the required parameter 'endLatitude' when calling estimatesPriceGet");
    }
    
    // verify the required parameter 'endLongitude' is set
    if (endLongitude == null) {
      throw new ApiException(400, "Missing the required parameter 'endLongitude' when calling estimatesPriceGet");
    }
    
    // create path and map variables
    String localVarPath = "/estimates/price".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "start_latitude", startLatitude));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "start_longitude", startLongitude));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "end_latitude", endLatitude));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "end_longitude", endLongitude));

    
    
    final String[] localVarAccepts = {
      "application/json"
    };
    final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);

    final String[] localVarContentTypes = {
      
    };
    final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);

    String[] localVarAuthNames = new String[] {  };

    GenericType<List<PriceEstimate>> localVarReturnType = new GenericType<List<PriceEstimate>>() {};
    return apiClient.invokeAPI(localVarPath, "GET", localVarQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAccept, localVarContentType, localVarAuthNames, localVarReturnType);
      }
  /**
   * Time Estimates
   * The Time Estimates endpoint returns ETAs for all products offered at a given location, with the responses expressed as integers in seconds. We recommend that this endpoint be called every minute to provide the most accurate, up-to-date ETAs.
   * @param startLatitude Latitude component of start location. (required)
   * @param startLongitude Longitude component of start location. (required)
   * @param customerUuid Unique customer identifier to be used for experience customization. (optional)
   * @param productId Unique identifier representing a specific product for a given latitude &amp; longitude. (optional)
   * @return List<Product>
   * @throws ApiException if fails to make API call
   */
  public List<Product> estimatesTimeGet(Double startLatitude, Double startLongitude, String customerUuid, String productId) throws ApiException {
    Object localVarPostBody = null;
    
    // verify the required parameter 'startLatitude' is set
    if (startLatitude == null) {
      throw new ApiException(400, "Missing the required parameter 'startLatitude' when calling estimatesTimeGet");
    }
    
    // verify the required parameter 'startLongitude' is set
    if (startLongitude == null) {
      throw new ApiException(400, "Missing the required parameter 'startLongitude' when calling estimatesTimeGet");
    }
    
    // create path and map variables
    String localVarPath = "/estimates/time".replaceAll("\\{format\\}","json");

    // query params
    List<Pair> localVarQueryParams = new ArrayList<Pair>();
    Map<String, String> localVarHeaderParams = new HashMap<String, String>();
    Map<String, Object> localVarFormParams = new HashMap<String, Object>();

    localVarQueryParams.addAll(apiClient.parameterToPairs("", "start_latitude", startLatitude));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "start_longitude", startLongitude));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "customer_uuid", customerUuid));
    localVarQueryParams.addAll(apiClient.parameterToPairs("", "product_id", productId));

    
    
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
