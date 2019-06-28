package life.qbic;

import life.qbic.OpenBis.Samples.TestSample;

import java.util.ArrayList;

public interface MetaDataGenerator {

    //samples from isolates
    ArrayList<TestSample> fetchPreparationSamples(String projectCode);

    void generateMetaDataForSamples(ArrayList<TestSample> samples);

    //also method to generate output??
}
