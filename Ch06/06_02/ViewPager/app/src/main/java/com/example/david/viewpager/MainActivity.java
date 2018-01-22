package com.example.david.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

// This class will display the Fragments in a ViewPager
public class MainActivity extends AppCompatActivity {

    // Get the static data in the form of a list
    private final List<Product> products = DataProvider.productList;

    // Get the size of the list
    private final int numPages = products.size();

    // Declare ViewPager field
    private ViewPager mPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the ViewPager object
        mPager = (ViewPager) findViewById(R.id.pager);

        // Create a ViewPagerAdapter, using the super class PagerAdapter,
        // and passing the method "getSupportFragmentManager()"
        PagerAdapter pagerAdapter = new
                ViewPagerAdapter(getSupportFragmentManager());

        // Use the adapter in the onCreate() method
        // Pass adapter object to the pager
        mPager.setAdapter(pagerAdapter);

    }

    // Create a ViewPager adapter
    private class ViewPagerAdapter extends FragmentStatePagerAdapter {

        public ViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        // The getItem() method will be called each time I navigate to a new page
        // I need to return an instance of a Fragment, and specifically, I'll return
        // an instance of my ItemFragment class.

        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {

            // When the method is called, an integer argument is passed into it
            // called "position", and I'll use that value to get the right object from my
            // list of products, with "products.get(position)"
            // That is how the adapter will go get a Fragment and display it.

            // The ViewPager will create an instance of the ItemFragment.
            // This ItemFragment will have position 1 in the list of products.
            // When the ViewPager is swiped, it will load a new ItemFragment, and the
            // ViewPager will know which one to load by getting the next position from the
            // list of products.
            // As the user swipes, a new ItemFragment instance at the specified position will be created
            // products.get(position) returns a product object from the list of products,
            // specifically for the specific page I am scrolling onto
            // position is the current page the ViewPager is on

            // The ArrayList.get() method is used to get the element of a specified position within the list.
            // Get a product from the list, that is at the position of the ViewPager
            return ItemFragment.newInstance(products.get(position));
        }

        // The getCount() method will be used by the ViewPager automatically to determine
        // how many pages to create.
        @Override
        public int getCount() {

            // Return the size of the list
            return numPages;
        }
    }

}