package de.exxcellent.challenge.applicationLogic.interactors;

import de.exxcellent.challenge.applicationLogic.mathUtils.FootballValueCondition;
import de.exxcellent.challenge.dataModels.FootballLineDataModel;
import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.io.TableDataProvider;
import de.exxcellent.challenge.parsers.FootballLineParser;

public class FootballTableInteractor extends BaseTableInteractor<FootballLineDataModel> {

    /**
     * @param tableDataProvider A component which provides a {@link Stream} of {@link String}s representing the input data to
     *                     be parsed and processed
     * @return a string which solves the "weather-task"
     * @throws Exception If something goes wrong in reading,parsing or processing of the input data
     */
    @Override
    public String processDataStructure(TableDataProvider tableDataProvider) throws Exception{
        //fetch input data from provider and parse it into the desired data-structure
        TableDataModel<FootballLineDataModel> data = parseData(tableDataProvider.getInputData(), new FootballLineDataModel[1] , new FootballLineParser());
        /**Let an instance of WeatherValueCondition find the desired object of data and return some information
         identifying said object**/
        return new FootballValueCondition().computeResult(data);
    }
}
