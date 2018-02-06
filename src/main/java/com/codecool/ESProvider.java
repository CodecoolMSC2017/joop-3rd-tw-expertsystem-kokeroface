package com.codecool;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;

    public ESProvider(FactParser factParser, RuleParser ruleParser) throws Exception {
        this.factRepository = factParser.getFactRepository();
        this.ruleRepository = ruleParser.getRuleRepository();
    }

    public void collectAnswers() {

    }

    public boolean getAnswerByQuestion(String questionId) {
        return true;
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