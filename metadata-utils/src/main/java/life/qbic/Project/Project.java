package life.qbic.Project;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * This Class represents the Project for which the meta data should be collected
 */
public class Project {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String projectCode;

    private final static Logger LOG = LogManager.getLogger(Project.class);


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
