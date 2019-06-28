package life.qbic;

import life.qbic.MetaDataCollector;
import life.qbic.OpenBis.Samples.TestSample;

import java.util.ArrayList;

public class MetaDataRetriever {

    public MetaDataRetriever(String projectCode){

        MetaDataCollector collector = new MetaDataCollector(projectCode);
    }

    //use collector to get info about samples and metadata
    public ArrayList<TestSample> retrieveSamples(){

        return null;
    }

    public void retrieveMetadata(ArrayList<TestSample> samples){

    }

    public void createTSVOutput(){

    }
}
