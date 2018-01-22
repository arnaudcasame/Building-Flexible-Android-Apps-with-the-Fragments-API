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
public class SimpleFragment extends Fragment {

    public static final String MESSAGE_KEY = "message_key";

    public SimpleFragment() {
        // Required empty public constructor
    }

    // New instance method that returns a new Instance of this class
    // This method will accept an argument from the newInstance() method
    // a String message
    public static SimpleFragment newInstance(String message) {

        // There's already code here in place to create a Bundle, and pass
        // the bundle into the fragment as its arguments

        // To use this method, go to the MainActivity class

        // Create a Bundle object
        Bundle args = new Bundle();

        // Put arguments into the Bundle
        args.putString(SimpleFragment.MESSAGE_KEY, message);

        // Create an instance of the Fragment class
        SimpleFragment fragment = new SimpleFragment();

        // Pass the arguments to the Fragment
        fragment.setArguments(args);

        // Return the instance of the fragment
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_simple, container, false);

        Bundle arguments = getArguments();
        if (arguments != null) {
            String message = arguments.getString(MESSAGE_KEY);
            TextView tvMessage = (TextView) view.findViewById(R.id.message);
            tvMessage.setText(message);
        }

        return view;
    }

}
