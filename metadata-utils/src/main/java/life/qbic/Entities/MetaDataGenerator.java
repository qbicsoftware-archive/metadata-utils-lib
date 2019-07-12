package life.qbic.Entities;

import life.qbic.Entities.OpenBis.Samples.TestSample;

import java.util.ArrayList;

public interface MetaDataGenerator {

    //samples from isolates
    void fetchPreparationSamples(String projectCode);

    ArrayList<String> generateMetaDataForSample(TestSample sample);

    //HashMap<Integer,ArrayList<TestSample>> createGrouping(ArrayList<TestSample> samples);

}
