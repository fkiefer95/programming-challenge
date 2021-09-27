package de.exxcellent.challenge.dataModels;

public class TableDataModel<LineType> {
    private LineType lines[];

    public TableDataModel(LineType lines[]) {
        this.lines = lines;
    }

    public LineType[] getLines(){
        return this.lines;
    }

}
