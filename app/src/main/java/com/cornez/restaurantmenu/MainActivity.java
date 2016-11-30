package com.cornez.restaurantmenu;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v4.app.Fragment;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.app.FragmentTransaction;
import android.content.Context;



public class MainActivity extends AppCompatActivity {

    private static final String TAB_KEY_INDEX = "tab_key";
    private Fragment breakfastFragment;
    private Fragment lunchFragment;
    private Fragment snackFragment;
    private Fragment dinnerFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //SET THE ACTION BAR
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS); //deprecated code
        actionBar.setDisplayShowTitleEnabled(false);

        //CREATE THE TABS AND BIND THEM TO THE ACTION BAR
        ActionBar.Tab breakfastTab = actionBar.newTab().setText(getString(R.string.ui_tabname_breakfast));
        ActionBar.Tab lunchTab = actionBar.newTab().setText(R.string.ui_tabname_lunch);
        ActionBar.Tab snackTab = actionBar.newTab().setText(R.string.ui_tabname_snack);
        ActionBar.Tab dinnerTab = actionBar.newTab().setText(R.string.ui_tabname_dinner);

        //CREATE EACH FRAGMENT AND BIND THEM TO THE ACTION BAR
        breakfastFragment = new BreakfastFragment();
        snackFragment = new SnackFragment();
        lunchFragment = new LunchFragment();
        dinnerFragment = new DinnerFragment();

        //SET THE LISTENER EVENTS FOR EACH OF THE ACTIONBAR TABS
        breakfastTab.setTabListener(new MyTabsListener(breakfastFragment, getApplicationContext()));
        snackTab.setTabListener(new MyTabsListener(snackFragment, getApplicationContext()));
        lunchTab.setTabListener(new MyTabsListener(lunchFragment, getApplicationContext()));
        dinnerTab.setTabListener(new MyTabsListener(dinnerFragment, getApplicationContext()));

        //ADD EACH OF THE TABS TO THE ACTION BAR
        actionBar.addTab(breakfastTab);
        actionBar.addTab(lunchTab);
        actionBar.addTab(snackTab);
        actionBar.addTab(dinnerTab);

        //RESTORE NAVIGATION
        if(savedInstanceState != null) {
            actionBar.setSelectedNavigationItem(savedInstanceState.getInt(TAB_KEY_INDEX, 0));
        }

    }

    class MyTabsListener implements ActionBar.TabListener {

        public Fragment fragment;

        public MyTabsListener(Fragment f, Context context) {
            fragment = f;
        }

        @Override
        public void onTabReselected(ActionBar.Tab tab, FragmentTransaction ft) {
        }
        @Override
        public void onTabSelected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.replace(R.id.fragment_container, fragment);
        }
        @Override
        public void onTabUnselected(ActionBar.Tab tab, FragmentTransaction ft) {
            ft.remove(fragment);
        }
    }
}


