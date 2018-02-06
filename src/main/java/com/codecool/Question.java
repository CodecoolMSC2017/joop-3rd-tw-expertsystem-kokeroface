package com.codecool;

public class Question {
    
    private String id;
    private String question;
    private Answer answer;

    public Question(String id, Answer answer) {
        this.id = id;
        this.answer = answer;
    }

    public String getId() {

        return id;
    }

    public String getQuestion() {

        return question;
    }

    public Answer getAnswer() {

        return answer;
    }

    public boolean getEvaluatedAnswer(String input) {

        return false;
    }
}
