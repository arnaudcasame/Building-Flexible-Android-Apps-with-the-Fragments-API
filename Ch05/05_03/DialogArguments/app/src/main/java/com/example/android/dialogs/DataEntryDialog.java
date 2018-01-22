package com.example.android.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DataEntryDialog extends DialogFragment{

    // In this class I'm receiving the data in the newInstance() factory method,
    // and I'm displaying the data in the onCreateView() method.

    public static final String PERSON_KEY = "PERSON_KEY";
    EditText etFirstName, etLastName, etAge;

    // Create a newInstance() factory method to receive a Person object
    public static DataEntryDialog newInstance(Person person) {

        Bundle args = new Bundle();

        // Add parcelable Person object to the Fragment's bundle arguments
        args.putParcelable(PERSON_KEY, person);

        DataEntryDialog fragment = new DataEntryDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.data_entry_dialog,
                container, false);

        etFirstName = (EditText) rootView.findViewById(R.id.textFirstName);
        etLastName = (EditText) rootView.findViewById(R.id.textLastName);
        etAge = (EditText) rootView.findViewById(R.id.textAge);

        // Receive data from the Fragments bundle args in onCreate()
        // or onCreateView() method
        Person person = getArguments().getParcelable(PERSON_KEY);

        // Display the Person object's values
        etFirstName.setText(person.getFirstName());
        etLastName.setText(person.getLastName());
        etAge.setText(String.valueOf(person.getAge()));

        Button btnOk = (Button) rootView.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button btnCancel = (Button) rootView.findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }
}
