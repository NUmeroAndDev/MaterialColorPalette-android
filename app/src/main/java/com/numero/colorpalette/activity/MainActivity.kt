package com.numero.colorpalette.activity

import android.content.ClipData
import android.content.ClipDescription
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.design.widget.AppBarLayout
import android.support.design.widget.TabLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar

import android.support.v4.view.ViewPager
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.numero.colorpalette.R
import com.numero.colorpalette.fragment.ColorListFragment
import com.numero.colorpalette.model.ColorStyle
import com.numero.colorpalette.model.color.MaterialColor
import com.numero.colorpalette.view.adapter.PagerAdapter
import io.reactivex.Observable

class MainActivity : AppCompatActivity(), ViewPager.OnPageChangeListener, ColorListFragment.ColorListFragmentListener {

    private var toolbar: Toolbar? = null
    private var appBarLayout: AppBarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        appBarLayout = findViewById(R.id.appbar)

        val pagerAdapter = PagerAdapter(applicationContext, supportFragmentManager)

        val viewPager = findViewById<ViewPager>(R.id.container)
        viewPager.adapter = pagerAdapter
        viewPager.addOnPageChangeListener(this)

        val tabLayout = findViewById<TabLayout>(R.id.tabs)
        tabLayout.setupWithViewPager(viewPager)

        val color = ColorStyle.values()[0].color
        setToolbarColor(color)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about_app -> {
                startActivity(AboutActivity.createIntent(this))
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}

    override fun onPageSelected(position: Int) {
        if (position >= ColorStyle.values().size) {
            return
        }
        val color = ColorStyle.values()[position].color
        setToolbarColor(color)
    }

    override fun onPageScrollStateChanged(state: Int) {}

    private fun setToolbarColor(materialColor: MaterialColor) {
        Observable.just(materialColor)
                .map { it.color500 }
                .map { Color.parseColor(it) }
                .subscribe { color ->
                    toolbar!!.setBackgroundColor(color!!)
                    appBarLayout!!.setBackgroundColor(color)
                }
        Observable.just(materialColor)
                .map { it.color700 }
                .map { Color.parseColor(it) }
                .subscribe { color ->
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        window.statusBarColor = color!!
                    }
                }
    }

    override fun onClickColor(color: String) {
        copyText(color)
        Toast.makeText(this, String.format("Copied color : %s", color), Toast.LENGTH_SHORT).show()
    }

    private fun copyText(text: String) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        clipboardManager.primaryClip = ClipData(ClipDescription("copied color", arrayOf(ClipDescription.MIMETYPE_TEXT_URILIST)), ClipData.Item(text))
    }
}
