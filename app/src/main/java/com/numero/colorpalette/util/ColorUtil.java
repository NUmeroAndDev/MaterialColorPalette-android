package com.numero.colorpalette.util;

import android.graphics.Color;

public class ColorUtil {
    /**
     * return white or black color, depending on background color
     *
     * @param backgroundColor background color
     * @return Color.BLACK or Color.WHITE
     */
    public static int getTextColor(int backgroundColor) {
        int red = Color.red(backgroundColor);
        int green = Color.green(backgroundColor);
        int blue = Color.blue(backgroundColor);
        if ((red * 0.299 + green * 0.587 + blue * 0.114) > 186) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }
}
