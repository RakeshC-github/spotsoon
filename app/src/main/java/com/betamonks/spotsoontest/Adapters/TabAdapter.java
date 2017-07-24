package com.betamonks.spotsoontest.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.betamonks.spotsoontest.Fragments.TabFragement1;
import com.betamonks.spotsoontest.Fragments.TabFragement2;
import com.betamonks.spotsoontest.Fragments.TabFragement3;


public class TabAdapter extends FragmentStatePagerAdapter {
    Fragment fragment = null;
    int mNumberOfTabs;

    public TabAdapter(FragmentManager fm, int NumOfTabs) {
        super(fm);
        this.mNumberOfTabs = NumOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        if (position == 0) {
            fragment = new TabFragement1();
        } else if (position == 1) {

            fragment = new TabFragement2();
        } else {
            fragment = new TabFragement3();
        }
        return fragment;

    }

    @Override
    public int getCount() {
        return mNumberOfTabs;
    }
}
