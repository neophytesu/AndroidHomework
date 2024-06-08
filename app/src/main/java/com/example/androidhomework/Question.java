package com.example.androidhomework;

//题目对象
public class Question {
    private long  id;
    private String num;
    private String question_text;
    private String questionA;
    private String questionB;
    private String questionC;
    private String questionD;
    private String answer;
    private int score;

    public Question() {
    }
    public Question(String num,String question_text,String questionA,String questionB,String questionC,String questionD,String answer,int score){
        this.num = num;
        this.question_text=question_text;
        this.questionA=questionA;
        this.questionB=questionB;
        this.questionC=questionC;
        this.questionD=questionD;
        this.answer=answer;
        this.score=score;
    }



    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getQuestionA() {
        return questionA;
    }

    public void setQuestionA(String questionA) {
        this.questionA = questionA;
    }

    public String getQuestionB() {
        return questionB;
    }

    public void setQuestionB(String questionB) {
        this.questionB = questionB;
    }

    public String getQuestionC() {
        return questionC;
    }



    public void setQuestionC(String questionC) {
        this.questionC = questionC;
    }

    public void setQuestionD(String questionD) {
        this.questionD = questionD;
    }
    public String getQuestionD() {
        return questionD;
    }

    public String getQuestion_text() {
        return question_text;
    }

    public void setQuestion_text(String question_text) {
        this.question_text = question_text;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
