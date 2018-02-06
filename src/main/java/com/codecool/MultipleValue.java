package com.codecool;

import java.util.List;

public class MultipleValue extends Value {

    List<String> params;
    boolean selectionType;

    public MultipleValue(List<String> params, boolean selectionType) {
        this.params = params;
        this.selectionType = selectionType;

    }
}
