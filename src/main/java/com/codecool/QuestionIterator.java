package com.codecool;

import java.util.Iterator;
import java.util.List;

public class QuestionIterator implements Iterator {

    private int i;
    private List<Question> list;

    public QuestionIterator(List<Question> list) {
        this.list = list;
    }

    @Override
    public boolean hasNext() {
        if (i < list.size()) {
            return true;
        }
        return false;
    }

    @Override
    public Question next() {
        Question question = list.get(i);
        i++;
        return question;
    }
}
