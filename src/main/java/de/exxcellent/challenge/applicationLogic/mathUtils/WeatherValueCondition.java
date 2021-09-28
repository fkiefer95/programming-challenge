package de.exxcellent.challenge.applicationLogic.mathUtils;

import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.dataModels.WeatherLineDataModel;

/**
 * Class WeatherValueCondition:
 * Provides method to find the smallest temperature difference in a table of {@link WeatherLineDataModel}
 */
public class WeatherValueCondition implements ValueCondition<WeatherLineDataModel> {
    //column indices
    private final int INDEX_MIN_TEMP =2;
    private final int INDEX_MAX_TEMP =1;
    private final int INDEX_DAY_OF_MONTH = 0;

    /**
     * find the smallest temperature difference in a table of {@link WeatherLineDataModel} and return the "Day" column of said entry
     * @param data The Table of weather data to operate on
     * @return "Day" column of {@link WeatherLineDataModel} in Table with the lowest temperature spread
     */
    @Override
    public String computeResult(TableDataModel<WeatherLineDataModel> data) throws Exception {
        double minTempSpread = 0;
        int minTempSpreadIndex = 0;
        int previousLineLength = 0;

        //iterate through the table line by line
        for(int index = 0; index < data.getLines().length; index++){

            //get current line
            double line[] = data.getLines()[index].getLine(); //get values
            //check whether all lines are the same length
            if(index !=0 && line.length != previousLineLength){
                throw new Exception("Line length Mismatch");
            }
            previousLineLength = line.length;
            //compute temperature spread
            double tempSpread = line[INDEX_MAX_TEMP]-line[INDEX_MIN_TEMP]; //compute temp spread
            if(tempSpread < 0.0){//Throw Exception if tempSpread is negative because this means that values are in wrong order
                throw new Exception("Invalid Temperature data: Max Temp < Min Temp");
            }
            //check for new minumum
            if( tempSpread < minTempSpread || index == 0){ //for first line or new minimum
                minTempSpread = tempSpread;
                minTempSpreadIndex = index; //save row number
            }
        }
        //Return day of month of the line with the smallest temperature spread. Result is cast to int to remove ".0"
        return Integer.toString((int)data.getLines()[minTempSpreadIndex].getLine()[INDEX_DAY_OF_MONTH]);
    }
}
