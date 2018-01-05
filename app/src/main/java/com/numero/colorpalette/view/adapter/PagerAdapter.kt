package com.numero.colorpalette.view.adapter

import android.content.Context
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

import com.numero.colorpalette.fragment.ColorListFragment
import com.numero.colorpalette.model.ColorStyle

class PagerAdapter(private val context: Context, fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {

    override fun getItem(position: Int): Fragment {
        val style = ColorStyle.values()[position]
        return ColorListFragment.newInstance(style.color)
    }

    override fun getCount(): Int {
        return ColorStyle.values().size
    }

    override fun getPageTitle(position: Int): CharSequence? {
        val style = ColorStyle.values()[position]
        return context.getString(style.nameStringRes)
    }
}
