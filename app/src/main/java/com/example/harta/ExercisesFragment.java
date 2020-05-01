package com.example.harta;

import android.database.Cursor;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class ExercisesFragment extends Fragment {

    BarChart barChart;
    ArrayList<BarEntry> barEntries;
    BarDataSet barDataSet;
    BarData barData;

    DatabaseHelper myDB;
    Cursor data;
    ArrayList<Person> userList;
    Person user;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_exercises,container,false);

        barChart = view.findViewById(R.id.barChart);

        barEntries = new ArrayList<>();
        userList = new ArrayList<>();
        myDB = new DatabaseHelper(getContext());
        data = myDB.getListContent2();
        //data.moveToNext();

        int numRows = data.getCount();

        if(numRows == 0){
            Toast.makeText(getContext(),"The Database is empty  :(.",Toast.LENGTH_LONG).show();
        }
        else{
            int i=0;
            while(data.moveToNext()){
                barEntries.add(new BarEntry(i,Integer.parseInt(data.getString(1))));
                i++;
            }
        }
        barDataSet = new BarDataSet(barEntries,"Beat Per Minute");
        barDataSet.setColors(ColorTemplate.LIBERTY_COLORS);
        barDataSet.setValueTextColor(Color.BLACK);
        barDataSet.setValueTextSize(10f);


        barData = new BarData(barDataSet);

        barChart.setFitBars(true);
        barChart.setDrawValueAboveBar(true);
        barChart.setMaxVisibleValueCount(50);
        barChart.setVisibleXRangeMaximum(barEntries.size());
        barChart.setData(barData);
        barChart.animateY(1000);


        XAxis xAxis = barChart.getXAxis();

        return view;
    }

    public class MyXAxisValueFormatter implements IAxisValueFormatter{

        private String[] mValues;

        public MyXAxisValueFormatter(String[] mValues) {
            this.mValues = mValues;
        }

        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return mValues[(int)value];
        }
    }


}
