package com.example.android.firstfragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // You can also keep track of fragments with tags
    // A tag is a String that you can use when you add the fragment,
    // and you can use later on again, to identify, and get a reference
    // to the fragment.
    public static final String FRAGMENT_TAG = "fragment_tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void addClickHandler(View view) {

        SimpleFragment fragment = new SimpleFragment();

        // Assign a tag, when creating the Fragment
        getSupportFragmentManager()
                .beginTransaction()
                // call addToBackStack() when you create the fragment to let the user remove a
                // recently added fragment by touching the device's back button.
                // reverses the operation of the fragment
                .addToBackStack(null)
//                .add(R.id.fragment_container, fragment)
                // Add TAG to the Fragment to get it's reference later
                .add(R.id.fragment_container, fragment, FRAGMENT_TAG)
                .commit();
    }

    public void removeClickHandler(View view) {

        // Use the tag to identify the fragment and get it's reference

        // Get reference to the fragment by getting it's container's ID,
        // or by using the Fragment's specific TAG that was applied to it when creating it
        Fragment fragment =
                getSupportFragmentManager()
//                        .findFragmentById(R.id.fragment_container); // Find fragment by it's container
                            .findFragmentByTag(FRAGMENT_TAG); // Find fragment by it's TAG

        // If the fragment is present, remove it
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .remove(fragment)
                    .commit();
        }
    }
}
