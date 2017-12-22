package com.numero.colorpalette.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.numero.colorpalette.R;
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

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.framgent_color_list, container, false);
        initViews(view);
        return view;
    }

    private void initViews(@NonNull View view) {

    }
}
