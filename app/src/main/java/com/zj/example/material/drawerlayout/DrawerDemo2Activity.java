package com.zj.example.material.drawerlayout;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 參考:http://soloho.cc/blog/how-do-i-use-drawerlayout-to-display-over-the-actionbar-or-toolbar-and-under-the-status-bar
 *
 * 講系統StatusBar(SystemBar)設置為透明,使用DrawerLayout來處理StatusBar,
 * 將DrawerLayout顯示在Toolbar和status bar之上
 *
 * create by zhengjiong
 * Date: 2015-04-18
 * Time: 15:22
 */
public class DrawerDemo2Activity extends ActionBarActivity{
    private String[] mItems = {"List Item 01", "List Item 02", "List Item 03", "List Item 04"};

    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawer_demo2_layout);

        initView();
        initToolbar();
        initDrawer();
        initListView();
    }

    private void initListView() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mItems);
        mListView.setAdapter(adapter);
    }

    private void initDrawer() {
        mDrawerToggle = new ActionBarDrawerToggle(
                this,
                mDrawerLayout,
                mToolbar,
                R.string.open,
                R.string.close
        ){
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerToggle.syncState();//加上這句話才可以顯示出三條線的NavigationIcon
        mDrawerLayout.setDrawerListener(mDrawerToggle);


        /**
         * 因為主題中設置了<item name="android:statusBarColor">@android:color/transparent</item>
         * statusBar為透明,如果statusBarColor直接設置成?colorPrimaryDark,
         * drawer就會被statusBar遮擋住!
         * 這裡必須設置statusBar的背景色
         */
        // 在这里我们获取了主题暗色，并设置了status bar的颜色
        TypedValue typedValue = new TypedValue();
        getTheme().resolveAttribute(R.attr.colorPrimaryDark, typedValue, true);
        int color = typedValue.data;


        /**
         * statusBarColor设置为透明是因为我们不再需要系统的status bar，
         * 因为我们无法控制它的位置，我们将交由DrawerLayout来处理。
         */
        // 注意setStatusBarBackgroundColor方法需要你将fitsSystemWindows设置为true才会生效
        mDrawerLayout.setStatusBarBackgroundColor(color);
    }

    private void initToolbar() {
        mToolbar.setTitle("DrawerDemo2");
        setSupportActionBar(mToolbar);
    }

    private void initView() {
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawerlayout);
        mListView = (ListView) findViewById(R.id.listview_menu);
    }


}
