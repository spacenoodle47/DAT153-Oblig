package com.example.dat153oblig1;

import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;

public class QuestionModel {
    private Uri question;
    private String option1, option2, option3;
    private int correctAnsNo;

    public QuestionModel(Uri question, String option1, String option2, String option3, int correctAnsNo) {
        this.question = question;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.correctAnsNo = correctAnsNo;
    }

    public Uri getQuestion() {
        return question;
    }
/*
    public void setQuestion(Integer question) {
        this.question = question;
    }*/

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

    public int getCorrectAnsNo() {
        return correctAnsNo;
    }

    public void setQuestion(Uri question) {
        this.question = question;
    }

    public void setCorrectAnsNo(int correctAnsNo) {
        this.correctAnsNo = correctAnsNo;
    }
}
