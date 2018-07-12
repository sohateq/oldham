package com.example.a1.myapplication.item;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.a1.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemFragment extends Fragment {

    int item;
    int position;


    public void setItem(int item){
        this.item = item;
    }

    public void setPosition(int position) {
        this.position = position;
    }
    private int calculateItem(int item, int position){
        switch (item) {
            case 0:
                return position;

            case 1:
                return (11 + position);

            case 2:
                return (13 + position);

            case 3:
                return (16 + position);

            case 4:
                return (21 + position);

            case 5:
                return (22 + position);

            case 6:
                return (24 + position);

            case 7:
                return (25 + position);

            case 8:
                return (26 + position);

        }
        return -1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        TextView textView = view.findViewById(R.id.fragment_text_view);
        ImageView imageView = view.findViewById(R.id.fragment_image_view);
        TextView descriptionView = view.findViewById(R.id.description_text_view);

        int number = calculateItem(item, position);

        Item item = new Item(number, getContext());
        textView.setText(item.getName());
        imageView.setImageResource(item.getPicId());
        descriptionView.setText(item.getDescription());

        return view;
    }

}
