package is.hi.hbv601g.fingerDancer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaplayer;
    private SoundPool sp;
    private int song;
    private int sound1;
    private int sound2;
    private int sound3;
    private int sound5;
    private int sound6;
    private int sound7;
    private int sound8;
    private int sound9;

    private Track track;
    private int score;
    private int combo;
    private int difficulty;
    private int hitTime;
    private int fadeInTime;
    private NoteButton buttons[] = new NoteButton[12];

    track = new Track("Another Day", 198, r.raw.song1);




    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        song = sp.load(getApplicationContext(),R.raw.song1,1);
        sound1 = sp.load(getApplicationContext(),R.raw.sound1,1);
        sound2 = sp.load(getApplicationContext(),R.raw.sound2,1);
        //sound3 = sp.load(getApplicationContext(),R.raw.sound3,1);
        sound5 = sp.load(getApplicationContext(),R.raw.sound5,1);
        sound6 = sp.load(getApplicationContext(),R.raw.sound6,1);
        sound7 = sp.load(getApplicationContext(),R.raw.sound7,1);
        sound8 = sp.load(getApplicationContext(),R.raw.sound8,1);
        sound9 = sp.load(getApplicationContext(),R.raw.sound9,1);
        mediaplayer = MediaPlayer.create(this, R.raw.song1);

        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    sp.play(sound1,1.0f,1.0f,1,1,10f);
                    Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade);
                    button2.startAnimation(animation);
                    return true;
                }
                return false;
            }
        });
    }

    protected void onStart() {
        super.onStart();
        startGame();
    }

    private void startGame() {
        mediaplayer.start();
        score = 0;
        combo = 0;
        difficulty = 1;


    }





    public void openMainActivity(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void backToMenu(View v){
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }

    public void tapOnButton(View v){
        Button button = (Button) findViewById(R.id.button2);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.fade);
        button.startAnimation(animation);
    }

    public void playsound1(View v){
        sp.play(sound1,1.0f,1.0f,1,1,10f);
    }

    public void playsound2(View v){
        sp.play(sound2,1.0f,1.0f,1,1,10f);
    }

    public void playsound3(View v){
        sp.play(sound3,1.0f,1.0f,1,1,10f);

    }

    public void playsound4(View v){
        sp.play(sound3,1.0f,1.0f,1,1,10f);

    }

    public void playsound5(View v){
        sp.play(sound5,1.0f,1.0f,1,1,10f);

    }

    public void playsound6(View v){
        sp.play(sound6,1.0f,1.0f,1,1,10f);

    }

    public void playsound7(View v){
        sp.play(sound7,1.0f,1.0f,1,1,10f);

    }

    public void playsound8(View v){
        sp.play(sound8,1.0f,1.0f,1,1,10f);

    }

    public void playsound9(View v){
        sp.play(sound9,1.0f,1.0f,1,1,10f);

    }

    public void playsound10(View v){
        sp.play(sound1,1.0f,1.0f,1,1,10f);

    }

    public void playsound11(View v){
        sp.play(sound1,1.0f,1.0f,1,1,10f);

    }

    public void playsound12(View v){
        sp.play(sound1,1.0f,1.0f,1,1,10f);

    }


}
