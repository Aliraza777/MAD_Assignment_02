package com.example.assignment_2.utilis;

import org.jetbrains.annotations.NotNull;

public class ColorPicker {
    @NotNull
    private static final String[] colors;
    private static int currentcolorindex;
    @NotNull
    public static final ColorPicker INSTANCE;

    @NotNull
    public final String[] getColors() {
        return colors;
    }

    public final int getCurrentcolorindex() {
        return currentcolorindex;
    }

    public final void setCurrentcolorindex(int var1) {
        currentcolorindex = var1;
    }

    @NotNull
    public final String getColor() {
        currentcolorindex = (currentcolorindex + 1) % colors.length;
        return colors[currentcolorindex];
    }

    public ColorPicker() {
    }

    static {
        ColorPicker var0 = new ColorPicker();
        INSTANCE = var0;
        colors = new String[]{"#FFBB86FC", "#FF03DAC5", "#2B2B2B", "#850000" };
    }
}
