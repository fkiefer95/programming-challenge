package de.exxcellent.challenge.applicationLogic;

import de.exxcellent.challenge.applicationLogic.mathUtils.ValueComparator;

/**
 * Interface DataStructureInteractor: A class which proccesses a given data structure in order to compute a certain result
 * @param <DataStructureType> The Type of Data-structure the interactor is supposed to operate on
 * @param <ResultType> The type of the result which the interactor is expected to produce
 */
public interface DataStructureInteractor<DataStructureType, ResultType> {
    ValueComparator comparator = null;

    ResultType processDataStructure(DataStructureType data) throws Exception;

}
