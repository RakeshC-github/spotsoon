package com.betamonks.spotsoontest.Fragments;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;


import com.betamonks.spotsoontest.Adapters.TabAdapter;
import com.betamonks.spotsoontest.Adapters.ViewPagerAdapter;
import com.betamonks.spotsoontest.R;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by bm-admin on 19/12/16.
 */
public class HomeFragement extends Fragment {

    ViewPager viewPager, viewPagerTab;
    private TabLayout tabLayout, tab_layout_indicator;
    private Integer[] images = {R.drawable.slider1, R.drawable.slider2, R.drawable.slider3};
    private String[] titles = {"AR.Rahman", "AR.Rahman Songs", "AR.Rahman Albums"};


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.homefragment, container, false);
        Log.d("Home", "fragment" + view);

        viewPager = (ViewPager) view.findViewById(R.id.imgviewPager);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getActivity(), images, titles);

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) view.findViewById(R.id.tab_layout);
        tab_layout_indicator = (TabLayout) view.findViewById(R.id.tab_layout_indicator);
        tabLayout.addTab(tabLayout.newTab().setText(" Video ").setIcon(R.drawable.ic_video));
        tabLayout.addTab(tabLayout.newTab().setText(" Images ").setIcon(R.drawable.ic_selected_image));
        tabLayout.addTab(tabLayout.newTab().setText(" Milestone ").setIcon(R.drawable.ic_selected_milestone));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);
        tab_layout_indicator.setSelectedTabIndicatorColor(getResources().getColor(R.color.tabSelected_TextColor));

        viewPagerTab = (ViewPager) view.findViewById(R.id.pager);
        final TabAdapter adapter = new TabAdapter(getFragmentManager(), tabLayout.getTabCount());
        viewPagerTab.setAdapter(adapter);

        viewPagerTab.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {


            }
        });

        return view;

    }


}
