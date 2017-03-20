package com.djr.multipleviewpager;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.djr.multipleviewpager.fragment.DiscoveryFragment;
import com.djr.multipleviewpager.fragment.DynamicFragment;
import com.djr.multipleviewpager.fragment.MineFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {


    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private PagerAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        initViewPager();
    }

    private void initViewPager() {
        mAdapter = new PagerAdapter(getSupportFragmentManager());

        mAdapter.addFragment(new MineFragment());
        mAdapter.addFragment(new DiscoveryFragment());
        mAdapter.addFragment(new DynamicFragment());

        mAdapter.addTitle("我的");
        mAdapter.addTitle("发现");
        mAdapter.addTitle("动态");

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setTabTextColors(getResources().getColor(R.color.tabtextcolors_unselected)
                , getResources().getColor(R.color.tabtextcolors_selected));
        mTabLayout.setupWithViewPager(mViewPager);
    }

    class PagerAdapter extends FragmentPagerAdapter {

        private List<Fragment> mFragments = new ArrayList<>();

        private List<String> mTitles = new ArrayList<>();

        public void addFragment(Fragment fragment) {
            if (fragment != null) {
                mFragments.add(fragment);
            }
        }

        public void addTitle(String title) {
            if (title != null) {
                mTitles.add(title);
            }
        }

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitles.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

    }


}
