package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.harta.R;

public class RehabShoulderIntermediate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_shoulder_intermediate);

        TextView msgTitle = (TextView) findViewById(R.id.msgShoulderIntermediateTitle);
        TextView msgShoulderIntermediate1 = (TextView) findViewById(R.id.msgShoulderIntermediate1);
        TextView msgShoulderIntermediate2 = (TextView) findViewById(R.id.msgShoulderIntermediate2);

        ImageView img3 = (ImageView) findViewById(R.id.imgShoulderIntermediate1);
        ImageView img4 = (ImageView) findViewById(R.id.imgShoulderIntermediate2);
        img3.setImageResource(R.drawable.sintermediate3);
        img4.setImageResource(R.drawable.sintermediate4);


        String msgTitletext = "These intermediate exercises are ideal if you’ve already made some progress toward shoulder mobility and control. " +
                "If you cannot perform them, you may want to continue repeating the basic-level exercises, but don’t forget to continue making attempts at these exercises too." +
                " They will require a towel, a table, and a cane or any other long, light object.\n";
        msgTitle.setText(msgTitletext);

        String msgShoulderIntermediate1text = "This exercise is very similar to the basic-level towel slide, but it incorporates a bigger range of motion by challenging " +
                "you to stretch your shoulder muscles in more than one direction. Start by sitting at a table with a towel and placing your affected hand on it, as before." +
                " Now use your other hand to slide your hand forward, but don’t simply slide it back toward you. Instead, follow this movement by sliding it from side to side. " +
                "Now slide it back toward you and continue sliding the towel from side to side. Finally, incorporate all of these movements into a series of circular motions, alternating" +
                " between clockwise and counterclockwise.\n";
        msgShoulderIntermediate1.setText(msgShoulderIntermediate1text);

        String msgShoulderIntermediate2text = "You’ll need a cane or lightweight umbrella for this exercise. Hold the cane with both hands in front of your body with your arms bent at " +
                "a 90-degree angle at your sides. Next, push the cane outward to your left and right without dropping your arms, so that the 90-degree angle remains consistent." +
                " This exercise will improve your ability to perform external rotations with your shoulders, which are required for a significant number of everyday tasks.\n";
        msgShoulderIntermediate2.setText(msgShoulderIntermediate2text);




    }
}