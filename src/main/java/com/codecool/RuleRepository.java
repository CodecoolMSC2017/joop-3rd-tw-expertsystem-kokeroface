package com.codecool;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RuleRepository {

    List<Question> questions = new ArrayList<>();

    public void addQuestion(Question question) {
        questions.add(question);

    }

    public Iterator<Question> getIterator() {
        return new QuestionIterator(questions);
    }
}
