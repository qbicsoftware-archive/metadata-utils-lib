package life.qbic.UseCases;

import life.qbic.openbis.openbisclient.OpenBisClient;

public class MSMetaDataCollector extends MetaDataCollector {

    public MSMetaDataCollector(String projectCode, OpenBisClient client) {
        super(projectCode, client);
    }

    @Override
    public String getDataType() {
        return "MS";
    }
}
