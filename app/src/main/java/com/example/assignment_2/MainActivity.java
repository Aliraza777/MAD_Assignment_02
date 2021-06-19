package com.example.assignment_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ToggleButton;
import android.widget.Toolbar;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private Button btnsignuot;
    private ActionBarDrawerToggle drawer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
        setup_Views();
        initialize();


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

    void setup_Views(){
        setUpDrawlayout();
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
    }

}