package life.qbic.Project;

import life.qbic.MetaDataGenerator;
import life.qbic.OpenBis.OpenBisContainer;
import life.qbic.OpenBis.Samples.TestSample;

import life.qbic.OpenBis.OpenBisContainerImplementation;

import java.util.ArrayList;
import java.util.HashMap;

public class ProjectMetaDataGenerator implements MetaDataGenerator {

    OpenBisContainer dataContainer;
    ArrayList<TestSample> preparationSamples;


    public ProjectMetaDataGenerator(String projectCode){

        dataContainer = new OpenBisContainerImplementation(projectCode);

    }

    /* is openbis specific --> thus use openbis container to implement grouping
    @Override
    public HashMap<Integer,ArrayList<TestSample>> createGrouping(ArrayList<TestSample> samples) {

        return null;
    }*/

    @Override
    public void fetchPreparationSamples(String projectCode) {
    }

    @Override
    public void generateMetaDataForSamples() {

    }
}
