package com.numero.colorpalette.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.numero.colorpalette.R;

public class ColorStateView extends FrameLayout {

    private View parentLayout;

    public ColorStateView(@NonNull Context context) {
        this(context, null);
    }

    public ColorStateView(@NonNull Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ColorStateView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        View view = LayoutInflater.from(context).inflate(R.layout.view_color_state, this, false);
        initViews(view);
        addView(view);
    }

    private void initViews(@NonNull View view) {
        parentLayout = view.findViewById(R.id.parent_layout);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        parentLayout.setOnClickListener(l);
    }
}
