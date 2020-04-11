package is.hi.hbv601g.fingerDancer;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import java.util.ArrayList;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

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
    private int sound9x2;

    private int score;
    private int combo;
    private int difficulty;
    private int hitTime;
    private int fadeInTime;
    private NoteButton buttons[] = new NoteButton[12];
    private Track track = new Track("Another Day", 99.0, "r.raw.song1");
    private Timer timer = new Timer(false);
    private Timer timer2;
    private boolean timer2Cancel = false;
    int[] notes = {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0,0,0,1,1,0,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,0,0,0,0,1,0,1,0,1,0,0,0,1,0,1,0,1,0,1,0,1,1,0,1,1,1,1,1,1,0,0,0,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,1,0,0,0,0,1,0};
    //int[] notes = new int[1340];




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
        sound9x2 = sp.load(getApplicationContext(),R.raw.sound9,1);
        mediaplayer = MediaPlayer.create(this, R.raw.song1);

        int lastNote = 0;
        for (int i=0; i<notes.length; i++) {
            if (notes[i] == 1) {
                notes[i] = (int)(Math.random()*12) + 1;
                while (notes[i] == lastNote) {
                    notes[i] = (int)(Math.random()*12) + 1;
                }
                lastNote = notes[i];
            }
        }


        final Button button2 = (Button) findViewById(R.id.button2);
        button2.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN ) {
                    sp.play(sound1,1.0f,1.0f,1,1,1);
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

        final Handler handler = new Handler();
        TimerTask timerTask = new TimerTask() {
            int i = -8;
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        timer2 = new Timer(false);
                        final Handler handler2 = new Handler();
                        final TimerTask timerTask2 = new TimerTask() {
                            int j = 0;
                            @Override
                            public void run() {
                                handler2.post(new Runnable() {
                                    @Override
                                    public void run() {
                                        if (i < 0) {
                                            if (j % 2 == 0) {
                                                sp.play(sound9,0.1f,0.1f,2,0,1);
                                            }
                                        }
                                        else if (notes[i] != 0) {
                                            if (i % 2 == 0) {
                                                sp.play(sound9, 0.5f, 0.5f, 1, 0, 1);
                                            }
                                            else {
                                                sp.play(sound9x2, 0.5f, 0.5f, 1, 0, 1);
                                            }
                                            Button button;
                                            if (notes[i] == 1) button = findViewById(R.id.button1);
                                            else if (notes[i] == 2) button = findViewById(R.id.button2);
                                            else if (notes[i] == 3) button = findViewById(R.id.button3);
                                            else if (notes[i] == 4) button = findViewById(R.id.button4);
                                            else if (notes[i] == 5) button = findViewById(R.id.button5);
                                            else if (notes[i] == 6) button = findViewById(R.id.button6);
                                            else if (notes[i] == 7) button = findViewById(R.id.button7);
                                            else if (notes[i] == 8) button = findViewById(R.id.button8);
                                            else if (notes[i] == 9) button = findViewById(R.id.button9);
                                            else if (notes[i] == 10) button = findViewById(R.id.button10);
                                            else if (notes[i] == 11) button = findViewById(R.id.button11);
                                            else button = findViewById(R.id.button12);
                                            Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade);
                                            button.startAnimation(animation);
                                        }
                                        if (j % 4 == 0 && i >= 0) {
                                            sp.play(sound8,0.5f,0.5f,2,0,1);
                                        }
                                        i++;
                                        j++;
                                        if (j == 16 || timer2Cancel) {
                                            timer2.cancel();
                                        }
                                    }
                                });
                            }
                        };
                        timer2.scheduleAtFixedRate(timerTask2, 0, (Math.round(60*1000/4 / track.getBpm())));
                    }
                });
            }
        };
        track.setOffset(5070);
        long offset = track.getOffset() - Math.round((60*1000*2 / track.getBpm()));
        System.out.println(offset);
        long period = Math.round(60*1000*4 / track.getBpm());
        timer.scheduleAtFixedRate(timerTask, offset, period);
    }



    public void openMainActivity(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    public void backToMenu(View v) {
        mediaplayer.stop();
        timer2Cancel = true;
        timer.cancel();
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }

    @Override
    public void onBackPressed() {
        mediaplayer.stop();
        timer2Cancel = true;
        timer.cancel();
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
