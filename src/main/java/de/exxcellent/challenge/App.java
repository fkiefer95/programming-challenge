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
        //flags for execution of usecases
        boolean runWeather = true;
        boolean runFootball = true;
        //filename to use (if provided)
        String filename = null;
        //check commandline arguments for which usecase to run
        if(args.length > 0){
            if(args[0].equals("--weather")){
                runFootball = false;
            } else if(args[0].equals("--football")){
                runWeather = false;
            } else{
                System.out.println("Warning: Unrecognized arguments will be ignored\n");
            }
        }
        //check commandline arguments for which file to use
        if(args.length > 1){
            filename = args[1];
        }
        //initialize display strings
        String dayWithSmallestTempSpread = "Error";
        String teamWithSmallestGoalSpread = "Error";
        //run tasks
        try {
            //weather task
            if(runWeather) {
                dayWithSmallestTempSpread = executeWeatherTask(filename);
                System.out.printf("Day with smallest temperature spread : %s%n", dayWithSmallestTempSpread);
            }
            //football task
            if(runFootball) {
                teamWithSmallestGoalSpread = executeFootballTask(filename);
                System.out.printf("Team with smallest goal spread       : %s%n", teamWithSmallestGoalSpread);
            }
        } catch (Exception x){
            x.printStackTrace();
        }





    }

    /**
     * This method runs the weather usecase
     * @param filename the name of the resource-file to use, may be null
     * @return The number of the desired day
     * @throws Exception if anything goes wrong
     */
    private static String executeWeatherTask(String filename) throws Exception{
        if(filename == null) {
            return new WeatherTableInteractor()
                    .processDataStructure(
                            new CsvResourceTableDataProvider("de/exxcellent/challenge/weather.csv")
                    );// My day analysis function call …
        } else{
            return new WeatherTableInteractor()
                    .processDataStructure(
                            new CsvResourceTableDataProvider("de/exxcellent/challenge/" + filename.trim())
                    );
        }
    }

    /**
     * This method runs the football usecase
     * @param filename the name of the resource-file to use, may be null
     * @return The name of the desired team
     * @throws Exception if anything goes wrong
     */
    private static String executeFootballTask(String filename) throws Exception {
        if (filename == null) {
            return new FootballTableInteractor()
                    .processDataStructure(
                            new CsvResourceTableDataProvider("de/exxcellent/challenge/football.csv")
                    );// My day analysis function call …
        } else {
            return new FootballTableInteractor()
                    .processDataStructure(
                            new CsvResourceTableDataProvider("de/exxcellent/challenge/" + filename.trim())
                    );
        }
    }
}
