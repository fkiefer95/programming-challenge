package de.exxcellent.challenge;

import de.exxcellent.challenge.applicationLogic.interactors.FootballTableInteractor;
import de.exxcellent.challenge.applicationLogic.interactors.WeatherTableInteractor;
import de.exxcellent.challenge.io.CsvResourceTableDataProvider;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 *
 * @author Benjamin Schmid <benjamin.schmid@exxcellent.de>
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     */
    public static void main(String... args) {

        String dayWithSmallestTempSpread = "Error";
        String teamWithSmallestGoalSpread = "Error";
        try {
            //weather task
            dayWithSmallestTempSpread = new WeatherTableInteractor()
                    .processDataStructure(
                            new CsvResourceTableDataProvider("de/exxcellent/challenge/weather.csv")
                    ); // My day analysis function call …

            //football task
            teamWithSmallestGoalSpread = new FootballTableInteractor()
                    .processDataStructure(
                            new CsvResourceTableDataProvider("de/exxcellent/challenge/swag.csv")
                    );// My goal analysis function call …
        } catch (Exception x){
            x.printStackTrace();
        }

        System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
        System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);


    }
}
