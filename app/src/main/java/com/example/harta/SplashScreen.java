package com.example.harta;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class SplashScreen extends AppCompatActivity {

    private TextView tv;
    private ImageView iv;
    Cursor cursor;
    DatabaseHelper myDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        iv = findViewById(R.id.hartaLogo);

        myDB = new DatabaseHelper(this);
        cursor = myDB.getListContent();
        if(cursor.getCount() == 0){
            AddData("User1","30","0912345677");
        }

        Animation myanim = AnimationUtils.loadAnimation(this, R.anim.mytransition);
        iv.startAnimation(myanim);

        final Intent i = new Intent(this,MainActivity.class);
        Thread timer = new Thread() {
            public void run() {

                try {
                    sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    startActivity(i);
                    finish();
                }
            }
        };
            timer.start();
    }

    public void AddData(String newName, String newAge, String newPhone){
        boolean insertData = myDB.addData(newName,newAge,newPhone);

        if(insertData){
            Toast.makeText(this,"Update Successfully!", Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(this,"Something Went Wrong2!", Toast.LENGTH_LONG).show();
        }
    }
}
