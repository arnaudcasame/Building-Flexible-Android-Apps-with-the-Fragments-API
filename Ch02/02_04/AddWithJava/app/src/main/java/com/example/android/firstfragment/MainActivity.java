package com.example.android.firstfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Declare Fragment
    private SimpleFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Create an instance of my SimpleFragment class
        fragment = new SimpleFragment();
    }

    public void clickHandler(View view) {

        // Add Fragment to screen when the button is clicked

        // Get a reference to the FragmentManager
        // Begin the transaction
        // Pass the container, and the fragment to put in the container
        // Commit the transaction
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }
}
