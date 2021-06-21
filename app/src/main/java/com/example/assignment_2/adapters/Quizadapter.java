package com.example.assignment_2.adapters;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2.R;
import com.example.assignment_2.activities.MainActivity;
import com.example.assignment_2.activities.QuestionActivity;
import com.example.assignment_2.models.Question;
import com.example.assignment_2.models.Quiz;
import com.example.assignment_2.utilis.ColorPicker;
import com.example.assignment_2.utilis.IconPicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quizadapter extends RecyclerView.Adapter<Quizadapter.QuizviewHolder> {
    ArrayList<Quiz> quizzes;
    Context context;
    String[] option;

    public Quizadapter(Context context, ArrayList<Quiz> quiz) {
        this.quizzes = quiz;
        this.context = context;
    }

    @Override
    public QuizviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.quiz_item, parent, false);
        return new QuizviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizviewHolder holder, int position) {
        holder.textViewTitle.setText(quizzes.get(position).title);
        Log.d("test", "onBindViewHolder: " + ColorPicker.getColor());
        Log.d("test", "onBindViewHolder: " + IconPicker.getIcon());
        holder.cardView.setCardBackgroundColor(Color.parseColor(ColorPicker.getColor()));
        holder.iconView.setImageResource(IconPicker.getIcon());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.R)
            @Override
            public void onClick(View v) {
                Toast.makeText(context, quizzes.get(position).title, Toast.LENGTH_LONG).show();
                Intent intent = new Intent(context, QuestionActivity.class);
                intent.putExtra("DATE", quizzes.get(position).getTitle());
                context.startActivity(intent);
//            return;
            }
        });

    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }


    public static class QuizviewHolder extends RecyclerView.ViewHolder {
        public TextView textViewTitle;
        public ImageView iconView;
        public CardView cardView;

        public QuizviewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.quizTitle);
            iconView = itemView.findViewById(R.id.quizicon);
            cardView = itemView.findViewById(R.id.cardcontainer);
        }
    }
}
