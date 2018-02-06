package com.codecool;

import java.util.Iterator;
import java.util.List;

public class FactIterator implements Iterator {

    private int i;
    private List<Fact> list;

    FactIterator(List<Fact> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        return i < list.size();
    }

    @Override
    public Fact next() {
        Fact fact = list.get(i);
        i++;
        return fact;
    }
}
