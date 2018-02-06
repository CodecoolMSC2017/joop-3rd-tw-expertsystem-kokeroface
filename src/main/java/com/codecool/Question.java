package com.codecool;

public class Question {
    
    String id, question;
    private Answer answer;

    Question(String id, String question,Answer answer) {
        this.id = id;
        this.answer = answer;
        this.question = question;
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

    public boolean getEvaluatedAnswer(String input) throws Exception {
        boolean choice = answer.evaluateAnswerByInput(input);
        return choice;
    }
}
