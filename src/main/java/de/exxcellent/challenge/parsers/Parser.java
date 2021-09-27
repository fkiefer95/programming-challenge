package de.exxcellent.challenge.parsers;

public interface Parser<TargetType> {
    final String stringDelimiter = ",";

    public TargetType parse(String data);
}
