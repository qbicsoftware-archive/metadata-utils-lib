package life.qbic.OpenBis;


import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import life.qbic.OpenBis.Samples.BiologicalEntity;
import life.qbic.OpenBis.Samples.BiologicalSample;
import life.qbic.OpenBis.Samples.SingleSampleRun;
import life.qbic.OpenBis.Samples.TestSample;

import java.util.HashMap;

public class OpenBisContainerImplementation implements OpenBisContainer {

    public OpenBisContainerImplementation(String projectCode) {

        //new OpenBisClient(); braucht String sessionToken, String assURL, String user, String password

    }

    @Override
    public BiologicalEntity getEntitiesForTestSample(String code) {
        return null;
    }

    @Override
    public BiologicalSample getBiologicalSamplesForTestSample(String code) {
        return null;
    }

    @Override
    public SingleSampleRun getSingleSampleRunForTestSample(String code) {
        return null;
    }

    @Override
    public TestSample getTestSampleForProject(String code) {
        return null;
    }

}
