package it.com.gaponov.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.gaponov.rest.MyController;
import com.gaponov.rest.MyControllerModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class MyControllerFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/mycontroller/1.0/message";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        MyControllerModel message = resource.get(MyControllerModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
