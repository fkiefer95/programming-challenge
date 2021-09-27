package de.exxcellent.challenge.io;

import java.util.stream.Stream;

public interface DataProvider{

    public Stream<String> getInputData() throws Exception;
}
