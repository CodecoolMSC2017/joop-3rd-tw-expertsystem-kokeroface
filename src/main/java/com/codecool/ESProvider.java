package com.codecool;

import java.util.*;

public class ESProvider {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, Boolean> answers = new HashMap<>();
    private Map<String, Integer> games = new HashMap<>();
    private String game = "";

    ESProvider(FactParser fact, RuleParser rule) throws Exception {
        this.factRepository = fact.getFactRepository();
        this.ruleRepository = rule.getRuleRepository();
    }

    public void collectAnswers() {
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        Iterator<Fact> factIterator = factRepository.getIterator();
        while (questionIterator.hasNext()) {
            Question question = questionIterator.next();
            boolean answer = getAnswerByQuestion(question.id);
            this.answers.put(question.getId(), answer);
        }
        while (factIterator.hasNext()) {
            Map<String, Boolean> questions = new HashMap<>();
            Fact fact = factIterator.next();
            Set<String> idSet = fact.getIdSet();
            List<String> idList = new ArrayList<>(idSet);
            for (int i = 0; i < idList.size(); i++) {
                questions.put(idList.get(i), fact.getValueById(idList.get(i)));
            }
            int counter = 0;
            for (Map.Entry<String, Boolean> bool : questions.entrySet()) {
                for (Map.Entry<String, Boolean> entry : answers.entrySet()) {
                    if (bool.getValue() == entry.getValue() && bool.getKey().equals(entry.getKey())) {
                        counter++;
                    }
                }
                games.put(fact.getDescription(),counter);
            }
        }
    }

    private boolean getAnswerByQuestion(String questionId) {

        Scanner userInput = new Scanner(System.in);
        Iterator<Question> iterator = ruleRepository.getIterator();

        while (iterator.hasNext()) {
            Question question = iterator.next();
            List<Value> values = question.getAnswer().getValues();
            if (questionId.equals(question.getId())) {
                if (values.get(0) instanceof SingleValue) {
                    System.out.println(question.getQuestion());
                } else {
                    System.out.println(question.getQuestion());
                    System.out.println("\nChoices:");
                    for (int j = 0; j < values.get(0).param.size(); j++) {
                        System.out.println(values.get(0).param.get(j));
                        System.out.println(values.get(1).param.get(j));
                    }
                }
                while (true) {
                    try {
                        String answer = userInput.nextLine();
                        return question.getEvaluatedAnswer(answer);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            }
        }
        return false;
    }

    public String evaluate() {
        int maxValueInMap = (Collections.max(games.values()));
        for (Map.Entry<String, Integer> item : games.entrySet()) {
            if (item.getValue() == maxValueInMap) {
                game += item.getKey()+", ";
            }
        }
        return game.substring(0, game.length() - 2);
    }

    public FactRepository getFactRepository() {
        return factRepository;
    }

    public RuleRepository getRuleRepository() {
        return ruleRepository;
    }

}
