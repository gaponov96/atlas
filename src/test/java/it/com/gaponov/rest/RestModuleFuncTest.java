package it.com.gaponov.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.gaponov.rest.RestModule;
import com.gaponov.rest.RestModuleModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class RestModuleFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/restmodule/1.0/message";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        RestModuleModel message = resource.get(RestModuleModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
