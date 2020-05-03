package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.harta.R;


public class RehabCoreAdvance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_core_advance);

        TextView msgTitle= (TextView) findViewById(R.id.msgCoreAdvanceTitle);
        TextView msgCoreAdvance1= (TextView) findViewById(R.id.msgCoreAdvance1);
        TextView msgCoreAdvance2= (TextView) findViewById(R.id.msgCoreAdvance2);
        TextView msgCoreAdvance3= (TextView) findViewById(R.id.msgCoreAdvance3);

        ImageView img7 = (ImageView) findViewById(R.id.imgCoreAdvance1);
        ImageView img8 = (ImageView) findViewById(R.id.imgCoreAdvance2);
        ImageView img9 = (ImageView) findViewById(R.id.imgCoreAdvance3);
        img7.setImageResource(R.drawable.cadvance7);
        img8.setImageResource(R.drawable.cadvance8);
        img9.setImageResource(R.drawable.cadvance9);

        String msgTitletext="As you continue to develop your core muscles, you will be ready to add more intensity. " +
                "These advanced exercises increase the intensity of the intermediate exercises so you can regain a strong, healthy core.\n";
        msgTitle.setText(msgTitletext);

        String msgCoreAdvance1text="Lay on an exercise mat with your shoulders and lower back flat on the floor. Support your legs on an exercise ball." +
                " Lift your arms above your head, then use the core muscles to lift your hips off the floor until your body is in a straight line from heels to shoulders." +
                " Slowly lower back down and repeat 10-15 times.";
        msgCoreAdvance1.setText(msgCoreAdvance1text);

        String msgCoreAdvance2text="Lay on the floor and lift the legs off of the ground, holding them in a cycling position. " +
                "Then, cycle as if you are riding a bicycle in the air. Rest and repeat 10 times.";
        msgCoreAdvance2.setText(msgCoreAdvance2text);

        String msgCoreAdvance3text="Imagine superman flying through the air. Now, lay on the floor on your stomach and take this same position, arms and legs extended." +
                " Hold to strengthen the core muscles in your back, and relax. Hold the position for 2-5 seconds and repeat 10 times.\n";
        msgCoreAdvance3.setText(msgCoreAdvance3text);
    }
}
