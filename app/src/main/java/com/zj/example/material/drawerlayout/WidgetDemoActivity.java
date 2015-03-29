package com.zj.example.material.drawerlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

/**
 * create by zhengjiong
 * Date: 2015-03-29
 * Time: 16:45
 */
public class WidgetDemoActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.widget_layout);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Widget Demo");
        toolbar.setTitleTextColor(Color.WHITE);
        setSupportActionBar(toolbar);

        //setNavigationIcon要在setSupportActionBar之後才會起作用,不然會顯示一個後退圖標
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            WidgetDemoActivity.this.finish();
        }
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }
}
