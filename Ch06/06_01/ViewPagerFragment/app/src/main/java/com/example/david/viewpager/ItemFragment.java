package com.example.david.viewpager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.NumberFormat;

public class ItemFragment extends Fragment {

    // Persistent field to store a Product object
    private Product mProduct;

    // Constant key for identifying the product
    public static final String PRODUCT_KEY = "product_key";

    // newInstance() method receives an instance of a Product object
    public static ItemFragment newInstance(Product product) {

        Bundle args = new Bundle();

        // Put the Product object into the Bundle
        args.putParcelable(PRODUCT_KEY, product);

        ItemFragment fragment = new ItemFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public ItemFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater
                .inflate(R.layout.fragment_detail, container, false);

        // Get the arguments from the Bundle
        Bundle args = getArguments();

        // Make sure the arguments in the Bundle aren't null
        if (args == null) throw new AssertionError();

        // Assign the value of the arguments to the mProduct field
        mProduct = args.getParcelable(PRODUCT_KEY);

        // Make sure the mProduct field isn't null
        if (mProduct == null) throw new AssertionError();


//      display text and image
        TextView nameText = (TextView) rootView.findViewById(R.id.nameText);
        nameText.setText(mProduct.getName());

        TextView descriptionText = (TextView) rootView.findViewById(R.id.descriptionText);
        descriptionText.setText(mProduct.getDescription());

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        String price = formatter.format(mProduct.getPrice());
        TextView priceText = (TextView) rootView.findViewById(R.id.priceText);
        priceText.setText(price);

        String productId = mProduct.getProductId();
        int imageResource = getActivity().getResources()
                .getIdentifier(productId, "drawable", getActivity().getPackageName());
        ImageView iv = (ImageView) rootView.findViewById(R.id.imageView);
        iv.setImageResource(imageResource);

        return rootView;
    }

}
