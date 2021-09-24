package de.exxcellent.challenge.io;

public interface ValueParser<StructureLineType, DataSourceType> {

    DataProvider dataProvider = null;
    public StructureLineType parseData(DataSourceType dataSource) throws Exception;

}
