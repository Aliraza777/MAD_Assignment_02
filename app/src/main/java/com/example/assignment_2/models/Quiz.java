package com.example.assignment_2.models;

import android.util.ArrayMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quiz {
    public String id;
    public String title;
    public Map<String , Question> questions = new HashMap<>();
    public Quiz(){
    }
    public Quiz(String id , String title){
        this.id = id;
        this.title = title;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setQuestions(Map<String, Question> questions) {
        this.questions = questions;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Map<String, Question> getQuestions() {
        return questions;
    }

    @Override
    public String toString() {
        return "Quiz  :  " +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", Questions=" + questions ;
    }
}
