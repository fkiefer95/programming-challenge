package de.exxcellent.challenge.parsers;

/**
 * Interface to be implemented by classes Parsing data from strings into a generic format
 * @param <TargetType> The data-structure to store the data parsed from the string into
 */
public interface Parser<TargetType> {
    final String stringDelimiter = ",";

    /**
     * This method takes a String and tries to parse data from it
     * @param data the data to parse
     * @return The parsed data+#
     * @throws Exception if parsing goes wrong
     */
    public TargetType parse(String data) throws Exception;
}
