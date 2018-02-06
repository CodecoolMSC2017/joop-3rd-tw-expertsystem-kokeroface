package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) throws Exception {
        ESProvider esp = new ESProvider(new FactParser(), new RuleParser());
        FactRepository factrepo = esp.getFactRepository();
        RuleRepository rulerepo = esp.getRuleRepository();
        Iterator<Fact> fit = factrepo.getIterator();
        Iterator<Question> qit = rulerepo.getIterator();

        /*while (qit.hasNext()) {
            esp.getAnswerByQuestion(qit.next().id);
        }*/


    }
}
