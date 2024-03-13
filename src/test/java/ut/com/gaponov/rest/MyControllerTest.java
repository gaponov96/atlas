package ut.com.gaponov.rest;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import com.gaponov.rest.MyController;
import com.gaponov.rest.MyControllerModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

public class MyControllerTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        MyController resource = new MyController();

        Response response = resource.getMessage();
        final MyControllerModel message = (MyControllerModel) response.getEntity();

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
