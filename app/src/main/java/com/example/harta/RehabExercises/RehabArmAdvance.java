package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harta.R;


public class RehabArmAdvance extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_arm_advance);

        TextView msgTitle= (TextView) findViewById(R.id.msgArmAdvanceTitle);
        TextView msgArmAdvance1= (TextView) findViewById(R.id.msgArmAdvance1);
        TextView msgArmAdvance2= (TextView) findViewById(R.id.msgArmAdvance2);
        TextView msgArmAdvance3= (TextView) findViewById(R.id.msgArmAdvance3);

        ImageView img6 = (ImageView) findViewById(R.id.imgArmAdvance1);
        ImageView img7 = (ImageView) findViewById(R.id.imgArmAdvance2);
        ImageView img8 = (ImageView) findViewById(R.id.imgArmAdvance3);
        img6.setImageResource(R.drawable.aadvance6);
        img7.setImageResource(R.drawable.aadvance7);
        img8.setImageResource(R.drawable.aadvance8);
        String msgTitletext="Muscles damaged due to a stroke are often weakened, mainly due to inactivity. This is why at-home exercise is so important." +
                " Once you have regained range of motion in your arm and wrist, you are ready to begin strengthening the muscles with these advanced exercises.\n";
        msgTitle.setText(msgTitletext);

        String msgArmAdvance1text="In a standing or sitting position, hold a small weight in your hand. Gently bend and straighten the elbow." +
                " Repeat to your endurance point. Over time, increase repetitions as the elbow strengthens.";
        msgArmAdvance1.setText(msgArmAdvance1text);

        String msgArmAdvance2text="Stand facing a wall or a door. Place your fingers gently on the surface of the door or wall." +
                " Walk your fingers up the surface using a spider-like motion, then walk them back down.";
        msgArmAdvance2.setText(msgArmAdvance2text);

        String msgArmAdvance3text="Finally, sit on the ground with your knees bent and your palms on the floor, " +
                "keeping your fingers pointing forward. Push through your hands to cause your bottom to lift off the floor slightly. Repeat as you grow stronger.\n";
        msgArmAdvance3.setText(msgArmAdvance3text);
    }
}
