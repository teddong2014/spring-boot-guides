# SWGProductsApi

All URIs are relative to *https://api.uber.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**productsGet**](SWGProductsApi.md#productsget) | **GET** /products | Product Types


# **productsGet**
```objc
-(NSNumber*) productsGetWithLatitude: (NSNumber*) latitude
    longitude: (NSNumber*) longitude
        completionHandler: (void (^)(NSArray<SWGProduct>* output, NSError* error)) handler;
```

Product Types

The Products endpoint returns information about the *Uber* products offered at a given location. The response includes the display name and other details about each product, and lists the products in the proper display order. 

### Example 
```objc

NSNumber* latitude = @1.2; // Latitude component of location.
NSNumber* longitude = @1.2; // Longitude component of location.

SWGProductsApi*apiInstance = [[SWGProductsApi alloc] init];

// Product Types
[apiInstance productsGetWithLatitude:latitude
              longitude:longitude
          completionHandler: ^(NSArray<SWGProduct>* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling SWGProductsApi->productsGet: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **latitude** | **NSNumber***| Latitude component of location. | 
 **longitude** | **NSNumber***| Longitude component of location. | 

### Return type

[**NSArray<SWGProduct>***](SWGProduct.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

