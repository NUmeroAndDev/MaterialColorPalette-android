package com.numero.colorpalette.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.numero.colorpalette.R;
import com.numero.colorpalette.databinding.FragmentColorListBinding;
import com.numero.colorpalette.model.color.MaterialColor;

public class ColorListFragment extends Fragment {

    private static final String BUNDLE_MATERIAL_COLOR = "MATERIAL_COLOR";

    private MaterialColor materialColor;
    private ColorListFragmentListener listener;

    public static ColorListFragment newInstance(MaterialColor materialColor) {
        ColorListFragment fragment = new ColorListFragment();
        Bundle args = new Bundle();
        args.putSerializable(BUNDLE_MATERIAL_COLOR, materialColor);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof ColorListFragmentListener) {
            listener = (ColorListFragmentListener) context;
        }
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
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentColorListBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_color_list, container, false);
        binding.setMaterialColor(materialColor);
        binding.setListener(listener);
        return binding.getRoot();
    }

    public interface ColorListFragmentListener {
        void onClickColor(@NonNull String color);
    }
}
