package de.exxcellent.challenge.io;

import de.exxcellent.challenge.App;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.stream.Stream;

public class CsvResourceDataProvider implements DataProvider<String, Stream<String>> {

    public CsvResourceDataProvider(){

    }

    @Override
    public Stream<String> getInputData(String iD) throws Exception {
        InputStream inputStream = App.class.getClassLoader().getResourceAsStream(iD);
        if(inputStream.available() == 0){
            throw new Exception("Cannot read input file");
        }
        return new BufferedReader(new InputStreamReader(inputStream, Charset.defaultCharset())).lines();

    }
}
