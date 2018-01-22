package com.example.android.dialogs;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

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

    private void showDialog() {

        // Create a new instance of the AlertDialogFragment class
        AlertDialogFragment dialogFragment = new AlertDialogFragment();

        // Force the user to interact with the dialog
        dialogFragment.setCancelable(false);

        // The show method of the DialogFragment requires 2 arguments, either a
        // manager or a transaction and then a String which is a tag.
        // The tag is like a request ID that you might use to identify and Intent.
        // It can be used to get a reference to the Fragment later on
        dialogFragment.show(getSupportFragmentManager(), "DIALOG_FRAGMENT");
    }

}
