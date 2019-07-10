package life.qbic;


import life.qbic.OpenBis.Samples.TestSample;
import life.qbic.Project.ProjectMetaDataGenerator;

import java.util.ArrayList;
import java.util.HashMap;

//useCase class
public class MetaDataCollector {

    private MetaDataGenerator generatedData;

    public MetaDataCollector(String projectCode){

        generatedData = new ProjectMetaDataGenerator(projectCode);

    }

    //retrieve all testsamples from the generatedData
    public ArrayList<TestSample> collectPreparationSamples(){

        return null;
    }

    //all testsamples act as entry a storage and hold the metadatainfo create Metadata from samples
    public HashMap<String,ArrayList<String>> collectMetadataFromSamples(ArrayList<TestSample> samples){

            //need to also include info about grouping etc thus returning only a testsample is not enough
            //HashMap<String,ArrayList<String>>: testsamplecode, entry of each column (ordered!)
            //consider handling conditions

        return null;
    }


}
