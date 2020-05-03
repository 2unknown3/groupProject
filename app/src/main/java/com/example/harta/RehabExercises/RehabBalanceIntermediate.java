package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.harta.R;


public class RehabBalanceIntermediate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_balance_intermediate);

        TextView msgTitle = (TextView) findViewById(R.id.msgBalanceIntermediateTitle);
        TextView msgBalanceIntermediate1 = (TextView) findViewById(R.id.msgBalanceIntermediate1);
        TextView msgBalanceIntermediate2 = (TextView) findViewById(R.id.msgBalanceIntermediate2);
        TextView msgBalanceIntermediate3 = (TextView) findViewById(R.id.msgBalanceIntermediate3);
        TextView msgBalanceIntermediate4 = (TextView) findViewById(R.id.msgBalanceIntermediate4);

        ImageView img3 = (ImageView) findViewById(R.id.imgBalanceIntermediate1);
        ImageView img4 = (ImageView) findViewById(R.id.imgBalanceIntermediate2);
        ImageView img5 = (ImageView) findViewById(R.id.imgBalanceIntermediate3);
        ImageView img6 = (ImageView) findViewById(R.id.imgBalanceIntermediate4);
        img3.setImageResource(R.drawable.bintermediate3);
        img4.setImageResource(R.drawable.bintermediate4);
        img5.setImageResource(R.drawable.bintermediate5);
        img6.setImageResource(R.drawable.bintermediate6);

        String msgTitletext = "The intermediate level exercises use the same basic ideas as the basic exercises, but without something to hold onto." +
                " After practicing the basic level exercises for a while, you should be able to perform them without assistance. However, for safety, always have a counter " +
                "or chair nearby to grab if you start to lose your balance.\n";
        msgTitle.setText(msgTitletext);

        String msgBalanceIntermediate1text = "3 sets of 10\n" +
                "Stand with your feet flat on the floor and your arms at your sides. Raise yourself to tiptoe, keeping your upper body and knees straight. Slowly lower and repeat.\n";
        msgBalanceIntermediate1.setText(msgBalanceIntermediate1text);

        String msgBalanceIntermediate2text = "3 sets of 10 (1 rep = both feet)\n" +
                "Perform the side step, crossing your legs across each other as you move sideways across a straight line, but without holding on." +
                " Go slowly to avoid a fall, and be ready to grab a hold of something if you lose your balance.\n";
        msgBalanceIntermediate2.setText(msgBalanceIntermediate2text);

        String msgBalanceIntermediate3text = "20 steps (10 for each foot)\n" +
                "Using the straight tape line for side stepping, walk forward, placing the heel of your foot directly in front of the toe of your other foot as you walk." +
                " Continue to the end of the tape, turn, and repeat by returning to the starting point.\n";
        msgBalanceIntermediate3.setText(msgBalanceIntermediate3text);

        String msgBalanceIntermediate4text = "3 sets of 10\n" +
                "Place an exercise ball between your back and a wall, standing tall. Slowly lower into a squatting position, holding on with one hand if needed or not holding on at all." +
                " Roll back up to a standing position and repeat.\n";

        msgBalanceIntermediate4.setText(msgBalanceIntermediate4text);
    }
}