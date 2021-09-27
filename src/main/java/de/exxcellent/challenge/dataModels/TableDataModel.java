package de.exxcellent.challenge.dataModels;

/**
 * This model represents a Table as a collection of rows
 * @param <LineType> The Type of the table's lines
 */
public class TableDataModel<LineType> {
    private LineType lines[];

    /**
     * Constructor
     * @param lines A Collection of table-lines
     */
    public TableDataModel(LineType lines[]) {
        this.lines = lines;
    }

    /**
     * @return The lines of the represented table
     */
    public LineType[] getLines(){
        return this.lines;
    }

}
