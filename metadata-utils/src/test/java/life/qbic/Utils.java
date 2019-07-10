package life.qbic;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import ch.ethz.sis.openbis.generic.dssapi.v3.IDataStoreServerApi;
import ch.systemsx.cisd.common.spring.HttpInvokerUtils;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Utils {

    String sessionToken;

    String user;
    String password;
    String ass_url;
    String projectCode;
    String test_sample_code;
    String testInstance_URL;

    IApplicationServerApi applicationServer;

    /**
     * read the credentials file with password and user to connect to openBIS
     * @throws IOException
     */
    public void readCredentials() throws IOException {
        File file = new File(getClass().getClassLoader().getResource("credentials.properties").getFile());

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
                else if(line.contains("ass_url")){
                    ass_url = line.split("=")[1];
                }
                else if(line.contains("code")){
                    projectCode = line.split("=")[1];
                }
                else if(line.contains("testCode")){
                    test_sample_code = line.split("=")[1];
                }
                else if(line.contains("testInstance_url")){
                    testInstance_URL = line.split("=")[1];
                }
            }
        }
    }

    public OpenBisClient createClient(){
        return new OpenBisClient(user,password,ass_url);
    }

    /**
     * create a session for the given credentials and save the sessiontoken
     * @param AppServerUri
     * @param user
     * @param password
     */
    public void createOpenBisSession(String AppServerUri, String user, String password) {

        if (!AppServerUri.isEmpty()) {
            this.applicationServer = HttpInvokerUtils.createServiceStub(
                    IApplicationServerApi.class,
                    AppServerUri + IApplicationServerApi.SERVICE_URL, 10000);
        } else {
            this.applicationServer = null;
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
