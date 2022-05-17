package com.example.fragmentslide;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;


public class ViewPagerAdpater extends FragmentStatePagerAdapter {
    public ViewPagerAdpater(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                return new Config();
            case 1:
                return new Messages();
            case 2:
                return new Calls();
            default:
                return new Config();
        }
    }

    @Override
    public int getCount() {
        return 3;
    }
}
