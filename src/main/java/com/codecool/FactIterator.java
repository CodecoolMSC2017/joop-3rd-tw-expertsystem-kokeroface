package com.codecool;

import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator {

    private int i;
    private List<Fact> list;

    public FactIterator(List<Fact> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (i + 1 < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Fact next() {
        Fact fact = list.get(i);
        i++;
        return fact;
    }
}
