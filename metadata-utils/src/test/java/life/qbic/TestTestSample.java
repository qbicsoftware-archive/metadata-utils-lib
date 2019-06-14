package life.qbic;

import junit.framework.TestCase;
import life.qbic.Project.QBiCProject;
import life.qbic.Samples.TestSample;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestTestSample {

    private TestSample testSample;
    private String sampleCode;

    @Before
    public void setUP() throws IOException {
        OpenBisLogIn login = new OpenBisLogIn();

        //create a session with OpenBIS
        login.readCredentials();
        login.createSession(login.ass_url, login.dss_url, login.user, login.password);

        sampleCode = login.test_sample_code;

        testSample = new TestSample(login.sessionToken, login.applicationServer, sampleCode);
    }

    @Test
    public void fetchTestSampleInformation(){

        testSample.fetchTestSample();
        TestCase.assertEquals(testSample.getAnalyte(),"RNA");
        //System.out.println(testSample.getSampleProperties());
    }

    @Test
    public void biologicalSampleTest(){
        testSample.getTissue();
    }

    @Test
    public void biologicalEntityTest(){
        System.out.println(testSample.getSource());
    }

}
