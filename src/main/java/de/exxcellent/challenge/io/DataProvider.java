package de.exxcellent.challenge.io;

public interface DataProvider<DataResourceIdentifierType, OutputDataType> {
    public OutputDataType getInputData(DataResourceIdentifierType iD ) throws Exception;
}
