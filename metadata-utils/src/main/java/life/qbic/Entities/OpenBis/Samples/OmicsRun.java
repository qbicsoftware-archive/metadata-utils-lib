package life.qbic.Entities.OpenBis.Samples;

public class OmicsRun {

    private TestSample parentTestSample;

    public OmicsRun(String parentCode){
        // TODO: 7/12/19 omics run is general case --> how to treat different omics runs? should this be implemented as an abstract class 
    }

    public String getFileName(){
        return null;
    }

    public String getConditions(){ return null;}

    public String getOmicsMeasurement(){
        return null;
    }

}
