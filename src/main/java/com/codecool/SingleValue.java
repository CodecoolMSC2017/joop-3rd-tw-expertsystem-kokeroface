package com.codecool;

class SingleValue extends Value {

    private String string;
    private boolean selectionType;

    SingleValue(String string, boolean selectionType) {
        this.string = string;
        this.selectionType = selectionType;
    }
}
