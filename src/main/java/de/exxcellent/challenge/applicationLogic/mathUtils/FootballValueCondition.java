package de.exxcellent.challenge.applicationLogic.mathUtils;

import de.exxcellent.challenge.dataModels.FootballLineDataModel;
import de.exxcellent.challenge.dataModels.TableDataModel;

/**
 * Class FootballValueCondition:
 * Provides method to find the smallest goal difference in a table of {@link FootballLineDataModel}s
 */
public class FootballValueCondition implements ValueCondition<FootballLineDataModel> {
    //column indices
    private final int INDEX_GOALS_SCORED =5;
    private final int INDEX_GOALS_ALLOWED =6;

    /**
     * find the smallest goal difference in a table of {@link FootballLineDataModel} and return the "Team" column of said entry
     * @param data The Table of football data to operate on
     * @return "Team" column of {@link FootballLineDataModel} in Table with the lowest goal difference
     */
    @Override
    public String computeResult(TableDataModel<FootballLineDataModel> data) throws Exception {
        double minGoalDifference = 0;
        int minGoalDifferenceIndex = 0;
        int previousLineLength = 0;

        //iterate through the table line by line
        for(int index = 0; index < data.getLines().length; index++){

            //get current line
            int values[] = data.getLines()[index].getValues(); //get values
            //check whether all lines are the same length
            if(index !=0 && values.length != previousLineLength){
                throw new Exception("Line length Mismatch");
            }
            previousLineLength = values.length;
            //compute absolute goal difference
            double goalDifference = Math.abs(values[INDEX_GOALS_ALLOWED]-values[INDEX_GOALS_SCORED]);
            //check for new minumum
            if( goalDifference < minGoalDifference || index == 0){ //for first line or new minimum
                minGoalDifference = goalDifference;
                minGoalDifferenceIndex = index; //save row number
            }
        }
        //return name of the team with the minimum goal difference
        return data.getLines()[minGoalDifferenceIndex].getTeamName();
    }
}
