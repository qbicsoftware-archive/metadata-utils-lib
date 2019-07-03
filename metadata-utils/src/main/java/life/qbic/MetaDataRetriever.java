package life.qbic;


import java.util.ArrayList;

//controller class
public class MetaDataRetriever {

    private MetaDataCollector collectedData;

    public MetaDataRetriever(String projectCode){

        collectedData = new MetaDataCollector(projectCode);
    }

    //use collector to get info about samples and metadata
    //apply all steps needed from the usecase (metadatacollector), steps are implemented as methods
    public void retrieveMetadata(){

    }

    public void createTSVOutput(){
        //getMaxNumOfConditions
    }
}
