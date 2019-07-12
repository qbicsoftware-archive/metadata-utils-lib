package life.qbic.UseCases;

import life.qbic.openbis.openbisclient.OpenBisClient;

public class MicroArrayMetaDataCollector extends MetaDataCollector {
    public MicroArrayMetaDataCollector(String projectCode, OpenBisClient client) {
        super(projectCode, client);
    }

    @Override
    public String getDataType() {
        return "MICROARRAY";
    }
}
