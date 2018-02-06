package com.codecool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private HashMap<String, Boolean> answers = new HashMap<>();

    public ESProvider(FactParser fact, RuleParser rule) throws Exception {
        this.factRepository = fact.getFactRepository();
        this.ruleRepository = rule.getRuleRepository();
    }

    public void collectAnswers() {
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        int counter = 0;
        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            this.answers.put(question.getId(), answers.get(counter));
            counter++;
        }
    }

    public boolean getAnswerByQuestion(String questionId) {

        Scanner userInput = new Scanner(System.in);
        Iterator<Question> iterator = ruleRepository.getIterator();
        while (iterator.hasNext()) {
            Question question = iterator.next();
            if (questionId.equals(question.getId())) {
                System.out.println(question.getQuestion());
                String answer;
                while (true) {
                    try {
                        answer = userInput.nextLine();
                        boolean result = question.getEvaluatedAnswer(answer);
                        return result;
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
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
