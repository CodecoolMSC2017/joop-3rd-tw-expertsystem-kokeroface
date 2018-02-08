package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class AnswerTest {

    private Answer answer1;

    @BeforeEach
    void setUp() {
        answer1 = new Answer();
        answer1.addValue(new SingleValue("dunno", false));
        answer1.addValue(new SingleValue("yes", true));

    }

    @Test
    void evaluateAnswerByInput() throws Exception {
        assertEquals(false, answer1.evaluateAnswerByInput("dunno"));
        assertEquals(true, answer1.evaluateAnswerByInput("yes"));

    }

    @Test
    void addValue() {
        assertEquals(2, answer1.values.size());
        answer1.addValue(new SingleValue("both", true));
        assertEquals(3, answer1.values.size());
    }
}