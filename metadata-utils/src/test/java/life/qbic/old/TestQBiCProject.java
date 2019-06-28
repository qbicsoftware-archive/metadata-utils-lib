package life.qbic.old;

import junit.framework.TestCase;
import org.junit.*;

import java.io.*;
import java.util.ArrayList;


public class TestQBiCProject {

    QBiCProject project;
    String projectCode;


    @Before
    public void setUp() throws IOException{
        OpenBisLogIn login = new OpenBisLogIn();

        //create a session with OpenBIS
        login.readCredentials();
        login.createSession(login.testInstance_URL, login.user, login.password);

        projectCode = login.projectCode;

        project = new QBiCProject(login.sessionToken, login.applicationServer, projectCode);
    }


    @Test
    public void getSamplePreparationCodes(){

        ArrayList<String> samples = project.fetchSamplePreparationCodes();

        //elements in list should start with the project code
        for(String sample : samples){
            System.out.println(sample);
            TestCase.assertTrue(sample.startsWith(projectCode));
        }
    }

    @Test
    public void downloadTest() throws IOException{
        project.createMetaDataSheet();

        File file =  new File(System.getProperty("user.dir")+File.separator+"metadataSheet.csv");
        Boolean fileExists = file.exists();

        TestCase.assertTrue(fileExists);

    }

}
