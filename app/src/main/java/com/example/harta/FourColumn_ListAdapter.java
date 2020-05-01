package com.example.harta;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.nio.file.attribute.UserDefinedFileAttributeView;
import java.util.ArrayList;

public class FourColumn_ListAdapter extends ArrayAdapter<Person> {

    private LayoutInflater mInflater;
    private ArrayList<Person> users;
    private int mViewResourceId;

    public FourColumn_ListAdapter(Context context, int textViewResourceId, ArrayList<Person> users) {
        super(context, textViewResourceId, users);
        this.users = users;
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mViewResourceId = textViewResourceId;
    }


    @SuppressLint("ViewHolder")
    public View getView(int position, View convertView, ViewGroup parent){
        convertView = mInflater.inflate(mViewResourceId, null);

        Person person = users.get(position);

        if (users != null) {
            TextView avgBpm = convertView.findViewById(R.id.viewAvgBpm);
            TextView maxBpm = convertView.findViewById(R.id.viewMaxBpm);
            TextView minBpm = convertView.findViewById(R.id.viewMinBpm);
            TextView dateBpm = convertView.findViewById(R.id.viewDateBpm);
            if (avgBpm != null) {
                avgBpm.setText(person.getAvgBpm());
            }
            if (maxBpm != null) {
                maxBpm.setText((person.getMaxBpm()));
            }
            if (minBpm != null) {
                minBpm.setText((person.getMinBpm()));
            }
            if (dateBpm != null) {
                dateBpm.setText((person.getDateBpm()));
            }
        }

        return convertView;
    }

}
