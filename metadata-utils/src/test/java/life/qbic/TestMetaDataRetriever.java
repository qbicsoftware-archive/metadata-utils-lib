package life.qbic;

import life.qbic.Controller.MetaDataRetriever;
import life.qbic.openbis.openbisclient.OpenBisClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import static junit.framework.TestCase.*;

public class TestMetaDataRetriever {

    private MetaDataRetriever retriever;
    private OpenBisClient mockClient;

    @Before
    public void setUp() throws IOException {
        Utils utils = new Utils();
        utils.readCredentials();
        mockClient = Mockito.mock(OpenBisClient.class);

        retriever = new MetaDataRetriever(utils.projectCode,mockClient);
    }


   /*
   just calling method in metadatacollector --> already tested
   @Test
    public void testMetaDataRetrieving(){
        //mock the called method to test if it acts right

        HashMap<String, ArrayList<String>> result = retriever.retrieveMetadata();

        //result needs to contain all samples from the project (no info lost)
        int numSamples = 0;
        assertEquals(numSamples,result.size());

    }*/

   @Test
    public void testCSVCreation(){

        retriever.createCSVOutput(new HashMap<>());
        //check if file is created (exists,...)

        File file =  new File("");
        Boolean fileExists = file.exists();

        assertTrue(fileExists);

        file.delete();
        assertTrue("File does not exist.", fileExists);

    }

}
