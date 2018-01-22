package com.example.android.preferencefragments;

import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

// The purpose of using Fragments in this context is that, just like with dialogs,
// the fragment wrapper lets the application framework correctly manager changes in
// orientation, and other configurations. It takes a little more work to wrap your preferences
// in fragments in this way, but it makes your preferences interfaces very stable, and
// very usable.

// This Activity contains the fragment which is added to the base content
// of the Activity itself
public class MyPreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Add the Fragment to the Activity
        getFragmentManager()
                .beginTransaction()
                .replace(
                        // ID refers to the entire container of the Activity
                        // Not a custom layout file
                        android.R.id.content,
                        // Pass a new instance of the MyPreferenceFragment class
                        new MyPreferenceFragment())
                .commit();
    }

    // UI for this Activity will be defined by a Preferences Fragment
    // Extends the superclass "PreferenceFragment"
    public static class MyPreferenceFragment extends PreferenceFragment {

        // When the fragment is created, the onCreate() method will be called
        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);

            // Inflate the preference XML resource
            addPreferencesFromResource(R.xml.preferences);

            // Now I have a fragment that wraps the preferences screen, and I'm
            // ready to use it in my Activity.
        }
    }
}
