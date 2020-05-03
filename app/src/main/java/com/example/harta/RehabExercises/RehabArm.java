package com.example.harta.RehabExercises;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.harta.R;


public class RehabArm extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_arm);

        Button basicArmBtn=findViewById(R.id.basicArmBtn);
        Button intermediateArmBtn=findViewById(R.id.intermediateArmBtn);
        Button advanceArmBtn=findViewById(R.id.advanceArmBtn);

        basicArmBtn.setOnClickListener(this);
        intermediateArmBtn.setOnClickListener(this);
        advanceArmBtn.setOnClickListener(this);

        TextView msgTitle= (TextView) findViewById(R.id.msgArmTitle);
        String msgTitletext="\nA stroke can often rob a patient of arm movement, making it difficult to perform simple tasks like moving the arm forward or grasping and releasing objects.\n";
        msgTitle.setText(msgTitletext);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.basicArmBtn:
                Intent intent = new Intent(this, RehabArmBasic.class);
                startActivity(intent);
                break;

            case R.id.intermediateArmBtn:
                Intent intent1 = new Intent(this, RehabArmIntermediate.class);
                startActivity(intent1);
                break;

            case R.id.advanceArmBtn:
                Intent intent2 = new Intent(this, RehabArmAdvance.class);
                startActivity(intent2);
                break;
        }
    }

}
