package com.codecool;

import java.util.List;
import java.util.ArrayList;

public class Answer {

    private List<Value> values = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) throws Exception {
        if (values.get(0) instanceof SingleValue) {
            if (input.equals(values.get(0).param.get(0).toString())) {
                return values.get(0).selectionType;
            } else if (input.equals(values.get(1).param.get(0).toString())) {
                return values.get(1).selectionType;
            }
            throw new Exception("Please enter either " + values.get(0).param.get(0) + " or " + values.get(1).param.get(0));

        } else {
            String possibleAnswer = "";
            for (int j = 0; j < values.get(0).param.size(); j++) {
                possibleAnswer += values.get(0).param.get(j)+"\n";
                possibleAnswer += values.get(1).param.get(j)+"\n";
            }
            for (int j = 0; j < values.get(0).param.size(); j++) {
                if (input.equals(values.get(0).param.get(j).toString())) {
                    return values.get(0).selectionType;
                } else if (input.equals(values.get(1).param.get(j).toString())) {
                    return values.get(1).selectionType;
                }
            }
            throw new Exception("Please enter one of the following:\n"+possibleAnswer);
        }
    }

    public void addValue(Value value) {
        values.add(value);
    }

    public List<Value> getValues() {
        return values;
    }
}
