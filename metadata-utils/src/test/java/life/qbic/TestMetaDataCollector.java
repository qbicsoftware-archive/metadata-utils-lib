package life.qbic;

import life.qbic.UseCases.NGSMetaDataCollector;
import life.qbic.openbis.openbisclient.OpenBisClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.*;

public class TestMetaDataCollector {

    private NGSMetaDataCollector collector;
    private OpenBisClient client;


    @Before
    public void setup() throws IOException {

        Utils utils = new Utils();
        utils.readCredentials();
        client = Mockito.mock(OpenBisClient.class);

        collector = new NGSMetaDataCollector(utils.projectCode, client);
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
        //mock the datagenerator in the method
        assertNotNull(collector.collectPreparationSamples());
    }

}
