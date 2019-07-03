package life.qbic;

import life.qbic.OpenBis.Samples.TestSample;

import java.util.ArrayList;
import java.util.HashMap;

public interface MetaDataGenerator {

    //samples from isolates
    void fetchPreparationSamples(String projectCode);

    void generateMetaDataForSamples(); //? do i need this? it is implicitly information in testsamples

    //HashMap<Integer,ArrayList<TestSample>> createGrouping(ArrayList<TestSample> samples);

}
