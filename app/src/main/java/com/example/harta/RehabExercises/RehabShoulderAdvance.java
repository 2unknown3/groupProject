package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harta.R;


public class RehabShoulderAdvance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_shoulder_advance);

        TextView msgTitle= (TextView) findViewById(R.id.msgShoulderAdvanceTitle);
        TextView msgShoulderAdvance1= (TextView) findViewById(R.id.msgShoulderAdvance1);
        TextView msgShoulderAdvance2= (TextView) findViewById(R.id.msgShoulderAdvance2);

        ImageView img5 = (ImageView) findViewById(R.id.imgShoulderAdvance1);
        ImageView img6 = (ImageView) findViewById(R.id.imgShoulderAdvance2);
        img5.setImageResource(R.drawable.sadvance5);
        img6.setImageResource(R.drawable.sadvance6);

        String msgTitletext="Finally, a couple of advanced exercises are particularly useful for people who can already grasp objects with their affected hand and move their affected shoulder." +
                " If you still haven’t regained complete range of motion in both shoulders, but you have enough strength and function to grab and reach in different directions, you may find these helpful." +
                " To perform them, you’ll need at least five or six cups that can be stacked. Disposable plastic or paper cups are usually the most effective, " +
                "because they’re more lightweight than glasses or hard plastic cups.\n";
        msgTitle.setText(msgTitletext);

        String msgShoulderAdvance1text="Sit at a table and stack the cups right in front of you. Before you begin, remind yourself to keep looking forward throughout the exercise. " +
                "It may help to train your sights on one specific point ahead of you, such as a painting on the wall or your own reflection in the mirror. " +
                "Now, grab the first cup from the stack. While continuing to look forward, pass the cup behind your neck and use your other hand to retrieve it and set it back down on the table." +
                " Continue doing this until you’ve passed the entire stack of cups from one hand to the next.";
        msgShoulderAdvance1.setText(msgShoulderAdvance1text);

        String msgShoulderAdvance2text="Stand in front of the table, or sit on a stool or backless chair. " +
                "Re-stack the cups on the table, and bring the first one behind your waist, passing it along the top of your pants line. " +
                "Retrieve and replace it with the other hand, and repeat.";
        msgShoulderAdvance2.setText(msgShoulderAdvance2text);

    }
}
