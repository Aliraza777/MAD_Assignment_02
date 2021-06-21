package com.example.assignment_2.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.text.Html;
import android.util.Log;
import android.widget.TextView;

import com.example.assignment_2.R;
import com.example.assignment_2.models.Question;
import com.example.assignment_2.models.Quiz;
import com.google.gson.Gson;

import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.R)
public class ResultActivity extends AppCompatActivity {
    Map<String, Question> questions = Map.of();
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        textView = findViewById(R.id.txtScore);
        setUpViews();
    }

    public void setUpViews() {
        String quizData = getIntent().getStringExtra("QUIZ");
        Gson gson = new Gson();
        Quiz[] quiz = gson.fromJson(quizData, Quiz[].class);
        questions = quiz[0].questions;
        calculateScore();
        setAnwserView();
    }

    public void setAnwserView() {
        StringBuilder stringBuilder = new StringBuilder();
        TextView answer;
        answer = findViewById(R.id.Answer);
        for (int i = 1; i < questions.size() + 1; i++) {
            Question question = questions.get("question" + i);
            stringBuilder.append("<font color '#000094'><b> Question :  <br/><hr>" + question.description + "</font></br><br/><br/>");
            stringBuilder.append("<font color '#18206f'> Answer :   <br/>" + question.answer + "</font><br/><br/><br/>");
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            answer.setText(Html.fromHtml(stringBuilder.toString(), Html.FROM_HTML_MODE_COMPACT));
        } else {
            answer.setText(Html.fromHtml(stringBuilder.toString()));
        }
    }

    public void calculateScore() {
        Integer score = 0;
        for (int i = 1; i < questions.size() + 1; i++) {
            Question question = questions.get("question" + i);
            if (question.answer.equals(question.useranswer)) {
                score = score + 10;
            }
        }

        textView.setText("Your Score: " + score);
    }
}
