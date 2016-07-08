# SWGEstimatesApi

All URIs are relative to *https://api.uber.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**estimatesPriceGet**](SWGEstimatesApi.md#estimatespriceget) | **GET** /estimates/price | Price Estimates
[**estimatesTimeGet**](SWGEstimatesApi.md#estimatestimeget) | **GET** /estimates/time | Time Estimates


# **estimatesPriceGet**
```objc
-(NSNumber*) estimatesPriceGetWithStartLatitude: (NSNumber*) startLatitude
    startLongitude: (NSNumber*) startLongitude
    endLatitude: (NSNumber*) endLatitude
    endLongitude: (NSNumber*) endLongitude
        completionHandler: (void (^)(NSArray<SWGPriceEstimate>* output, NSError* error)) handler;
```

Price Estimates

The Price Estimates endpoint returns an estimated price range for each product offered at a given location. The price estimate is provided as a formatted string with the full price range and the localized currency symbol.<br><br>The response also includes low and high estimates, and the [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code for situations requiring currency conversion. When surge is active for a particular product, its surge_multiplier will be greater than 1, but the price estimate already factors in this multiplier. 

### Example 
```objc

NSNumber* startLatitude = @1.2; // Latitude component of start location.
NSNumber* startLongitude = @1.2; // Longitude component of start location.
NSNumber* endLatitude = @1.2; // Latitude component of end location.
NSNumber* endLongitude = @1.2; // Longitude component of end location.

SWGEstimatesApi*apiInstance = [[SWGEstimatesApi alloc] init];

// Price Estimates
[apiInstance estimatesPriceGetWithStartLatitude:startLatitude
              startLongitude:startLongitude
              endLatitude:endLatitude
              endLongitude:endLongitude
          completionHandler: ^(NSArray<SWGPriceEstimate>* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling SWGEstimatesApi->estimatesPriceGet: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startLatitude** | **NSNumber***| Latitude component of start location. | 
 **startLongitude** | **NSNumber***| Longitude component of start location. | 
 **endLatitude** | **NSNumber***| Latitude component of end location. | 
 **endLongitude** | **NSNumber***| Longitude component of end location. | 

### Return type

[**NSArray<SWGPriceEstimate>***](SWGPriceEstimate.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **estimatesTimeGet**
```objc
-(NSNumber*) estimatesTimeGetWithStartLatitude: (NSNumber*) startLatitude
    startLongitude: (NSNumber*) startLongitude
    customerUuid: (SWGUUID*) customerUuid
    productId: (NSString*) productId
        completionHandler: (void (^)(NSArray<SWGProduct>* output, NSError* error)) handler;
```

Time Estimates

The Time Estimates endpoint returns ETAs for all products offered at a given location, with the responses expressed as integers in seconds. We recommend that this endpoint be called every minute to provide the most accurate, up-to-date ETAs.

### Example 
```objc

NSNumber* startLatitude = @1.2; // Latitude component of start location.
NSNumber* startLongitude = @1.2; // Longitude component of start location.
SWGUUID* customerUuid = [[SWGUUID alloc] init]; // Unique customer identifier to be used for experience customization. (optional)
NSString* productId = @"productId_example"; // Unique identifier representing a specific product for a given latitude & longitude. (optional)

SWGEstimatesApi*apiInstance = [[SWGEstimatesApi alloc] init];

// Time Estimates
[apiInstance estimatesTimeGetWithStartLatitude:startLatitude
              startLongitude:startLongitude
              customerUuid:customerUuid
              productId:productId
          completionHandler: ^(NSArray<SWGProduct>* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling SWGEstimatesApi->estimatesTimeGet: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **startLatitude** | **NSNumber***| Latitude component of start location. | 
 **startLongitude** | **NSNumber***| Longitude component of start location. | 
 **customerUuid** | [**SWGUUID***](.md)| Unique customer identifier to be used for experience customization. | [optional] 
 **productId** | **NSString***| Unique identifier representing a specific product for a given latitude &amp; longitude. | [optional] 

### Return type

[**NSArray<SWGProduct>***](SWGProduct.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

