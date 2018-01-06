package com.numero.colorpalette.fragment

import android.content.Context
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.numero.colorpalette.R
import com.numero.colorpalette.databinding.FragmentColorListBinding

import com.numero.colorpalette.model.color.MaterialColor

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
        if (arguments != null) {
            materialColor = arguments!!.getSerializable(BUNDLE_MATERIAL_COLOR) as MaterialColor
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val binding = DataBindingUtil.inflate<FragmentColorListBinding>(inflater, R.layout.fragment_color_list, container, false)
        binding.setMaterialColor(materialColor)
        binding.setListener(listener)
        return binding.getRoot()
    }

    interface ColorListFragmentListener {
        fun onClickColor(color: String)
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
