package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        ESProvider esp = new ESProvider(new FactParser(), new RuleParser());
        FactRepository factrepo = esp.getFactRepository();
        RuleRepository rulerepo = esp.getRuleRepository();
        Iterator<Fact> fit= factrepo.getIterator();
        Iterator<Question> qit = rulerepo.getIterator();

        while (fit.hasNext()) {
            System.out.println(fit.next().description);
        }

        while (qit.hasNext()) {
            System.out.println(qit.next().question);
        }

    }
}
