package life.qbic;

import life.qbic.openbis.openbisclient.OpenBisClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.*;

public class TestMetaDataRetriever {

    private MetaDataRetriever retriever;
    private OpenBisClient client;

    @Before
    public void setUp() throws IOException {
        Utils utils = new Utils();
        utils.readCredentials();
        client = utils.createClient();

        retriever = new MetaDataRetriever(utils.projectCode,client);
    }


    @Test
    public void testMetaDataRetrieving(){
        HashMap<String, ArrayList<String>> result = retriever.retrieveMetadata();

        //result needs to contain all samples from the project (no info lost)
        int numSamples = 0;
        assertEquals(numSamples,result.size());


    }

    public void testCSVCreation(){
        retriever.createCSVOutput();
    }

    @After
    public void logout(){
        client.logout();
    }
}
