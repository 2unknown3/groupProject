package com.example.harta.RehabExercises;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.harta.R;


public class RehabLeg extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_leg);

        Button basicLegBtn = findViewById(R.id.basicLegBtn);
        Button intermediateLegBtn = findViewById(R.id.intermediateLegBtn);
        Button advanceLegBtn = findViewById(R.id.advanceLegBtn);

        basicLegBtn.setOnClickListener(this);
        intermediateLegBtn.setOnClickListener(this);
        advanceLegBtn.setOnClickListener(this);

        TextView msgTitle = (TextView) findViewById(R.id.msgLegTitle);
        String msgTitletext = "\nStroke recovery can be a long process. Managing the ongoing need to rebuild bodily control and strength after neurological damage is no easy task." +
                " If you have suffered from a stroke, loss of balance and control can make standing and walking difficult." +
                " While outpatient stroke recovery therapy is vital to improving this problem, you can also continue improving after returning home with the help of these leg exercises for stroke recovery.\n";
        msgTitle.setText(msgTitletext);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basicLegBtn:
                Intent intent = new Intent(this, RehabLegBasic.class);
                startActivity(intent);
                break;

            case R.id.intermediateLegBtn:
                Intent intent1 = new Intent(this, RehabLegIntermediate.class);
                startActivity(intent1);
                break;

            case R.id.advanceLegBtn:
                Intent intent2 = new Intent(this, RehabLegAdvance.class);
                startActivity(intent2);
                break;
        }
    }
}