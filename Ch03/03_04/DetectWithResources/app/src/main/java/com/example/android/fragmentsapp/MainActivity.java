package com.example.android.fragmentsapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.FrameLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Android can measure screen dimensions with resource selectors, that is
    // resource folder names, that provide alternate files to be used when
    // certain conditions are satisfied.

    // The system loads the layout file from the appropriate layout directory
    // based on screen size of the device on which your app is running.

    // Boolean to keep track of whether the device is showing 1 fragment or 2
    private boolean mTablet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Add some logical code in MainActivity to determine at runtime whether I'm
        // working on a large device in landscape orientation.

        // Declare an instance of a FrameLayout
        FrameLayout fragmentContainer =
                (FrameLayout) findViewById(R.id.detail_fragment_container);

        // Next I'll set the value of mTablet by looking at whether I got a null value back.
        // So now I'm saying, if the fragmentContainer object isn't null,
        // then I'm on a tablet, but if it is null, then I'm either on a phone or I'm
        // on a tablet in portrait mode.
        mTablet = (fragmentContainer != null);

        // Next I'll report the results

        // Get TextView reference
        TextView tv = (TextView) findViewById(R.id.textOut);

        // Display the value of mTablet
        tv.setText("Fragments side-by-side? " + mTablet);

        // So now I'm detecting the size of the screen by looking to see what happened
        // as the application framework loaded the layouts.
        // On a phone, or on a tablet in portrait mode, the version "content_main"
        // in the directory "layout" will be used. On a tablet in landscape mode,
        // the "content_main.xml" in the directory "layout-w820dp" will be used.

    }

}
