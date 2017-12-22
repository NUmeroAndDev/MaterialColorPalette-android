package com.numero.colorpalette.model;

import android.support.annotation.StringRes;

import com.numero.colorpalette.R;

public enum ColorStyle {

    RED(
            R.string.red, "RED"
    ),

    PINK(
            R.string.pink, "PINK"
    ),

    PURPLE(
            R.string.purple, "PURPLE"
    ),

    DEEP_PURPLE(
            R.string.deep_purple, "DEEP PURPLE"
    ),

    INDIGO(
            R.string.indigo, "INDIGO"
    ),

    BLUE(
            R.string.blue, "BLUE"
    ),

    LIGHT_BLUE(
            R.string.light_blue, "LIGHT BLUE"
    ),

    CYAN(
            R.string.cyan, "CYAN"
    ),

    TEAL(
            R.string.teal, "TEAL"
    ),

    GREEN(
            R.string.light_green, "LIGHT GREEN"
    ),

    LIME(
            R.string.lime, "LIME"
    ),

    YELLOW(
            R.string.yellow, "YELLOW"
    ),

    AMBER(
            R.string.amber, "AMBER"
    ),

    ORANGE(
            R.string.orange, "ORANGE"
    ),

    DEEP_ORANGE(
            R.string.deep_orange, "DEEP_ORANGE"
    ),

    BROWN(
            R.string.brown, "BROWN"
    ),

    GREY(
            R.string.grey, "GREY"
    ),

    BLUE_GREY(
            R.string.blue_grey, "BLUE GREY"
    );


    private int nameStringRes;
    // FIXME 色モデルに書き換える
    private String color;

    ColorStyle(@StringRes int nameStringRes, String color) {
        this.nameStringRes = nameStringRes;
        this.color = color;
    }

    @StringRes
    public int getNameStringRes() {
        return nameStringRes;
    }

    public String getColor() {
        return color;
    }
}
