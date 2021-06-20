package com.example.assignment_2.models;

public class Question {
    public String description = "";
    public String option1 = "";
    public String option2 = "";
    public String option3 = "";
    public String option4 = "";
    private String answer = "";
    public String useranswer = "";

    public Question(String description , String option1 , String option2 , String option3 , String option4 , String answer ,String useranswer){
        this.description = description;
        this.option1 = option1;
        this.option2 = option2;
        this.option3 = option3;
        this.option4 = option4;
        this.answer = answer;
        this.useranswer = useranswer;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public void setOption4(String option4) {
        this.option4 = option4;
    }

    public void setUseranswer(String useranswer) {
        this.useranswer = useranswer;
    }

    public String getAnswer() {
        return answer;
    }

    public String getDescription() {
        return description;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    public String getOption3() {
        return option3;
    }

    public String getOption4() {
        return option4;
    }

    public String getUseranswer() {
        return useranswer;
    }


    @Override
    public String toString() {
        return "Question  : " +
                "description='" + description + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", option4='" + option4 + '\'' +
                ", answer='" + answer + '\'' +
                ", useranswer='" + useranswer ;
    }
}
