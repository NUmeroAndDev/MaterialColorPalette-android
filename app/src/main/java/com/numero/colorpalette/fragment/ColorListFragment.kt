package com.numero.colorpalette.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.numero.colorpalette.R

import com.numero.colorpalette.model.color.MaterialColor
import kotlinx.android.synthetic.main.fragment_color_list.*

class ColorListFragment : Fragment() {

    private var materialColor: MaterialColor? = null
    private var listener: ColorListFragmentListener? = null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        if (context is ColorListFragmentListener) {
            listener = context
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val serializable = arguments?.getSerializable(BUNDLE_MATERIAL_COLOR)
        if (serializable is MaterialColor) {
            materialColor = serializable
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_color_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        colorState50View.colorCodeText = materialColor?.color50
        colorState100View.colorCodeText = materialColor?.color100
        colorState200View.colorCodeText = materialColor?.color200
        colorState300View.colorCodeText = materialColor?.color300
        colorState400View.colorCodeText = materialColor?.color400
        colorState500View.colorCodeText = materialColor?.color500
        colorState600View.colorCodeText = materialColor?.color600
        colorState700View.colorCodeText = materialColor?.color700
        colorState800View.colorCodeText = materialColor?.color800
        colorState900View.colorCodeText = materialColor?.color900
        colorStateA100View.colorCodeText = materialColor?.colorA100
        colorStateA200View.colorCodeText = materialColor?.colorA200
        colorStateA400View.colorCodeText = materialColor?.colorA400
        colorStateA700View.colorCodeText = materialColor?.colorA700

        colorState50View.setOnClickListener {
            listener?.onClickColor(materialColor?.color50)
        }
        colorState100View.setOnClickListener {
            listener?.onClickColor(materialColor?.color100)
        }
        colorState200View.setOnClickListener {
            listener?.onClickColor(materialColor?.color200)
        }
        colorState300View.setOnClickListener {
            listener?.onClickColor(materialColor?.color300)
        }
        colorState400View.setOnClickListener {
            listener?.onClickColor(materialColor?.color400)
        }
        colorState500View.setOnClickListener {
            listener?.onClickColor(materialColor?.color500)
        }
        colorState600View.setOnClickListener {
            listener?.onClickColor(materialColor?.color600)
        }
        colorState700View.setOnClickListener {
            listener?.onClickColor(materialColor?.color700)
        }
        colorState800View.setOnClickListener {
            listener?.onClickColor(materialColor?.color800)
        }
        colorState900View.setOnClickListener {
            listener?.onClickColor(materialColor?.color900)
        }
        colorStateA100View.setOnClickListener {
            listener?.onClickColor(materialColor?.colorA100)
        }
        colorStateA200View.setOnClickListener {
            listener?.onClickColor(materialColor?.colorA200)
        }
        colorStateA400View.setOnClickListener {
            listener?.onClickColor(materialColor?.colorA400)
        }
        colorStateA700View.setOnClickListener {
            listener?.onClickColor(materialColor?.colorA700)
        }
    }

    interface ColorListFragmentListener {
        fun onClickColor(color: String?)
    }

    companion object {

        private val BUNDLE_MATERIAL_COLOR = "MATERIAL_COLOR"

        fun newInstance(materialColor: MaterialColor): ColorListFragment {
            val fragment = ColorListFragment()
            val args = Bundle()
            args.putSerializable(BUNDLE_MATERIAL_COLOR, materialColor)
            fragment.arguments = args
            return fragment
        }
    }
}
