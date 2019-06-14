package life.qbic.Samples;

import ch.ethz.sis.openbis.generic.asapi.v3.IApplicationServerApi;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.common.search.SearchResult;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.Sample;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.fetchoptions.SampleFetchOptions;
import ch.ethz.sis.openbis.generic.asapi.v3.dto.sample.search.SampleSearchCriteria;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.Map;

/**
 * This class represents the TestSample (Q_TEST_SAMPLE), thus a row of the output table.
 * It saves all relevant meta data for a TestSample
 */
public class TestSample {

    //actually a Sample type on the level of the Experiment type Sample_Preparation
    private String sessionToken;
    private IApplicationServerApi applicationServer;
    private String sampleCode;
    private Map<String,String> properties;

    private final static Logger LOG = LogManager.getLogger(TestSample.class);


    public TestSample(String sessionToken, IApplicationServerApi applicationServer, String sampleCode){

        this.sessionToken = sessionToken;
        this.applicationServer = applicationServer;
        this.sampleCode = sampleCode;

    }

    public void fetchTestSample(){
        SampleSearchCriteria criteria = new SampleSearchCriteria();
        criteria.withCode().thatEquals(sampleCode);

        // tell the API to fetch all descendants for each returned sample
        SampleFetchOptions fetchOptions = new SampleFetchOptions();
        fetchOptions.withProperties();

        SearchResult<Sample> result = applicationServer.searchSamples(sessionToken, criteria, fetchOptions);


        for(Sample sample : result.getObjects()){
            properties = sample.getProperties();
        }


    }

    /**
     * Return properties of the Sample as a map with key,value (e.g. health_state, healthy)
     * @return
     */
    public HashMap<String,String> getSampleProperties(){
        //Properties are encoded by XML and first need to be parsed
        //also one sample can store multiple properties
        if(properties.containsKey("Q_PROPERTIES")){

             return parseProperties(properties.get("Q_PROPERTIES"));
        }

        LOG.warn("No Sample name is available for the given sample code");
        return null;
    }

    /**
     * Get the Secondary name for this sample (ExternalDB identifier)
     * @return
     */
    public String getSecondaryName(){
        //Secondary Name is saved as External DB identifier
        if(properties.containsKey("Q_EXTERNALDB_ID")) return properties.get("Q_EXTERNALDB_ID");

        LOG.warn("No Secondary name is available for the given sample code");
        return null;
    }

    /**
     * An analyte is descirbed by e.g. RNA (no QBiC specific code type for a Sample)
     * @return
     */
    public String getAnalyte(){
        //Analyte is saved as Sample type
        if(properties.containsKey("Q_SAMPLE_TYPE")) return properties.get("Q_SAMPLE_TYPE");

        LOG.warn("No Analyte is available for the given sample code");
        return null;
    }


    /**
     *
     * @return
     */
    public String getSampleName(){
        //The sample name is saved as Secondary name
        if(properties.containsKey("Q_SECONDARY_NAME")) return properties.get("Q_SECONDARY_NAME");

        LOG.warn("No Sample name is available for the given sample code");
        return null;
    }


    /**
     *
     * @return
     */
    public String getRIN(){
        //RIN is saved as RNA Integrity Number
        if(properties.containsKey("Q_RNA_INTEGRITY_NUMBER")) return properties.get("Q_RNA_INTEGRITY_NUMBER");

        LOG.warn("No RIN is available for the given sample code");
        return null;

    }

    // TODO: 6/12/19 these are the methods depending on deeper or higher structures (hierarchically spoken) thus create the corresponding objects
    //  in the respective functions and implement the major functionality (actually fetching the e.g tissue type through the objects function?

    /**
     * This property is stored in a sample of type Biological Sample
     * @return
     */
    public String getTissue(){
        //Primary tissue/body fluid
        BiologicalSample biologSample = new BiologicalSample(sessionToken, applicationServer, sampleCode);

        return biologSample.getTissue();
    }


    /**
     * The information about the source of the sample is saved in an Biological Entity
     * @return
     */
    public String getSource(){
        //NCBI organism
        BiologicalEntity biologEntity = new BiologicalEntity(sessionToken, applicationServer, sampleCode);

        return biologEntity.getSource();
    }

    /**
     * Q_NGS_SINGLE_RUN_SAMPLE
     * @return
     */
    public String getFileName(){

        return "";
    }

    /**
     * This method returns the grouping of the samples
     * @return
     */
    public String getGrouping(){

        return null;
    }


    public String getTestSampleCode() {
        return sampleCode;
    }

    /**
     * Parser for the properties that are encoded in XML
     * @param xmlCode
     * @return
     */
    private HashMap<String,String> parseProperties(String xmlCode){

        HashMap<String,String> props = new HashMap<String, String>();
        //System.out.println(xmlCode);

        org.jdom.input.SAXBuilder saxBuilder = new SAXBuilder();
        try {
            org.jdom.Document doc = saxBuilder.build(new StringReader(xmlCode));

            //a Sample property can contains qfactors
            Element qfactors = doc.getRootElement().getChild("qfactors");

            // TODO: 6/12/19 handle multiple children of qfactors!!!!!
            //with multiple qcategorical children
            Element qcategorical = qfactors.getChild("qcategorical");

            if(qcategorical != null){
                String label = qcategorical.getAttribute("label").getValue();
                String value = qcategorical.getAttribute("value").getValue();

                props.put(label,value);
            }

            //and or with multiple qcontinous children
            Element qcontinous = qfactors.getChild("qcontinous");

            if (qcontinous != null){
                String label = qcontinous.getAttribute("label").getValue();
                String value = qcontinous.getAttribute("value").getValue();
                String unit = qcontinous.getAttribute("unit").getValue();

                props.put(label,value+" "+unit);

            }


        } catch (JDOMException e) {
            // handle JDOMException
        } catch (IOException e) {
            // handle IOException
        }

        return props;
    }


}
