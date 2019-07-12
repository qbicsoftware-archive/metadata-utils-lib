package life.qbic.Entities.OpenBis;


import life.qbic.Entities.OpenBis.Samples.BiologicalEntity;
import life.qbic.Entities.OpenBis.Samples.BiologicalSample;
import life.qbic.Entities.OpenBis.Samples.OmicsRun;
import life.qbic.Entities.OpenBis.Samples.TestSample;

import java.util.ArrayList;
import java.util.HashMap;

public interface OpenBisContainer {

    // die alle evlt nur in der implementierung als private klassen
    BiologicalEntity getEntityForTestSample(String sampleCode);
    BiologicalSample getBiologicalSampleForTestSample(String sampleCode);
    ArrayList<OmicsRun> getSingleSampleRunsForTestSample(String sampleCode);
    //
    ArrayList<TestSample> getTestSamplesForProject(String projectCode);
    HashMap<String,ArrayList<String>> getFactors(ArrayList<TestSample> samples);
    HashMap<Integer,String> getSampleGrouping();
    String mapVocabularyTermIDToString(int id);

}
