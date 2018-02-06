package com.codecool;

public class Main {
    public static void main(String[] args) {
        FactParser facts = new FactParser();
        RuleParser rules = new RuleParser();
        ESProvider esp = new ESProvider(facts, rules);
    }
}
