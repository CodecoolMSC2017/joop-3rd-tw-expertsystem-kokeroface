package com.codecool;

import java.util.*;

public class ESProviderGUI {

    private FactRepository factRepository;
    private RuleRepository ruleRepository;
    private Map<String, Integer> games = new HashMap<>();
    private String game = "";
    private int maxValueInMap, gameCount;

    ESProviderGUI(FactParser fact, RuleParser rule) throws Exception {
        this.factRepository = fact.getFactRepository();
        this.ruleRepository = rule.getRuleRepository();
    }

    public void collectAnswers(Map<String, Boolean> answers) {
        Iterator<Question> questionIterator = ruleRepository.getIterator();
        Iterator<Fact> factIterator = factRepository.getIterator();

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

    public String evaluate() {
        game = "";
        maxValueInMap = (Collections.max(games.values()));
        for (Map.Entry<String, Integer> item : games.entrySet()) {
            if (item.getValue() == maxValueInMap) {
                gameCount++;
                game += item.getKey()+", ";
            }
        }
        game = game.substring(0, game.length() - 2);
        return game;
    }

    public int getMaxValueInMap() {
        return maxValueInMap;
    }

    public int getGameCount() {
        return gameCount;
    }
}
