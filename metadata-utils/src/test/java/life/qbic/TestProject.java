package life.qbic;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import life.qbic.Project.Project;
import org.junit.*;


public class TestProject {

    Project project;
    IApplicationServerApi applicationServerApi;

    @Before
    public void setUp(){
        project = new Project("token", applicationServerApi, "QXXXX");
    }
    @Test
    public void getSamplePreparationCodes(){

        //obtained list should not be null
        //assertNotNull();
        //elements in list should s
    }
}
