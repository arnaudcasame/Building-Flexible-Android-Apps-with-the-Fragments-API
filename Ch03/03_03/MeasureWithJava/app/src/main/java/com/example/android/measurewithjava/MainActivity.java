package com.example.android.measurewithjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mOut;

    // boolean to track whether or not to use a fragment on a device
    private  boolean mUseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOut = (TextView) findViewById(R.id.text_out);

    }

    // Method is called when the user presses a button
    public void onMeasureBtnClick(View view) {

        // Create an instance of the ScreenUtility class and pass in the current
        // Activity
        ScreenUtility su = new ScreenUtility(this);

        // Display the resulting dimensions
        mOut.setText(String.format(
                "Width: %s, Height: %s",
                su.getDpWidth(), su.getDpHeight()));

        // Next you have to decide what dimensions you're looking for. A good guideline
        // is if you're working on a large device in landscape mode, then you want to use
        // fragments laid out side by side. But if you're working with a device that's in
        // portrait mode, or a small device in either orientation, then you probably don't
        // want to use that fragment and instead use two separate activities.

        // Threshold for when I want to place fragments side by side, instead of using
        // two different activities
        if (su.getDpWidth() >= 820) {
            mUseFragment = true;
        } else {
            mUseFragment = false;
        }

        // Display results using a Toast message
        Toast.makeText(this, "Using fragment? " + mUseFragment, Toast.LENGTH_SHORT).show();
    }

}
