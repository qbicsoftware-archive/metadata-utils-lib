package life.qbic;

import life.qbic.Entities.OpenBis.OpenBisContainer;
import life.qbic.Entities.OpenBis.OpenBisContainerImplementation;
import life.qbic.openbis.openbisclient.OpenBisClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestOpenBisContainer {

    private OpenBisContainer container;
    private OpenBisClient client;

    @Before
    public void setup() throws IOException {
        Utils utils = new Utils();
        utils.readCredentials();
        client = utils.createClient();

        container = new OpenBisContainerImplementation(utils.projectCode, client);
    }


    @Test
    public void testParseXMLFactors(){
    }

    @Test
    public void testCreateGrouping(){
    }

    @After
    public void logout(){
        client.logout();
    }
}
