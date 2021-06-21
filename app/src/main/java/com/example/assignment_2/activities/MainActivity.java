package com.example.assignment_2.activities;

import androidx.annotation.NonNull;
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
import android.widget.Toast;

import com.example.assignment_2.R;
import com.example.assignment_2.adapters.Quizadapter;
import com.example.assignment_2.models.Question;
import com.example.assignment_2.models.Quiz;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private FirebaseFirestore firestore;
    private Button btnsignuot;
    private ActionBarDrawerToggle drawer;
    private ArrayList<Quiz> quiz = new ArrayList<>();
    public Quizadapter adapter;
    public RecyclerView quizlist;
    public FloatingActionButton datepicker;
    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        quizlist =  findViewById(R.id.recyclerView);
        datepicker = findViewById(R.id.btnDatePicker);
        setup_Views();
    }
//
//    public void dummy(){
//        quiz.add(new Quiz("12.11.2022" , "12.11.2022"));
//        quiz.add(new Quiz("24.6.2022" , "24.6.2022"));
//        quiz.add(new Quiz("13.1.2022" , "13.1.2022"));
//        quiz.add(new Quiz("01.09.2022" , "01.09.2022"));
//        quiz.add(new Quiz("10.10.2022" , "10.10.2022"));
//
//        Log.d("Ali", "dummy: "+ quiz.toString());
//    }

    void setup_Views(){
        initialize();
        setUpFireStore();
        setUpDrawlayout();
        setupRecyclerView();
        setUpDatePicker();
    }
    public void setUpDatePicker(){
        datepicker.setOnClickListener(value -> {
            MaterialDatePicker<Long> materialDateBuilder = MaterialDatePicker.Builder.datePicker().build();
            materialDateBuilder.show(getSupportFragmentManager(),"DatePicker");
            materialDateBuilder.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener<Long>() {
                @Override
                public void onPositiveButtonClick(Long selection) {
                    Log.d("DatePicker", materialDateBuilder.getHeaderText());
                    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    String date = dateFormat.format(new Date(selection));
                    Intent intent = new Intent(MainActivity.this, QuestionActivity.class);
                    intent.putExtra("DATE", date);
                    MainActivity.this.startActivity(intent);
                }
            });
            materialDateBuilder.addOnNegativeButtonClickListener(selection -> {
                Log.d("DatePicker", materialDateBuilder.getHeaderText());
            });
            materialDateBuilder.addOnCancelListener(selection -> {
                Log.d("DatePicker", "Date Picker Cancelled");
            });
        });
    }
    public void setUpFireStore(){
        firestore = FirebaseFirestore.getInstance();
        CollectionReference collectionReference = firestore.collection( "quizzes");
        collectionReference.addSnapshotListener((value, error) ->{
                if(value == null || error != null ) {
                    Toast.makeText(this , "Error fetching Data !" , Toast.LENGTH_LONG).show();
                    return;
                }

                quiz.clear();
                quiz.addAll(value.toObjects(Quiz.class));
            Log.d("data", "setUpFireStore: " + value.toObjects(Quiz.class).toString());
                adapter.notifyDataSetChanged();
        });
    }

    public void setupRecyclerView(){
        adapter = new Quizadapter(this, quiz);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this , 2);
        quizlist.setLayoutManager(gridLayoutManager);
        quizlist.setAdapter(adapter);
//        quizlist.setAdapter(new Quizadapter(quiz));
    }
    public void setUpDrawlayout(){
        navigationView = findViewById(R.id.navigation);
        navigationView.setNavigationItemSelectedListener(item -> {
            Intent intent = new Intent(MainActivity.this, profileActivity.class);
            MainActivity.this.startActivity(intent);
            finish();
            return true;
        });
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