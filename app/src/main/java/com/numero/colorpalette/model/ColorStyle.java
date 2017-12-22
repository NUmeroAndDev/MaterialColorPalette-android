package com.numero.colorpalette.model;

import android.support.annotation.StringRes;

import com.numero.colorpalette.R;
import com.numero.colorpalette.model.color.Amber;
import com.numero.colorpalette.model.color.Blue;
import com.numero.colorpalette.model.color.BlueGrey;
import com.numero.colorpalette.model.color.Brown;
import com.numero.colorpalette.model.color.Cyan;
import com.numero.colorpalette.model.color.DeepOrange;
import com.numero.colorpalette.model.color.DeepPurple;
import com.numero.colorpalette.model.color.Grey;
import com.numero.colorpalette.model.color.Indigo;
import com.numero.colorpalette.model.color.LightBlue;
import com.numero.colorpalette.model.color.LightGreen;
import com.numero.colorpalette.model.color.Lime;
import com.numero.colorpalette.model.color.MaterialColor;
import com.numero.colorpalette.model.color.Orange;
import com.numero.colorpalette.model.color.Pink;
import com.numero.colorpalette.model.color.Purple;
import com.numero.colorpalette.model.color.Red;
import com.numero.colorpalette.model.color.Teal;
import com.numero.colorpalette.model.color.Yellow;

public enum ColorStyle {

    RED(
            R.string.red, new Red()
    ),

    PINK(
            R.string.pink, new Pink()
    ),

    PURPLE(
            R.string.purple, new Purple()
    ),

    DEEP_PURPLE(
            R.string.deep_purple, new DeepPurple()
    ),

    INDIGO(
            R.string.indigo, new Indigo()
    ),

    BLUE(
            R.string.blue, new Blue()
    ),

    LIGHT_BLUE(
            R.string.light_blue, new LightBlue()
    ),

    CYAN(
            R.string.cyan, new Cyan()
    ),

    TEAL(
            R.string.teal, new Teal()
    ),

    GREEN(
            R.string.light_green, new LightGreen()
    ),

    LIME(
            R.string.lime, new Lime()
    ),

    YELLOW(
            R.string.yellow, new Yellow()
    ),

    AMBER(
            R.string.amber, new Amber()
    ),

    ORANGE(
            R.string.orange, new Orange()
    ),

    DEEP_ORANGE(
            R.string.deep_orange, new DeepOrange()
    ),

    BROWN(
            R.string.brown, new Brown()
    ),

    GREY(
            R.string.grey, new Grey()
    ),

    BLUE_GREY(
            R.string.blue_grey, new BlueGrey()
    );


    private int nameStringRes;
    private MaterialColor color;

    ColorStyle(@StringRes int nameStringRes, MaterialColor color) {
        this.nameStringRes = nameStringRes;
        this.color = color;
    }

    @StringRes
    public int getNameStringRes() {
        return nameStringRes;
    }

    public MaterialColor getColor() {
        return color;
    }
}
