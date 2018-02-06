package com.codecool;

import java.util.HashMap;
import java.util.Set;

public class Fact {

    String id, description;
    private HashMap<String, Boolean> values = new HashMap<>();

    Fact(String id, String description) {
        this.id = id;
        this.description = description;
    }

    public Set<String> getIdSet() {
        return values.keySet();
    }

    public void setFactValueById(String id, boolean value) {
        values.put(id, value);
    }

    public boolean getValueById(String id) {
        return values.get(id);
    }

    public String getDescription() {
        return description;
    }
}
