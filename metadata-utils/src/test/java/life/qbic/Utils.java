package life.qbic;

import ch.ethz.sis.openbis.generic.asapi.v3.dto.common.search.SearchResult;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.vocabulary.VocabularyTerm;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.vocabulary.fetchoptions.VocabularyTermFetchOptions;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.vocabulary.search.VocabularyTermSearchCriteria;

public class Utils {

   /* public static String mapIDToOrganism(String id){
        VocabularyTermSearchCriteria criteria = new VocabularyTermSearchCriteria();
        criteria.withCode().thatEquals(id);

        VocabularyTermFetchOptions vocabularyFetchOptions = new VocabularyTermFetchOptions();
        vocabularyFetchOptions.withVocabulary();

        SearchResult<VocabularyTerm> result = applicationServer.searchVocabularyTerms(sessionToken, criteria, vocabularyFetchOptions);

        for(VocabularyTerm vocabulary : result.getObjects()){
            return vocabulary.getLabel();
        }

        return id;
    }*/
}
