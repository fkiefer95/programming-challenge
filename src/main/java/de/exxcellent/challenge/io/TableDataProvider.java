package de.exxcellent.challenge.io;

import java.util.stream.Stream;

/**
 * This interface is to be implemented by classes providing table data from various sources
 */
public interface TableDataProvider {
    /**
     * @return stream of strings representing lines from the table in the data source
     * @throws Exception if something goes wrong in reading the data from its source
     */
    public Stream<String> getInputData() throws Exception;
}
