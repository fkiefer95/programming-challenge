package de.exxcellent.challenge;

import de.exxcellent.challenge.applicationLogic.mathUtils.WeatherValueCondition;
import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.dataModels.WeatherLineDataModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Example JUnit 5 test case.
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
class AppTest {

    private String successLabel = "not successful";

    @BeforeEach
    void setUp() {
        successLabel = "successful";
    }

    @Test
    void aPointlessTest() {
        assertEquals("successful", successLabel, "My expectations were not met");
    }

    /**@Test
    void runFootball() {
        App.main("--football", "football.csv");
    }**/

    @Test
    void testWeatherValueCondition(){
        double[] data = {1,2,3};
        WeatherLineDataModel[] lineModel = {new WeatherLineDataModel(data)};
        TableDataModel<WeatherLineDataModel> tableModel = new TableDataModel<>(lineModel);
        WeatherValueCondition weatherValueConditionTestCandidate = new WeatherValueCondition();
        assertEquals("1",weatherValueConditionTestCandidate.computeResult(tableModel),"Result incorrect");
    }
}