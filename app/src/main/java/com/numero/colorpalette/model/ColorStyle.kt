package com.numero.colorpalette.model

import android.support.annotation.StringRes

import com.numero.colorpalette.R
import com.numero.colorpalette.model.color.*

enum class ColorStyle constructor(@param:StringRes @get:StringRes val nameStringRes: Int, val color: MaterialColor) {

    RED(
            R.string.red, Red()
    ),

    PINK(
            R.string.pink, Pink()
    ),

    PURPLE(
            R.string.purple, Purple()
    ),

    DEEP_PURPLE(
            R.string.deep_purple, DeepPurple()
    ),

    INDIGO(
            R.string.indigo, Indigo()
    ),

    BLUE(
            R.string.blue, Blue()
    ),

    LIGHT_BLUE(
            R.string.light_blue, LightBlue()
    ),

    CYAN(
            R.string.cyan, Cyan()
    ),

    TEAL(
            R.string.teal, Teal()
    ),

    GREEN(
            R.string.green, Green()
    ),

    LIGHT_GREEN(
            R.string.light_green, LightGreen()
    ),

    LIME(
            R.string.lime, Lime()
    ),

    YELLOW(
            R.string.yellow, Yellow()
    ),

    AMBER(
            R.string.amber, Amber()
    ),

    ORANGE(
            R.string.orange, Orange()
    ),

    DEEP_ORANGE(
            R.string.deep_orange, DeepOrange()
    ),

    BROWN(
            R.string.brown, Brown()
    ),

    GREY(
            R.string.grey, Grey()
    ),

    BLUE_GREY(
            R.string.blue_grey, BlueGrey()
    )
}
