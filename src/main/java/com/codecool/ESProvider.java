package com.codecool;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    public ESProvider(FactParser fact, RuleParser rule) throws Exception {
        this.factRepository = fact.getFactRepository();
        this.ruleRepository = rule.getRuleRepository();
    }

    public void collectAnswers() {

    }

    public boolean getAnswerByQuestion(String questionId) {
        return false;
    }

    public String evaluate() {
        return null;
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }

}
