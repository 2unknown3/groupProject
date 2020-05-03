package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.harta.R;

public class RehabCoreIntermediate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_core_intermediate);

        TextView msgTitle = (TextView) findViewById(R.id.msgCoreIntermediateTitle);
        TextView msgCoreIntermediate1 = (TextView) findViewById(R.id.msgCoreIntermediate1);
        TextView msgCoreIntermediate2 = (TextView) findViewById(R.id.msgCoreIntermediate2);
        TextView msgCoreIntermediate3 = (TextView) findViewById(R.id.msgCoreIntermediate3);

        ImageView img4 = (ImageView) findViewById(R.id.imgCoreIntermediate1);
        ImageView img5 = (ImageView) findViewById(R.id.imgCoreIntermediate2);
        ImageView img6 = (ImageView) findViewById(R.id.imgCoreIntermediate3);
        img4.setImageResource(R.drawable.cintermediate4);
        img5.setImageResource(R.drawable.cintermediate5);
        img6.setImageResource(R.drawable.cintermediate6);

        String msgTitletext = "Once you begin building some strength, you are ready to progress in your exercise practice. " +
                "These intermediate exercises will challenge a larger number of core muscles and build even more strength.\n";
        msgTitle.setText(msgTitletext);

        String msgCoreIntermediate1text = "Lay on the exercise mat and place one leg flat on the floor with the knee bent. " +
                "Place the other leg on an exercise ball. Using the core muscles, lift the pelvis off the mat and slowly lower back down. Repeat for 10 repetitions, then switch legs.\n";
        msgCoreIntermediate1.setText(msgCoreIntermediate1text);

        String msgCoreIntermediate2text = "Clams are a great exercise for your core as well as your legs. Lie down on your side with your knees bent, resting one knee on top of the other." +
                " Keeping your feet together, lift the upper knee towards the ceiling and hold your knees apart for 10 seconds." +
                " Next, slowly lower your knee back down. Be careful not to roll your hips back. Repeat 5-10 times on each side.\n";
        msgCoreIntermediate2.setText(msgCoreIntermediate2text);

        String msgCoreIntermediate3text = "Kneel on the ground and place your hands flat on the ground so you are in a crawling stance. " +
                "Contract the pelvic floor and raise one leg while lifting the opposite arm." +
                " Hold for a few seconds, and return to the starting position, repeating with the opposite arm and leg. Repeat for two to three sets of 10 reps each.\n";
        msgCoreIntermediate3.setText(msgCoreIntermediate3text);


    }
}