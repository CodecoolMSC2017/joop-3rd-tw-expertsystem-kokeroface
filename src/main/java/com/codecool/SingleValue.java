package com.codecool;

public class SingleValue extends Value {

    private String string;
    private boolean selectionType;

    public SingleValue(String string, boolean selectionType) {
        this.string = string;
        this.selectionType = selectionType;
    }
}
