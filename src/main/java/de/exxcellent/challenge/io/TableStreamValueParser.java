package de.exxcellent.challenge.io;

import de.exxcellent.challenge.dataModels.LineOfDoublesDataModel;
import de.exxcellent.challenge.dataModels.TableOfDoublesDataModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class TableStreamValueParser implements ValueParser<TableOfDoublesDataModel, Stream<String>>{
    private final String stringDelimiter = ",";

    /**
     * Method parseData()
     * @param dataSource The data to be parsed into a table of doubles as a stream
     * @return A Table of doubles containing the values of the data source
     * @throws Exception if parsing goes wrong
     */
    @Override
    public TableOfDoublesDataModel parseData(Stream<String> dataSource) throws Exception {

         List<LineOfDoublesDataModel> result = dataSource.skip(1) //skip first line which contains the labels
                .map(st -> {//for every line in the stream:
                    try {
                        return parseLine(st); //Parse the values into the desired format
                    } catch (Exception e) { //print stacktrace if parsing goes wrong
                        e.printStackTrace();
                        return null;
                    }
                })
                .collect(Collectors.toList());// collect the resulting line models in a list

        return new TableOfDoublesDataModel(result.toArray(LineOfDoublesDataModel[]::new)); //collect all parsed lines in a table-model and return it
    }

    /**
     * Method parseLine takes a string (1 line) from the imput data and tries to parse a series of Double values which are then stored in the desired data structure
     * @param line one line from the input data
     * @return The parsed double values wrapped in an Object of LineOfDoublesDataModel
     * @throws Exception if parsing goes wrong
     */
    private LineOfDoublesDataModel parseLine(String line) throws Exception{
        //create tokenizer for delimiter specified above
        String columns[] = line.split(stringDelimiter);
        int numberOfColumns = columns.length;
        List<Double> values = Arrays.stream(columns)
                .map(st -> Double.parseDouble(st))
                .collect(Collectors.toList());
        return new LineOfDoublesDataModel(values.stream().mapToDouble(d -> d).toArray());

    }
}
