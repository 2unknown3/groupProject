package com.example.harta;

import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;


public class DailyExerciseFragment extends Fragment {

    TextView timeText, dayText, exeText;

    Cursor data;
    DatabaseHelper myDB;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_daily_exercise,container,false);


        myDB = new DatabaseHelper(getContext());
        data = myDB.getListContent();
        data.moveToNext();

        timeText = view.findViewById(R.id.timeText);
        dayText = view.findViewById(R.id.dayText);
        exeText = view.findViewById(R.id.exeText);

        int age = Integer.parseInt(data.getString(2));

        if(age >= 20 && age <=29){
            timeText.setText("45 - 60 minutes");
            dayText.setText("3");
            exeText.setText("Weight Training followed by Cardio Exercise");
        }

        if(age >= 30 && age <=39){
            timeText.setText("45 - 60 minutes");
            dayText.setText("4");
            exeText.setText("Cardio and Resistance Exercise");
        }
        if(age >= 40 && age <=49){
            timeText.setText("60 minutes");
            dayText.setText("4 - 5");
            exeText.setText("Weight Training and Cadio Exercise");
        }
        if(age >= 50 && age <=59){
            timeText.setText("20 - 40 minutes");
            dayText.setText("4 - 6 Sessions");
            exeText.setText("Cardio Exercise");
        }
        if(age >= 60 && age <= 69){
            timeText.setText("Whenever Possible");
            dayText.setText("3");
            exeText.setText("Slow Cardio Exervise amd Light weight Training");
        }
        if(age >= 70){
            timeText.setText("Whenever Possible");
            dayText.setText("5 - 7");
            exeText.setText("Aerobic and Balance Exervcse");
        }




        return view;
    }

}
