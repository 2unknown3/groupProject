package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.harta.R;

public class RehabCoreBasic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_core_basic);

        TextView msgTitle= (TextView) findViewById(R.id.msgCoreBasicTitle);
        TextView msgCoreBasic1= (TextView) findViewById(R.id.msgCoreBasic1);
        TextView msgCoreBasic2= (TextView) findViewById(R.id.msgCoreBasic2);
        TextView msgCoreBasic3= (TextView) findViewById(R.id.msgCoreBasic3);

        ImageView img1 = (ImageView) findViewById(R.id.imgCoreBasic1);
        ImageView img2 = (ImageView) findViewById(R.id.imgCoreBasic2);
        ImageView img3 = (ImageView) findViewById(R.id.imgCoreBasic3);
        img1.setImageResource(R.drawable.cbasic1);
        img2.setImageResource(R.drawable.cbasic3);
        img3.setImageResource(R.drawable.cbasic3);


        String msgTitletext="Strokes are life-threatening events that can cause irreversible neurological damage, so the recovery period is as much about retraining the brain as it is about strengthening the muscles. " +
                "In order to regain use of your core muscles, you must keep them active in order to create the brain connections you need to improve after a stroke.\n";
        msgTitle.setText(msgTitletext);

        String msgCoreBasic1text="Pelvic floor contractions, also known as Kegels, can help strengthen the muscles on the pelvic floor, which is the muscular base of the abdomen attached to the pelvis.\n" +
                "First, find the muscles by imagining that you are trying to hold urine or stop from passing gas. Squeeze these muscles by lifting and drawing in, then hold for a count of three. Relax then repeat, " +
                "gradually increasing the" +
                " holding time until you can hold for 10 seconds. If at any point you feel the contraction relaxing, let it relax completely and rest for 10 seconds before contracting again. Repeat the exercise 10 times.\n";
        msgCoreBasic1.setText(msgCoreBasic1text);

        String msgCoreBasic2text="Lay on your back with your hands resting at your side. Bend your knees and place your feet flat on the floor. " +
                "Roll your hips so that your knees push to the left, then to the right, then back to center. Repeat 10-20 times.";
        msgCoreBasic2.setText(msgCoreBasic2text);

        String msgCoreBasic3text="Lay on the floor with the hips and feet flat with the knees bent. Keep the pelvis still, using the hands to keep it in place if needed. Inhale, and drop the left knee to the left, " +
                "as far as possible without lifting the pelvis, keeping the knee bent. Exhale, and draw the knee back in. Repeat 5 times per side.";
        msgCoreBasic3.setText(msgCoreBasic3text);
    }
}
