package com.example.assignment_2.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.assignment_2.R;
import com.google.firebase.auth.FirebaseAuth;

public class profileActivity extends AppCompatActivity {
    FirebaseAuth firebaseAuth;
    TextView textView;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        firebaseAuth = FirebaseAuth.getInstance();
        textView = findViewById(R.id.Email);
        if (firebaseAuth.getCurrentUser() != null) {
            textView.setText(firebaseAuth.getCurrentUser().getEmail());
        }
        logout = findViewById(R.id.btnLogout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                Intent intent = new Intent(profileActivity.this, login.class);
                profileActivity.this.startActivity(intent);
                finish();
            }
        });
    }
}