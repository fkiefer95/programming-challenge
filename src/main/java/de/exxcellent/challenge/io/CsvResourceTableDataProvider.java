package de.exxcellent.challenge.io;

import de.exxcellent.challenge.App;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.stream.Stream;

public class CsvResourceTableDataProvider implements TableDataProvider {

    private String resourceID = "";

    /**
     * Constructs an object of Class CsvResourceDataProvider
     * @param resourceID the Path to the file in the "resources" folder containing the desired data
     */
    public CsvResourceTableDataProvider(String resourceID){
        this.resourceID = resourceID;
    }

    /**
     * Method getInputData: Accepts a string identifying a file in the "Resources" Folder, tries to open said file and provide a stream of it's contents
     * @return A stream of lines read from the resource-file
     * @throws Exception if Input file can't be read.
     */
    @Override
    public Stream<String> getInputData() throws Exception {
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(this.resourceID); //open desired file as input stream
        if(inputStream.available() == 0){ //check whether file is readable and not empty
            throw new Exception("Cannot read input file");
        }
        return new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset())).lines(); // read file line by line and return a stream of read lines

    }
}
