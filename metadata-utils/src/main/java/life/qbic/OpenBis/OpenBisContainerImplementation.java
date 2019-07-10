package life.qbic.OpenBis;


import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import life.qbic.OpenBis.Samples.BiologicalEntity;
import life.qbic.OpenBis.Samples.BiologicalSample;
import life.qbic.OpenBis.Samples.SingleSampleRun;
import life.qbic.OpenBis.Samples.TestSample;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenBisContainerImplementation implements OpenBisContainer {

    private HashMap<Integer,String> sampleGrouping;
    private String sessionToken;
    private IApplicationServerApi v3;

    public OpenBisContainerImplementation(String projectCode, OpenBisClient client) {

        //get info about connection from client to make db requests
        //get openbis project

    }

    @Override
    public BiologicalEntity getEntitiesForTestSample(String sampleCode) {
        return null;
    }

    @Override
    public BiologicalSample getBiologicalSamplesForTestSample(String sampleCode) {
        return null;
    }

    @Override
    public SingleSampleRun getSingleSampleRunForTestSample(String sampleCode) {
        return null;
    }

    @Override
    public ArrayList<TestSample> getTestSamplesForProject(String projectCode) {
        return null;
    }

    @Override
    public String getFactors(String sampleCode) {
        return null;
    }

    @Override
    public HashMap<Integer,String> getSampleGrouping(){
        return null;
    }


    public String getFactorsForSample(String sampleCode) {
        //do it for samples and experiment level and only keep the union of both (no double information)
        return null;
    }

    public String getFactorsForExperiment(String exprimentCode) {
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
