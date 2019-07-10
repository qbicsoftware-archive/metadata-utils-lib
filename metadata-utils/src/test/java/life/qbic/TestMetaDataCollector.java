package life.qbic;

import life.qbic.openbis.openbisclient.OpenBisClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class TestMetaDataCollector {

    private MetaDataCollector collector;
    private OpenBisClient client;


    @Before
    public void setup() throws IOException {

        Utils utils = new Utils();
        utils.readCredentials();
        client = utils.createClient();

        collector = new MetaDataCollector(utils.projectCode, client);
    }

    @Test
    public void testCollectMetadataFromSamples(){
        HashMap<String, ArrayList<String>> result = collector.collectMetadataFromSamples(null);

        //result needs to contain all samples from the project (no info lost)
        int numSamples = 0;
        assertEquals(numSamples,result.size());

        //each sample needs to have the same number of columns in order to have the same info
        int numColumn = result.get(0).size();
        for(ArrayList<String> columns : result.values()){

        }

    }

    @Test
    public void testCollectPreparationSamples(){

    }


    @After
    public void logout(){
        client.logout();
    }
}
