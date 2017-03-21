package com.djr.multipleviewpager.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.djr.multipleviewpager.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by DongJr on 2017/3/20.
 */

public class DiscoveryFragment extends Fragment {

    @Bind(R.id.tabLayout)
    TabLayout mTabLayout;
    @Bind(R.id.viewPager)
    ViewPager mViewPager;

    private PagerAdapter mAdapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_discovery, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initViewPager();
    }

    private void initViewPager() {
        mAdapter = new PagerAdapter(getChildFragmentManager());

        mAdapter.addFragment(new DisCoveryItemFragment());
        mAdapter.addFragment(new DisCoveryItemFragment());
        mAdapter.addFragment(new DisCoveryItemFragment());
        mAdapter.addFragment(new DisCoveryItemFragment());

        mAdapter.addTitle("个性推荐");
        mAdapter.addTitle("歌单");
        mAdapter.addTitle("主播电台");
        mAdapter.addTitle("排行榜");

        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
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
