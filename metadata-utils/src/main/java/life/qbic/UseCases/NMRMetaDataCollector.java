package life.qbic.UseCases;

import life.qbic.openbis.openbisclient.OpenBisClient;

public class NMRMetaDataCollector extends MetaDataCollector {

    public NMRMetaDataCollector(String projectCode, OpenBisClient client) {
        super(projectCode, client);
    }

    @Override
    public String getDataType() {
        return "Q_NMR_MEASUREMENT";
    }
}
