package de.exxcellent.challenge.applicationLogic;

import de.exxcellent.challenge.applicationLogic.mathUtils.ValueComparator;

public interface DataStructureProcessor<StructureLineType, ResultType> {
    ValueComparator comparator = null;

    ResultType processDataStructure(StructureLineType data) throws Exception;

}
