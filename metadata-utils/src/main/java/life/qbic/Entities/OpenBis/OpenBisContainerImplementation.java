package life.qbic.Entities.OpenBis;


import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import life.qbic.Entities.OpenBis.Samples.BiologicalEntity;
import life.qbic.Entities.OpenBis.Samples.BiologicalSample;
import life.qbic.Entities.OpenBis.Samples.OmicsRun;
import life.qbic.Entities.OpenBis.Samples.TestSample;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;
import java.util.HashMap;

public class OpenBisContainerImplementation implements OpenBisContainer {

    private HashMap<Integer,String> sampleGrouping;
    private String sessionToken;
    private IApplicationServerApi v3;

    public OpenBisContainerImplementation(String projectCode, OpenBisClient client) {

        //get info about connection from client to make db requests
        //erst hier client login! auch logout am ende!
        //get openbis project

    }

    //parents
    @Override
    public BiologicalEntity getEntityForTestSample(String sampleCode) {
        return null;
    }

    @Override
    public BiologicalSample getBiologicalSampleForTestSample(String sampleCode) {
        return null;
    }

    //child
    //e.g. singlesamplerun
    @Override
    public ArrayList<OmicsRun> getOmicsForTestSample(String sampleCode) {
        return null;
    }

    //enter sample type
    @Override
    public ArrayList<TestSample> getTestSamplesForProject(String projectCode) {
        return null;
    }

    @Override
    //samplecode, list of parsed conditions, list all, even duplicates (no filtering)
    public HashMap<String,ArrayList<String>> getFactors(ArrayList<TestSample> samples) {
        return null;
    }

    @Override
    public HashMap<Integer,String> getSampleGrouping(){
        return null;
    }

    @Override
    public String mapVocabularyTermIDToString(int id) {
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
