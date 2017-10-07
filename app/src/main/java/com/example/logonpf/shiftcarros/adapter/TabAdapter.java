package com.example.logonpf.shiftcarros.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.logonpf.shiftcarros.fragments.PokemonFragment;
import com.example.logonpf.shiftcarros.fragments.StarWarsFragment;

public class TabAdapter extends FragmentStatePagerAdapter {

    public static int TOTAL_ABAS = 2;

    public TabAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        switch (position) {
            case 0:
                fragment = new PokemonFragment();
                break;
            case 1:
                fragment = new StarWarsFragment();
                break;
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return TOTAL_ABAS;
    }
}
