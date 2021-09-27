package de.exxcellent.challenge.applicationLogic;

import de.exxcellent.challenge.applicationLogic.mathUtils.ValueComparator;

public interface DataStructureProcessor<DataStructureType, ResultType> {
    ValueComparator comparator = null;

    ResultType processDataStructure(DataStructureType data) throws Exception;

}
