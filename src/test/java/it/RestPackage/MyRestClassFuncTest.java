package it.RestPackage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import RestPackage.MyRestClass;
import RestPackage.MyRestClassModel;
import org.apache.wink.client.Resource;
import org.apache.wink.client.RestClient;

public class MyRestClassFuncTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {

        String baseUrl = System.getProperty("baseurl");
        String resourceUrl = baseUrl + "/rest/myrestclass/3/message";

        RestClient client = new RestClient();
        Resource resource = client.resource(resourceUrl);

        MyRestClassModel message = resource.get(MyRestClassModel.class);

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
