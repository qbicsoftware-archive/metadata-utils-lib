package life.qbic;

import junit.framework.TestCase;
import life.qbic.Project.QBiCProject;
import life.qbic.Samples.BiologicalEntity;
import life.qbic.Samples.BiologicalSample;
import life.qbic.Samples.TestSample;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class TestTestSample {

    private TestSample testSample;
    private String sampleCode;
    private OpenBisLogIn login;

    @Before
    public void setUP() throws IOException {
        login = new OpenBisLogIn();

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
    }

    // TODO: 6/14/19 what should be tested for biological entity and biological sample ?
    @Test
    public void biologicalSampleTest(){
        BiologicalSample biologSample = new BiologicalSample(login.sessionToken, login.applicationServer, sampleCode);
        TestCase.assertTrue(biologSample.getTissue() != null);
    }

    @Test
    public void biologicalEntityTest(){
        BiologicalEntity biologEntity = new BiologicalEntity(login.sessionToken, login.applicationServer, sampleCode);
        TestCase.assertTrue(biologEntity.getSource() != null);
    }

    @Test
    public void testMultipleConditions(){

    }

}
