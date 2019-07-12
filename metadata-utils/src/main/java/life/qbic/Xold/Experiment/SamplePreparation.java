package life.qbic.Xold.Experiment;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Represents an Experiment of OpenBIS of the Type Q_Sample_Preparation
 */
public class SamplePreparation {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String experimentCode;

    private final static Logger LOG = LogManager.getLogger(SamplePreparation.class);


    public SamplePreparation(String sessionToken, IApplicationServerApi applicationServer, String experimentCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.experimentCode = experimentCode;

    }



    public String getSamplePreparationCode(){

        return "";
    }

    /**
     * Maybe there are properties saved for the corresponding  
     * @return
     */
    // TODO: 6/7/19 nur für Experimente vom Type Q_EXPERIMENTAL_DESIGN
    public String getExperimentProperties(){

        return "";
    }

}
