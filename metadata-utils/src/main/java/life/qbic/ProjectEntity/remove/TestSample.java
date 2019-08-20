package life.qbic.ProjectEntity;

import java.util.HashMap;

public class TestSample extends QBiCSample{


    public TestSample(String sampleCode, HashMap<String, String> properties)    {
        super(sampleCode, properties);
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

    public String getConditions(){
        return null;
    }


}
