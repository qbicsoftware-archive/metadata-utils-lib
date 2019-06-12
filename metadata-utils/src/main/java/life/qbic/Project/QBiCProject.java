package life.qbic.Project;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.common.search.SearchResult;

import ch.ethz.sis.openbis.generic.asapi.v3.dto.dataset.DataSet;

import ch.ethz.sis.openbis.generic.asapi.v3.dto.experiment.Experiment;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.experiment.fetchoptions.ExperimentFetchOptions;

import ch.ethz.sis.openbis.generic.asapi.v3.dto.project.Project;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.project.fetchoptions.ProjectFetchOptions;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.project.search.ProjectSearchCriteria;

import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.fetchoptions.SampleFetchOptions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

/**
 * This Class represents the QBiCProject for which the meta data should be collected
 */
public class QBiCProject {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String projectCode;

    private final static Logger LOG = LogManager.getLogger(QBiCProject.class);


    public QBiCProject(String sessionToken, IApplicationServerApi applicationServer, String projectCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.projectCode = projectCode;

    }

    /**
     * Lookup all SamplePreparation Codes for a project (Experiment Type Q_SAMPLE_PREPARATION Codes)
     * @return
     */
    public ArrayList<String> fetchSamplePreparationCodes(){

        ProjectSearchCriteria criteria = new ProjectSearchCriteria();
        criteria.withCode().thatEquals(projectCode);

        // tell the API to fetch the experiment codes and corresponding sample codes for the current project
        ProjectFetchOptions fetchOptions = new ProjectFetchOptions();
        ExperimentFetchOptions experimentFetchOptions = new ExperimentFetchOptions();
        SampleFetchOptions sampleFetchOptions = new SampleFetchOptions();

        experimentFetchOptions.withType();
        experimentFetchOptions.withSamplesUsing(sampleFetchOptions);
        fetchOptions.withExperimentsUsing(experimentFetchOptions);


        SearchResult<Project> result = applicationServer.searchProjects(sessionToken, criteria, fetchOptions);
        LOG.info("Fetched information for the project");

        // get all sample codes of the project
        ArrayList<String> sampleCodes = new ArrayList<String>();

        for (Project project : result.getObjects()) {
            for(Experiment experiment :project.getExperiments()){
                //SamplePreparation Codes are the codes the metadata table is based on
                if(experiment.getType().getCode().equals("Q_SAMPLE_PREPARATION")){
                    for(Sample sample : experiment.getSamples()){
                        sampleCodes.add(sample.getCode());
                    }
                }
            }
        }

        return sampleCodes;
    }

}
