package com.example.android.dialogs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DataEntryDialog extends DialogFragment{

    public static final String PERSON_KEY = "PERSON_KEY";
    EditText etFirstName, etLastName, etAge;

    // Create an instance of the interface listener
    private DataEntryListener mListener;

    // Factory method receives a person data object
    public static DataEntryDialog newInstance(Person person) {

        Bundle args = new Bundle();

        // Add the Person data object that was passed into the factory method
        // to the bundle as a parcelable argument
        args.putParcelable(PERSON_KEY, person);

        DataEntryDialog fragment = new DataEntryDialog();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mListener = (DataEntryListener) context;
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

        // Extract the Person data object from the Bundle
        Person person = getArguments().getParcelable(PERSON_KEY);

        // Populate the fragment's views with the Person object's data
        etFirstName.setText(person.getFirstName());
        etLastName.setText(person.getLastName());
        etAge.setText(String.valueOf(person.getAge()));

        Button btnOk = (Button) rootView.findViewById(R.id.btnOk);
        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Save the data from the EditText fields
                saveData();
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

    private void saveData() {

        // Create a empty Person object
        Person person = new Person();

        // Add data to Person object from the EditText field
        person.setFirstName(etFirstName.getText().toString());
        person.setLastName(etLastName.getText().toString());
        person.setAge(Integer.valueOf(etAge.getText().toString()));

        // Set callback method on listener object passing data back to the listening Activity
        mListener.onDataEntryComplete(person);

        // Remove the Dialog from the screen
        dismiss();
    }

    // Define interface for Activity or Fragment to implement
    public interface DataEntryListener {

        // Method to be overwritten receives a Person object
        void onDataEntryComplete(Person person);
    }
}
