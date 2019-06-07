package life.qbic;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;

import java.util.ArrayList;

/**
 * This class represents the TestSample (Q_TEST_SAMPLE), thus a row of the output table.
 * It saves all relevant meta data for a TestSample
 */
public class TestSample {

    //actually a Sample type on the level of the Experiment type Sample_Preparation
    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String projectCode;

    public TestSample(String sessionToken, IApplicationServerApi applicationServer, String projectCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.projectCode = projectCode;

    }


    public ArrayList<String> getSampleProperties(){

        return null;
    }

    public String getLabID(){

        return "";
    }

    public String getExtractCode(){

        return "";
    }

    public String getSource(){

        return "";
    }

    public String getSampleType(){

        return "";
    }

    public String getSecondaryName(){

        return "";
    }

    public String getRIN(){

        return "";
    }

    public String getTissue(){

        return "";
    }


}
