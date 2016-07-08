(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/Error', 'model/PriceEstimate', 'model/Product'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/Error'), require('../model/PriceEstimate'), require('../model/Product'));
  } else {
    // Browser globals (root is window)
    if (!root.UberApi) {
      root.UberApi = {};
    }
    root.UberApi.EstimatesApi = factory(root.UberApi.ApiClient, root.UberApi.Error, root.UberApi.PriceEstimate, root.UberApi.Product);
  }
}(this, function(ApiClient, Error, PriceEstimate, Product) {
  'use strict';

  /**
   * Estimates service.
   * @module api/EstimatesApi
   * @version 1.0.0
   */

  /**
   * Constructs a new EstimatesApi. 
   * @alias module:api/EstimatesApi
   * @class
   * @param {module:ApiClient} apiClient Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the estimatesPriceGet operation.
     * @callback module:api/EstimatesApi~estimatesPriceGetCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/PriceEstimate>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Price Estimates
     * The Price Estimates endpoint returns an estimated price range for each product offered at a given location. The price estimate is provided as a formatted string with the full price range and the localized currency symbol.&lt;br&gt;&lt;br&gt;The response also includes low and high estimates, and the [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code for situations requiring currency conversion. When surge is active for a particular product, its surge_multiplier will be greater than 1, but the price estimate already factors in this multiplier. 
     * @param {Number} startLatitude Latitude component of start location.
     * @param {Number} startLongitude Longitude component of start location.
     * @param {Number} endLatitude Latitude component of end location.
     * @param {Number} endLongitude Longitude component of end location.
     * @param {module:api/EstimatesApi~estimatesPriceGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {Array.<module:model/PriceEstimate>}
     */
    this.estimatesPriceGet = function(startLatitude, startLongitude, endLatitude, endLongitude, callback) {
      var postBody = null;

      // verify the required parameter 'startLatitude' is set
      if (startLatitude == undefined || startLatitude == null) {
        throw "Missing the required parameter 'startLatitude' when calling estimatesPriceGet";
      }

      // verify the required parameter 'startLongitude' is set
      if (startLongitude == undefined || startLongitude == null) {
        throw "Missing the required parameter 'startLongitude' when calling estimatesPriceGet";
      }

      // verify the required parameter 'endLatitude' is set
      if (endLatitude == undefined || endLatitude == null) {
        throw "Missing the required parameter 'endLatitude' when calling estimatesPriceGet";
      }

      // verify the required parameter 'endLongitude' is set
      if (endLongitude == undefined || endLongitude == null) {
        throw "Missing the required parameter 'endLongitude' when calling estimatesPriceGet";
      }


      var pathParams = {
      };
      var queryParams = {
        'start_latitude': startLatitude,
        'start_longitude': startLongitude,
        'end_latitude': endLatitude,
        'end_longitude': endLongitude
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = [PriceEstimate];

      return this.apiClient.callApi(
        '/estimates/price', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the estimatesTimeGet operation.
     * @callback module:api/EstimatesApi~estimatesTimeGetCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/Product>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Time Estimates
     * The Time Estimates endpoint returns ETAs for all products offered at a given location, with the responses expressed as integers in seconds. We recommend that this endpoint be called every minute to provide the most accurate, up-to-date ETAs.
     * @param {Number} startLatitude Latitude component of start location.
     * @param {Number} startLongitude Longitude component of start location.
     * @param {Object} opts Optional parameters
     * @param {String} opts.customerUuid Unique customer identifier to be used for experience customization.
     * @param {String} opts.productId Unique identifier representing a specific product for a given latitude &amp; longitude.
     * @param {module:api/EstimatesApi~estimatesTimeGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {Array.<module:model/Product>}
     */
    this.estimatesTimeGet = function(startLatitude, startLongitude, opts, callback) {
      opts = opts || {};
      var postBody = null;

      // verify the required parameter 'startLatitude' is set
      if (startLatitude == undefined || startLatitude == null) {
        throw "Missing the required parameter 'startLatitude' when calling estimatesTimeGet";
      }

      // verify the required parameter 'startLongitude' is set
      if (startLongitude == undefined || startLongitude == null) {
        throw "Missing the required parameter 'startLongitude' when calling estimatesTimeGet";
      }


      var pathParams = {
      };
      var queryParams = {
        'start_latitude': startLatitude,
        'start_longitude': startLongitude,
        'customer_uuid': opts['customerUuid'],
        'product_id': opts['productId']
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = [Product];

      return this.apiClient.callApi(
        '/estimates/time', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
