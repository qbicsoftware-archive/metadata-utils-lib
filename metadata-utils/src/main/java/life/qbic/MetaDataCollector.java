package life.qbic;


import life.qbic.OpenBis.Samples.TestSample;
import life.qbic.Project.ProjectMetaDataGenerator;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;
import java.util.HashMap;

//useCase class
public class MetaDataCollector {

    private MetaDataGenerator generatedData;
    private OpenBisClient client;

    public MetaDataCollector(String projectCode, OpenBisClient client){

        generatedData = new ProjectMetaDataGenerator(projectCode, client);

    }

    //retrieve all testsamples from the generatedData
    public ArrayList<TestSample> collectPreparationSamples(){

        return null;
    }

    //all testsamples act as entry a storage and hold the metadatainfo create Metadata from samples
    public HashMap<String,ArrayList<String>> collectMetadataFromSamples(ArrayList<String> preparationSample){

            //need to also include info about grouping etc thus returning only a testsample is not enough
            //HashMap<String,ArrayList<String>>: testsamplecode, entry of each column (ordered!)
            //consider handling conditions

        return null;
    }


}
