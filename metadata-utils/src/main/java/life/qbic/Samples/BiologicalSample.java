package life.qbic.Samples;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;

import ch.ethz.sis.openbis.generic.asapi.v3.dto.common.search.SearchResult;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.fetchoptions.SampleFetchOptions;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.search.SampleSearchCriteria;

import ch.ethz.sis.openbis.generic.asapi.v3.dto.vocabulary.VocabularyTerm;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.vocabulary.fetchoptions.VocabularyTermFetchOptions;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.vocabulary.search.VocabularyTermSearchCriteria;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Map;

public class BiologicalSample {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String sampleCode;//sampleCode is the code of a Q_TEST_SAMPLE
    private Map<String,String> properties;

    private final static Logger LOG = LogManager.getLogger(BiologicalSample.class);


    public BiologicalSample(String sessionToken, IApplicationServerApi applicationServer, String sampleCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.sampleCode = sampleCode;

        fetchBiologicalSample();

    }

    private void fetchBiologicalSample(){
        //search for the sample code
        SampleSearchCriteria criteria = new SampleSearchCriteria();
        criteria.withCode().thatEquals(sampleCode);

        // tell the API to fetch all descendants for each returned sample
        SampleFetchOptions fetchOptions = new SampleFetchOptions();
        fetchOptions.withParentsUsing(fetchOptions);
        fetchOptions.withProperties();
        fetchOptions.withType();

        SearchResult<Sample> result = applicationServer.searchSamples(sessionToken, criteria, fetchOptions);

        //check the parents to retrieve Biological_Samples
        for(Sample sample : result.getObjects()){
            for(Sample parent : sample.getParents()){
                if(parent.getType().getCode().equals("Q_BIOLOGICAL_SAMPLE")){
                    //a sample cannot have multiple parents
                    properties = parent.getProperties();
                }
            }

        }

    }


    // TODO: 6/7/19 add functions to represent the biolog. sample type from openBIS (retrieve needed properties)
    public String getTissue(){
        //Primary tissue/body fluid
        if(properties.containsKey("Q_PRIMARY_TISSUE"))  return mapToLabel(properties.get("Q_PRIMARY_TISSUE"));

        LOG.warn("No tissue is available for the given sample code "+sampleCode);

        return null;
    }

    /**
     * Function to
     * @param id
     * @return
     */
    private String mapToLabel(String id){
        VocabularyTermSearchCriteria criteria = new VocabularyTermSearchCriteria();
        criteria.withCode().thatEquals(id);

        VocabularyTermFetchOptions vocabularyFetchOptions = new VocabularyTermFetchOptions();
        vocabularyFetchOptions.withVocabulary();

        SearchResult<VocabularyTerm> result = applicationServer.searchVocabularyTerms(sessionToken, criteria, vocabularyFetchOptions);

        for(VocabularyTerm vocabulary : result.getObjects()){
            return vocabulary.getLabel();
        }

        LOG.warn("Source Organism cannot be found, the taxonomy ID is returned");
        return id;
    }
}
