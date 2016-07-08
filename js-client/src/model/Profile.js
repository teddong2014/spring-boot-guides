(function(root, factory) {
  if (typeof define === 'function' && define.amd) {
    // AMD. Register as an anonymous module.
    define(['ApiClient'], factory);
  } else if (typeof module === 'object' && module.exports) {
    // CommonJS-like environments that support module.exports, like Node.
    module.exports = factory(require('../ApiClient'));
  } else {
    // Browser globals (root is window)
    if (!root.UberApi) {
      root.UberApi = {};
    }
    root.UberApi.Profile = factory(root.UberApi.ApiClient);
  }
}(this, function(ApiClient) {
  'use strict';




  /**
   * The Profile model module.
   * @module model/Profile
   * @version 1.0.0
   */

  /**
   * Constructs a new <code>Profile</code>.
   * @alias module:model/Profile
   * @class
   */
  var exports = function() {
    var _this = this;






  };

  /**
   * Constructs a <code>Profile</code> from a plain JavaScript object, optionally creating a new instance.
   * Copies all relevant properties from <code>data</code> to <code>obj</code> if supplied or a new instance if not.
   * @param {Object} data The plain JavaScript object bearing properties of interest.
   * @param {module:model/Profile} obj Optional instance to populate.
   * @return {module:model/Profile} The populated <code>Profile</code> instance.
   */
  exports.constructFromObject = function(data, obj) {
    if (data) {
      obj = obj || new exports();

      if (data.hasOwnProperty('first_name')) {
        obj['first_name'] = ApiClient.convertToType(data['first_name'], 'String');
      }
      if (data.hasOwnProperty('last_name')) {
        obj['last_name'] = ApiClient.convertToType(data['last_name'], 'String');
      }
      if (data.hasOwnProperty('email')) {
        obj['email'] = ApiClient.convertToType(data['email'], 'String');
      }
      if (data.hasOwnProperty('picture')) {
        obj['picture'] = ApiClient.convertToType(data['picture'], 'String');
      }
      if (data.hasOwnProperty('promo_code')) {
        obj['promo_code'] = ApiClient.convertToType(data['promo_code'], 'String');
      }
    }
    return obj;
  }

  /**
   * First name of the Uber user.
   * @member {String} first_name
   */
  exports.prototype['first_name'] = undefined;
  /**
   * Last name of the Uber user.
   * @member {String} last_name
   */
  exports.prototype['last_name'] = undefined;
  /**
   * Email address of the Uber user
   * @member {String} email
   */
  exports.prototype['email'] = undefined;
  /**
   * Image URL of the Uber user.
   * @member {String} picture
   */
  exports.prototype['picture'] = undefined;
  /**
   * Promo code of the Uber user.
   * @member {String} promo_code
   */
  exports.prototype['promo_code'] = undefined;




  return exports;
}));


