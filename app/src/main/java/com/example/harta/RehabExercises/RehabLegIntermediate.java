package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harta.R;


public class RehabLegIntermediate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_leg_intermediate);

        TextView msgTitle = (TextView) findViewById(R.id.msgLegIntermediateTitle);
        TextView msgLegIntermediate1 = (TextView) findViewById(R.id.msgLegIntermediate1);
        TextView msgLegIntermediate2 = (TextView) findViewById(R.id.msgLegIntermediate2);
        TextView msgLegIntermediate3 = (TextView) findViewById(R.id.msgLegIntermediate3);

        ImageView img4 = (ImageView) findViewById(R.id.imgLegIntermediate1);
        ImageView img5 = (ImageView) findViewById(R.id.imgLegIntermediate2);
        ImageView img6 = (ImageView) findViewById(R.id.imgLegIntermediate3);
        img4.setImageResource(R.drawable.lintermediate4);
        img5.setImageResource(R.drawable.lintermediate5);
        img6.setImageResource(R.drawable.lintermediate6);

        String msgTitletext = "Often after a stroke, the hips and the core muscle groups, which are crucial to standing and walking, become weak. " +
                "Bridging exercises help to strengthen these core muscles." +
                " Like the standing and balance exercises, bridging exercises move through a progression to help rebuild your strength and coordination.\n";
        msgTitle.setText(msgTitletext);

        String msgLegIntermediate1text = "The basic bridging exercise, called “Inner Range Quad Movement”, builds strength in the thigh muscles." +
                " To perform this exercise, lay down and place a pillow or rolled towel under the knee joint. " +
                "Then, press the back of the knee into the pillow or rolled towel to lift your heel off the floor.\n";
        msgLegIntermediate1.setText(msgLegIntermediate1text);

        String msgLegIntermediate2text = "“Ski Squats” take bridging exercises to the next level. For this exercise, lean against a flat wall, placing your feet in front of you." +
                " Using the wall to support your weight and your back, slowly bend your knees to lower yourself down. " +
                "Hold this position for 10 seconds, if you can. Slide back up, supporting your weight on the wall, until you are in a standing position.\n";
        msgLegIntermediate2.setText(msgLegIntermediate2text);

        String msgLegIntermediate3text = "To take bridging exercises to the advanced level, repeat the “Ski Squat”," +
                " but place a gym ball between yourself and the wall when you bend your knees into the squat position.\n";
        msgLegIntermediate3.setText(msgLegIntermediate3text);


    }
}