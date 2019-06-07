package life.qbic.Samples;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;

/**
 * This class represents the TestSample (Q_TEST_SAMPLE), thus a row of the output table.
 * It saves all relevant meta data for a TestSample
 */
public class TestSample {

    //actually a Sample type on the level of the Experiment type Sample_Preparation
    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String sampleCode;

    private final static Logger LOG = LogManager.getLogger(TestSample.class);


    public TestSample(String sessionToken, IApplicationServerApi applicationServer, String sampleCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.sampleCode = sampleCode;

    }


    /**
     * Return properties of the Sample as a map with key,value (e.g. health_state, healthy)
     * @return
     */
    public HashMap<String,String> getSampleProperties(){
        //Properties

        return null;
    }

    /**
     * Get the LabID for this sample (ExternalDB identifier)
     * @return
     */
    public String getLabID(){
        //External DB identifier

        return "";
    }

    /**
     * The "Sample type" is not the "Sample Type"
     * e.g RNA (no QBiC specific code type for a Sample)
     * @return
     */
    public String getSampleType(){
        //Sample type

        return "";
    }


    /**
     *
     * @return
     */
    // TODO: 6/7/19 There is also a secondary Name field for Q_NGS_SINGLE_RUN types.. which one is needed??
    public String getSecondaryName(){
        //Secondary name
        return "";
    }


    /**
     *
     * @return
     */
    public String getTissue(){
        //Primary tissue/body fluid
        return "";
    }

    /**
     *
     * @return
     */
    public String getRIN(){
        //RNA Integrity Number

        return "";
    }

    /**
     * Get the ExtractionCode from the corresponding Biological Sample
     * @param bioSample
     * @return
     */
    public String getExtractCode(BiologicalSample bioSample){
        //Sample Type must equal Q_BIOLOGICAL_SAMPLE

        //check if the given biologSample has the current TestSample as a parent

        return "";
    }

    /**
     *
     * @param entity
     * @return
     */
    public String getSource(BiologicalEntity entity){
        //NCBI organism

        return "";
    }





}
