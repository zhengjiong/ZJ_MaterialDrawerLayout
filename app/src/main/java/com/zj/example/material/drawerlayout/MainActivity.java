package com.zj.example.material.drawerlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

/**
 * 需要注意:
 * setNavigationIcon要在setSupportActionBar之後才會起作用,不然會顯示一個後退圖標
 *
 * create by zhengjiong
 * Date: 2015-03-28
 * Time: 18:32
 */
public class MainActivity extends ActionBarActivity{


    private String[] data = new String[]{
        "ToolBar Demo",
        "DrawerLayout Demo",
        "Widget Demo"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        initToolBar();
        initListview();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ToolBar Demo");
        toolbar.setSubtitle("subTitle");
        setSupportActionBar(toolbar);

        //setNavigationIcon要在setSupportActionBar之後才會起作用,不然會顯示一個後退圖標
        //toolbar.setNavigationIcon(R.drawable.abc_ic_menu_share_mtrl_alpha);
    }

    private void initListview() {
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, data);
        ListView listview = (ListView) findViewById(R.id.listview);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new OnListItemClickListener());
    }

    class OnListItemClickListener implements AdapterView.OnItemClickListener{

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (position) {
                case 0:
                    /*ActivityOptionsCompat optionsCompat = new ActivityOptionsCompat().makeSceneTransitionAnimation(
                            MainActivity.this,
                            null, ToolbarDemoActivity.);*/
                    startActivity(new Intent(MainActivity.this, ToolbarDemoActivity.class));
                    break;
                case 1:
                    startActivity(new Intent(MainActivity.this, DrawerDemoActivity.class));
                    break;
                case 2:
                    startActivity(new Intent(MainActivity.this, WidgetDemoActivity.class));
                    break;
                default:
                    break;
            }
        }
    }

}
