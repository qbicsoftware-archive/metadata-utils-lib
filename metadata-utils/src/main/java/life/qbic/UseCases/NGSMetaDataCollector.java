package life.qbic.UseCases;


import life.qbic.Entities.OpenBis.Samples.TestSample;
import life.qbic.Entities.MetaDataGenerator;
import life.qbic.Entities.ProjectMetaDataGenerator;
import life.qbic.openbis.openbisclient.OpenBisClient;

import java.util.ArrayList;
import java.util.HashMap;

//one use case is handeling ngs data
public class NGSMetaDataCollector extends MetaDataCollector {


    public NGSMetaDataCollector(String projectCode, OpenBisClient client) {
        super(projectCode, client);
    }

    @Override
    public String getDataType() {
        return "Q_NGS_MEASUREMENT";
    }


}
