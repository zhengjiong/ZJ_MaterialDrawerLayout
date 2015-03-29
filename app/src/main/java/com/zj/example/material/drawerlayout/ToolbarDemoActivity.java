package com.zj.example.material.drawerlayout;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

/**
 *
 *
 * create by zhengjiong
 * Date: 2015-03-28
 * Time: 23:13
 */
public class ToolbarDemoActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toolbar_demo_layout);
        initToolbar();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ToolBar Demo");
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setLogo(R.drawable.abc_ic_menu_cut_mtrl_alpha);
        setSupportActionBar(toolbar);

        //setNavigationIcon要在setSupportActionBar之後才會起作用,不然會顯示一個後退圖標
        toolbar.setNavigationIcon(R.drawable.abc_ic_ab_back_mtrl_am_alpha);

        /**
         * 和 setNavigationIcon 一样，setOnMenuItemClickListener需要將之设定在 setSupportActionBar 之后才有作用。
         * setOnMenuItemClickListener相當於是actionbar的onOptionsItemSelected方法
         */
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id.share:
                        Toast.makeText(ToolbarDemoActivity.this, "share", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_settings:
                        Toast.makeText(ToolbarDemoActivity.this, "settings", Toast.LENGTH_SHORT).show();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        /**
         * menu的創建方式還是和actionbar的一樣
        */
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            /**
             * 返回鍵的點擊只能在onOptionsItemSelected中捕獲到,
             * OnMenuItemClickListener中是捕獲不到的
             */
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
