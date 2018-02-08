package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FactRepositoryTest {

    List<Fact> testList = new ArrayList<>();
    FactRepository testFactRepository = new FactRepository();
    Fact fact2;

    @BeforeEach
    void setUp() {
        Fact fact1 = new Fact("pubg", "PLAYERUNKNOWN'S BATTLEGROUNDS");
        fact1.setFactValueById("money",false);
        fact1.setFactValueById("graphics",false);
        fact1.setFactValueById("multiplayer",true);
        fact1.setFactValueById("pegi",true);
        fact1.setFactValueById("type",true);
        fact1.setFactValueById("view",true);
        fact1.setFactValueById("details",false);
        testList.add(fact1);
        testFactRepository.addFact(fact1);
    }

    @Test
    void addFact() {
        assertEquals(1,testList.size());
        testList.add(fact2);
        assertEquals(2,testList.size());

    }

    @Test
    void getIterator() {
        Fact temp = testFactRepository.getIterator().next();
        assertEquals(false,temp.getValueById("money"));
        assertEquals(false,temp.getValueById("graphics"));
        assertEquals(true,temp.getValueById("multiplayer"));
    }
}