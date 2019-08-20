package life.qbic.Entities;

import life.qbic.datamodel.*;
import life.qbic.datamodel.experiments.TestExperiment;
import life.qbic.datamodel.projects.ProjectInfo;
import life.qbic.datamodel.samples.TSVSampleBean;

import java.util.ArrayList;

public class QbicProject {

    private ProjectInfo project;
    private TestExperiment testExperiment; //for factors on experiment level
   // private ArrayList<TSVSampleBean> preparationSamples; --> implicitly contained within test experiment??


}
