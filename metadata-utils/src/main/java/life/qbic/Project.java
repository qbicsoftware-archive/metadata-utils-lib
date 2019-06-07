package life.qbic;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;

/**
 * This Class represents the Project for which the meta data should be collected
 */
public class Project {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String projectCode;

    public Project(String sessionToken, IApplicationServerApi applicationServer, String projectCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.projectCode = projectCode;

    }

    /**
     * Lookup all SamplePreparation Codes for a project (Experiment Type Q_SAMPLE_PREPARATION Codes)
     * @return
     */
    public String getSamplePreparationCodes(){



        return "";
    }

}
