package life.qbic.Controller;


import life.qbic.UseCases.NGSMetaDataCollector;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;
import java.util.HashMap;

//controller class
public class MetaDataRetriever {

    private String projectCode;
    private OpenBisClient client;
    private HashMap<String,ArrayList<String>> sampleMetadata;

    public MetaDataRetriever(String projectCode, OpenBisClient client){
            this.projectCode = projectCode;
            this.client = client;
    }

    // TODO: 7/12/19 handle different use cases!!!
    // always return the columnwise info --> info as string?? --> headerinformation equal for each use case??

    //use collector to get info about samples and metadata
    //apply all steps needed from the usecase (metadatacollector), steps are implemented as methods
    public ArrayList<String> retrieveMetadata(){
        NGSMetaDataCollector collectedData = new NGSMetaDataCollector(projectCode, client);

        return null;
    }


}
