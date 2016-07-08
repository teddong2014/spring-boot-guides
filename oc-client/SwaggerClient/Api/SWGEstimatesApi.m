#import "SWGEstimatesApi.h"
#import "SWGQueryParamCollection.h"
#import "SWGPriceEstimate.h"
#import "SWGError.h"
#import "SWGUUID.h"
#import "SWGProduct.h"


@interface SWGEstimatesApi ()

@property (nonatomic, strong) NSMutableDictionary *defaultHeaders;

@end

@implementation SWGEstimatesApi

NSString* kSWGEstimatesApiErrorDomain = @"SWGEstimatesApiErrorDomain";
NSInteger kSWGEstimatesApiMissingParamErrorCode = 234513;

@synthesize apiClient = _apiClient;

#pragma mark - Initialize methods

- (instancetype) init {
    self = [super init];
    if (self) {
        SWGConfiguration *config = [SWGConfiguration sharedConfig];
        if (config.apiClient == nil) {
            config.apiClient = [[SWGApiClient alloc] init];
        }
        _apiClient = config.apiClient;
        _defaultHeaders = [NSMutableDictionary dictionary];
    }
    return self;
}

- (id) initWithApiClient:(SWGApiClient *)apiClient {
    self = [super init];
    if (self) {
        _apiClient = apiClient;
        _defaultHeaders = [NSMutableDictionary dictionary];
    }
    return self;
}

#pragma mark -

+ (instancetype)sharedAPI {
    static SWGEstimatesApi *sharedAPI;
    static dispatch_once_t once;
    dispatch_once(&once, ^{
        sharedAPI = [[self alloc] init];
    });
    return sharedAPI;
}

-(NSString*) defaultHeaderForKey:(NSString*)key {
    return self.defaultHeaders[key];
}

-(void) addHeader:(NSString*)value forKey:(NSString*)key {
    [self setDefaultHeaderValue:value forKey:key];
}

-(void) setDefaultHeaderValue:(NSString*) value forKey:(NSString*)key {
    [self.defaultHeaders setValue:value forKey:key];
}

-(NSUInteger) requestQueueSize {
    return [SWGApiClient requestQueueSize];
}

#pragma mark - Api Methods

///
/// Price Estimates
/// The Price Estimates endpoint returns an estimated price range for each product offered at a given location. The price estimate is provided as a formatted string with the full price range and the localized currency symbol.<br><br>The response also includes low and high estimates, and the [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code for situations requiring currency conversion. When surge is active for a particular product, its surge_multiplier will be greater than 1, but the price estimate already factors in this multiplier. 
///  @param startLatitude Latitude component of start location. 
///
///  @param startLongitude Longitude component of start location. 
///
///  @param endLatitude Latitude component of end location. 
///
///  @param endLongitude Longitude component of end location. 
///
///  @returns NSArray<SWGPriceEstimate>*
///
-(NSNumber*) estimatesPriceGetWithStartLatitude: (NSNumber*) startLatitude
    startLongitude: (NSNumber*) startLongitude
    endLatitude: (NSNumber*) endLatitude
    endLongitude: (NSNumber*) endLongitude
    completionHandler: (void (^)(NSArray<SWGPriceEstimate>* output, NSError* error)) handler {
    // verify the required parameter 'startLatitude' is set
    if (startLatitude == nil) {
        NSParameterAssert(startLatitude);
        if(handler) {
            NSDictionary * userInfo = @{NSLocalizedDescriptionKey : [NSString stringWithFormat:NSLocalizedString(@"Missing required parameter '%@'", nil),@"startLatitude"] };
            NSError* error = [NSError errorWithDomain:kSWGEstimatesApiErrorDomain code:kSWGEstimatesApiMissingParamErrorCode userInfo:userInfo];
            handler(nil, error);
        }
        return nil;
    }

    // verify the required parameter 'startLongitude' is set
    if (startLongitude == nil) {
        NSParameterAssert(startLongitude);
        if(handler) {
            NSDictionary * userInfo = @{NSLocalizedDescriptionKey : [NSString stringWithFormat:NSLocalizedString(@"Missing required parameter '%@'", nil),@"startLongitude"] };
            NSError* error = [NSError errorWithDomain:kSWGEstimatesApiErrorDomain code:kSWGEstimatesApiMissingParamErrorCode userInfo:userInfo];
            handler(nil, error);
        }
        return nil;
    }

    // verify the required parameter 'endLatitude' is set
    if (endLatitude == nil) {
        NSParameterAssert(endLatitude);
        if(handler) {
            NSDictionary * userInfo = @{NSLocalizedDescriptionKey : [NSString stringWithFormat:NSLocalizedString(@"Missing required parameter '%@'", nil),@"endLatitude"] };
            NSError* error = [NSError errorWithDomain:kSWGEstimatesApiErrorDomain code:kSWGEstimatesApiMissingParamErrorCode userInfo:userInfo];
            handler(nil, error);
        }
        return nil;
    }

    // verify the required parameter 'endLongitude' is set
    if (endLongitude == nil) {
        NSParameterAssert(endLongitude);
        if(handler) {
            NSDictionary * userInfo = @{NSLocalizedDescriptionKey : [NSString stringWithFormat:NSLocalizedString(@"Missing required parameter '%@'", nil),@"endLongitude"] };
            NSError* error = [NSError errorWithDomain:kSWGEstimatesApiErrorDomain code:kSWGEstimatesApiMissingParamErrorCode userInfo:userInfo];
            handler(nil, error);
        }
        return nil;
    }

    NSMutableString* resourcePath = [NSMutableString stringWithFormat:@"/estimates/price"];

    // remove format in URL if needed
    [resourcePath replaceOccurrencesOfString:@".{format}" withString:@".json" options:0 range:NSMakeRange(0,resourcePath.length)];

    NSMutableDictionary *pathParams = [[NSMutableDictionary alloc] init];

    NSMutableDictionary* queryParams = [[NSMutableDictionary alloc] init];
    if (startLatitude != nil) {
        queryParams[@"start_latitude"] = startLatitude;
    }
    if (startLongitude != nil) {
        queryParams[@"start_longitude"] = startLongitude;
    }
    if (endLatitude != nil) {
        queryParams[@"end_latitude"] = endLatitude;
    }
    if (endLongitude != nil) {
        queryParams[@"end_longitude"] = endLongitude;
    }
    NSMutableDictionary* headerParams = [NSMutableDictionary dictionaryWithDictionary:self.apiClient.configuration.defaultHeaders];
    [headerParams addEntriesFromDictionary:self.defaultHeaders];
    // HTTP header `Accept`
    NSString *acceptHeader = [self.apiClient.sanitizer selectHeaderAccept:@[@"application/json"]];
    if(acceptHeader.length > 0) {
        headerParams[@"Accept"] = acceptHeader;
    }

    // response content type
    NSString *responseContentType = [[acceptHeader componentsSeparatedByString:@", "] firstObject] ?: @"";

    // request content type
    NSString *requestContentType = [self.apiClient.sanitizer selectHeaderContentType:@[]];

    // Authentication setting
    NSArray *authSettings = @[];

    id bodyParam = nil;
    NSMutableDictionary *formParams = [[NSMutableDictionary alloc] init];
    NSMutableDictionary *localVarFiles = [[NSMutableDictionary alloc] init];

    return [self.apiClient requestWithPath: resourcePath
                                    method: @"GET"
                                pathParams: pathParams
                               queryParams: queryParams
                                formParams: formParams
                                     files: localVarFiles
                                      body: bodyParam
                              headerParams: headerParams
                              authSettings: authSettings
                        requestContentType: requestContentType
                       responseContentType: responseContentType
                              responseType: @"NSArray<SWGPriceEstimate>*"
                           completionBlock: ^(id data, NSError *error) {
                                if(handler) {
                                    handler((NSArray<SWGPriceEstimate>*)data, error);
                                }
                           }
          ];
}

///
/// Time Estimates
/// The Time Estimates endpoint returns ETAs for all products offered at a given location, with the responses expressed as integers in seconds. We recommend that this endpoint be called every minute to provide the most accurate, up-to-date ETAs.
///  @param startLatitude Latitude component of start location. 
///
///  @param startLongitude Longitude component of start location. 
///
///  @param customerUuid Unique customer identifier to be used for experience customization. (optional)
///
///  @param productId Unique identifier representing a specific product for a given latitude & longitude. (optional)
///
///  @returns NSArray<SWGProduct>*
///
-(NSNumber*) estimatesTimeGetWithStartLatitude: (NSNumber*) startLatitude
    startLongitude: (NSNumber*) startLongitude
    customerUuid: (SWGUUID*) customerUuid
    productId: (NSString*) productId
    completionHandler: (void (^)(NSArray<SWGProduct>* output, NSError* error)) handler {
    // verify the required parameter 'startLatitude' is set
    if (startLatitude == nil) {
        NSParameterAssert(startLatitude);
        if(handler) {
            NSDictionary * userInfo = @{NSLocalizedDescriptionKey : [NSString stringWithFormat:NSLocalizedString(@"Missing required parameter '%@'", nil),@"startLatitude"] };
            NSError* error = [NSError errorWithDomain:kSWGEstimatesApiErrorDomain code:kSWGEstimatesApiMissingParamErrorCode userInfo:userInfo];
            handler(nil, error);
        }
        return nil;
    }

    // verify the required parameter 'startLongitude' is set
    if (startLongitude == nil) {
        NSParameterAssert(startLongitude);
        if(handler) {
            NSDictionary * userInfo = @{NSLocalizedDescriptionKey : [NSString stringWithFormat:NSLocalizedString(@"Missing required parameter '%@'", nil),@"startLongitude"] };
            NSError* error = [NSError errorWithDomain:kSWGEstimatesApiErrorDomain code:kSWGEstimatesApiMissingParamErrorCode userInfo:userInfo];
            handler(nil, error);
        }
        return nil;
    }

    NSMutableString* resourcePath = [NSMutableString stringWithFormat:@"/estimates/time"];

    // remove format in URL if needed
    [resourcePath replaceOccurrencesOfString:@".{format}" withString:@".json" options:0 range:NSMakeRange(0,resourcePath.length)];

    NSMutableDictionary *pathParams = [[NSMutableDictionary alloc] init];

    NSMutableDictionary* queryParams = [[NSMutableDictionary alloc] init];
    if (startLatitude != nil) {
        queryParams[@"start_latitude"] = startLatitude;
    }
    if (startLongitude != nil) {
        queryParams[@"start_longitude"] = startLongitude;
    }
    if (customerUuid != nil) {
        queryParams[@"customer_uuid"] = customerUuid;
    }
    if (productId != nil) {
        queryParams[@"product_id"] = productId;
    }
    NSMutableDictionary* headerParams = [NSMutableDictionary dictionaryWithDictionary:self.apiClient.configuration.defaultHeaders];
    [headerParams addEntriesFromDictionary:self.defaultHeaders];
    // HTTP header `Accept`
    NSString *acceptHeader = [self.apiClient.sanitizer selectHeaderAccept:@[@"application/json"]];
    if(acceptHeader.length > 0) {
        headerParams[@"Accept"] = acceptHeader;
    }

    // response content type
    NSString *responseContentType = [[acceptHeader componentsSeparatedByString:@", "] firstObject] ?: @"";

    // request content type
    NSString *requestContentType = [self.apiClient.sanitizer selectHeaderContentType:@[]];

    // Authentication setting
    NSArray *authSettings = @[];

    id bodyParam = nil;
    NSMutableDictionary *formParams = [[NSMutableDictionary alloc] init];
    NSMutableDictionary *localVarFiles = [[NSMutableDictionary alloc] init];

    return [self.apiClient requestWithPath: resourcePath
                                    method: @"GET"
                                pathParams: pathParams
                               queryParams: queryParams
                                formParams: formParams
                                     files: localVarFiles
                                      body: bodyParam
                              headerParams: headerParams
                              authSettings: authSettings
                        requestContentType: requestContentType
                       responseContentType: responseContentType
                              responseType: @"NSArray<SWGProduct>*"
                           completionBlock: ^(id data, NSError *error) {
                                if(handler) {
                                    handler((NSArray<SWGProduct>*)data, error);
                                }
                           }
          ];
}



@end
