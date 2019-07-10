package life.qbic;

import life.qbic.Project.ProjectMetaDataGenerator;
import life.qbic.openbis.openbisclient.OpenBisClient;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import static junit.framework.TestCase.assertEquals;

public class TestMetaDataGenerator {


    private MetaDataGenerator generatedData;
    private OpenBisClient client;

    @Before
    public void setUp() throws IOException {
        Utils utils = new Utils();
        utils.readCredentials();

        client = utils.createClient();

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

    @After
    public void logout(){
        client.logout();
    }

}
