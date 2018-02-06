package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FactRepository {

    private List<Fact> facts = new ArrayList<>();

    public void addFact(Fact fact) {
        facts.add(fact);
    }

    public List<Fact> getFactList() {
        return facts;
    }

    public Iterator<Fact> getIterator() {

        return null;
    }
}
