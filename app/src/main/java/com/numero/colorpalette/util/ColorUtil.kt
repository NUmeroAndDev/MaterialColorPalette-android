package com.numero.colorpalette.util

import android.graphics.Color

object ColorUtil {
    /**
     * return white or black color, depending on background color
     *
     * @param backgroundColor background color
     * @return Color.BLACK or Color.WHITE
     */
    fun getTextColor(backgroundColor: Int): Int {
        val red = Color.red(backgroundColor)
        val green = Color.green(backgroundColor)
        val blue = Color.blue(backgroundColor)
        return if (red * 0.299 + green * 0.587 + blue * 0.114 > 186) {
            Color.BLACK
        } else {
            Color.WHITE
        }
    }
}
