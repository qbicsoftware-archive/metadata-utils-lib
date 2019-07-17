package life.qbic.UseCases;

import life.qbic.Entities.TestSample;
import life.qbic.Controller.ProjectMetaDataGenerator;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class MetaDataCollector {

    // TODO: 7/12/19 general use case --> abstract class, interface??
    // how do the different use cases differ? what is specific for each case? how many cases do we have

    private OpenBisClient client;
    private String projectCode;

    public MetaDataCollector(String projectCode, OpenBisClient client){
        this.projectCode = projectCode;
        this.client = client;
    }

    //retrieve all testsamples from the generatedData
    public ArrayList<TestSample> collectPreparationSamples(){
        MetaDataGenerator generatedData = new ProjectMetaDataGenerator(projectCode, client);

        return null;
    }

    //all testsamples act as entry a storage and hold the metadatainfo create Metadata from samples
    public HashMap<String,ArrayList<String>> collectMetadataFromSamples(ArrayList<String> preparationSample){

        //need to also include info about grouping etc thus returning only a testsample is not enough
        //HashMap<String,ArrayList<String>>: testsamplecode, entry of each column (ordered!)
        //consider handling conditions

        //return value is "table" with column entries per preparation samples
        return null;
    }

    //each use case has a different data type that needs to be queried
    public abstract String getDataType();

}
