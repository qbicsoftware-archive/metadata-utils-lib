package life.qbic.ProjectEntity;

import java.util.HashMap;

public class BiologicalSample extends QBiCSample{


    public BiologicalSample(String sampleCode, HashMap<String, String> properties){
        super(sampleCode, properties);
    }

    public String getTissue(){
        return null;
    }
    public String getConditions(){ return null;}

}
