package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.dataModels.WeatherLineDataModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link Parser} which parses strings into {@link WeatherLineDataModel}s
 */
public class WeatherLineParser implements Parser<WeatherLineDataModel>{
    /**
     * This method parses strings into {@link WeatherLineDataModel}s
     * @param data the data to parse
     * @return a {@link WeatherLineDataModel} containing the data from the string
     * @throws Exception if parsing was unsuccessful
     */
    @Override
    public WeatherLineDataModel parse(String data) throws Exception {
        //split columns at delimiter specified above
        String columns[] = data.split(stringDelimiter);
        List<Double> values = Arrays.stream(columns)
                .map(st -> Double.parseDouble(st))
                .collect(Collectors.toList()); //collect values from columns in list
        return new WeatherLineDataModel(values.stream().mapToDouble(d -> d).toArray());
    }
}
