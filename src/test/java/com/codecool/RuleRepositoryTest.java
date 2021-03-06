package com.codecool;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RuleRepositoryTest {
    private RuleRepository ruleRepo;
    private Question question;

    @BeforeEach
    void setUp() {
        ruleRepo = new RuleRepository();
        SingleValue single = new SingleValue("yes",true);
        SingleValue single2 = new SingleValue("no",false);
        Answer answ = new Answer();
        answ.addValue(single);
        answ.addValue(single2);
        question = new Question("Money","Do you want money?",answ);
    }

    @Test
    void addQuestion() {
        assertEquals(0,ruleRepo.questions.size());
        ruleRepo.addQuestion(question);
        assertEquals(1,ruleRepo.questions.size());
    }

    @Test
    void getIterator() throws Exception {
        ruleRepo.addQuestion(question);
        Question questi= ruleRepo.getIterator().next();
        assertEquals(false,questi.getEvaluatedAnswer("no"));
        assertEquals(true,questi.getEvaluatedAnswer("yes"));
    }
}