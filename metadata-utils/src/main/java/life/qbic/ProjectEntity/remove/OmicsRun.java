package life.qbic.ProjectEntity;

import java.util.HashMap;

public class OmicsRun extends QBiCSample{


    public OmicsRun(String sampleCode, HashMap<String, String> properties){
        super(sampleCode, properties);
    }

    public String getFileName(){
        return null;
    }

    public String getConditions(){ return null;}

    public String getOmicsMeasurement(){
        return null;
    }

}
