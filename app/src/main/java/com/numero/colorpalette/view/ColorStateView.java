package com.numero.colorpalette.view;

import android.content.Context;
import android.content.res.TypedArray;
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
    private TextView colorNameTextView;

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
        a.recycle();
    }

    private void initViews(@NonNull View view) {
        parentLayout = view.findViewById(R.id.parent_layout);

        titleTextView = view.findViewById(R.id.title_text_view);
        colorNameTextView = view.findViewById(R.id.color_name_text);
    }

    public void setTitle(@Nullable String titleString) {
        titleTextView.setText(titleString);
    }

    public void setColorName(@Nullable String colorName) {
        colorNameTextView.setText(colorName);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        parentLayout.setOnClickListener(l);
    }
}
