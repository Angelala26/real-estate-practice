package com.example.android.realestatepractice;

/**
 * Created by Angela on 9/24/17.
 */

public class Question {
    //int because it will point to a resource id
    private int questionId;
    private String question;
    private String opta;
    private String optb;
    private String optc;
    private String optd;
    private String answer;
    private boolean isAnswerCorrect = false;


    public Question() {
        questionId = 0;
        question = "";
        opta = "";
        optb = "";
        optc = "";
        optd = "";
        answer = "";
    }

    public Question(String question, String opta, String optb, String optc,
                    String optd, String answer) {
        this.question = question;
        this.opta = opta;
        this.optb = optb;
        this.optc = optc;
        this.optd = optd;
        this.answer = answer;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpta() {
        return opta;
    }

    public void setOpta(String opta) {
        this.opta = opta;
    }

    public String getOptb() {
        return optb;
    }

    public void setOptb(String optb) {
        this.optb = optb;
    }

    public String getOptc() {
        return optc;
    }

    public void setOptc(String optc) {
        this.optc = optc;
    }

    public String getOptd() {
        return optd;
    }

    public void setOptd(String optd) {
        this.optd = optd;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setAnsweredCorrectly() {
        isAnswerCorrect = true;
    }

    public boolean isAnsweredCorrectly() {
        return isAnswerCorrect;
    }

}
