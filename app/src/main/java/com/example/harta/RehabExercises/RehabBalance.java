package com.example.harta.RehabExercises;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.harta.R;


public class RehabBalance extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_balance);

        Button basicBalanceBtn=findViewById(R.id.basicBalanceBtn);
        Button intermediateBalanceBtn=findViewById(R.id.intermediateBalanceBtn);
        Button advanceBalanceBtn=findViewById(R.id.advanceBalanceBtn);

        basicBalanceBtn.setOnClickListener(this);
        intermediateBalanceBtn.setOnClickListener(this);
        advanceBalanceBtn.setOnClickListener(this);

        TextView msgTitle= (TextView) findViewById(R.id.msgBalanceTitle);
        String msgTitletext="If you are struggling to walk or are stumbling often after a stroke, the problem may be muscle weakness, but it could also be your balance." +
                " A stroke damages the brain and weakens the messages your ears, eyes and muscles sent to the neurological system. These messages are essential to maintaining balance." +
                " As the brain begins to repair itself, " +
                "you may notice a return of your coordination and balance. However, residual balance problems may occur, " +
                "especially if the stroke affected your vision, hearing, or the balance control system in the brain.\n";
        msgTitle.setText(msgTitletext);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.basicBalanceBtn:
                Intent intent = new Intent(this, RehabBalanceBasic.class);
                startActivity(intent);
                break;

            case R.id.intermediateBalanceBtn:
                Intent intent1 = new Intent(this, RehabBalanceIntermediate.class);
                startActivity(intent1);
                break;

            case R.id.advanceBalanceBtn:
                Intent intent2 = new Intent(this, RehabBalanceAdvance.class);
                startActivity(intent2);
                break;
        }
    }
}
