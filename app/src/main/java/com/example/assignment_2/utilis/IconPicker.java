package com.example.assignment_2.utilis;

import com.example.assignment_2.R;

import org.jetbrains.annotations.NotNull;

public class IconPicker {
    @NotNull
    private static final Integer[] icons;
    private static int currenticon;
    @NotNull
    public static final IconPicker INSTANCE;

    @NotNull
    public final Integer[] getIcons() {
        return icons;
    }

    public final int getCurrenticon() {
        return currenticon;
    }

    public final void setCurrenticon(int var1) {
        currenticon = var1;
    }

    public final int getIcon() {
        currenticon = (currenticon + 1) % icons.length;
        return icons[currenticon];
    }

    public IconPicker() {
    }

    static {
        IconPicker var0 = new IconPicker();
        INSTANCE = var0;
        icons = new Integer[]{ R.drawable.quiz_icon1 , R.drawable.quiz_icon2 , R.drawable.quiz_icon3 , R.drawable.quiz_icon4 ,R.drawable.quiz_icon5 ,
                R.drawable.quiz_icon6 , R.drawable.quiz_icon7 , R.drawable.quiz_icon8 , R.drawable.quiz_icon9 , R.drawable.quiz_icon10 ,
                R.drawable.quiz_icon11 , R.drawable.quiz_icon12 , R.drawable.quiz_icon13 , R.drawable.quiz_icon14 };
    }
}
