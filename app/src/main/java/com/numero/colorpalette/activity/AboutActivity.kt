package com.numero.colorpalette.activity

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import com.numero.colorpalette.BuildConfig
import com.numero.colorpalette.R
import kotlinx.android.synthetic.main.activity_about.*

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        versionTextView.text = String.format("Ver %s", BuildConfig.VERSION_NAME)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_about, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
            R.id.action_view_source -> {
                startSourceView()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun startSourceView() {
        startActivity(Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(getString(R.string.source_url))
        })
    }

    companion object {
        fun createIntent(context: Context): Intent = Intent(context, AboutActivity::class.java)
    }
}
