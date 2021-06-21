package com.example.assignment_2.adapters;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.assignment_2.R;
import com.example.assignment_2.models.Question;

public class Optionadapter extends RecyclerView.Adapter<Optionadapter.OptionViewHolder> {
    Context context;
    Question question;
    String[] option;

    public Optionadapter(Context context, Question question) {
        this.context = context;
        this.question = question;
        option = new String[]{question.option1, question.option2, question.option3, question.option4};
    }

    @Override
    public OptionViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.option_item, parent, false);
        return new OptionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(OptionViewHolder holder, int position) {
        holder.textView.setText(option[position]);
        holder.itemView.setOnClickListener(v -> {
            Toast.makeText(context, option[position], Toast.LENGTH_SHORT).show();
            question.useranswer = option[position];
            notifyDataSetChanged();
        });
        if (question.useranswer == option[position]) {
            holder.itemView.setBackgroundResource(R.drawable.option_item_selected_bg);
        } else {
            holder.itemView.setBackgroundResource(R.drawable.option_item_bg);
        }
    }

    @Override
    public int getItemCount() {
        return option.length;
    }

    public static class OptionViewHolder extends RecyclerView.ViewHolder {
        TextView textView;

        public OptionViewHolder(View itemView) {
            super(itemView);
            textView = (TextView) itemView.findViewById(R.id.quiz_option);

        }
    }
}


