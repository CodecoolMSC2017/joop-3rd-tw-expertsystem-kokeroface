package com.codecool;

public class ESProvider {

    FactParser fact;
    RuleParser rule;

    public ESProvider(FactParser fact, RuleParser rule) {
        this.fact = fact;
        this.rule = rule;
    }

    public void collectAnswers() {

    }

    public boolean getAnswerByQuestion(String questionId) {

        return false;
    }

    public String evaluate() {

        return null;
    }
}
