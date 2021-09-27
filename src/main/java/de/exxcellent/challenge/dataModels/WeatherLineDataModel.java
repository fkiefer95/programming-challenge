package de.exxcellent.challenge.dataModels;

/**
 * This class represents a table-row containing values of type double.
 */
public class WeatherLineDataModel {
    private double[] line;

    /**
     * Constructor
     * @param line An array of double values
     */
    public WeatherLineDataModel(double line[]){
        this.line = line;
    }

    /**
     * @return The values stored in the represented table row
     */
    public double[] getLine() {
        return line;
    }

}
