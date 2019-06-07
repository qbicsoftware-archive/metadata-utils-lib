package life.qbic;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;

/**
 * Represents an Experiment of OpenBIS of the Type Q_Sample_Preparation
 */
public class SamplePreparation {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String projectCode;

    public SamplePreparation(String sessionToken, IApplicationServerApi applicationServer, String projectCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.projectCode = projectCode;

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
