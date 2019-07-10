package life.qbic.OpenBis;


import life.qbic.OpenBis.Samples.BiologicalEntity;
import life.qbic.OpenBis.Samples.BiologicalSample;
import life.qbic.OpenBis.Samples.SingleSampleRun;
import life.qbic.OpenBis.Samples.TestSample;

import java.util.ArrayList;
import java.util.HashMap;

public interface OpenBisContainer {

    BiologicalEntity getEntitiesForTestSample(String sampleCode);
    BiologicalSample getBiologicalSamplesForTestSample(String sampleCode);
    SingleSampleRun getSingleSampleRunForTestSample(String sampleCode);
    ArrayList<TestSample> getTestSamplesForProject(String projectCode);
    String getFactors(String sampleCode);
    HashMap<Integer,String> getSampleGrouping();

}
