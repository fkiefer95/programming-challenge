package de.exxcellent.challenge.applicationLogic.interactors;

import de.exxcellent.challenge.applicationLogic.mathUtils.WeatherValueCondition;
import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.dataModels.WeatherLineDataModel;
import de.exxcellent.challenge.io.TableDataProvider;
import de.exxcellent.challenge.parsers.WeatherLineParser;

/**
 * This class is an extension of {@link BaseTableInteractor} which lets an instance of {@link WeatherValueCondition}
 * operate on a {@link TableDataModel} containing lines of type {@link WeatherLineDataModel}
 */
public class WeatherTableInteractor extends BaseTableInteractor<WeatherLineDataModel>{
    /**
     *
     * @param tableDataProvider A component which provides a {@link Stream} of {@link String}s representing the input data to
     *                     be parsed and processed
     * @return a string which solves the "weather-task"
     * @throws Exception If something goes wrong in reading,parsing or processing of the input data
     */
    @Override
    public String processDataStructure(TableDataProvider tableDataProvider) throws Exception{
        //fetch input data from provider and parse it into the desired data-structure
        TableDataModel<WeatherLineDataModel> data = parseData(tableDataProvider.getInputData(), new WeatherLineDataModel[1] , new WeatherLineParser());
        /**Let an instance of WeatherValueCondition find the desired object of data and return some information
        identifying said object**/
        return new WeatherValueCondition().computeResult(data);
    }
}
