package de.exxcellent.challenge.dataModels;

public class WeatherLineDataModel {
    private double[] line;

    public WeatherLineDataModel(double line[]){
        this.line = line;
    }

    public double[] getLine() {
        return line;
    }

}
