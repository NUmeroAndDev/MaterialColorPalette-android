package com.numero.colorpalette.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.FrameLayout

import com.numero.colorpalette.R
import com.numero.colorpalette.util.ColorUtil

import io.reactivex.Observable
import kotlinx.android.synthetic.main.view_color_state.view.*

class ColorStateView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    var titleText: String? = null
        set(value) {
            titleTextView.text = value
        }

    var colorCodeText: String? = null
        set(value) {
            if (value.isNullOrEmpty()) {
                visibility = View.GONE
                return
            }
            colorCodeTextView.text = value
            visibility = View.VISIBLE
            Observable.just(value)
                    .map { Color.parseColor(it) }
                    .doOnNext {
                        visibility = View.VISIBLE
                        setBackgroundColor(it)
                    }
                    .map { ColorUtil.getTextColor(it) }
                    .subscribe({
                        titleTextView.setTextColor(it)
                        colorCodeTextView.setTextColor(it)
                    }, {
                        visibility = View.GONE
                    })
        }

    init {
        View.inflate(context, R.layout.view_color_state, this)

        val a = context.obtainStyledAttributes(attrs, R.styleable.ColorStateView)
        titleText = a.getString(R.styleable.ColorStateView_title)
        colorCodeText = a.getString(R.styleable.ColorStateView_colorCode)
        a.recycle()
    }

    override fun setOnClickListener(l: View.OnClickListener?) {
        parentLayout.setOnClickListener(l)
    }
}
