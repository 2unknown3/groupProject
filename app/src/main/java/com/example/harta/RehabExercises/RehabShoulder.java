package com.example.harta.RehabExercises;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.harta.R;


public class RehabShoulder extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_shoulder);

        Button basicShoulderBtn = findViewById(R.id.basicShoulderBtn);
        Button intermediateShoulderBtn = findViewById(R.id.intermediateShoulderBtn);
        Button advanceShoulderBtn = findViewById(R.id.advanceShoulderBtn);

        basicShoulderBtn.setOnClickListener(this);
        intermediateShoulderBtn.setOnClickListener(this);
        advanceShoulderBtn.setOnClickListener(this);

        TextView msgTitle = (TextView) findViewById(R.id.msgShoulderTitle);
        String msgTitletext = "\nRecovering your arm and shoulder movement after a stroke can be challenging." +
                " If you can’t easily grasp and release objects, move your arms forward, or use your arms to support your weight or you’re just starting your recovery." +
                " It’s important to incorporate helpful shoulder exercises for stroke recovery into your daily routine at home.\n";
        msgTitle.setText(msgTitletext);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basicShoulderBtn:
                Intent intent = new Intent(this, RehabShoulderBasic.class);
                startActivity(intent);
                break;

            case R.id.intermediateShoulderBtn:
                Intent intent1 = new Intent(this, RehabShoulderIntermediate.class);
                startActivity(intent1);
                break;

            case R.id.advanceShoulderBtn:
                Intent intent2 = new Intent(this, RehabShoulderAdvance.class);
                startActivity(intent2);
                break;
        }
    }
}
