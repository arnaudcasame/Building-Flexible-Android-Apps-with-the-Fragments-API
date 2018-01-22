package com.example.david.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final List<Product> products = DataProvider.productList;
    private final int numPages = products.size();

    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = (ViewPager) findViewById(R.id.pager);
        PagerAdapter pagerAdapter =
                new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);
    }

    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ItemFragment.newInstance(products.get(position));
        }

        @Override
        public int getCount() {
            return numPages;
        }
    }

    // Method handles when the back button is pressed
    @Override
    public void onBackPressed() {

        // If I'm the first page of the ViewPager ...
        if (mPager.getCurrentItem() == 0) {

            // Exit the application
            super.onBackPressed();

        } else { // If I'm NOT the first page of the ViewPager ...

            // Go back to the previous page, by setting the current item in the
            // ViewPager to the previous item, by subtracting 1 from the current item
            mPager.setCurrentItem(mPager.getCurrentItem() - 1);
        }
    }
}