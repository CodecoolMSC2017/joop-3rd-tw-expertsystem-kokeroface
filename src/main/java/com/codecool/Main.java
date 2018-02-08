package com.codecool;

public class Main {
    public static void main(String[] args) throws Exception {
        ESProvider esp = new ESProvider(new FactParser(), new RuleParser());
        esp.collectAnswers();

        System.out.println(esp.evaluate());
    }
}
