package com.numero.colorpalette.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.numero.colorpalette.R;

public class ColorStateView extends FrameLayout {

    private View parentLayout;
    private TextView titleTextView;
    private TextView colorCodeTextView;

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

        final TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.ColorStateView);
        String title = a.getString(R.styleable.ColorStateView_title);
        setTitle(title);
        String colorCode = a.getString(R.styleable.ColorStateView_colorCode);
        setColorCode(colorCode);
        a.recycle();
    }

    private void initViews(@NonNull View view) {
        parentLayout = view.findViewById(R.id.parent_layout);

        titleTextView = view.findViewById(R.id.title_text_view);
        colorCodeTextView = view.findViewById(R.id.color_code_text);
    }

    public void setTitle(@Nullable String titleString) {
        titleTextView.setText(titleString);
    }

    public void setColorCode(@Nullable String colorCode) {
        colorCodeTextView.setText(colorCode);
        if (colorCode == null || colorCode.isEmpty()) {
            setVisibility(GONE);
            return;
        }
        setVisibility(VISIBLE);
        try {
            int color = Color.parseColor(colorCode);
            setBackgroundColor(color);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        parentLayout.setOnClickListener(l);
    }
}
