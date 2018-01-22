package com.example.android.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v4.app.DialogFragment;

/**
 * Created by romellbolton on 1/20/18.
 */

// The DialogFragment class is a basic fragment, but it's specifically designed
// to wrap existing dialogues.

// Dialog Fragments give you a way of managing dialogues to make them persist
// even when the device's orientation has changed or other configurations have changed.
// They also give you all the other benefits of fragments including a consistent
// way of communicating with the rest of the application.
public class AlertDialogFragment extends DialogFragment {

    // When I want to display the dialogue, I'll simply create an instance of this
    // class, and then I'll show it. All of the logic about the dialog will be
    // encapsulated within this class.

    // In order to find out what kind of dialog should appear, I'll override
    // a method called onCreateDialog(). This method returns an instance of the
    // Dialog class, and to create it, add code that defines the dialog.

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // Build the Dialog
        AlertDialog alertDialog = new AlertDialog.Builder(
                // Call getActivity() for the Fragment to get a reference to it's containing Activity
                getActivity()).create();

        // Customize the Dialog
        alertDialog.setTitle("Alert");
        alertDialog.setMessage("Here's some important information!");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        // Return the dialog
        return alertDialog;
    }
}
