package ut.com.gaponov.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.gaponov.rest.RestModule;
import com.gaponov.rest.RestModuleModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

public class RestModuleTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        RestModule resource = new RestModule();

        Response response = resource.getMessage();
        final RestModuleModel message = (RestModuleModel) response.getEntity();

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
