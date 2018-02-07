package com.codecool;

import java.util.List;
import java.util.ArrayList;

public class Answer {

    @SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
    private List<Value> values = new ArrayList<>();
    private int i;
    private String possibleAnswer = "";

    public boolean evaluateAnswerByInput(String input) throws Exception {
        if (values.get(i) instanceof SingleValue) {
            if (input.equals(values.get(i).param.get(0).toString())) {
                return values.get(i).selectionType;
            } else if (input.equals(values.get(i + 1).param.get(0).toString())) {
                return values.get(i + 1).selectionType;
            }
            throw new Exception("Please enter either " + values.get(i).param.get(0) + " or " + values.get(i + 1).param.get(0));

        } else {
            for (int j = 0; j < values.get(i).param.size(); j++) {
                possibleAnswer += values.get(i).param.get(j)+"\n";
                possibleAnswer += values.get(i+1).param.get(j)+"\n";
            }

            for (int j = 0; j < values.get(i).param.size(); j++) {
                if (input.equals(values.get(i).param.get(j).toString())) {
                    System.out.println(values.get(i).selectionType);
                    return values.get(i).selectionType;
                } else if (input.equals(values.get(i+1).param.get(j).toString())) {
                    System.out.println(values.get(i+1).selectionType);
                    return values.get(i + 1).selectionType;
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
