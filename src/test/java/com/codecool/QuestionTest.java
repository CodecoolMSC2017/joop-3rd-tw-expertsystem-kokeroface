package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class QuestionTest {

    Answer answer;
    Question question;

    @BeforeEach
    void setUp() {
        Value singleValue = new SingleValue("no",false);
        List<String> values = new ArrayList<String>();
        values.add("yes");
        Value multipleValue = new MultipleValue(values,true);
        answer = new Answer();
        answer.addValue(singleValue);
        answer.addValue(multipleValue);
        question = new Question("graphics","Are graphics important for you?", answer);
    }

    @Test
    void getId() {
        assertEquals("graphics",question.getId());
    }

    @Test
    void getQuestion() {
        assertEquals("Are graphics important for you?",question.getQuestion());
    }

    @Test
    void getAnswer() {
        assertEquals(answer, question.getAnswer());
    }

    @Test
    void getEvaluatedAnswer() throws Exception {
        assertEquals(true,question.getEvaluatedAnswer("yes"));
        assertEquals(false,question.getEvaluatedAnswer("no"));
    }
}