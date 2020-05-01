package com.example.harta;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {

    public static final String EXTRA_AGE = "AGE";

    DatabaseHelper myDB;
    Cursor cursor;
    Button updateBtn;
    EditText editName, editAge, editPhone;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile,container,false);

        updateBtn = view.findViewById(R.id.updateBtn);
        editName = view.findViewById(R.id.editName);
        editAge = view.findViewById(R.id.editAge);
        editPhone = view.findViewById(R.id.editPhoneNumber);

        myDB = new DatabaseHelper(getContext());
        cursor = myDB.getListContent();



        defaultInfo();
        implementListeners();

        return view;
    }

    private void defaultInfo() {
        cursor.moveToNext();
        editName.setText(cursor.getString(1));
        editAge.setText(cursor.getString(2));
        editPhone.setText(cursor.getString(3));
    }

    private void implementListeners() {

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newName = editName.getText().toString(), newAge = editAge.getText().toString(), newPhone = editPhone.getText().toString();
                if(editName.length() != 0 || editAge.length() != 0 || editPhone.length() != 0){
                    upData(newName,newAge,newPhone);
                   // updateBtn.setEnabled(false);
                }
                else{
                    Toast.makeText(getContext(),"Something Went Wrong1!", Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    public void upData(String newName, String newAge, String newPhone){
        boolean updateValue = myDB.updateData(newName,newAge,newPhone);

        if(updateValue){
            Toast.makeText(getContext(),"Update Successfully!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(getContext(),"Something Went Wrong2!", Toast.LENGTH_LONG).show();
        }
    }



}
