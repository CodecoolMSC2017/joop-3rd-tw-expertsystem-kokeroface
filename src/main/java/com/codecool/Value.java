package com.codecool;

import java.util.ArrayList;
import java.util.List;

public abstract class Value {
    List<String> param;
    boolean selectionType;

    Value(List<String> list, boolean selectionType) {
        param = list;
        this.selectionType = selectionType;

    }

    Value(String param, boolean selectionType) {
        List<String> list = new ArrayList<>();
        list.add(param);
        this.param = list;
        this.selectionType = selectionType;
    }

    public List<String> getInputPattern() {
        return param;
    }

    public boolean getSelectionType() {
        return selectionType;
    }
}