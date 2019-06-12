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

    IApplicationServerApi applicationServer;
    IDataStoreServerApi dataStoreServer;
    QBiCProject project;

    //Set by the credentials
    String sessionToken;
    String user;
    String password;
    String dss_url;
    String ass_url;
    String projectCode;


    @Before
    public void setUp() throws IOException{

        //create a session with OpenBIS
        readCredentials();
        createSession(ass_url,dss_url,user,password);

        project = new QBiCProject(sessionToken, applicationServer, projectCode);
    }


    @Test
    public void getSamplePreparationCodes(){

        ArrayList<String> samples = project.getSamplePreparationCodes();

        //elements in list should start with the project code
        for(String sample : samples){
            TestCase.assertTrue(sample.startsWith(projectCode));
        }
        String test ="this is a test";
    }


    /**
     * read the credentials file with password and user to connect to openBIS
     * @throws IOException
     */
    private void readCredentials() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("Credentials.properties").getFile());

        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader)) {

            String line;
            while ((line = br.readLine()) != null) {
                if(line.contains("#")){
                    continue;
                }

                if(line.contains("user")){
                    user = line.split("=")[1];
                }
                else if(line.contains("password")){
                    password = line.split("=")[1];
                }
                else if(line.contains("dss_url")){
                    dss_url = line.split("=")[1];
                }
                else if(line.contains("ass_url")){
                    ass_url = line.split("=")[1];
                }
                else if(line.contains("code")){
                    projectCode = line.split("=")[1];
                }
            }
        }
    }

    /**
     * create a session for the given credentials and save the sessiontoken
     * @param AppServerUri
     * @param DataServerUri
     * @param user
     * @param password
     */
    public void createSession(String AppServerUri, String DataServerUri, String user, String password) {

        if (!AppServerUri.isEmpty()) {
            this.applicationServer = HttpInvokerUtils.createServiceStub(
                    IApplicationServerApi.class,
                    AppServerUri + IApplicationServerApi.SERVICE_URL, 10000);
        } else {
            this.applicationServer = null;
        }
        if (!DataServerUri.isEmpty()) {
            this.dataStoreServer = HttpInvokerUtils.createStreamSupportingServiceStub(
                    IDataStoreServerApi.class,
                    DataServerUri + IDataStoreServerApi.SERVICE_URL, 10000);
        } else {
            this.dataStoreServer = null;
        }

        try {
            this.sessionToken = this.applicationServer.login(user, password);
            this.applicationServer.getSessionInformation(this.sessionToken);
        } catch (AssertionError | Exception err) {
            System.err.println("Connection Error");
            return;
        }
    }
}
