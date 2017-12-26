package com.numero.colorpalette.activity;

import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.numero.colorpalette.R;
import com.numero.colorpalette.model.ColorStyle;
import com.numero.colorpalette.model.color.MaterialColor;
import com.numero.colorpalette.view.adapter.PagerAdapter;

import io.reactivex.Observable;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private Toolbar toolbar;
    private AppBarLayout appBarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        appBarLayout = findViewById(R.id.appbar);

        PagerAdapter pagerAdapter = new PagerAdapter(getApplicationContext(), getSupportFragmentManager());

        ViewPager viewPager = findViewById(R.id.container);
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(this);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);

        MaterialColor color = ColorStyle.values()[0].getColor();
        setToolbarColor(color);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_about_app:
                startActivity(AboutActivity.createIntent(this));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
    }

    @Override
    public void onPageSelected(int position) {
        if (position >= ColorStyle.values().length) {
            return;
        }
        MaterialColor color = ColorStyle.values()[position].getColor();
        setToolbarColor(color);
    }

    @Override
    public void onPageScrollStateChanged(int state) {
    }

    private void setToolbarColor(@NonNull MaterialColor materialColor) {
        Observable.just(materialColor)
                .map(MaterialColor::getColor500)
                .map(Color::parseColor)
                .subscribe(color -> {
                    toolbar.setBackgroundColor(color);
                    appBarLayout.setBackgroundColor(color);
                });
        Observable.just(materialColor)
                .map(MaterialColor::getColor700)
                .map(Color::parseColor)
                .subscribe(color -> {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().setStatusBarColor(color);
                    }
                });
    }
}
