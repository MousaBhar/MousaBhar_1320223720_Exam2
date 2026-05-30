package com.example.exam2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class ViewPagerAdapter extends FragmentStateAdapter {

    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0: return TabFragment.newInstance("First Tab");
            case 1: return TabFragment.newInstance("Second Tab");
            case 2: return TabFragment.newInstance("Third Tab");
            default: return TabFragment.newInstance("Tab");
        }
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
