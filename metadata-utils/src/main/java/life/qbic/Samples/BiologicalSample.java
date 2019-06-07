package life.qbic.Samples;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BiologicalSample {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String sampleCode;

    private final static Logger LOG = LogManager.getLogger(BiologicalSample.class);


    public BiologicalSample(String sessionToken, IApplicationServerApi applicationServer, String sampleCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.sampleCode = sampleCode;

    }

    // TODO: 6/7/19 add functions to represent the biolog sample type from openBIS (retrieve needed properties) 
}
