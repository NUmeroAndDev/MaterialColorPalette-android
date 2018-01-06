package com.numero.colorpalette.view

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.TextView

import com.numero.colorpalette.R
import com.numero.colorpalette.util.ColorUtil

import io.reactivex.Observable

class ColorStateView @JvmOverloads constructor(context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0) : FrameLayout(context, attrs, defStyleAttr) {

    private var parentLayout: View? = null
    private var titleTextView: TextView? = null
    private var colorCodeTextView: TextView? = null

    init {
        val view = LayoutInflater.from(context).inflate(R.layout.view_color_state, this, false)
        initViews(view)
        addView(view)

        val a = context.obtainStyledAttributes(attrs, R.styleable.ColorStateView)
        val title = a.getString(R.styleable.ColorStateView_title)
        setTitle(title)
        val colorCode = a.getString(R.styleable.ColorStateView_colorCode)
        setColorCode(colorCode)
        a.recycle()
    }

    private fun initViews(view: View) {
        parentLayout = view.findViewById(R.id.parentLayout)

        titleTextView = view.findViewById(R.id.titleTextView)
        colorCodeTextView = view.findViewById(R.id.colorCodeTextView)
    }

    fun setTitle(titleString: String?) {
        titleTextView!!.text = titleString
    }

    fun setColorCode(colorCode: String?) {
        colorCodeTextView!!.text = colorCode
        if (colorCode == null || colorCode.isEmpty()) {
            visibility = View.GONE
            return
        }
        visibility = View.VISIBLE
        Observable.just(colorCode)
                .map { Color.parseColor(it) }
                .doOnNext { color ->
                    visibility = View.VISIBLE
                    setBackgroundColor(color!!)
                }
                .map { ColorUtil.getTextColor(it) }
                .subscribe({ color ->
                    titleTextView!!.setTextColor(color!!)
                    colorCodeTextView!!.setTextColor(color)
                }) { visibility = View.GONE }
    }

    override fun setOnClickListener(l: View.OnClickListener?) {
        parentLayout!!.setOnClickListener(l)
    }
}
