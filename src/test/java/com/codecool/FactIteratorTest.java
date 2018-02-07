package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class FactIteratorTest {

    private FactRepository factrepo;
    private Iterator<Fact> iterator;

    @BeforeEach
    void setUp() {
        factrepo = new FactRepository();
        iterator = factrepo.getIterator();
    }

    @Test
    void hasNext() {
        assertEquals(false,iterator.hasNext());
        factrepo.addFact(new Fact("testid","testfact1"));
        assertEquals(true,iterator.hasNext());
    }

    @Test
    void next() {
        Fact fact1 = new Fact("test1", "testFact1");
        Fact fact2 = new Fact("test2", "testFact2");
        factrepo.addFact(fact1);
        factrepo.addFact(fact2);
        assertEquals(iterator.next(), fact1);
        assertEquals(iterator.next(), fact2);
    }
}