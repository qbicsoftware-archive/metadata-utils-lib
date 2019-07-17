package life.qbic.UseCases;


import life.qbic.openbis.openbisclient.OpenBisClient;

//one use case is handeling ngs data
public class NGSMetaDataCollector extends MetaDataCollector {


    public NGSMetaDataCollector(String projectCode, OpenBisClient client) {
        super(projectCode, client);
    }

    @Override
    public String getDataType() {
        return "NGS";
    }


}
