package com.cecepapp.cecepapp.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cecepapp.cecepapp.fragment.About1Fragment;
import com.cecepapp.cecepapp.fragment.About2Fragment;



public class PagerAdapter extends FragmentStatePagerAdapter {

    private int mNoOfTabs;

    public PagerAdapter(FragmentManager fm, int NumberOfTabs)
    {
        super(fm);
        this.mNoOfTabs = NumberOfTabs;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position)
        {
            case 0:
                return new About1Fragment();
            case 1:
                return new About2Fragment();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mNoOfTabs;
    }
}

