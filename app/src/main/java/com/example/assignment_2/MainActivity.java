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
    private ActionBarDrawerToggle menubar;
    private ToggleButton toggleButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
//        androidx.appcompat.widget.Toolbar myToolbar = findViewById(R.id.appBar);
//        setSupportActionBar(myToolbar);
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.mainDrawer);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(MainActivity.this , drawer , myToolbar , R.string.app_name , R.string.app_name);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        getActionBar().setDisplayHomeAsUpEnabled(true);
//        getActionBar().setHomeButtonEnabled(true);



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

    private void initialize() {
        btnsignuot = findViewById(R.id.signout);
    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(menubar.onOptionsItemSelected(item)){
//            return true;
//        }
//
//    }

//    @Override
//    protected  void onPostCreate(Bundle savedInstanceState) {
//
//        super.onPostCreate(savedInstanceState);
//        menubar.syncState();
//    }
//
//    @Override
//    public void onConfigurationChanged(Configuration newConfig) {
//        super.onConfigurationChanged(newConfig);
//        menubar.onConfigurationChanged(newConfig);
//    }
}