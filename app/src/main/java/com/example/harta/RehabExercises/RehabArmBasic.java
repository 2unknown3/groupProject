package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.harta.R;


public class RehabArmBasic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_arm_basic);


        TextView msgTitle= (TextView) findViewById(R.id.msgArmBasicTitle);
        TextView msgArmBasic1= (TextView) findViewById(R.id.msgArmBasic1);
        TextView msgArmBasic2= (TextView) findViewById(R.id.msgArmBasic2);

        ImageView img1 = (ImageView) findViewById(R.id.imgArmBasic1);
        ImageView img2 = (ImageView) findViewById(R.id.imgArmBasic2);
        img1.setImageResource(R.drawable.abasic1);
        img2.setImageResource(R.drawable.abasic2);

        String msgTitletext="Strokes are a frightening, life-threatening medical condition, but once you begin recovering you will experience the impact on your quality of life caused by neurological damage. " +
                "It’s possible to retrain the brain to make up for this damage, but you must keep the affected muscle groups active. These basic level exercises are a starting point to add flexibility and " +
                "mobility to your affected arm after a stroke.\n";
        msgTitle.setText(msgTitletext);

        String msgArmBasic1text="For this exercise, place your hands palms down on the table and rotate your wrist so your fingers point towards your body." +
                " Keeping your elbows straight, slowly move your body backwards until you feel a stretch on the inside of the arm. Lean on the table for support if you need to.";
        msgArmBasic1.setText(msgArmBasic1text);

        String msgArmBasic2text="For this exercise, place your forearm on the table, with the hand over the edge of the table, palm down. First, drop the hand down, using your other hand to gently stretch the ligaments and muscles." +
                " Then, leaving your forearm on the table, lift the wrist up, down and sideways, gently stretching the extended wrist with the other hand.";
        msgArmBasic2.setText(msgArmBasic2text);
    }
}
