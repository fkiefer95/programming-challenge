package de.exxcellent.challenge.applicationLogic;

import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.io.CsvResourceDataProvider;
import de.exxcellent.challenge.parsers.Parser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class TableInteractor: Implementation of {@link DataStructureInteractor} which operates on a {@link TableDataModel}
 * in order to produce a String as a result
 */
public abstract class BaseTableInteractor<LineType> {

    public abstract String processDataStructure(String resourcePath) throws Exception;

    protected TableDataModel parseData(Stream<String> dataSource, LineType target[], Parser<LineType> parser) throws Exception {

        List<LineType> result = dataSource.skip(1) //skip first line which contains the labels
                .map(st -> {//for every line in the stream:
                    try {
                        return parser.parse(st); //Parse the values into the desired format
                    } catch (Exception e) { //print stacktrace if parsing goes wrong
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toList());// collect the resulting line models in a list

        return new TableDataModel<LineType>(result.toArray(target)); //collect all parsed lines in a table-model and return it
    }
}
