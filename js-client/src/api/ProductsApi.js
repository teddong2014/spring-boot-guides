(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/Product', 'model/Error'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/Product'), require('../model/Error'));
  } else {
    // Browser globals (root is window)
    if (!root.UberApi) {
      root.UberApi = {};
    }
    root.UberApi.ProductsApi = factory(root.UberApi.ApiClient, root.UberApi.Product, root.UberApi.Error);
  }
}(this, function(ApiClient, Product, Error) {
  'use strict';

  /**
   * Products service.
   * @module api/ProductsApi
   * @version 1.0.0
   */

  /**
   * Constructs a new ProductsApi. 
   * @alias module:api/ProductsApi
   * @class
   * @param {module:ApiClient} apiClient Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the productsGet operation.
     * @callback module:api/ProductsApi~productsGetCallback
     * @param {String} error Error message, if any.
     * @param {Array.<module:model/Product>} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * Product Types
     * The Products endpoint returns information about the *Uber* products offered at a given location. The response includes the display name and other details about each product, and lists the products in the proper display order. 
     * @param {Number} latitude Latitude component of location.
     * @param {Number} longitude Longitude component of location.
     * @param {module:api/ProductsApi~productsGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {Array.<module:model/Product>}
     */
    this.productsGet = function(latitude, longitude, callback) {
      var postBody = null;

      // verify the required parameter 'latitude' is set
      if (latitude == undefined || latitude == null) {
        throw "Missing the required parameter 'latitude' when calling productsGet";
      }

      // verify the required parameter 'longitude' is set
      if (longitude == undefined || longitude == null) {
        throw "Missing the required parameter 'longitude' when calling productsGet";
      }


      var pathParams = {
      };
      var queryParams = {
        'latitude': latitude,
        'longitude': longitude
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
        '/products', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
