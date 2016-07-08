package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Product;
import io.swagger.client.model.Error;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for ProductsApi
 */
public class ProductsApiTest {

    private final ProductsApi api = new ProductsApi();

    
    /**
     * Product Types
     *
     * The Products endpoint returns information about the *Uber* products offered at a given location. The response includes the display name and other details about each product, and lists the products in the proper display order. 
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void productsGetTest() throws ApiException {
        Double latitude = null;
        Double longitude = null;
        // List<Product> response = api.productsGet(latitude, longitude);

        // TODO: test validations
    }
    
}
