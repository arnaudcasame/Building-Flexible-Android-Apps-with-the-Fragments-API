package com.example.android.dialogs;

import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by romellbolton on 1/20/18.
 */

/*
Creating a custom dialog is a mixture of creating a simple dialog, and creating a
fragment. For the custom dialog you start with an XML layout file that describes the dialog's
appearance, and then you go and get that layout file in the onCreateView() method.
You set up whatever events you need to manage the dialog at run time, and your dialog
will behave as you need it to, persisting between configuration changes, and either presenting
data or collecting data from the user.
 */

// Extends DialogFragment
public class DataEntryDialog extends DialogFragment  {

    // Instead of overriding onCreateDialog(), I'll override onCreateView()
    // The code is now just like I'm working in a standard fragment. I'll inflate
    // the layout file, and then return the resulting view after manipulating the view
    // however I need to.

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        // Inflate the custom dialog layout
        View rootView = inflater.inflate(R.layout.data_entry_dialog,
                container, false);

        // Make sure I'm reacting to the buttons in the layout by dismissing the buttons when they are pressed
        Button btnOk = rootView.findViewById(R.id.btnOk);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the dialog
                dismiss();
            }
        });

        Button btnCancel = rootView.findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Close the dialog
                dismiss();
            }
        });

        // Return the rootView
        return rootView;
    }
}
