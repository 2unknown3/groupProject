package com.example.harta;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class DatabaseFragment extends Fragment {

    DatabaseHelper myDB;
    ArrayList<Person> userList;
    ListView listView;
    Person user;
    Cursor data;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.viewcontents2_layout,container,false);

        myDB = new DatabaseHelper(getContext());

        userList = new ArrayList<>();
        data = myDB.getListContent2();



        int numRows = data.getCount();
        if(numRows == 0){
            Toast.makeText(getContext(),"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }else{
            int i=0;
            while(data.moveToNext()){
                user = new Person(data.getString(1),data.getString(2),data.getString(3),data.getString(4));
                userList.add(i,user);
                System.out.println(data.getString(1)+" "+data.getString(2)+" "+data.getString(3)+" "+data.getString(4));
                System.out.println(userList.get(i).getAvgBpm());
                i++;
            }
            FourColumn_ListAdapter adapter =  new FourColumn_ListAdapter(getActivity(),R.layout.fragment_database, userList);
            listView = view.findViewById(R.id.listView2);
            listView.setAdapter(adapter);

        }

        return view;
    }



}
