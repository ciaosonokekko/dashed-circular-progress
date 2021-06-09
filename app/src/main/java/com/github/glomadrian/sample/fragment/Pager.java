package com.github.glomadrian.sample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.github.glomadrian.dashedcircularprogress.DashedCircularProgress;
import com.github.glomadrian.sample.R;

import org.jetbrains.annotations.Nullable;

/**
 * @author Adrián García Lomas
 */
public class Pager extends Fragment {

    private DashedCircularProgress dashedCircularProgress;
    private ViewPager viewPager;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.pager, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        dashedCircularProgress = (DashedCircularProgress) view.findViewById(R.id.simple);
        viewPager = (ViewPager) view.findViewById(R.id.circular_view_pager);
        viewPager.setAdapter(new PagerAdapter(getChildFragmentManager()));
        onSpeed();

        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
                //Empty
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 0) {
                    onSpeed();
                } else if (position == 1) {
                    onStrong();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                //Empty
            }
        });
    }

    private void onSpeed() {
        dashedCircularProgress.setIcon(R.drawable.speed);
        dashedCircularProgress.setValue(46);
    }

    private void onStrong() {
        dashedCircularProgress.setIcon(R.drawable.strong);
        dashedCircularProgress.setValue(68);
    }

    public static Pager getInstance() {
        return new Pager();
    }

    private class PagerAdapter extends FragmentPagerAdapter {

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return new SpeedFragment();
                case 1:
                    return new StrongFragment();
            }

            return new SpeedFragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }

    public static class SpeedFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.speed, container, false);
        }
    }

    public static class StrongFragment extends Fragment {

        @Override
        public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                                 @Nullable Bundle savedInstanceState) {
            return inflater.inflate(R.layout.strong, container, false);
        }
    }

}
