package ut.RestPackage;

import org.junit.Test;
import org.junit.After;
import org.junit.Before;
import org.mockito.Mockito;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import RestPackage.MyRestClass;
import RestPackage.MyRestClassModel;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.GenericEntity;

public class MyRestClassTest {

    @Before
    public void setup() {

    }

    @After
    public void tearDown() {

    }

    @Test
    public void messageIsValid() {
        MyRestClass resource = new MyRestClass();

        Response response = resource.getMessage();
        final MyRestClassModel message = (MyRestClassModel) response.getEntity();

        assertEquals("wrong message","Hello World",message.getMessage());
    }
}
