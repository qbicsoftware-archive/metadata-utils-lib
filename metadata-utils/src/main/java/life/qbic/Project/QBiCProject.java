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
import life.qbic.Samples.TestSample;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.weaver.ast.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This Class represents the QBiCProject for which the meta data should be collected
 */
public class QBiCProject {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String projectCode;
    //contains the group assignment and the corresponding list of sample codes of this group
    private HashMap<Integer,ArrayList<String>> groups = new HashMap<>();
    //contains a list of all possible properties occurring in this project
    private ArrayList<String> properties = new ArrayList<>();

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

    /**
     * Method to calculate the grouping of the samples corresponding to their parent entity
     */
    private void calculateGrouping(ArrayList<String> samples){

        int groupCounter = 1;

        for(String sample : samples){
            TestSample testSample = new TestSample(sessionToken,applicationServer,sample);
            testSample.fetchTestSample();

            if(!groups.containsKey(testSample.getEntity())){
                ArrayList<String> codes = new ArrayList<>();
                codes.add(testSample.getTestSampleCode());

                groups.put(groupCounter,codes);

                groupCounter++;
            }
            else{
                groups.get(groupCounter).add(testSample.getTestSampleCode());
            }

        }
    }

    /**
     * look up the group in the "groups" map to retrieve the assigned group of a sample
     * @param sampleCode
     * @return
     */
    private int getGroup(String sampleCode){
        // TODO: 6/14/19 nice feature would be to add what type of group it is e.g human sample: patient1, plant sample: plant1, ...
        for(Map.Entry<Integer, ArrayList<String>> entry : groups.entrySet()){
            for(String code : entry.getValue()){
                if(code.equals(sampleCode)){
                    return entry.getKey();
                }
            }
        }

        LOG.warn("No grouping can be created");
        return 0;
    }

    /**
     * Fill the list properties with the properties of the sample
     * @param samples
     */
    private void parseSampleProperties(ArrayList<String> samples) {

        //can i assume that all samples have the same properties??
        TestSample testSample = new TestSample(sessionToken, applicationServer, samples.get(0));
        testSample.fetchTestSample();

        properties.addAll(testSample.getSampleProperties().keySet());

    }

    /**
     * create as many columns as properties exits
     * @return
     */
    private String createConditionsCol(){
        String conditions = "";
        for(String elem : properties){
            conditions = conditions+"\t"+"Condition: "+elem;
        }
        return conditions;
    }

    /**
     * Method to retrieve the values of the corresponding properties
     * @param sample
     * @return
     */
    private String getAllPropertiesAsString(TestSample sample){
        StringBuilder propertyString = new StringBuilder();

        for(String prop : properties){
            propertyString.append("\t"+sample.getSampleProperties().get(prop));
        }

        return propertyString.toString();
    }

    /**
     * Method to create the meta data sheet by calling
     * @throws IOException
     */
    public void createMetaDataSheet() throws IOException {

        FileWriter csvWriter = new FileWriter(System.getProperty("user.dir") + File.separator +"metadataSheet.csv");
        LOG.info("Metadata sheet gets created");
        //System.console().printf("Metadata sheet gets created please wait");
        ArrayList<String> samples = fetchSamplePreparationCodes();
        calculateGrouping(samples);
        parseSampleProperties(samples);

        //print header
        csvWriter.append("QBiC_Barcode");
        csvWriter.append("\t");
        csvWriter.append("Secondary_Name");
        csvWriter.append("\t");
        csvWriter.append("Sample_Name");
        csvWriter.append("\t");
        csvWriter.append("Sample_Grouping");
        csvWriter.append("\t");
        csvWriter.append("Sample_Source");
        csvWriter.append("\t");
        csvWriter.append("Sample_Tissue");
        csvWriter.append("\t");
        csvWriter.append("Analyte");
        csvWriter.append("\t");
        csvWriter.append("RIN/DIN");
        csvWriter.append("\t");
        csvWriter.append("Filename");
        csvWriter.append(createConditionsCol());
        csvWriter.append("\n");


        for(String code : samples){
            TestSample sample = new TestSample(sessionToken,applicationServer,code);
            sample.fetchTestSample();

            //each code is an entry in the final table
            csvWriter.append(code+"\t");
            csvWriter.append(sample.getSecondaryName()+"\t");
            csvWriter.append(sample.getSampleName()+"\t");
            csvWriter.append(getGroup(code)+"\t");
            csvWriter.append(sample.getSource()+"\t");
            csvWriter.append(sample.getTissue()+"\t");
            csvWriter.append(sample.getAnalyte()+"\t");
            csvWriter.append(sample.getRIN()+"\t");
            csvWriter.append(sample.getFileName()+"\t");
            csvWriter.append(getAllPropertiesAsString(sample));
            csvWriter.append("\n");

        }

        csvWriter.flush();
        csvWriter.close();

    }



}
