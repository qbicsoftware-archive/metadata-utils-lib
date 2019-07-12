package life.qbic.Xold.Samples;

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

public class BiologicalEntity {

    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String sampleCode; //represents a Sample of type Q_TEST_SAMPLE
    private Map<String,String> properties;
    private String biologicalEntityCode;

    private final static Logger LOG = LogManager.getLogger(BiologicalEntity.class);


    public BiologicalEntity(String sessionToken, IApplicationServerApi applicationServer, String sampleCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.sampleCode = sampleCode;

        fetchBiologicalEntity();
    }

    private void fetchBiologicalEntity(){
        //search for the sample code
        SampleSearchCriteria criteria = new SampleSearchCriteria();
        criteria.withCode().thatEquals(sampleCode);

        // tell the API to fetch all descendants for each returned sample
        SampleFetchOptions fetchOptions = new SampleFetchOptions();
        fetchOptions.withParentsUsing(fetchOptions);
        fetchOptions.withProperties();
        fetchOptions.withType();

        SearchResult<Sample> result = applicationServer.searchSamples(sessionToken, criteria, fetchOptions);


        //check the parents to retrieve Biological_Entity
        for(Sample sample : result.getObjects()){
            //biological sample level
            for(Sample biologSample : sample.getParents()){
                //entity level
                for(Sample entity : biologSample.getParents()) {
                    if (entity.getType().getCode().equals("Q_BIOLOGICAL_ENTITY")) {
                        biologicalEntityCode = entity.getCode();
                        //a sample can only be connected to one Entity! /can only have one parent
                        properties = entity.getProperties();
                    }
                }
            }

        }

    }

    private String mapIDToOrganism(String id){
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

    /**
     * Look up the corresponding biolog. entity
     * @return
     */

    public String getSource(){
        //source organism (NCBI)
        if(properties.containsKey("Q_NCBI_ORGANISM"))  return mapIDToOrganism(properties.get("Q_NCBI_ORGANISM"));

        LOG.warn("No source organism is available for the given sample code");

        return null;
    }

    public String getBiologicalEntityCode(){
        return biologicalEntityCode;
    }

}
