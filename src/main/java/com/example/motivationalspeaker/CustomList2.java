package com.example.motivationalspeaker;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomList2 extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web1;
    private final Integer[] imageId1;
    public CustomList2(Activity context,
                       String[] web, Integer[] imageId) {
        super(context, R.layout.list_single2, web);
        this.context = context;
        this.web1 = web;
        this.imageId1 = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.list_single2, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web1[position]);

        imageView.setImageResource(imageId1[position]);
        return rowView;
    }
}