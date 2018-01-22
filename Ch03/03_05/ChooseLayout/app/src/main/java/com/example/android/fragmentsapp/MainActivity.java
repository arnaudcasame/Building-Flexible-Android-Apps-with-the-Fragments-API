package com.example.android.fragmentsapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private boolean mTablet;
    private ViewGroup fragmentContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fragmentContainer = (ViewGroup) findViewById(R.id.detail_fragment_container);
        mTablet = (fragmentContainer != null);

        TextView tvOut = (TextView) findViewById(R.id.textOut);
        tvOut.setText("Fragments side-by-side? " + mTablet);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewDetailFragment();
            }
        });

    }

    // Method is executed when the FAB is pressed
    private void viewDetailFragment() {

        if (mTablet) { // If I'm on a tablet

            // I'll see that fragment within the current Activity.

            // Get a reference to a FragmentManager
            FragmentManager fragmentManager =
                    getSupportFragmentManager();

            // Create an instance of the DetailActivityFragment
            DetailActivityFragment fragment = new DetailActivityFragment();

            // Add that Fragment to the current Activity so 2 fragments are
            // showing side by side
            fragmentManager.beginTransaction()
                    .add(R.id.detail_fragment_container, fragment)
                    .commit();

        } else { // If I'm not on a tablet, specifically in landscape orientation

            // Go to a separate Activity and see the same content (Detail Activity Fragment only)
            Intent intent = new Intent(this, DetailActivity.class);
            startActivity(intent);
        }
    }

}
