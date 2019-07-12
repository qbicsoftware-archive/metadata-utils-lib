package life.qbic.Entities.OpenBis.Samples;

import java.util.HashMap;

public class TestSample {

    private String entityID;
    private BiologicalSample biologicalSample;
    private OmicsRun ssRun;
    private String sampleCode;

    HashMap<String,String> properties; //?????

    public TestSample(String sampleCode)
    {
        this.sampleCode = sampleCode;

    }

    public HashMap<String,String> getProperties(){
        return properties;
    }


    //methods that retain info from properties hashmap
    //some are retained recursively through related sample types
    public String getSecondaryName(){
        return null;
    }

    public String getSampleName(){
        return null;
    }

    public String getAnalyte(){
        return null;
    }

    public String getRIN(){
        return null;
    }

    public String getTissue(){
        return null;
    }

    public String getOrganism(){
        return null;
    }

    public String getFileName(){
        return null;
    }

    public String getEntityID(){
        return entityID;
    }

    public String getConditions(){
        return null;
    }

    public String getSampleCode(){
        return sampleCode;
    }

}
