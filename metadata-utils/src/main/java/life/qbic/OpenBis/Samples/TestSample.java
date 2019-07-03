package life.qbic.OpenBis.Samples;

import java.util.HashMap;

public class TestSample {

    String entityID;
    BiologicalSample biologicalSample;
    SingleSampleRun ssRun;

    HashMap<String,String> properties; //?????

    public TestSample(String sampleCode){
        //fill properties

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

   /* is implemented with returned hashmap in createGroup?
   public int getGroup(){
        return -1;
    }*/

    public String getConditions(){
        return null;
    }



}
