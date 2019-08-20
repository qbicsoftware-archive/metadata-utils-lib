package life.qbic.ProjectEntity;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class QBiCSample {

    private String sampleCode;
    private QBiCSample parent;
    private ArrayList<QBiCSample> children = new ArrayList<>();
    private HashMap<String,String> properties;


    public QBiCSample(String sampleCode, HashMap<String,String> properties){
        this.properties = properties;
        this.sampleCode = sampleCode;
    }

    public void addChild(QBiCSample child){
        children.add(child);
    }

    public void setParent(QBiCSample parent){
        this.parent = parent;
    }

    private void filterForRelevantProperties(ArrayList<String> propLabelList){
        //method to manipulate
        //determine what kind of properties are filtered based on useCase!!!!
        //give warnings here

    }

    public String getSampleCode() {
        return sampleCode;
    }

    public QBiCSample getParent() {
        return parent;
    }

    public ArrayList<QBiCSample> getChildren() {
        return children;
    }

    public HashMap<String, String> getProperties() {
        return properties;
    }
}
