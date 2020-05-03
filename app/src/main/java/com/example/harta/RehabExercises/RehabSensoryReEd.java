package com.example.harta.RehabExercises;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.harta.R;


public class RehabSensoryReEd extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rehab_sensory_re_ed);


        TextView msgTitle= (TextView) findViewById(R.id.msgSensoryTitle);
        TextView msgSensory1= (TextView) findViewById(R.id.msgSensory1);
        TextView msgSensory2= (TextView) findViewById(R.id.msgSensory2);
        TextView msgSensory3= (TextView) findViewById(R.id.msgSensory3);
        TextView msgSensory4= (TextView) findViewById(R.id.msgSensory4);
        TextView msgSensory5= (TextView) findViewById(R.id.msgSensory5);

        String msgTitletext="The Cause of Sensory Changes after Stroke\n\n" +
                "If stroke damaged the part of your brain that is responsible for interpreting your senses, then you may develop sensory issues after stroke. Specifically," +
                " sensory issues arise from damage to the right side of the brain or the parietal and occipital lobes.";
        msgTitle.setText(msgTitletext);

        String msgSensory1text="Gather together objects with different textures and place them onto a table in front of you. Then, without looking at the objects," +
                " pick them up and feel them. Try to distinguish the difference between textures. Some examples of objects to grab are soft scarves, rough sandpaper," +
                " fluffy cotton balls, rough Velcro, and cool silverware.";
        msgSensory1.setText(msgSensory1text);

        String msgSensory2text="Fill a bowl with uncooked rice and bury different textured objects in it, like marbles, coins, Velcro strips, cotton balls, etc." +
                " Then, reach your hand into the bowl and try to find the objects without looking.";
        msgSensory2.setText(msgSensory2text);

        String msgSensory3text="Have someone place different objects in your hand with your eyes open. Sense how these objects feel." +
                " Once you’ve gone through all the objects and observed how they feel, perform the exercise again with your eyes closed." +
                " Put all your focus into feeling each object to emphasize that connection in your mind. Note any difference between how the objects feel with your eyes open or closed.";
        msgSensory3.setText(msgSensory3text);

        String msgSensory4text="This exercise is particularly beneficial to stroke survivors who have trouble feeling heat or cold. Soak a cloth in cold water and soak another cloth in hot (but not scalding) water." +
                " Then, have someone place the cold cloth on your arm. Try to sense what that feels like.\n\n" +
                "After 30 seconds, have them switch the cold cloth with the warm cloth. Try to sense the difference in temperature. Then, close your eyes." +
                " Have your assistant place one cloth on your arm and try to determine if you’re feeling heat or cold. Repeat this exercise back and forth alternating from hot to cold. " +
                "If you don’t have an assistant, you can perform this exercise yourself using your unaffected side to place the cloths on your arm.";
        msgSensory4.setText(msgSensory4text);

        String msgSensory5text="Close your eyes and have a caregiver place her hand somewhere on your arm. Then, point to the area that you think she touched." +
                " If you don’t point to the correct area, have your caregiver move your hand. Then, open your eyes to visually absorb the information. Feedback like this helps retrain your brain. " +
                "It’s like telling your brain, “I was not touched here, I was touched there.” Repeat this exercise at least 10 times, preferably more!\n\n" +
                "Once you master this exercise, switch it up by having your assistant touch you with different textured objects, like a Q-tip or metal spoon. " +
                "Always keep your eyes closed during the exercise, and if you perform the exercise incorrectly," +
                " open your eyes once your caregiver moves your finger to absorb the feedback.\n\n";
        msgSensory5.setText(msgSensory5text);








    }
}
