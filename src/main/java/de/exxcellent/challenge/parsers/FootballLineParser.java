package de.exxcellent.challenge.parsers;

import de.exxcellent.challenge.dataModels.FootballLineDataModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Implementation of {@link Parser} which parses strings into {@link de.exxcellent.challenge.dataModels.FootballLineDataModel}s
 */
public class FootballLineParser implements Parser<FootballLineDataModel> {

    private final int INDEX_TEAM_NAME = 0;

    /**
     * This method parses strings into {@link FootballLineDataModel}s
     * @param data the data to parse
     * @return a {@link FootballLineDataModel} containing the data from the string
     * @throws Exception if parsing was unsuccessful
     */
    @Override
    public FootballLineDataModel parse(String data) throws Exception {
        //split columns at delimiter specified above
        String columns[] = data.split(stringDelimiter);
        List<Integer> values = Arrays.stream(columns)
                .skip(1) //skip team name
                .map(st -> Integer.parseInt(st))
                .collect(Collectors.toList()); //collect values from columns in list
        return new FootballLineDataModel(values.stream().mapToInt(i -> i).toArray(),columns[0]);
    }

}
