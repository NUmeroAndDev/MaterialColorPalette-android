package com.numero.colorpalette.view.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.numero.colorpalette.fragment.ColorListFragment;
import com.numero.colorpalette.model.ColorStyle;

public class PagerAdapter extends FragmentPagerAdapter {

    private final Context context;

    public PagerAdapter(@NonNull Context context, @NonNull FragmentManager fragmentManager) {
        super(fragmentManager);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        ColorStyle style = ColorStyle.values()[position];
        return ColorListFragment.newInstance(style.getColor());
    }

    @Override
    public int getCount() {
        return ColorStyle.values().length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        ColorStyle style = ColorStyle.values()[position];
        return context.getString(style.getNameStringRes());
    }
}
