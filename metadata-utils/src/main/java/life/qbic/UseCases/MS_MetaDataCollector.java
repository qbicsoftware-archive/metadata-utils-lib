package life.qbic.UseCases;

import life.qbic.openbis.openbisclient.OpenBisClient;

public class MS_MetaDataCollector extends MetaDataCollector {

    public MS_MetaDataCollector(String projectCode, OpenBisClient client) {
        super(projectCode, client);
    }

    @Override
    public String getDataType() {
        return "Q_MS_MEASUREMENT";
    }
}
