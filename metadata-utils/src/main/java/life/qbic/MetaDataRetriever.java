package life.qbic;


import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;
import java.util.HashMap;

//controller class
public class MetaDataRetriever {

    private MetaDataCollector collectedData;

    public MetaDataRetriever(String projectCode, OpenBisClient client){

        collectedData = new MetaDataCollector(projectCode, client);
    }

    //use collector to get info about samples and metadata
    //apply all steps needed from the usecase (metadatacollector), steps are implemented as methods
    public HashMap<String,ArrayList<String>> retrieveMetadata(){

        return null;
    }

    public void createCSVOutput(){
        //getMaxNumOfConditions
    }
}
