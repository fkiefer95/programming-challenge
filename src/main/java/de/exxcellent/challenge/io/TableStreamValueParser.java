package de.exxcellent.challenge.io;

import de.exxcellent.challenge.dataModels.LineOfDoublesDataModel;
import de.exxcellent.challenge.dataModels.TableOfDoublesDataModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TableStreamValueParser implements ValueParser<TableOfDoublesDataModel, Stream<String>>{
    private final String stringDelimiter = ",";

    @Override
    public TableOfDoublesDataModel parseData(Stream<String> dataSource) throws Exception {
        //check if input file exists and is readable
        /**if(!dataSource.exists() || !dataSource.canRead()){
            throw new Exception("Could not Read input File: File does not exist or is not readable");
        }
        BufferedReader reader = new BufferedReader(new FileReader(dataSource));

        Stream<String> lineStream = reader.lines(); //read file line by line **/
        List<LineOfDoublesDataModel> result = dataSource.skip(1)
                .map(st -> {
                    try {
                        ;
                        return parseLine(st);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return null;
                    }
                }) // call function parseLine() for each line from the csv-file...
                .collect(Collectors.toList());//...and collect the resulting line models in a list

        return new TableOfDoublesDataModel(result.toArray(LineOfDoublesDataModel[]::new)); //collect all parsed lines in a table-model and return it
    }

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
