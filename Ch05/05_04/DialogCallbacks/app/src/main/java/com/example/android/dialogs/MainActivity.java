package com.example.android.dialogs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DataEntryDialog.DataEntryListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab == null) throw new AssertionError();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDialog();
            }
        });
    }

    // Method passes a data object as an argument to a Dialog Fragment,
    // and then shows it on the screen
    private void showDialog() {

        // Create a Person data object
        Person p = new Person("Mickey", "Mouse", 35);

        // Instantiate a DataEntryDialog, passing the person data object
        // as an argument to it's factory method
        DataEntryDialog dialog = DataEntryDialog.newInstance(p);

        // Show the dialog
        dialog.show(getSupportFragmentManager(), "DIALOG_FRAGMENT");
    }

    // Callback method receives Person object from the Fragment
    @Override
    public void onDataEntryComplete(Person person) {

        // Display the Person object's data received from the Fragment
        Toast.makeText(this, "You entered " + person.getFirstName()
                + " " + person.getLastName(), Toast.LENGTH_SHORT).show();
    }
}
