package com.example.android.firstfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */

/*
    To pass Data into a Fragment, you Bundle up the data you want in a Bundle
    object, you pass that that in as the arguments from an Activity, and then
    in the Fragment's onCreate() method or later, you can extract the values by calling
    the getArguments() method.
     */
public class SimpleFragment extends Fragment {

    // In order to pass an argument, you need a String key, and that key is typically
    // defined in the Fragment itself. It has to be available to both the fragment,
    // and to anything in the application that's passing the argument in.
    public static final String MESSAGE_KEY = "message_key";

    public SimpleFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // To get to the arguments, you add code within the fragment itself.
        // You can add code in the onCreate() method, or any other following event.

        // Create View object
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);

        // Get a reference form the arguments that were passed into the fragment
        Bundle arguments = getArguments();

        // If there are arguments in the Bundle
        if (arguments != null) {

            // Extract value from the arguments bundle
            String message = arguments.getString(MESSAGE_KEY);

            // Find the TextView to display the argument data
            TextView tvMessage = (TextView) view.findViewById(R.id.message);

            // Display the value in the TextView
            tvMessage.setText(message);

            // The value that was passed from the Activity is now available
            // within the Fragment
        }

        // Return view object
        return view;
    }

}
