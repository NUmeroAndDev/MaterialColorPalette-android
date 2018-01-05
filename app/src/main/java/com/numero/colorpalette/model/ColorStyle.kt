package com.numero.colorpalette.model

import android.support.annotation.StringRes

import com.numero.colorpalette.R
import com.numero.colorpalette.model.color.Amber
import com.numero.colorpalette.model.color.Blue
import com.numero.colorpalette.model.color.BlueGrey
import com.numero.colorpalette.model.color.Brown
import com.numero.colorpalette.model.color.Cyan
import com.numero.colorpalette.model.color.DeepOrange
import com.numero.colorpalette.model.color.DeepPurple
import com.numero.colorpalette.model.color.Grey
import com.numero.colorpalette.model.color.Indigo
import com.numero.colorpalette.model.color.LightBlue
import com.numero.colorpalette.model.color.LightGreen
import com.numero.colorpalette.model.color.Lime
import com.numero.colorpalette.model.color.MaterialColor
import com.numero.colorpalette.model.color.Orange
import com.numero.colorpalette.model.color.Pink
import com.numero.colorpalette.model.color.Purple
import com.numero.colorpalette.model.color.Red
import com.numero.colorpalette.model.color.Teal
import com.numero.colorpalette.model.color.Yellow

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

    // FIXME
    GREEN(
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
