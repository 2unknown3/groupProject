package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harta.R;


public class RehabLegAdvance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_leg_advance);

        TextView msgTitle= (TextView) findViewById(R.id.msgLegAdvanceTitle);
        TextView msgLegAdvance1= (TextView) findViewById(R.id.msgLegAdvance1);
        TextView msgLegAdvance2= (TextView) findViewById(R.id.msgLegAdvance2);
        TextView msgLegAdvance3= (TextView) findViewById(R.id.msgLegAdvance3);

        ImageView img7 = (ImageView) findViewById(R.id.imgLegAdvance1);
        ImageView img8 = (ImageView) findViewById(R.id.imgLegAdvance2);
        ImageView img9 = (ImageView) findViewById(R.id.imgLegAdvance3);
        img7.setImageResource(R.drawable.ladvance7);
        img8.setImageResource(R.drawable.ladvance8);
        img9.setImageResource(R.drawable.ladvance9);


        String msgTitletext="If the lower legs are affected after a stroke, Clams can provide strengthening and improved range of motion. " +
                "Clams focuses on building strength and coordination in the lower leg, increasing range of motion and control.\n";
        msgTitle.setText(msgTitletext);

        String msgLegAdvance1text="Before starting Clams, you must stretch the calf muscle and build coordination in the lower body. " +
                "In sitting helps with this. In a sitting position, create a stirrup around one foot using a towel or belt, placing the stirrup around the ball of the foot. " +
                "Gently pull the stirrup up towards your body to stretch the calf muscle. Then, pull it with the outer hand to turn the foot out, continuing to stretch the muscle.";
        msgLegAdvance1.setText(msgLegAdvance1text);

        String msgLegAdvance2text="Once you have built some flexibility, you are ready for the Clams exercise. Lay down on your side, and bend your knees, resting one on top of the other." +
                " Then, while you keep your feet together, lift the upper knee away from the other knee, holding them apart for a count of 10 seconds. " +
                "Slowly lower your knee back down. While performing this exercise, make sure that you do not roll your hips back.";
        msgLegAdvance2.setText(msgLegAdvance2text);

        String msgLegAdvance3text="After mastering Clams, take it to the next level by lifting the knee and the foot of the upper leg. " +
                "Again, hold the position for a count of 10 seconds. Lower it back down. Repeat a few times to build strength and range of motion.\n";
        msgLegAdvance3.setText(msgLegAdvance3text);
    }
}
