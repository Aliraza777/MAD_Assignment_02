package com.example.assignment_2.activities;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.assignment_2.R;
import com.example.assignment_2.adapters.Optionadapter;
import com.example.assignment_2.models.Question;
import com.example.assignment_2.models.Quiz;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RequiresApi(api = Build.VERSION_CODES.R)
public class QuestionActivity extends AppCompatActivity {
    Button next,prev,submit;
    FirebaseFirestore firestore;
    Question question;
    Optionadapter adapter;
    Integer index = 1;
    List<Quiz> quiz = new ArrayList<>();
//    public Map<Quiz> quiz = new ArrayList<>();
//    Question questions = (Question) Map.of();
    Map<String,Question> questions = Map.of();
    RecyclerView recyclerViewl;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        recyclerViewl = findViewById(R.id.optionList);
        next = findViewById(R.id.btnNext);
        prev = findViewById(R.id.btnPrevious);
        submit = findViewById(R.id.btnSubmit);
        setUpFireStore();
        setUpEventLister();
    }
    public void setUpEventLister(){
        prev.setOnClickListener(value -> {
            index--;
            bindViews();
        });
        next.setOnClickListener(value -> {
            index++;
            bindViews();
        });
        submit.setOnClickListener(value -> {
            Log.d("FINAL", questions.toString());
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            String json=gson.toJson(quiz);

            Intent intent = new Intent(QuestionActivity.this, ResultActivity.class);
            intent.putExtra("QUIZ", json);
            QuestionActivity.this.startActivity(intent);
            finish();
        });
    }
    public void setUpFireStore(){
        firestore = FirebaseFirestore.getInstance();
        String date= getIntent().getStringExtra("DATE");
        if(date != null){
            firestore.collection("quizzes")
                    .whereEqualTo("title", date)
                    .get()
                    .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                        @Override
                        public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                            if(queryDocumentSnapshots!=null && !queryDocumentSnapshots.isEmpty()){
                                quiz.addAll(queryDocumentSnapshots.toObjects(Quiz.class));
                                questions = quiz.get(0).questions;
                                bindViews();
                            }
                            else{
                                Toast.makeText(QuestionActivity.this,"No Quiz at Avaiable at Requested Date",Toast.LENGTH_LONG).show();
                                Intent intent = new Intent(QuestionActivity.this, MainActivity.class);
                                QuestionActivity.this.startActivity(intent);
                                finish();
                            }
                        }
                    });
        }

    }
    public void bindViews(){
//        question = new Question(
//                "what is your name",
//                "ali" ,
//                "ali wahlah" ,
//                "ali raza" ,
//                "Muhammad Ali Raza",
//                "Muhammad Ali Raza");

        next.setVisibility(View.GONE);
        prev.setVisibility(View.GONE);
        submit.setVisibility(View.GONE);
        if(index==1){
            next.setVisibility(View.VISIBLE);
        }
        else if(index==questions.size()) {
            submit.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
        }
        else{
            next.setVisibility(View.VISIBLE);
            prev.setVisibility(View.VISIBLE);
        }

        Question question = questions.get("question"+index);
        String description = question.description;
        TextView descp = findViewById(R.id.description);
        descp.setText(question.description);
        adapter = new Optionadapter(this , question);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerViewl.setLayoutManager(layoutManager);
        recyclerViewl.setAdapter(adapter);
        recyclerViewl.setHasFixedSize(true);

    }
//
}