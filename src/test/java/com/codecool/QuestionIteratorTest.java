package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class QuestionIteratorTest {

    private Iterator<Question> iterator;
    private RuleRepository rulerepo;

    @BeforeEach
    void setUp() {
        rulerepo = new RuleRepository();
        iterator = rulerepo.getIterator();
    }

    @Test
    void hasNext() {
        assertEquals(iterator.hasNext(),false);
        rulerepo.addQuestion(new Question("test1", "testQuestion1", new Answer()));
        assertEquals(iterator.hasNext(),true);
    }

    @Test
    void next() {
        Question question1 = new Question("test1", "testQuestion1", new Answer());
        Question question2 = new Question("test2", "testQuestion2", new Answer());
        rulerepo.addQuestion(question1);
        rulerepo.addQuestion(question2);
        assertEquals(iterator.next(), question1);
        assertEquals(iterator.next(), question2);
    }
}