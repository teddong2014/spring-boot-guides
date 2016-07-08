(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/Activities', 'model/Error', 'model/Profile'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('../model/Activities'), require('../model/Error'), require('../model/Profile'));
  } else {
    // Browser globals (root is window)
    if (!root.UberApi) {
      root.UberApi = {};
    }
    root.UberApi.UserApi = factory(root.UberApi.ApiClient, root.UberApi.Activities, root.UberApi.Error, root.UberApi.Profile);
  }
}(this, function(ApiClient, Activities, Error, Profile) {
  'use strict';

  /**
   * User service.
   * @module api/UserApi
   * @version 1.0.0
   */

  /**
   * Constructs a new UserApi. 
   * @alias module:api/UserApi
   * @class
   * @param {module:ApiClient} apiClient Optional API client implementation to use,
   * default to {@link module:ApiClient#instance} if unspecified.
   */
  var exports = function(apiClient) {
    this.apiClient = apiClient || ApiClient.instance;


    /**
     * Callback function to receive the result of the historyGet operation.
     * @callback module:api/UserApi~historyGetCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Activities} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * User Activity
     * The User Activity endpoint returns data about a user&#39;s lifetime activity with Uber. The response will include pickup locations and times, dropoff locations and times, the distance of past requests, and information about which products were requested.&lt;br&gt;&lt;br&gt;The history array in the response will have a maximum length based on the limit parameter. The response value count may exceed limit, therefore subsequent API requests may be necessary.
     * @param {Object} opts Optional parameters
     * @param {Integer} opts.offset Offset the list of returned results by this amount. Default is zero.
     * @param {Integer} opts.limit Number of items to retrieve. Default is 5, maximum is 100.
     * @param {module:api/UserApi~historyGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {module:model/Activities}
     */
    this.historyGet = function(opts, callback) {
      opts = opts || {};
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
        'offset': opts['offset'],
        'limit': opts['limit']
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = Activities;

      return this.apiClient.callApi(
        '/history', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }

    /**
     * Callback function to receive the result of the meGet operation.
     * @callback module:api/UserApi~meGetCallback
     * @param {String} error Error message, if any.
     * @param {module:model/Profile} data The data returned by the service call.
     * @param {String} response The complete HTTP response.
     */

    /**
     * User Profile
     * The User Profile endpoint returns information about the Uber user that has authorized with the application.
     * @param {module:api/UserApi~meGetCallback} callback The callback function, accepting three arguments: error, data, response
     * data is of type: {module:model/Profile}
     */
    this.meGet = function(callback) {
      var postBody = null;


      var pathParams = {
      };
      var queryParams = {
      };
      var headerParams = {
      };
      var formParams = {
      };

      var authNames = [];
      var contentTypes = [];
      var accepts = ['application/json'];
      var returnType = Profile;

      return this.apiClient.callApi(
        '/me', 'GET',
        pathParams, queryParams, headerParams, formParams, postBody,
        authNames, contentTypes, accepts, returnType, callback
      );
    }
  };

  return exports;
}));
