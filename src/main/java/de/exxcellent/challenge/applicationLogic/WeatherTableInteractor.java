package de.exxcellent.challenge.applicationLogic;

import de.exxcellent.challenge.applicationLogic.mathUtils.WeatherValueCondition;
import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.dataModels.WeatherLineDataModel;
import de.exxcellent.challenge.io.CsvResourceDataProvider;
import de.exxcellent.challenge.io.DataProvider;
import de.exxcellent.challenge.parsers.WeatherLineParser;

public class WeatherTableInteractor extends BaseTableInteractor<WeatherLineDataModel>{
    @Override
    public String processDataStructure(DataProvider dataProvider) throws Exception{
        //CsvResourceDataProvider dataProvider = new CsvResourceDataProvider();
        WeatherLineDataModel lineType[] = new WeatherLineDataModel[1];
        TableDataModel data = parseData(dataProvider.getInputData(), lineType , new WeatherLineParser());

        return new WeatherValueCondition().computeResult(data);
    }
}
