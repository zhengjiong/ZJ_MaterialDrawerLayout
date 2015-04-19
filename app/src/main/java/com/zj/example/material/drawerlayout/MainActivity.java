package com.zj.example.material.drawerlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * 需要注意:
 * setNavigationIcon要在setSupportActionBar之後才會起作用,不然會顯示一個後退圖標
 *
 * create by zhengjiong
 * Date: 2015-03-28
 * Time: 18:32
 */
public class MainActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_layout);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.place_holder, new MyListFragment())
                .commit();

        initToolBar();
    }

    private void initToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("ToolBar Demo");
        toolbar.setSubtitle("subTitle");
        setSupportActionBar(toolbar);

        //setNavigationIcon要在setSupportActionBar之後才會起作用,不然會顯示一個後退圖標
        //toolbar.setNavigationIcon(R.drawable.abc_ic_menu_share_mtrl_alpha);
    }

    public static class MyListFragment extends ListFragment{
        private String[] data = new String[]{
                "ToolBar Demo",
                "DrawerLayout Demo",
                "Widget Demo",
                "SystemBar Demo"
        };

        private View mRootView;

        public MyListFragment(){}

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            mRootView = inflater.inflate(R.layout.main_fragment_layout, null);
            return mRootView;
        }

        @Override
        public void onViewCreated(View view, Bundle savedInstanceState) {
            super.onViewCreated(view, savedInstanceState);

            initListview();
        }

        private void initListview() {
            ArrayAdapter adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_list_item_1, data);
            getListView().setAdapter(adapter);
            getListView().setOnItemClickListener(new OnListItemClickListener());
        }

        class OnListItemClickListener implements AdapterView.OnItemClickListener{

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                    /*ActivityOptionsCompat optionsCompat = new ActivityOptionsCompat().makeSceneTransitionAnimation(
                            MainActivity.this,
                            null, ToolbarDemoActivity.);*/
                        startActivity(new Intent(getActivity(), ToolbarDemoActivity.class));
                        break;
                    case 1:
                        startActivity(new Intent(getActivity(), DrawerDemoActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(getActivity(), WidgetDemoActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(getActivity(), DrawerDemo2Activity.class));
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
