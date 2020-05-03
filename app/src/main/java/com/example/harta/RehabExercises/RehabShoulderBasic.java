package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.harta.R;


public class RehabShoulderBasic extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_shoulder_basic);

        TextView msgTitle= (TextView) findViewById(R.id.msgShoulderBasicTitle);
        TextView msgShoulderBasic1= (TextView) findViewById(R.id.msgShoulderBasic1);
        TextView msgShoulderBasic2= (TextView) findViewById(R.id.msgShoulderBasic2);

        ImageView img1 = (ImageView) findViewById(R.id.imgShoulderBasic1);
        ImageView img2 = (ImageView) findViewById(R.id.imgShoulderBasic2);
        img1.setImageResource(R.drawable.sbasic1);
        img2.setImageResource(R.drawable.sbasic2);

        String msgTitletext="Though strokes are life-threatening and often cause irreversible neurological damage, " +
                "you may be able to retrain other regions of your brain to make up for this damage. Your muscles must remain active if you hope to use them again," +
                " and some exercises aim to achieve this specific task. These two basic-level exercises are recommended for people who still struggle to move or use their shoulder after a stroke.\n" +
                "If you have completely or partially lost function or even sensation in one side of your body after your stroke, you still have a very powerful tool at your disposal: " +
                "the other side of your body. The first exercise will help you use your functioning hand to stretch and stimulate your shoulder muscles. The second focuses on your shoulders themselves," +
                " specifically the muscles that allow you to move your shoulder blade on the unaffected side of your body.\n\n";
        msgTitle.setText(msgTitletext);

        String msgShoulderBasic1text="Get a towel and sit down at a table, desk, or other flat surface. Fold or spread the towel, and make sure it’s on the table immediately in front of you. " +
                "Now, place your affected hand on the towel and put your unaffected hand directly on top of it. Apply enough pressure to keep your hands together," +
                " then use your hand to slide the towel away from you, toward the middle of the table.\n" +
                "As your hands move forward, your shoulders will also stretch forward, with the towel reducing friction and allowing your shoulder muscles to stretch and strengthen." +
                " If you feel comfortable leaning forward with your upper body, do so in order to slide the towel even farther forward. If you can do this until your arms are almost " +
                "parallel with your body, the extra movement will allow you to stretch your shoulders at shoulder level, paving the way for a greater range of motion.\n";
        msgShoulderBasic1.setText(msgShoulderBasic1text);

        String msgShoulderBasic2text="Sit or stand in front of a mirror so that you can clearly see your entire upper body. Now, lift your unaffected shoulder up in a shrugging motion, " +
                "just as you would if you didn’t know the answer to a question. Instead of simply letting it drop again, roll your shoulder back. As you do so, your shoulder blades " +
                "should get closer together. Repeat this exercise several times each day.\n\n";
        msgShoulderBasic2.setText(msgShoulderBasic2text);

    }
}
