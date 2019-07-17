package life.qbic.Controller;


import life.qbic.Entities.BiologicalEntity;
import life.qbic.Entities.BiologicalSample;
import life.qbic.Entities.OmicsRun;
import life.qbic.Entities.TestSample;

import java.util.ArrayList;
import java.util.HashMap;

public interface OpenBisContainer {

    // die alle evlt nur in der implementierung als private klassen
    BiologicalEntity getEntityForTestSample(String sampleCode);
    BiologicalSample getBiologicalSampleForTestSample(String sampleCode);
    ArrayList<OmicsRun> getOmicsForTestSample(String sampleCode);
    //
    ArrayList<TestSample> getTestSamplesForProject(String projectCode);
    HashMap<String,ArrayList<String>> getFactors(ArrayList<TestSample> samples);
    HashMap<Integer,String> getSampleGrouping();
    String mapVocabularyTermIDToString(int id);

}
