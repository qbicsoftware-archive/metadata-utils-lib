package life.qbic.ProjectEntity;

import java.util.HashMap;

public class BiologicalEntity extends QBiCSample{


    public BiologicalEntity(String sampleCode, HashMap<String, String> properties) {
        super(sampleCode, properties);
    }

    public String getOrganism(){
        return null;
    }
    public String getConditions(){ return null;}
}
