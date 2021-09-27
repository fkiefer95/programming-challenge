package de.exxcellent.challenge.applicationLogic.interactors;

import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.io.TableDataProvider;
import de.exxcellent.challenge.parsers.Parser;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Class BaseTableInteractor This class Provides The base for Interactor classes which implement the following process:
 * - Read & Parse Data from a Data source
 * - Find Object in said Data which matches the given condition
 * - Return some information on said object
 * @param <LineType> The type of data-object the Interactor is supposed to work with
 */
public abstract class BaseTableInteractor<LineType> {

    /**
     * Method processDataStructure: Implementations of this method will load data from a source and examine it in order
     * to find the data-object which best fits a certain condition
     * @param tableDataProvider A component which provides a {@link Stream} of {@link String}s representing the input data to
     *                     be parsed and processed
     * @return A String identifying the data-object from the input data which best fits the given condition
     * @throws Exception if there is an error processing the data structure, e.g. invalid data
     */
    public abstract String processDataStructure(TableDataProvider tableDataProvider) throws Exception;

    /**
     * This method takes a stream of Data (as {@link String}). For every object in the stream, the conversion to the
     * desired data-type ("LineType") is delegated to a separate {@link Parser} instance
     * @param dataSource A component emitting a stream of strings. Each object in the stream corresponds to one desired
     *                   data object
     * @param target The desired data structure to collect and return the parsed data
     * @param parser An instance of a {@link Parser}-implementation used to parse data from string
     * @return The Data parsed from the source as Table
     * @throws Exception if parsing goes wrong
     */
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
