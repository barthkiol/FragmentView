package com.example.fragmentslide;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import com.example.fragmentslide.R;


import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNav;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.GRAY));


        bottomNav = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.view_pager);
        setUpViewPager();
        bottomNav.setOnNavigationItemSelectedListener((item) ->{
            switch (item.getItemId()){
                case R.id.config:
                    viewPager.setCurrentItem(0);
                    break;
                case R.id.messages:
                    viewPager.setCurrentItem(1);
                    break;
                case R.id.calls:
                    viewPager.setCurrentItem(2);
                    break;
            }
            return true;
        });


    }

    public void setActionBarTitle(String title){
        getSupportActionBar().setTitle(title);
    }

    private void setUpViewPager() {
        ViewPagerAdpater viewPagerAdpater = new ViewPagerAdpater(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        viewPager.setAdapter(viewPagerAdpater);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        bottomNav.getMenu().findItem(R.id.config).setChecked(true);
                        break;
                    case 1:
                        bottomNav.getMenu().findItem(R.id.messages).setChecked(true);
                        break;
                    case 2:
                        bottomNav.getMenu().findItem(R.id.calls).setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}