package life.qbic.Samples;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BiologicalEntity {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String sampleCode;
    private Sample biologEntity;

    private final static Logger LOG = LogManager.getLogger(BiologicalEntity.class);


    public BiologicalEntity(String sessionToken, IApplicationServerApi applicationServer, String sampleCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.sampleCode = sampleCode;

    }

    /**
     * Look up the corresponding Biolog. entity
     * @return
     */
    // TODO: 6/7/19 what represents the sampleCode and how is it different tot he biolog. entity, rethink how to use the code and when this class is used
    //  and for which types of samples they are used
    public Sample getBiologEntity(){

        return null;
    }
    //add more functions to retrieve further meta data info from this type

}
