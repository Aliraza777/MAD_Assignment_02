package com.example.assignment_2.utilis;


public class ColorPicker {

    private static String[] color = {"#037e8f", "#05fafa", "#05dbeb", "#f70202", "#231c80", "#aa05fc", "#e00978", "#0a8a03"};
    private static int curretcolor = 0;

    public static String getColor() {
        curretcolor = (curretcolor + 1) % color.length;
        return color[curretcolor];
    }
}
