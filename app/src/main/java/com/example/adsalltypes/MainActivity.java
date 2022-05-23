package com.example.adsalltypes;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    MainAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tebLayout);
        viewPager=findViewById(R.id.view_pager);

        adapter=new MainAdapter(getSupportFragmentManager());
        adapter.AddFragment(new AdaptiveBannerFragment(),"AdaptiveBanner");
        adapter.AddFragment(new AdMobBannerFragment(),"AdMobBanner");
        adapter.AddFragment(new InterstitialFragment(),"Interstitial");
        adapter.AddFragment(new RewardedVideoFragment(),"RewardedVideo");
        adapter.AddFragment(new NativeAdsFragment(),"NativeVideo");
        adapter.AddFragment(new ManagerBannerFragment(),"ManagerBanner");
        adapter.AddFragment(new NativeAdvancedFragment(),"NativeAdvanced");


        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

    }

    private class MainAdapter extends FragmentPagerAdapter {
        ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
        ArrayList<String> stringArrayList=new ArrayList<>();

        private void AddFragment(Fragment fragment,String s){
            fragmentArrayList.add(fragment);
            stringArrayList.add(s);
        }

        public MainAdapter(@NonNull @org.jetbrains.annotations.NotNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @org.jetbrains.annotations.NotNull
        @Override
        public Fragment getItem(int position) {
            return fragmentArrayList.get(position);
        }

        @Override
        public int getCount() {
            return fragmentArrayList.size();
        }

        @Nullable
        @org.jetbrains.annotations.Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            return stringArrayList.get(position);
        }
    }
}