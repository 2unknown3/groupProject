package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.harta.R;


public class RehabArmIntermediate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_arm_intermediate);

        TextView msgTitle= (TextView) findViewById(R.id.msgArmIntermediateTitle);
        TextView msgArmIntermediate1= (TextView) findViewById(R.id.msgArmIntermediate1);
        TextView msgArmIntermediate2= (TextView) findViewById(R.id.msgArmIntermediate2);
        TextView msgArmIntermediate3= (TextView) findViewById(R.id.msgArmIntermediate3);
        ImageView img3 = (ImageView) findViewById(R.id.imgArmIntermediate1);
        ImageView img4 = (ImageView) findViewById(R.id.imgArmIntermediate2);
        ImageView img5 = (ImageView) findViewById(R.id.imgArmIntermediate3);
        img3.setImageResource(R.drawable.aintermediate3);
        img4.setImageResource(R.drawable.aintermediate4);
        img5.setImageResource(R.drawable.aintermediate5);

        String msgTitletext="Once you have gained basic flexibility in the wrist, hand, and inner arm, you are ready to work on a full range of motion for these joints. " +
                "These intermediate-level exercises can be the key to recovering the use of your arms. They help retrain the brain to make up for the neurological damage you have suffered.\n";
        msgTitle.setText(msgTitletext);

        String msgArmIntermediate1text="The elbow stretch focuses on restoring a range of motion to the elbow. This exercise can be done while sitting or standing." +
                " Hold the arm at a comfortable position, then carefully bend and straighten the elbows as if you are doing a dumbbell curl.";
        msgArmIntermediate1.setText(msgArmIntermediate1text);

        String msgArmIntermediate2text="Take up a crawling position with your elbows straight. Gently lean your body backwards, keeping your arm position, until you feel a stretch on your inner arm." +
                " Hold the position and repeat.";
        msgArmIntermediate2.setText(msgArmIntermediate2text);

        String msgArmIntermediate3text="When you are sitting or standing, extend the elbow and rotate your wrist through a full range of motion. " +
                "Continue this exercise a few times to encourage greater motion in the wrist.";
        msgArmIntermediate3.setText(msgArmIntermediate3text);

    }
}
