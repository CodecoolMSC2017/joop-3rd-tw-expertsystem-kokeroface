package com.codecool;

import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        ESProvider esp = new ESProvider(new FactParser(), new RuleParser());
    }
}
