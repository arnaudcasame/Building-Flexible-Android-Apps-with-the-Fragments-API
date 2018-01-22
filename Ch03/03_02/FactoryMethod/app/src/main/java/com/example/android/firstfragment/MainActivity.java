package com.example.android.firstfragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickHandler(View view) {

        // Now the precise mechanism for how that data is being worked with
        // is all being handled within the Fragment itself.

        // Create an instance of the Fragment and pass in arguments to it's instantiation method
        SimpleFragment fragment = SimpleFragment.newInstance("Passed to factory method");
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }
}
