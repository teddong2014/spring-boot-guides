package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Error;
import io.swagger.client.model.PriceEstimate;
import io.swagger.client.model.Product;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for EstimatesApi
 */
public class EstimatesApiTest {

    private final EstimatesApi api = new EstimatesApi();

    
    /**
     * Price Estimates
     *
     * The Price Estimates endpoint returns an estimated price range for each product offered at a given location. The price estimate is provided as a formatted string with the full price range and the localized currency symbol.&lt;br&gt;&lt;br&gt;The response also includes low and high estimates, and the [ISO 4217](http://en.wikipedia.org/wiki/ISO_4217) currency code for situations requiring currency conversion. When surge is active for a particular product, its surge_multiplier will be greater than 1, but the price estimate already factors in this multiplier. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void estimatesPriceGetTest() throws ApiException {
        Double startLatitude = null;
        Double startLongitude = null;
        Double endLatitude = null;
        Double endLongitude = null;
        // List<PriceEstimate> response = api.estimatesPriceGet(startLatitude, startLongitude, endLatitude, endLongitude);

        // TODO: test validations
    }
    
    /**
     * Time Estimates
     *
     * The Time Estimates endpoint returns ETAs for all products offered at a given location, with the responses expressed as integers in seconds. We recommend that this endpoint be called every minute to provide the most accurate, up-to-date ETAs.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void estimatesTimeGetTest() throws ApiException {
        Double startLatitude = null;
        Double startLongitude = null;
        String customerUuid = null;
        String productId = null;
        // List<Product> response = api.estimatesTimeGet(startLatitude, startLongitude, customerUuid, productId);

        // TODO: test validations
    }
    
}
