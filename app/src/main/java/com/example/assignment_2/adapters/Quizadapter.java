package com.example.assignment_2.adapters;



import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.util.ArrayMap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2.R;
import com.example.assignment_2.activities.MainActivity;
import com.example.assignment_2.models.Question;
import com.example.assignment_2.models.Quiz;
import com.example.assignment_2.utilis.ColorPicker;
import com.example.assignment_2.utilis.IconPicker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Quizadapter extends RecyclerView.Adapter<Quizadapter.QuizviewHolder>{
    ArrayList<Quiz> quizzes;
    Question question;
    Context context;
    String[] option;
    MainActivity activity;
    public Quizadapter(Context context,ArrayList<Quiz> quiz){
        this.quizzes = quiz;
        this.context = context;

    }
    public Quizadapter(Context context , Question question){
        this.context = context;
        this.question = question;
//        option = new String[]{question.option1 , question.option2 , question.option3 , question.option4};
    }
    private Object QuizviewHolder;


    @NonNull
    @Override
    public QuizviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.quiz_item, parent , false);
        return new QuizviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuizviewHolder holder, int position) {
        holder.textViewTitle.setText(quizzes.get(position).title);
        ColorPicker colorPicker  = new ColorPicker();
        IconPicker iconPicker = new IconPicker();
        holder.cardView.setCardBackgroundColor(Color.parseColor(colorPicker.getColor()));
        holder.iconView.setImageResource(iconPicker.getIcon());

    }

    @Override
    public int getItemCount() {
        return quizzes.size();
    }

    public static class QuizviewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;
        ImageView iconView;
        CardView cardView;
        public QuizviewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.quizTitle);
            iconView = itemView.findViewById(R.id.quizicon);
            cardView = iconView.findViewById(R.id.cardcontainer);
        }
    }

}
