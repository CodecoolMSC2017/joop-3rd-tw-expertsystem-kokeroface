package com.codecool;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        FactParser fp = new FactParser();
        FactRepository repo = fp.getFactRepository();
        List<Fact> facts = repo.getFactList();


        for (Fact fact : facts) {
            System.out.println(fact.id+"\t\t\t\t\t\t\t\t"+fact.description);
        }
    }
}
