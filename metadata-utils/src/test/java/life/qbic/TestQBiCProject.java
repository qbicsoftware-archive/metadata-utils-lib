package life.qbic;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.project.Project;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample;
import ch.ethz.sis.openbis.generic.dssapi.v3.IDataStoreServerApi;
import ch.systemsx.cisd.common.spring.HttpInvokerUtils;
import junit.framework.TestCase;
import life.qbic.Project.QBiCProject;
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
        login.createSession(login.ass_url, login.dss_url, login.user, login.password);

        projectCode = login.projectCode;

        project = new QBiCProject(login.sessionToken, login.applicationServer, projectCode);
    }


    @Test
    public void getSamplePreparationCodes(){

        ArrayList<String> samples = project.fetchSamplePreparationCodes();

        //elements in list should start with the project code
        for(String sample : samples){
            //System.out.println(sample);
            TestCase.assertTrue(sample.startsWith(projectCode));
        }
    }



}
