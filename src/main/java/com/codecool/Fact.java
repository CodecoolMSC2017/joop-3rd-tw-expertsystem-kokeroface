package com.codecool;

import java.util.Set;

public class Fact {

    protected String id, description;

    public Fact(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Set<String> getIdSet() {

        return null;
    }

    public void setFactValueById(String id, boolean value) {

    }

    public boolean getValueById(String id) {

        return true;
    }

    public String getDescription() {
        return description;
    }
}
