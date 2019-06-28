package life.qbic.OpenBis;


import life.qbic.OpenBis.Samples.BiologicalEntity;
import life.qbic.OpenBis.Samples.BiologicalSample;
import life.qbic.OpenBis.Samples.SingleSampleRun;
import life.qbic.OpenBis.Samples.TestSample;

import java.util.ArrayList;
import java.util.HashMap;

public interface OpenBisContainer {

    //BiologicalEntity getEntitiesForTestSample(String code);
    //BiologicalSample getBiologicalSamplesForTestSample(String code);
    //SingleSampleRun getSingleSampleRunForTestSample(String code);
    ArrayList<TestSample> getTestSampleForProject(String code);

    //grouping

}
