package com.codecool;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RuleParserTest {

    RuleParser ruleParserTest = new RuleParser();

    @Test
    void getRuleRepository() throws Exception {
        RuleRepository test = ruleParserTest.getRuleRepository();
        Question moneys = test.getIterator().next();
        assertEquals(true,moneys.getEvaluatedAnswer("yes"));
        assertEquals(false,moneys.getEvaluatedAnswer("no"));

    }
}
