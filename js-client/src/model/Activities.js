(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient', 'model/Activity'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'), require('./Activity'));
  } else {
    // Browser globals (root is window)
    if (!root.UberApi) {
      root.UberApi = {};
    }
    root.UberApi.Activities = factory(root.UberApi.ApiClient, root.UberApi.Activity);
  }
}(this, function(ApiClient, Activity) {
  'use strict';




  /**
   * The Activities model module.
   * @module model/Activities
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>Activities</code>.
   * @alias module:model/Activities
   * @class
   */
  var exports = function() {
    var _this = this;





  };

  /**
   * Constructs a <code>Activities</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/Activities} obj Optional instance to populate.
   * @return {module:model/Activities} The populated <code>Activities</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('offset')) {
        obj['offset'] = ApiClient.convertToType(data['offset'], 'Integer');
      }
      if (data.hasOwnProperty('limit')) {
        obj['limit'] = ApiClient.convertToType(data['limit'], 'Integer');
      }
      if (data.hasOwnProperty('count')) {
        obj['count'] = ApiClient.convertToType(data['count'], 'Integer');
      }
      if (data.hasOwnProperty('history')) {
        obj['history'] = ApiClient.convertToType(data['history'], [Activity]);
      }
    }
    return obj;
  }

  /**
   * Position in pagination.
   * @member {Integer} offset
   */
  exports.prototype['offset'] = undefined;
  /**
   * Number of items to retrieve (100 max).
   * @member {Integer} limit
   */
  exports.prototype['limit'] = undefined;
  /**
   * Total number of items available.
   * @member {Integer} count
   */
  exports.prototype['count'] = undefined;
  /**
   * @member {Array.<module:model/Activity>} history
   */
  exports.prototype['history'] = undefined;




  return exports;
}));


