package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harta.R;


public class RehabLegBasic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_leg_basic);

        TextView msgTitle= (TextView) findViewById(R.id.msgLegBasicTitle);
        TextView msgLegBasic1= (TextView) findViewById(R.id.msgLegBasic1);
        TextView msgLegBasic2= (TextView) findViewById(R.id.msgLegBasic2);
        TextView msgLegBasic3= (TextView) findViewById(R.id.msgLegBasic3);

        ImageView img1 = (ImageView) findViewById(R.id.imgLegBasic1);
        ImageView img2 = (ImageView) findViewById(R.id.imgLegBasic2);
        ImageView img3 = (ImageView) findViewById(R.id.imgLegBasic3);
        img1.setImageResource(R.drawable.lbasic1);
        img2.setImageResource(R.drawable.lbasic2);
        img3.setImageResource(R.drawable.lbasic3);

        String msgTitletext="Balance and coordination are often lost after a stroke. This can make simple actions, like standing and walking, " +
                "difficult. In addition, weakness can occur around the muscles on the exterior of the hip area.\n" +
                "Exercises for standing and balance are vital to helping you regain your quality of life after a stroke. When performing these exercises, always hold onto a table or similar stable surface to avoid a fall.\n\n";
        msgTitle.setText(msgTitletext);

        String msgLegBasic1text="Hold on to a stable surface, standing straight and tall while you transfer your weight to one side. Swing the other leg to the side. Use your balance to hold this position for 10 seconds." +
                " Slowly lower your leg back down. Repeat a few times, as long as you have the strength, and then switch legs.\n";
        msgLegBasic1.setText(msgLegBasic1text);

        String msgLegBasic2text="Once you have mastered the first exercise, move on to the intermediate level. Again, hold on to a stable surface, keeping your back tall and straight. Transfer your weight to one leg," +
                " and bring the other leg up in front of you, bending the knee. Hold this position for a count of 10, and slowly lower it back down. Repeat, then switch legs.";
        msgLegBasic2.setText(msgLegBasic2text);

        String msgLegBasic3text="Finally, progress to the advanced level. This time, stand straight and tall and transfer your weight to one leg. Swing the other leg out behind you as far as you can. Hold for 10 seconds," +
                " if you can, and lower it back down slowly. Repeat and switch legs.\n" +
                "This progression of exercises will strengthen the hip muscle and improve balance, so you can regain normal use of your legs. \n";
        msgLegBasic3.setText(msgLegBasic3text);
    }
}
