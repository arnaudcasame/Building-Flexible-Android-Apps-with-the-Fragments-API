package com.example.android.firstfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    /*
    To pass Data into a Fragment, you Bundle up the data you want in a Bundle
    object, you pass that that in as the arguments from an Activity, and then
    in the Fragment's onCreate() method or later, you can extract the values by calling
    the getArguments() method.
     */


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void clickHandler(View view) {

        // When you are adding a fragment to an activity programmatically, you have
        // an opportunity to pass data to the fragment as arguments. You do this with
        // the Fragment's setArguments() method, which accepts a bundle object.

        // Define an instance of the Bundle class
        Bundle arguments = new Bundle();

        // Define the arguments in a Bundle
        arguments.putString(SimpleFragment.MESSAGE_KEY, "Passed as an argument");

        // Create instance of the Fragment
        SimpleFragment fragment = new SimpleFragment();

        // Pass the arguments to the Fragment
        fragment.setArguments(arguments);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }
}
