package com.example.journal;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Adapter extends ArrayAdapter<User> {
    public Adapter(@NonNull Context context, @NonNull ArrayList<User> objects) {
        super(context, R.layout.modele_item, objects);;
    }




    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        convertView= LayoutInflater.from(getContext()).inflate(R.layout.modele_item,parent,false);
        TextView name=convertView.findViewById(R.id.name);
        TextView phone=convertView.findViewById(R.id.phone);
        TextView logo=convertView.findViewById(R.id.logo);
        User user=  getItem(position);
        name.setText(user.getName());
        phone.setText(user.getPhone());
        char logo1 = name.getText().charAt(0);
        logo.setText(logo1+"");


        return convertView;

    }
}
