package com.example.android.preferencefragments;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }

    // Method opens a Settings screen and let the user set a value
    public void onSettingsClick(MenuItem item) {

        // Open the Preferences Activity
        Intent intent = new Intent(this, MyPreferencesActivity.class);
        startActivity(intent);
    }

    // Method tests the preference set by the user
    public void onTestPrefClick(MenuItem item) {

        // Get a reference to the preferences for this application
        SharedPreferences preferences = PreferenceManager
                .getDefaultSharedPreferences(this);

        // Retrieve the username from the preferences
        String userName = preferences.getString("username", "not defined");

        // Display the resulting value in a Toast message
        Toast.makeText(this, "User name: " + userName, Toast.LENGTH_SHORT).show();
    }
}
