package com.codecool;

import java.util.List;
import java.util.ArrayList;

public class Answer {

    List<Value> values = new ArrayList<>();

    public boolean evaluateAnswerByInput(String input) throws Exception {

        input = input.toLowerCase();
        if (input.equals("yes") ) {
            return true;
        } else if (input.equals("no")) {
            return false;
        }
        throw new Exception("Wrong input");
    }

    public void addValue(Value value) {
        values.add(value);
    }
}
