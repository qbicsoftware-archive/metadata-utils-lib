package life.qbic;

import life.qbic.UseCases.MetaDataGenerator;
import life.qbic.Controller.ProjectMetaDataGenerator;
import life.qbic.openbis.openbisclient.OpenBisClient;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.io.IOException;

public class TestMetaDataGenerator {


    private MetaDataGenerator generatedData;
    private OpenBisClient client;

    @Before
    public void setUp() throws IOException {
        Utils utils = new Utils();
        utils.readCredentials();

        client = Mockito.mock(OpenBisClient.class);

        generatedData = new ProjectMetaDataGenerator(utils.projectCode, client);
    }

    @Test
    public void testFetchPreparationSamples(){
        //test if all samples are retrieved
        //maybe test if codes follow samplecode specifications
    }

    @Test
    public void testGenerateMetaDataForSample(){
        //test how missing info is handled --> nan or so
    }



}
