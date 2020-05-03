package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harta.R;


public class RehabHand extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_hand);

        TextView msgTitle= (TextView) findViewById(R.id.msgHandTitle);
        String msgTitletext="Therapeutic Ball Exercises for Hand Recovery after Stroke\n\n" +
                "Therapeutic balls are extremely useful for building strength and dexterity, especially in the aftermath of a stroke event. They are widely available," +
                " in a range of resistance levels, and affordable.\n\n";
        msgTitle.setText(msgTitletext);

        TextView msgHand1= (TextView) findViewById(R.id.msgHand1);
        TextView msgHand2= (TextView) findViewById(R.id.msgHand2);
        TextView msgHand3= (TextView) findViewById(R.id.msgHand3);
        TextView msgHand4= (TextView) findViewById(R.id.msgHand4);
        TextView msgHand5= (TextView) findViewById(R.id.msgHand5);
        TextView msgHand6= (TextView) findViewById(R.id.msgHand6);


        ImageView img1 = (ImageView) findViewById(R.id.imgHand1);
        ImageView img2 = (ImageView) findViewById(R.id.imgHand2);
        ImageView img3 = (ImageView) findViewById(R.id.imgHand3);
        ImageView img4 = (ImageView) findViewById(R.id.imgHand4);
        ImageView img5 = (ImageView) findViewById(R.id.imgHand5);
        ImageView img6 = (ImageView) findViewById(R.id.imgHand6);
        img1.setImageResource(R.drawable.hhand1);
        img2.setImageResource(R.drawable.hhand2);
        img3.setImageResource(R.drawable.hhand3);
        img4.setImageResource(R.drawable.hhand4);
        img5.setImageResource(R.drawable.hhand5);
        img6.setImageResource(R.drawable.hhand6);


        String msgHand1text="Hold ball tightly in palm of hand. Squeeze the ball, hold, and relax. Repeat ten times, for two sets.\n";
        msgHand1.setText(msgHand1text);

        String msgHand2text="Place ball between bent thumb and extended two fingers of same hand. Extend and straighten the thumb to roll the ball. Repeat ten times, for two sets.";
        msgHand2.setText(msgHand1text);

        String msgHand3text="Hold ball between thumb and index and middle fingers. Squeeze together, hold and relax. Repeat ten times, for two sets.";
        msgHand3.setText(msgHand1text);

        String msgHand4text="Place ball in palm of hand, bringing thumb towards the base of the little finger. Repeat ten times, for two sets.";
        msgHand4.setText(msgHand1text);

        String msgHand5text="Place ball between any two fingers. Squeeze the two fingers together, hold and relax. Repeat ten times, for two sets.";
        msgHand5.setText(msgHand1text);

        String msgHand6text="Place ball on a table. Place tips of fingers on the ball and roll the ball outward on the table. Repeat ten times, for two sets.";
        msgHand6.setText(msgHand1text);


    }
}
