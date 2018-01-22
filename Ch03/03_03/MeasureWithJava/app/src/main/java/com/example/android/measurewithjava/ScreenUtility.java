package com.example.android.measurewithjava;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

public class ScreenUtility {

    // Fields to hold the dpi for the width and the height
    float dpWidth;
    float dpHeight;

    // Constructor receives a reference to the current Activity
    public ScreenUtility(Activity activity) {

        // Gets the raw dimensions as something called "DisplayMetrics"
        // The DisplayMetrics object represents the size of the screen in physical pixels.
        // But as Android Developers, that's not what we care about.
        // We care about "device independent pixels", and so we have to do a conversion.
        // To do that, we start with Display Metrics, then we find the density,
        // the number of pixels per inch.
        // And then, getting the device independent pixels is a simple matter of division.
        // You divide the physical pixels by the density, and that gives you the device
        // independent pixels.
        // Those values are saved here as fields of this class, and they're made accessible
        // through the public getter methods.

        // Get the Display of the device
        Display display = activity.getWindowManager().getDefaultDisplay();

        // Create DisplayMetrics object to get the raw dimensions of the device
        // Represents the size of the screen in physical pixels
        DisplayMetrics outMetrics = new DisplayMetrics();

        // Call the display's getMetrics() method to get information on the display
        // such as screen size, density, etc.
        display.getMetrics(outMetrics);

        // Get the density of from the display metrics
        // The number of pixels per inch
        float density = activity.getResources().getDisplayMetrics().density;

        // Divide the physical width pixels by the density to get the device independent pixels for the width
        dpWidth = outMetrics.widthPixels / density;

        // Divide the physical height pixels by the density to get the device independent pixels for the height
        dpHeight = outMetrics.heightPixels / density;

        // This class will be used in the MainActivity class.
    }

    // Return the device independent pixels for the width of the device
    public float getDpWidth() {
        return dpWidth;
    }

    // Return the device independent pixels for the height of the device
    public float getDpHeight() {
        return dpHeight;
    }

}
