package is.hi.hbv601g.fingerDancer;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Timer;
import java.util.TimerTask;


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
    private int miss;

    int[] buttons = new int[]{R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5, R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10, R.id.button11, R.id.button12};
    private boolean[] buttonIsActivated = new boolean[12];
    //private NoteButton buttons[] = new NoteButton[12];

    private int score;
    private int combo;
    private int difficulty;
    private int hitAccuracy;
    private int lifebar = 100;
    private int fadeInTime;

    private Track track = new Track("Another Day", 99.0, "r.raw.song1");
    int[] notes = {1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,1,0,0,0,0,1,0,0,0,1,1,1,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,1,1,0,0,1,0,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,1,1,0,0,1,0,0,1,0,1,0,0,0,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,0,1,0,1,0,0,1,0,0,1,0,1,0,1,0,1,0,1,0,1,0,0,0,0,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,0,0,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,1,1,0,1,0,1,0,1,0,1,0,0,0,1,0,1,1,1,0,0,0,1,0,0,0,1,0,0,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,1,1,0,1,0,1,0,1,1,1,0,1,0,1,0,1,0,1,1,1,1,1,0,1,0,1,0,1,0,1,0,1,0,1,0,1,1,1,1,1,1,1,0,1,0,0,0,0,0,1,0,0,0,1,1,1,0,1,0,0,1,0,0,0,0,1,0,0,0,1,0,1,1,1,0,0,0,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,1,0,0,0,1,0,0,0,1,0,0,0,1,1,1,1,1,0,0,0,1,0,1,1,1,0,1,0,1,0,1,1,1,0,0,1,0,0,1,0,1,0,0,0,1,0,0,0,1,0,0,0,0,0,0,0,0};

    private Timer timer = new Timer(false);
    private Timer timer2;
    private boolean timer2Cancel = false;





    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = new SoundPool(12, AudioManager.STREAM_MUSIC,0);
        song = sp.load(getApplicationContext(),R.raw.song1,1);
        sound1 = sp.load(getApplicationContext(),R.raw.sound1,1);
        sound6 = sp.load(getApplicationContext(),R.raw.sound6,1);
        sound8 = sp.load(getApplicationContext(),R.raw.sound8,1);
        sound9 = sp.load(getApplicationContext(),R.raw.sound9,1);
        sound9x2 = sp.load(getApplicationContext(),R.raw.sound99,1);
        miss = sp.load(getApplicationContext(),R.raw.soundmiss,1);
        mediaplayer = MediaPlayer.create(this, R.raw.song1);

        int lastNote1 = 0;
        int lastNote2 = 0;
        for (int i=0; i<notes.length; i++) {
            if (notes[i] == 1) {
                if (i != 0 && notes[i-1] != 0) {
                    notes[i] = 0;
                    while (notes[i] == 0) {
                        int r2 = (int) (Math.random()*2);
                        int r3 = (int) (Math.random()*3);
                        int r4 = (int) (Math.random()*4);
                        if (lastNote1 == 1) { if (r2 == 0 && lastNote2 != 2) notes[i] = 2; else if (r2 == 1 && lastNote2 != 4) notes[i] = 4; }
                        else if (lastNote1 == 2) { if (r3 == 0 && lastNote2 != 1) notes[i] = 1; else if (r3 == 1 && lastNote2 != 3) notes[i] = 3; else if (r3 == 2 && lastNote2 != 5) notes[i] = 5; }
                        else if (lastNote1 == 3) { if (r2 == 0 && lastNote2 != 2) notes[i] = 2; else if (r2 == 1 && lastNote2 != 6) notes[i] = 6; }
                        else if (lastNote1 == 4) { if (r3 == 0 && lastNote2 != 1) notes[i] = 1; else if (r3 == 1 && lastNote2 != 5) notes[i] = 5; else if (r3 == 2 && lastNote2 != 7) notes[i] = 7; }
                        else if (lastNote1 == 5) { if (r4 == 0 && lastNote2 != 2) notes[i] = 2; else if (r4 == 1 && lastNote2 != 4) notes[i] = 4; else if (r4 == 2 && lastNote2 != 6) notes[i] = 6; else if (r4 == 3 && lastNote2 != 8) notes[i] = 8; }
                        else if (lastNote1 == 6) { if (r3 == 0 && lastNote2 != 3) notes[i] = 3; else if (r3 == 1 && lastNote2 != 5) notes[i] = 5; else if (r3 == 2 && lastNote2 != 9) notes[i] = 9; }
                        else if (lastNote1 == 7) { if (r3 == 0 && lastNote2 != 4) notes[i] = 4; else if (r3 == 1 && lastNote2 != 8) notes[i] = 8; else if (r3 == 2 && lastNote2 != 10) notes[i] = 10; }
                        else if (lastNote1 == 8) { if (r4 == 0 && lastNote2 != 5) notes[i] = 5; else if (r4 == 1 && lastNote2 != 7) notes[i] = 7; else if (r4 == 2 && lastNote2 != 9) notes[i] = 9; else if (r4 == 3 && lastNote2 != 11) notes[i] = 11; }
                        else if (lastNote1 == 9) { if (r3 == 0 && lastNote2 != 6) notes[i] = 6; else if (r3 == 1 && lastNote2 != 8) notes[i] = 8; else if (r3 == 2 && lastNote2 != 12) notes[i] = 12; }
                        else if (lastNote1 == 10) { if (r2 == 0 && lastNote2 != 7) notes[i] = 7; else if (r2 == 1 && lastNote2 != 11) notes[i] = 11; }
                        else if (lastNote1 == 11) { if (r3 == 0 && lastNote2 != 8) notes[i] = 8; else if (r3 == 1 && lastNote2 != 10) notes[i] = 10; else if (r3 == 2 && lastNote2 != 12) notes[i] = 12; }
                        else { if (r2 == 0 && lastNote2 != 9) notes[i] = 9; else if (r2 == 1 && lastNote2 != 11) notes[i] = 11; }
                    }
                }
                else {
                    notes[i] = (int) (Math.random() * 12) + 1;
                    while (notes[i] == lastNote1 || notes[i] == lastNote2) {
                        notes[i] = (int) (Math.random() * 12) + 1;
                    }
                }
                lastNote2 = lastNote1;
                lastNote1 = notes[i];
            }
        }

        for (int i=0; i<12; i++) {
            final Button button = findViewById(buttons[i]);
            final int finalI = i;
            button.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if (event.getAction() == MotionEvent.ACTION_DOWN) {
                        if (buttonIsActivated[finalI]) {
                            lifebarIncrement(10);
                            score += 100 * (1 + combo * 0.20);
                            combo += 1;
                            buttonIsActivated[finalI] = false;
                        }
                        else {
                            miss();
                            sp.play(miss, 0.5f, 0.5f, 1, 0, 1);
                            @SuppressLint("ResourceType") AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_miss);
                            set.setTarget(findViewById(buttons[finalI]));
                            set.start();
                        }
                        updateScore();
                        updateCombo();
                        return true;
                    }
                    return false;
                }
            });
        }
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
        hitAccuracy = 500;
        track.setOffset(5070);

        final Handler lifebaStarter = new Handler();
        lifebaStarter.postDelayed(new Runnable() {
            @Override
            public void run() {
                startLifebar();
            }
        }, track.getOffset());

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
                                    @SuppressLint("ResourceType")
                                    @Override
                                    public void run() {
                                        if (i >= notes.length) {
                                            System.out.println("Song finished!");
                                            //finishGame();
                                        }
                                        if (i < 0) {
                                            if (j % 2 == 0) {
                                                sp.play(sound9,0.1f,0.1f,2,0,1);
                                            }
                                        }
                                        else if (notes[i] != 0) {
                                            if (i % 4 == 0) {
                                                sp.play(sound9, 0.5f, 0.5f, 1, 0, 1);
                                            }
                                            else if (i % 2 == 0) {
                                                sp.play(sound9x2, 0.35f, 0.35f, 1, 0, 1);
                                            }
                                            else {
                                                sp.play(sound6, 0.2f, 0.2f, 1, 0, 1);
                                                sp.play(sound9x2, 0.15f, 0.15f, 1, 0, 1);
                                            }
                                            if (j % 4 == 0 && i >= 0) {
                                                if (j % 8 == 0) {
                                                    sp.play(sound8, 0.6f, 0.6f, 1, 0, 1);
                                                    sp.play(sound1, 0.20f, 0.20f, 1, 0, 1);
                                                }
                                                else {
                                                    sp.play(sound8, 0.35f, 0.35f, 1, 0, 1);
                                                    sp.play(sound1, 0.35f, 0.35f, 1, 0, 1);
                                                }
                                            }
                                            //Button button;
                                            AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_white);
                                            if (notes[i] == 1) set.setTarget(findViewById(R.id.button1)); //button = findViewById(R.id.button1);
                                            else if (notes[i] == 2) set.setTarget(findViewById(R.id.button2));
                                            else if (notes[i] == 3) set.setTarget(findViewById(R.id.button3));
                                            else if (notes[i] == 4) set.setTarget(findViewById(R.id.button4));
                                            else if (notes[i] == 5) set.setTarget(findViewById(R.id.button5));
                                            else if (notes[i] == 6) set.setTarget(findViewById(R.id.button6));
                                            else if (notes[i] == 7) set.setTarget(findViewById(R.id.button7));
                                            else if (notes[i] == 8) set.setTarget(findViewById(R.id.button8));
                                            else if (notes[i] == 9) set.setTarget(findViewById(R.id.button9));
                                            else if (notes[i] == 10) set.setTarget(findViewById(R.id.button10));
                                            else if (notes[i] == 11) set.setTarget(findViewById(R.id.button11));
                                            else set.setTarget(findViewById(R.id.button12));
                                            set.start();
                                            //Animation animation = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_white);
                                            //animation.setTarget(findViewById(R.id.button11));
                                            //button.startAnimation(animation);
                                        }
                                        else if (j % 4 == 0 && i >= 0) {
                                            if (j % 8 == 0) {
                                                sp.play(sound8, 0.3f, 0.3f, 1, 0, 1);
                                            }
                                            else {
                                                sp.play(sound8, 0.20f, 0.20f, 1, 0, 1);
                                            }
                                        }
                                        if ((i+3) >= 0 && notes[i+3] != 0) {
                                            AnimatorSet set = new AnimatorSet();
                                            int r = (int) (Math.random()*6);
                                            if (r == 0) set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_red);
                                            else if (r == 1) set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_blue);
                                            else if (r == 2) set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_yellow);
                                            else if (r == 3) set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_pink);
                                            else if (r == 4) set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_green);
                                            else if (r == 5) set = (AnimatorSet) AnimatorInflater.loadAnimator(getBaseContext(), R.anim.fade_lightblue);

                                            final int buttonToActivate;
                                            if (notes[i+3] == 1) { set.setTarget(findViewById(R.id.button1)); buttonToActivate = 1; }
                                            else if (notes[i+3] == 2) { set.setTarget(findViewById(R.id.button2)); buttonToActivate = 2; }
                                            else if (notes[i+3] == 3) { set.setTarget(findViewById(R.id.button3)); buttonToActivate = 3; }
                                            else if (notes[i+3] == 4) { set.setTarget(findViewById(R.id.button4)); buttonToActivate = 4; }
                                            else if (notes[i+3] == 5) { set.setTarget(findViewById(R.id.button5)); buttonToActivate = 5; }
                                            else if (notes[i+3] == 6) { set.setTarget(findViewById(R.id.button6)); buttonToActivate = 6; }
                                            else if (notes[i+3] == 7) { set.setTarget(findViewById(R.id.button7)); buttonToActivate = 7; }
                                            else if (notes[i+3] == 8) { set.setTarget(findViewById(R.id.button8)); buttonToActivate = 8; }
                                            else if (notes[i+3] == 9) { set.setTarget(findViewById(R.id.button9)); buttonToActivate = 9; }
                                            else if (notes[i+3] == 10) { set.setTarget(findViewById(R.id.button10)); buttonToActivate = 10; }
                                            else if (notes[i+3] == 11) { set.setTarget(findViewById(R.id.button11)); buttonToActivate = 11; }
                                            else { set.setTarget(findViewById(R.id.button12)); buttonToActivate = 12; }
                                            set.start();

                                            int timeTillZero = (int) (60*1000/4*3 / track.getBpm());

                                            final Handler activateHandler = new Handler();
                                            activateHandler.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    buttonIsActivated[buttonToActivate-1] = true;
                                                }
                                            }, timeTillZero - hitAccuracy);

                                            final Handler deactivateHandler = new Handler();
                                            deactivateHandler.postDelayed(new Runnable() {
                                                @Override
                                                public void run() {
                                                    if (buttonIsActivated[buttonToActivate-1] == true) {
                                                        miss();
                                                        updateCombo();
                                                        buttonIsActivated[buttonToActivate - 1] = false;
                                                    }
                                                }
                                            }, timeTillZero + hitAccuracy);
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
        long offset = track.getOffset() - Math.round((60*1000*2 / track.getBpm()));
        long period = Math.round(60*1000*4 / track.getBpm());
        timer.scheduleAtFixedRate(timerTask, offset, period);
    }



    private void miss() {
        combo = 0;
        lifebarIncrement(-7);
    }

    private void updateScore() {
        TextView textView = findViewById(R.id.scoreView);
        textView.setText(Integer.toString(score));
    }

    private void updateCombo() {
        TextView textView = findViewById(R.id.comboView);
        textView.setText(Integer.toString(combo));
    }

    private void startLifebar() {
        Timer lifebarTimer = new Timer();
        lifebarTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                lifebarIncrement(-1);
                if (lifebar <= 0) {
                    System.out.println("Game lost!");
                    //finishGame();
                }
            }
        }, 0, 100);
    }

    private void lifebarIncrement(int diff) {
        ProgressBar progressbar = findViewById(R.id.lifeBar);
        progressbar.incrementProgressBy(diff);
        lifebar += diff;
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

    public void checkBoxMusic(View v){
        CheckBox checkBox = (CheckBox)v;
        if (checkBox.isChecked()) {
            mediaplayer.setVolume(0.0f, 0.0f);
        }
        else {
            mediaplayer.setVolume(1.0f, 1.0f);
        }
    }


}
