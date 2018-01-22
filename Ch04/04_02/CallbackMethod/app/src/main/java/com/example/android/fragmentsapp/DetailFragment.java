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

    private EditText textFirstName, textLastName, textAge;

    // Now I need an object that will implement this interface
    // I'll declare an instance of the interface at the top of the class
    private FragmentListener mListener;

    public DetailFragment() {
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

        // Error handling
        // I'm saying if the context isn't an instance of the Fragment Listener,
        // I should throw an assertion
        if (!(context instanceof FragmentListener)) throw new AssertionError();


        // Get the reference to my listener object here
        // I need to cast the context as an instance of the interface
        mListener = (FragmentListener) context;

        // Now I have a reference to my Listener object
        // The next step is to implement that interface in the
        // MainActivity class that contains the Fragment
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_detail, container, false);

        textFirstName = (EditText) rootView.findViewById(R.id.textFirstName);
        textLastName = (EditText) rootView.findViewById(R.id.textLastName);
        textAge = (EditText) rootView.findViewById(R.id.textAge);

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
        // When this method is called, I want to send a message to the containing Activity

    }

    // Define interface
    // This interface will send information to the calling Activity,
    // the first name, last name, and the age
    public interface FragmentListener {
        void onFragmentFinish(String firstName, String lastName, int age);

        // Now I need an object that will implement this interface
        // I'll declare an instance of the interface at the top of the class
    }

}
