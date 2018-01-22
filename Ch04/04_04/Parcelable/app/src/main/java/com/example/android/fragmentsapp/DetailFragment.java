package com.example.android.fragmentsapp;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class DetailFragment extends Fragment {
    // It is ideal to use the Parcelable interface when you want to take a complex object,
    // and pass it around your application in a Bundle.
    // In this case, as arguments being sent to a fragment.

    // Passing data in as arguments

    // Change the DetailFragment class to use arguments, so that I'm receiving
    // an instance of the Person class. 

    private EditText textFirstName, textLastName, textAge;
    private FragmentListener mListener;

    public DetailFragment() {
    }

    // The new instance method will receive a Person object
    public static DetailFragment newInstance(Person person) {

        // A bundle can pass in simple values, like Strings and numbers, and booleans.
        // But it can't take a complex object like person, unless that object implements
        // an interface named parcelable.

        Bundle args = new Bundle();

        // Once Person is made to be a parcelable object, you can now add it to
        // the arguments to be set on the Fragment
        args.putParcelable("PERSON_KEY", person);
        
        DetailFragment fragment = new DetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        if (!(context instanceof FragmentListener)) throw new AssertionError();
        mListener = (FragmentListener) context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        textFirstName = (EditText) rootView.findViewById(R.id.textFirstName);
        textLastName = (EditText) rootView.findViewById(R.id.textLastName);
        textAge = (EditText) rootView.findViewById(R.id.textAge);

        // Get a reference to the Person object
        Person person = getArguments().getParcelable("PERSON_KEY");

        // Set the values in the TextFields of the Fragment
        textFirstName.setText(person.getFirstName());
        textLastName.setText(person.getLastName());
        textAge.setText(String.valueOf(person.getAge()));

        Button doneButton = (Button) rootView.findViewById(R.id.done_button);
        doneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                done();
            }
        });
        return rootView;
    }

    private void done() {
        if (mListener == null) {
            throw new AssertionError();
        }

        String firstName = textFirstName.getText().toString();
        String lastName = textLastName.getText().toString();
        int age = Integer.valueOf(textAge.getText().toString());

        // Take values and package them into data objects
        Person person = new Person(firstName, lastName, age);

        // Pass the data object to the callback method
        mListener.onFragmentFinish(person);
    }

    public interface FragmentListener {
        void onFragmentFinish(Person person);
    }

}
