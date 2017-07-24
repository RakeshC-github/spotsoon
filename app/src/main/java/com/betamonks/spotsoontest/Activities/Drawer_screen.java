package com.betamonks.spotsoontest.Activities;
//http://www.android4devs.com/2014/12/how-to-make-material-design-navigation-drawer.html

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.GestureDetector;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.betamonks.spotsoontest.Adapters.Drawer_Adapter;
import com.betamonks.spotsoontest.Fragments.TestFragement;
import com.betamonks.spotsoontest.Fragments.HomeFragement;
import com.betamonks.spotsoontest.R;

/**
 * Created by bm-admin on 8/12/16.
 */
public class Drawer_screen extends AppCompatActivity {


    String titles[] = {"Home", "Test App"};
    int icons[] = {R.drawable.ic_home,
            R.drawable.ic_test};
    String name = "SpotSoon";
    String email = "";
    int profile = R.mipmap.ic_launcher;

    private Toolbar toolbar;
    Fragment fragment = null;
    RecyclerView mRecyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager mLayoutManager;
    DrawerLayout Drawer;

    ActionBarDrawerToggle mDrawerToogle;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.drawerscreen);

        FragmentTransaction tx = getSupportFragmentManager().beginTransaction();
        tx.replace(R.id.Content, new HomeFragement());
        tx.commit();
        toolbar = (Toolbar) findViewById(R.id.tool_bar_id);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("HOME");


        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mAdapter = new Drawer_Adapter(titles, icons, name, email, profile, this);
        mRecyclerView.setAdapter(mAdapter);


        final GestureDetector mGestureDetector = new GestureDetector(Drawer_screen.this, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return true;
            }

        });

        mRecyclerView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
            @Override
            public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
                View child = recyclerView.findChildViewUnder(motionEvent.getX(), motionEvent.getY());

                if (child != null && mGestureDetector.onTouchEvent(motionEvent)) {
                    Drawer.closeDrawers();

                    int position = mRecyclerView.getChildPosition(child);

                    Toast.makeText(getApplicationContext(), "RecyclerView = " + mRecyclerView.getChildPosition(child), Toast.LENGTH_SHORT).show();
                    Log.d("motion = ", "" + position);

                    onTouchDrawer(mRecyclerView.getChildPosition(child));
                    return true;
                }

                return false;
            }

            @Override
            public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {


            }

            @Override
            public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

            }
        });

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        Drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
        mDrawerToogle = new ActionBarDrawerToggle(this, Drawer, toolbar, R.string.openDrawer, R.string.closeDrawer) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(false);
        mDrawerToogle.setDrawerIndicatorEnabled(false);
        mDrawerToogle.setHomeAsUpIndicator(R.drawable.ic_menu);

        Drawer.setDrawerListener(mDrawerToogle);
        mDrawerToogle.syncState();
        mDrawerToogle.setToolbarNavigationClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DrawerLayout drawer = (DrawerLayout) findViewById(R.id.DrawerLayout);
                if (drawer.isDrawerOpen(GravityCompat.START)) {
                    drawer.closeDrawer(GravityCompat.START);
                } else {
                    drawer.openDrawer(GravityCompat.START);
                }
            }
        });
    }


    public Fragment onTouchDrawer(int position) {

        Log.w("Position", "" + position);
        if (position == 1) {
            Log.w("Position_1", "" + position);
            fragment = new HomeFragement();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Content, fragment).commit();
            getSupportActionBar().setTitle("HOME");

        } else if (position == 2) {

            fragment = new TestFragement();
            FragmentManager fragmentManager = getSupportFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.Content, fragment).commit();
            getSupportActionBar().setTitle("TEST");
        }
        return fragment;
    }


}
