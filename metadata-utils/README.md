# Metadata Utils

[![Build Status](https://travis-ci.com/qbicsoftware/metadata-utils.svg?branch=development)](https://travis-ci.com/qbicsoftware/metadata-utils)[![Code Coverage]( https://codecov.io/gh/qbicsoftware/metadata-utils/branch/development/graph/badge.svg)](https://codecov.io/gh/qbicsoftware/metadata-utils)

Metadata Utils, version 1.0.0-SNAPSHOT - A Java library to collect the metadata from an OpenBIS instance

## Author
Created by Jennifer Bödker (jennifer.boedker@student.uni-tuebingen.de).

## Description

This library generates a tabular output containing the metadata for a given QBiC-Project-Code. 
This library does not implement a connection to OpenBIS and thus needs a session token and an application server (from OpenBIS). 

For a given project code the 

**What are OpenBIS-Properties?** OpenBis provides the possibility to store individual information in further columns. All these values are grouped by the term **Property**.
This should not be confused with a property `Q_PROPERTY` which is itself a QBiC-**Property**. Also, each **Property** could contain different information
depending on which type of sample it is used for.

## How to Install
`git clone https://github.com/qbicsoftware/metadata-utils-lib`    
`mvn clean install`    
to create a jar with dependencies included:    
`mvn clean package`

## Development

Following steps have to be performed to retrieve the meta data:

1. **Fetch the Project**: For a given OpenBIS project code the respective project is retrieved (if it exists).

2. **Fetch the Experiment and Corresponding Samples**: From this project the associated `Q_SAMPLE_PREPARATION` experiment with all its samples is fetched. 
                                                       
3. **Parse Experiment Factors**: If the experiment has `Q_PROPERTIES` (encoded as *XML*) the have to be parsed and assigned to the respective 
                                    samples of the experiment.
 
4. **Get Sample Meta Data**: For each sample of the experiment (they are of type `Q_TEST_SAMPLE`) retrieve information about the 
                              `Q_EXTERNALDB_ID`, `Q_SAMPLE_TYPE`, `Q_SECONDARY_NAME`, `Q_RNA_INTEGRITY_NUMBER` and the `Q_PROPERTIES` 
                              (also *XML* encoded, thus need to be parsed).

5. **Get Meta Data of Child-Samples**: Furthermore, the child of a sample is a sample of type `Q_NGS_SINGLE_SAMPLE_RUN` (for NGS projects) which contains the respective files.
                                        The filenames of the runs are retrieved by the property `Q_SECONDARY_NAME` (note that this property is 
                                        different to the `Q_SECONDARY_NAME` of samples of type `Q_TEST_SAMPLES`). A `Q_TEST_SAMPLE` can have multiple files!

6. **Get Meta Data of Parent-Samples**: The parent of a `Q_TEST_SAMPLES` is a `Q_BIOLOGICAL_SAMPLE` which holds the information about `Q_PRIMARY_TISSUE`.
                                         The parent of a `Q_BIOLOGICAL_SAMPLE` is a `Q_BIOLOGICAL_ENTITY` which holds the information about the `Q_NCBI_ORGANISM`.
                                         Both return an ID that needs to be mapped to a meaningful name: 
                                         This has to be done with the retrieved organism and the tissue to retrieve the label of the `VocabularyTerm`.
                                         
7. **Grouping**: Grouping should show which samples stem from the same organism. Thus, to retrieve this information for each sample (Q_TEST_SAMPLE) the entities have to
                 be retrieved and samples with the same entity are grouped together.
                 