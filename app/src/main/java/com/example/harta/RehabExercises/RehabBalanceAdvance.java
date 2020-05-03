package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.ImageView;

import com.example.harta.R;


public class RehabBalanceAdvance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_balance_advance);

        TextView msgTitle= (TextView) findViewById(R.id.msgBalanceAdvanceTitle);
        TextView msgBalanceAdvance1= (TextView) findViewById(R.id.msgBalanceAdvance1);
        TextView msgBalanceAdvance2= (TextView) findViewById(R.id.msgBalanceAdvance2);
        TextView msgBalanceAdvance3= (TextView) findViewById(R.id.msgBalanceAdvance3);

        ImageView img7 = (ImageView) findViewById(R.id.imgBalanceAdvance1);
        ImageView img8 = (ImageView) findViewById(R.id.imgBalanceAdvance2);
        ImageView img9 = (ImageView) findViewById(R.id.imgBalanceAdvance3);
        img7.setImageResource(R.drawable.badvance7);
        img8.setImageResource(R.drawable.badvance8);
        img9.setImageResource(R.drawable.badvance9);

        String msgTitletext="Once you start noticing improved balance, do not stop exercising. You are still building those connections. Now it’s time to move on to advanced level exercises.\n";
        msgTitle.setText(msgTitletext);

        String msgBalanceAdvance1text="3 sets of 5\n" +
                "Place both feet flat on the floor. Slowly lift one leg until you are balanced on the other leg. Hold for a count of 10, and slowly lower it back down. Alternate legs and repeat.\n";
        msgBalanceAdvance1.setText(msgBalanceAdvance1text);

        String msgBalanceAdvance2text="20 steps\n" +
                "In a room that is free from obstacles, walk backwards slowly. Try to avoid looking where you are going, but use your sense of balance and slow movements to avoid a fall." +
                " At first, perform this exercise with something closely to hold onto like a wall or countertop until you gain confidence in your abilities.\n";
        msgBalanceAdvance2.setText(msgBalanceAdvance2text);

        String msgBalanceAdvance3text="3 sets of 10\n" +
                "Using a weighted exercise ball, slowly pass the ball from hand to hand as you circle it around your body. Start by circling the body in a clockwise motion." +
                " Then, repeat in a counter-clockwise motion. Perform this exercise while standing.\n";
        msgBalanceAdvance3.setText(msgBalanceAdvance3text);
    }
}
