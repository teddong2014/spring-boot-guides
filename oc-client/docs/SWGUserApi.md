# SWGUserApi

All URIs are relative to *https://api.uber.com/v1*

Method | HTTP request | Description
------------- | ------------- | -------------
[**historyGet**](SWGUserApi.md#historyget) | **GET** /history | User Activity
[**meGet**](SWGUserApi.md#meget) | **GET** /me | User Profile


# **historyGet**
```objc
-(NSNumber*) historyGetWithOffset: (NSNumber*) offset
    limit: (NSNumber*) limit
        completionHandler: (void (^)(SWGActivities* output, NSError* error)) handler;
```

User Activity

The User Activity endpoint returns data about a user's lifetime activity with Uber. The response will include pickup locations and times, dropoff locations and times, the distance of past requests, and information about which products were requested.<br><br>The history array in the response will have a maximum length based on the limit parameter. The response value count may exceed limit, therefore subsequent API requests may be necessary.

### Example 
```objc

NSNumber* offset = @56; // Offset the list of returned results by this amount. Default is zero. (optional)
NSNumber* limit = @56; // Number of items to retrieve. Default is 5, maximum is 100. (optional)

SWGUserApi*apiInstance = [[SWGUserApi alloc] init];

// User Activity
[apiInstance historyGetWithOffset:offset
              limit:limit
          completionHandler: ^(SWGActivities* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling SWGUserApi->historyGet: %@", error);
                        }
                    }];
```

### Parameters

Name | Type | Description  | Notes
------------- | ------------- | ------------- | -------------
 **offset** | **NSNumber***| Offset the list of returned results by this amount. Default is zero. | [optional] 
 **limit** | **NSNumber***| Number of items to retrieve. Default is 5, maximum is 100. | [optional] 

### Return type

[**SWGActivities***](SWGActivities.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

# **meGet**
```objc
-(NSNumber*) meGetWithCompletionHandler: 
        (void (^)(SWGProfile* output, NSError* error)) handler;
```

User Profile

The User Profile endpoint returns information about the Uber user that has authorized with the application.

### Example 
```objc


SWGUserApi*apiInstance = [[SWGUserApi alloc] init];

// User Profile
[apiInstance meGetWithCompletionHandler: 
          ^(SWGProfile* output, NSError* error) {
                        if (output) {
                            NSLog(@"%@", output);
                        }
                        if (error) {
                            NSLog(@"Error calling SWGUserApi->meGet: %@", error);
                        }
                    }];
```

### Parameters
This endpoint does not need any parameter.

### Return type

[**SWGProfile***](SWGProfile.md)

### Authorization

No authorization required

### HTTP request headers

 - **Content-Type**: Not defined
 - **Accept**: application/json

[[Back to top]](#) [[Back to API list]](../README.md#documentation-for-api-endpoints) [[Back to Model list]](../README.md#documentation-for-models) [[Back to README]](../README.md)

