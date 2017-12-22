package com.numero.colorpalette.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.numero.colorpalette.model.color.MaterialColor;

public class ColorListFragment extends Fragment {

    private static final String BUNDLE_MATERIAL_COLOR = "MATERIAL_COLOR";

    private MaterialColor materialColor;

    public static ColorListFragment newInstance(MaterialColor materialColor) {
        ColorListFragment fragment = new ColorListFragment();
        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_MATERIAL_COLOR, materialColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            materialColor = (MaterialColor) getArguments().getSerializable(BUNDLE_MATERIAL_COLOR);
        }
    }
}
