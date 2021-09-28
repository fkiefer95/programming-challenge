package de.exxcellent.challenge;

import de.exxcellent.challenge.applicationLogic.interactors.WeatherTableInteractor;
import de.exxcellent.challenge.applicationLogic.mathUtils.WeatherValueCondition;
import de.exxcellent.challenge.dataModels.TableDataModel;
import de.exxcellent.challenge.dataModels.WeatherLineDataModel;
import de.exxcellent.challenge.io.CsvResourceTableDataProvider;
import de.exxcellent.challenge.io.TableDataProvider;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

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
        try {
            assertEquals("1", weatherValueConditionTestCandidate.computeResult(tableModel), "Result incorrect");
        } catch (Exception x){
            x.printStackTrace();
            fail("Exception thrown in WeatherValueCondition");
        }
    }

    @Test
    void testCsvResourceTableDataProvider(){
        CsvResourceTableDataProvider dataProvider = new CsvResourceTableDataProvider("de/exxcellent/challenge/test_row_length.csv");
        try {
            Stream<String> stream = dataProvider.getInputData();
            List listOfStrings = stream.collect(Collectors.toList());
            assertEquals(listOfStrings.get(0), "1.0,2.0,3.0,4.0,5.0", "Wrong line read from file");
            assertEquals(listOfStrings.get(1), "6.0,7.0,8.0,9.0", "Wrong line read from file");
        } catch (Exception x){
            x.printStackTrace();
            fail("Exception caught during data loading");
        }
    }

    @Test
    void testWeatherTableInteractor(){
        boolean exception_thrown = false;
        WeatherTableInteractor weatherTableInteractor = new WeatherTableInteractor();
        ArrayList<String> testInput = new ArrayList<>();
        testInput.add("1.0,3.0,3.5,4.0,5.0");
        testInput.add("6.0,8.0,7.0,9.0,10.0");
        TableDataProvider testProvider = new TableDataProvider() {
            @Override
            public Stream<String> getInputData() throws Exception {
                return testInput.stream();
            }
        };
        try{
           assertEquals(weatherTableInteractor.processDataStructure(testProvider),"1", "Wrong answer returned") ;
        } catch(Exception x){
            x.printStackTrace();
            fail("Exception caught in Interactor");
        }



    }
}