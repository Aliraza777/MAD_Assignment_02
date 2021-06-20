package com.example.assignment_2.activities;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArrayMap;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;

import com.example.assignment_2.R;
import com.example.assignment_2.adapters.Quizadapter;
import com.example.assignment_2.models.Question;
import com.example.assignment_2.models.Quiz;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button btnsignuot;
    private ActionBarDrawerToggle drawer;
    private ArrayList<Quiz> quiz = new ArrayList<>();
    public Quizadapter adapter;
    public RecyclerView quizlist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        quizlist =  findViewById(R.id.recyclerView);
        setup_Views();

    }

    void setup_Views(){
        initialize();
        setUpDrawlayout();
        setupRecyclerView();
    }
    public void setupRecyclerView(){
        adapter = new Quizadapter(this, quiz);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this , 2);
        quizlist.setLayoutManager(gridLayoutManager);
        quizlist.setAdapter(adapter);
//        quizlist.setAdapter(new Quizadapter(quiz));
    }
    public void setUpDrawlayout(){
        setSupportActionBar(findViewById(R.id.appBar));
        drawer= new ActionBarDrawerToggle(MainActivity.this,findViewById(R.id.mainDrawer),R.string.app_name,R.string.app_name);
        drawer.syncState();
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawer.onOptionsItemSelected(item)) {
            return (true);
        }
        return super.onOptionsItemSelected(item);
    }
    private void initialize() {
        btnsignuot = findViewById(R.id.signout);
        listenersignout();

    }
    public void listenersignout(){
        btnsignuot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent intent = new Intent(MainActivity.this, login.class);
                startActivity(intent);
                finish();
            }
        });


    }

}