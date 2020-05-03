package com.example.harta.RehabExercises;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.harta.R;


public class RehabCore extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_core);

        Button basicCoreBtn=findViewById(R.id.basicCoreBtn);
        Button intermediateCoreBtn=findViewById(R.id.intermediateCoreBtn);
        Button advanceCoreBtn=findViewById(R.id.advanceCoreBtn);

        basicCoreBtn.setOnClickListener(this);
        intermediateCoreBtn.setOnClickListener(this);
        advanceCoreBtn.setOnClickListener(this);

        TextView msgTitle= (TextView) findViewById(R.id.msgCoreTitle);
        String msgTitletext="\nAs with any new exercise, stroke victims should talk with their health care provider before attempting any of these. " +
                "If the exercises cause pain, the individual should stop.\n";
        msgTitle.setText(msgTitletext);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.basicCoreBtn:
                Intent intent = new Intent(this, RehabCoreBasic.class);
                startActivity(intent);
                break;

            case R.id.intermediateCoreBtn:
                Intent intent1 = new Intent(this, RehabCoreIntermediate.class);
                startActivity(intent1);
                break;

            case R.id.advanceCoreBtn:
                Intent intent2 = new Intent(this, RehabCoreAdvance.class);
                startActivity(intent2);
                break;
        }
    }
}
