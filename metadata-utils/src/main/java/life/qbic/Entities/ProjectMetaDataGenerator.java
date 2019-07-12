package life.qbic.Entities;

import life.qbic.Entities.OpenBis.OpenBisContainer;
import life.qbic.Entities.OpenBis.Samples.TestSample;

import life.qbic.Entities.OpenBis.OpenBisContainerImplementation;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;

public class ProjectMetaDataGenerator implements MetaDataGenerator {

    private ArrayList<TestSample> preparationSamples;
    private String projectCode;
    private OpenBisClient client;


    public ProjectMetaDataGenerator(String projectCode, OpenBisClient client){
        this.projectCode = projectCode;
        this.client = client;
    }

    /* is openbis specific --> thus use openbis container to implement grouping
    @Override
    public HashMap<Integer,ArrayList<TestSample>> createGrouping(ArrayList<TestSample> samples) {

        return null;
    }*/

    @Override
    public void fetchPreparationSamples(String projectCode) {

        OpenBisContainer dataContainer = new OpenBisContainerImplementation(projectCode, client);

    }

    @Override
    public ArrayList<String> generateMetaDataForSample(TestSample sample) {

        //use the preparation samples and fetch all parent and child samples with needed information
        //return value is one row in final table
        return null;
    }
}
