package life.qbic;


import life.qbic.OpenBis.Samples.TestSample;
import life.qbic.Project.ProjectMetaDataGenerator;

import java.util.ArrayList;

public class MetaDataCollector {

    private String projectCode;

    public MetaDataCollector(String projectCode){

        this.projectCode = projectCode;

        MetaDataGenerator test = new ProjectMetaDataGenerator("");

    }

    public ArrayList<TestSample> collectPreparationSamples(){

        return null;
    }

    public void collectMetadata(ArrayList<TestSample> samples){

    }


}
