package com.example.assignment_2.utilis;

import com.example.assignment_2.R;

import org.jetbrains.annotations.NotNull;

public class IconPicker {
    public static Integer[] icons = { R.drawable.quiz_icon5 ,
            R.drawable.quiz_icon6 , R.drawable.quiz_icon7 , R.drawable.quiz_icon8 , R.drawable.quiz_icon9 , R.drawable.quiz_icon10 ,
            R.drawable.quiz_icon11 , R.drawable.quiz_icon12 , R.drawable.quiz_icon13 , R.drawable.quiz_icon14 };

    @NotNull
    private static int currenticon = 0;
    public static int getIcon() {
        currenticon = (currenticon + 1) % icons.length;
        return icons[currenticon];
    }

    public IconPicker() {
    }

}
