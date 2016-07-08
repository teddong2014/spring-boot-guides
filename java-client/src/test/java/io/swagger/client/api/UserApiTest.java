package io.swagger.client.api;

import io.swagger.client.ApiException;
import io.swagger.client.model.Activities;
import io.swagger.client.model.Error;
import io.swagger.client.model.Profile;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * API tests for UserApi
 */
public class UserApiTest {

    private final UserApi api = new UserApi();

    
    /**
     * User Activity
     *
     * The User Activity endpoint returns data about a user&#39;s lifetime activity with Uber. The response will include pickup locations and times, dropoff locations and times, the distance of past requests, and information about which products were requested.&lt;br&gt;&lt;br&gt;The history array in the response will have a maximum length based on the limit parameter. The response value count may exceed limit, therefore subsequent API requests may be necessary.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void historyGetTest() throws ApiException {
        Integer offset = null;
        Integer limit = null;
        // Activities response = api.historyGet(offset, limit);

        // TODO: test validations
    }
    
    /**
     * User Profile
     *
     * The User Profile endpoint returns information about the Uber user that has authorized with the application.
     *
     * @throws ApiException
     *          if the Api call fails
     */
    @Test
    public void meGetTest() throws ApiException {
        // Profile response = api.meGet();

        // TODO: test validations
    }
    
}
