package life.qbic;


import life.qbic.OpenBis.Samples.TestSample;
import life.qbic.Project.ProjectMetaDataGenerator;

import java.util.ArrayList;

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
    public void collectMetadataFromSamples(ArrayList<TestSample> samples){

    }


}
