package de.exxcellent.challenge.applicationLogic.mathUtils;

import de.exxcellent.challenge.dataModels.TableDataModel;

public interface ValueCondition<LineType> {
    public String computeResult(TableDataModel<LineType> data);
}
