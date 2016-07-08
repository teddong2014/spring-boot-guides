#import "SWGPriceEstimate.h"

@implementation SWGPriceEstimate

- (instancetype)init {
  self = [super init];
  if (self) {
    // initialize property's default value, if any
    
  }
  return self;
}


/**
 * Maps json key to property name.
 * This method is used by `JSONModel`.
 */
+ (JSONKeyMapper *)keyMapper {
  return [[JSONKeyMapper alloc] initWithDictionary:@{ @"product_id": @"productId", @"currency_code": @"currencyCode", @"display_name": @"displayName", @"estimate": @"estimate", @"low_estimate": @"lowEstimate", @"high_estimate": @"highEstimate", @"surge_multiplier": @"surgeMultiplier" }];
}

/**
 * Indicates whether the property with the given name is optional.
 * If `propertyName` is optional, then return `YES`, otherwise return `NO`.
 * This method is used by `JSONModel`.
 */
+ (BOOL)propertyIsOptional:(NSString *)propertyName {

  NSArray *optionalProperties = @[@"productId", @"currencyCode", @"displayName", @"estimate", @"lowEstimate", @"highEstimate", @"surgeMultiplier"];
  return [optionalProperties containsObject:propertyName];
}

@end
