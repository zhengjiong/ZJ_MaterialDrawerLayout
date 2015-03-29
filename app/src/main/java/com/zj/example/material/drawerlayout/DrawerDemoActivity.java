package com.zj.example.material.drawerlayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 使用ToolBar代替ActionBar
 *
 * create by zhengjiong
 * Date: 2015-03-25
 * Time: 22:16
 */
public class DrawerDemoActivity extends ActionBarActivity {
    private String[] mItems = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mListView;

    private ArrayAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_demo_layout);


        initView();
        initToolbar();
        initDrawerToggle();
        initData();
    }

    private void initDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,
                R.string.open, R.string.close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };

        mDrawerToggle.syncState();
        mDrawerLayout.setDrawerListener(mDrawerToggle);
    }

    private void initData() {
        mAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, mItems);
        mListView.setAdapter(mAdapter);
    }

    private void initToolbar() {
        mToolbar.setTitle("Toolbar");
        //這裡不用設置toolbar的color,在style中用textColorPrimary
        //mToolbar.setTitleTextColor(Color.WHITE);

        setSupportActionBar(mToolbar);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //getSupportActionBar().setHomeButtonEnabled(true);//设置返回键可用
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mListView = (ListView) findViewById(R.id.listview_menu);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
