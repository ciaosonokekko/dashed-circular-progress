package com.github.glomadrian.sample;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.github.glomadrian.sample.fragment.Pager;
import com.github.glomadrian.sample.fragment.Simple;
import com.github.glomadrian.sample.fragment.Size;

/**
 * @author Adrián García Lomas
 */
public class Adapter extends FragmentPagerAdapter {
//    private static final int COUNT = 4;
    private static final int COUNT = 3;

    public Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return Simple.getInstance();
            case 1:
                return Pager.getInstance();
            case 2:
                return Size.getInstance();
//            case 3:
//                return DragonBall.getInstance();
        }
        return Simple.getInstance();
    }

    @Override
    public int getCount() {
        return COUNT;
    }
}
