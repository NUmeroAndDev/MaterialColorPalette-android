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
import com.numero.colorpalette.view.ColorStateView;

public class ColorListFragment extends Fragment {

    private static final String BUNDLE_MATERIAL_COLOR = "MATERIAL_COLOR";

    private ColorStateView colorState50View;
    private ColorStateView colorState100View;
    private ColorStateView colorState200View;
    private ColorStateView colorState300View;
    private ColorStateView colorState400View;
    private ColorStateView colorState500View;
    private ColorStateView colorState600View;
    private ColorStateView colorState700View;
    private ColorStateView colorState800View;
    private ColorStateView colorState900View;
    private ColorStateView colorStateA100View;
    private ColorStateView colorStateA200View;
    private ColorStateView colorStateA400View;
    private ColorStateView colorStateA700View;

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
        colorState50View = view.findViewById(R.id.color_state_50_view);
        colorState100View = view.findViewById(R.id.color_state_100_view);
        colorState200View = view.findViewById(R.id.color_state_200_view);
        colorState300View = view.findViewById(R.id.color_state_300_view);
        colorState400View = view.findViewById(R.id.color_state_400_view);
        colorState500View = view.findViewById(R.id.color_state_500_view);
        colorState600View = view.findViewById(R.id.color_state_600_view);
        colorState700View = view.findViewById(R.id.color_state_700_view);
        colorState800View = view.findViewById(R.id.color_state_800_view);
        colorState900View = view.findViewById(R.id.color_state_900_view);
        colorStateA100View = view.findViewById(R.id.color_state_a100_view);
        colorStateA200View = view.findViewById(R.id.color_state_a200_view);
        colorStateA400View = view.findViewById(R.id.color_state_a400_view);
        colorStateA700View = view.findViewById(R.id.color_state_a700_view);
    }
}
