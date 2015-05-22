package com.example.tariqul.quiztest;

/**
 * Created by tariqul on 5/21/2015.
 */
public class Question {
    private int key;
    private String questionId;
    private String question;
    private String option1;
    private String option2;
    private String option3;
    private String option4;
    private String answer;

    public Question(String questionId, String question, String option1, String option2, String option3, String option4, String answer){

        this();

        setQuestionId(questionId);
        setQuestion(question);
        setOption1(option1);
        setOption2(option2);
        setOption3(option3);
        setOption4(option4);
        setAnswer(answer);


    }

    public Question(){

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
}

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public String getOption4() {
        return option4;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Override
    public String toString() {
        return question +" "+ option1+" "+option2 +" "+option3+" "+ option4+" "+ answer;
    }
}
