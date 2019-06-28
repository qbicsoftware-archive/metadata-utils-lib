package life.qbic.Project;

import life.qbic.MetaDataGenerator;
import life.qbic.OpenBis.OpenBisContainer;
import life.qbic.OpenBis.Samples.TestSample;

import life.qbic.OpenBis.OpenBisContainerImplementation;

import java.util.ArrayList;

public class ProjectMetaDataGenerator implements MetaDataGenerator {


    public ProjectMetaDataGenerator(String projectCode){

        OpenBisContainer container = new OpenBisContainerImplementation(projectCode);

    }

    @Override
    public ArrayList<TestSample> fetchPreparationSamples(String projectCode) {
        return null;
    }

    @Override
    public void generateMetaDataForSamples(ArrayList<TestSample> samples) {

    }
}
