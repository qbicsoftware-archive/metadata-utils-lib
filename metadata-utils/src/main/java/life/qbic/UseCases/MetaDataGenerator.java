package life.qbic.UseCases;

import life.qbic.Entities.TestSample;

import java.util.ArrayList;

public interface MetaDataGenerator {

    //samples from isolates
    void fetchPreparationSamples(String projectCode);

    ArrayList<String> generateMetaDataForSample(TestSample sample);

    //HashMap<Integer,ArrayList<TestSample>> createGrouping(ArrayList<TestSample> samples);

}
