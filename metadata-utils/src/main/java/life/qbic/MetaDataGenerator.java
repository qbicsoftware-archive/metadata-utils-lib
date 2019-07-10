package life.qbic;

import life.qbic.OpenBis.Samples.TestSample;

import java.util.ArrayList;
import java.util.HashMap;

public interface MetaDataGenerator {

    //samples from isolates
    void fetchPreparationSamples(String projectCode);

    ArrayList<String> generateMetaDataForSample(String sampleCode);

    //HashMap<Integer,ArrayList<TestSample>> createGrouping(ArrayList<TestSample> samples);

}
