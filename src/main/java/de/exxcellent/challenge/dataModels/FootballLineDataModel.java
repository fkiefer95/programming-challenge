package de.exxcellent.challenge.dataModels;

public class FootballLineDataModel {

    private String teamName;
    private int[] values;

    public FootballLineDataModel(int values[], String teamName){
        this.values = values;
        this.teamName = teamName;
    }

    public String getTeamName() {
        return teamName;
    }

    public int[] getValues() {
        return values;
    }

}
