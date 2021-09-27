package de.exxcellent.challenge.applicationLogic.mathUtils;

import de.exxcellent.challenge.dataModels.TableDataModel;

/**
 * Interface ValueCondition
 * @param <LineType> The type of table row on which the condition is supposed to operate
 */
public interface ValueCondition<LineType> {
    /**
     * Check which row in the given table meets the specified condition and return some information on said row
     * @param data The table which shall be examined
     * @return Some information on the row matching the implemented condition
     */
    public String computeResult(TableDataModel<LineType> data);
}
