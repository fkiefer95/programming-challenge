package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.dataModels.WeatherLineDataModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WeatherLineParser implements Parser<WeatherLineDataModel>{
    @Override
    public WeatherLineDataModel parse(String data) {
        //create tokenizer for delimiter specified above
        String columns[] = data.split(stringDelimiter);
        int numberOfColumns = columns.length;
        List<Double> values = Arrays.stream(columns)
                .map(st -> Double.parseDouble(st))
                .collect(Collectors.toList());
        return new WeatherLineDataModel(values.stream().mapToDouble(d -> d).toArray());
    }
}
