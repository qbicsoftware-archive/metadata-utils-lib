package life.qbic.OpenBis;


import life.qbic.OpenBis.Samples.BiologicalEntity;
import life.qbic.OpenBis.Samples.BiologicalSample;
import life.qbic.OpenBis.Samples.SingleSampleRun;
import life.qbic.OpenBis.Samples.TestSample;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenBisContainerImplementation implements OpenBisContainer {

    public OpenBisContainerImplementation(String projectCode) {

        //new OpenBisClient(); braucht String sessionToken, String assURL, String user, String password
        //get openbis project

    }

    @Override
    public BiologicalEntity getEntitiesForTestSample(String code) {
        return null;
    }

    @Override
    public BiologicalSample getBiologicalSamplesForTestSample(String code) {
        return null;
    }

    @Override
    public SingleSampleRun getSingleSampleRunForTestSample(String code) {
        return null;
    }

    @Override
    public ArrayList<TestSample> getTestSampleForProject(String code) {
        return null;
    }

    @Override
    public String getFactors(String code) {
        return null;
    }


    public String getFactorsForSample(String code) {
        //do it for samples and experiment level and only keep the union of both (no double information)
        return null;
    }

    public String getFactorsForExperiment(String code) {
        //do it for samples and experiment level and only keep the union of both (no double information)
        return null;
    }

    private String parseXMLFactors(String xml){
        return null;
    }

    private HashMap<Integer,TestSample> createGrouping(ArrayList<TestSample> samples){
        return null;
    }
}
