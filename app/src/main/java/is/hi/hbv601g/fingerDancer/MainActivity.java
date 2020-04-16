package is.hi.hbv601g.fingerDancer;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private SoundPool mSp;
    private Context context;
    private int mSound1;

    private boolean isGameOver = false;
    private Handler mhandler;

    private List<Button> mbuttons;

    public static MediaPlayer mMediaPlayer;
    public static boolean musicStarted = false;

    private int Score = 0;
    private boolean start = true;
    private BounceButtonInterpolator bb = new BounceButtonInterpolator(0.1, 15);
    private int mTrack;
    private int mScore;
    private int mCombo;
    private int mDifficulty;
    private int mFadeInTime;
    private int mI = 0;

    private boolean mButtonIsClicked = true;

    private Random mRand = new Random();
    int mRndNumber = mRand.nextInt((12 - 1) + 1);

    // the count down text in acitivity_main
    private TextView mScoreTable;
    // the length of the song.

    private Button mInGameHighScore;

    private static final String TAG = MainActivity.class.getSimpleName();

    private static  long millsecondsinfuture = 1500;
    private static  long CountDownInterval = 1500;
    // button to pause and start the game.
    private Button mButtonStartPause;
    // resetButton to resetTimer
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private CountDownTimer mCountDownTimer1[];
    private boolean mTimerRunning;
    private int index = 0;
    private long mMillisecondsInFuture = millsecondsinfuture;
    private long mCountDownInterval = CountDownInterval;
    private long millisUntilFinished = CountDownInterval;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.song);
        if (musicStarted == false) {
            mMediaPlayer.start();
            musicStarted = true;
        }
        mScoreTable = findViewById(R.id.scoreTable);
        mInGameHighScore = findViewById(R.id.inGameHighScore);





        mbuttons = new ArrayList<Button>(Button_ids.length);

        for (int id : Button_ids) {
            Button button = (Button) findViewById(id);
            mbuttons.add(button);
        }

        new Handler().postDelayed(new Runnable() {
            public void run() {

                mCountDownTimer = new CountDownTimer(millsecondsinfuture, CountDownInterval) {
                    Random mRand = new Random();
                    Random mRand1 = new Random();
                    Random mRand2 = new Random();

                    int mRndNumber1 = mRand.nextInt((12 - 1) + 1);
                    int tala = mRndNumber1;
                    int mRndNumber2 = mRand1.nextInt((12 - 1) + 1);
                    int tala2 = mRndNumber2;
                    int mRndNumber3 = mRand2.nextInt((12 - 1) + 1);
                    int tala3 = mRndNumber3;
                    Random mRandx = new Random();
                    int btnCnt = mRandx.nextInt((3));

                    boolean btnclicked1 = false;
                    boolean btnclicked2 = false;
                    boolean btnclicked3 = false;


                    @Override
                    public void onTick(long millisUntilFinished) {
                        mMillisecondsInFuture = millisUntilFinished;




                        if(btnCnt == 0){
                            mbuttons.get(tala).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonnode));
                        }

                        if(btnCnt == 1) {
                            mbuttons.get(tala).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncombo));
                            mbuttons.get(tala2).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncombo));
                        }

                        if(btnCnt == 2){
                            mbuttons.get(tala).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonthree));
                            mbuttons.get(tala2).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonthree));
                            mbuttons.get(tala3).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonthree));
                        }

                        for (int i = 0; i < mbuttons.size(); i++) {
                            final int finalI = i;
                            final int finalII = i;

                            mbuttons.get(i).setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    if(btnCnt ==0 ) {
                                        if (mbuttons.get(tala).getId() != v.getId()) {
                                            mScore = 0;
                                            mScoreTable.setText(Integer.toString(mScore));
                                            wrongButton(finalI);
                                            buttonBlink(mbuttons.get(tala));
                                        }
                                    }

                                    if(btnCnt == 1) {

                                        if (mbuttons.get(tala).getId() != v.getId() && mbuttons.get(tala2).getId() != v.getId()) {
                                            mScore = 0;
                                            mScoreTable.setText(Integer.toString(mScore));
                                            wrongButton(finalI);
                                            buttonBlink(mbuttons.get(tala2));
                                            buttonBlink(mbuttons.get(tala));


                                        }
                                    }

                                    if(btnCnt == 2){

                                        if (mbuttons.get(tala).getId() != v.getId() && mbuttons.get(tala2).getId() != v.getId() &&
                                                mbuttons.get(tala3).getId() != v.getId()) {
                                            mScore = 0;
                                            mScoreTable.setText(Integer.toString(mScore));
                                            wrongButton(finalI);
                                            buttonBlink(mbuttons.get(tala3));
                                            buttonBlink(mbuttons.get(tala2));
                                            buttonBlink(mbuttons.get(tala));


                                        }

                                    }



                                    if(btnCnt == 0) {
                                        if ((mbuttons.get(tala).getId() == mbuttons.get(finalI).getId())) {
                                            buttonBounce(mbuttons.get(tala));
                                            mbuttons.get(tala).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonnode));
                                            btnclicked1 = true;
                                            mScore += 1;
                                            mScoreTable.setText(Integer.toString(mScore));
                                            scoreBounce();
                                            v.setOnClickListener(null);
                                        }
                                    }

                                        if(btnCnt == 1) {
                                            if (mbuttons.get(tala).getId() == v.getId()) {
                                                buttonBounce(mbuttons.get(tala));
                                                mbuttons.get(tala).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncombo));
                                                btnclicked1 = true;
                                                v.setOnClickListener(null);
                                            }
                                            if (mbuttons.get(tala2).getId() == v.getId()) {
                                                buttonBounce(mbuttons.get(tala2));
                                                mbuttons.get(tala2).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttoncombo));
                                                btnclicked2 = true;
                                                v.setOnClickListener(null);
                                            }
                                            if (btnclicked1 == true && btnclicked2 == true) {
                                                mScore += 2;
                                                scoreBounce();
                                                mScoreTable.setText(Integer.toString(mScore));
                                            }
                                        }
                                        if( btnCnt == 2) {
                                            if (mbuttons.get(tala).getId() == v.getId()) {
                                                buttonBounce(mbuttons.get(tala));
                                                mbuttons.get(tala).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonthree));
                                                btnclicked1 = true;
                                                v.setOnClickListener(null);
                                            }
                                            if (mbuttons.get(tala2).getId() == v.getId()) {
                                                buttonBounce(mbuttons.get(tala2));
                                                mbuttons.get(tala2).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonthree));
                                                btnclicked2 = true;
                                                v.setOnClickListener(null);
                                            }

                                            if (mbuttons.get(tala3).getId() == v.getId()) {
                                                buttonBounce(mbuttons.get(tala3));
                                                mbuttons.get(tala2).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonthree));
                                                btnclicked3 = true;
                                                v.setOnClickListener(null);
                                            }
                                            if (btnclicked1 == true && btnclicked2 == true && btnclicked3 == true  ) {
                                                mScore += 3;
                                                scoreBounce();
                                                mScoreTable.setText(Integer.toString(mScore));
                                            }







                                        }
                                }
                            });

                        }

                    }


                    @Override
                    public void onFinish() {

                        mInGameHighScore.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                SharedPreferences preferences = getSharedPreferences("PREFS", 0);
                                SharedPreferences.Editor editor = preferences.edit();
                                editor.putInt("lastscore", mScore);
                                editor.apply();

                                Intent i = new Intent(getApplicationContext(), inGameHighScoreActivity.class);
                                startActivity(i);
                                finish();
                            }
                        });

                        mbuttons.get(tala).setBackgroundDrawable(getResources().getDrawable(R.drawable.button1));
                        mbuttons.get(tala2).setBackgroundDrawable(getResources().getDrawable(R.drawable.button1));
                        mbuttons.get(tala3).setBackgroundDrawable(getResources().getDrawable(R.drawable.button1));

                        if ((btnclicked1 == false &&  btnCnt == 0) ||
                                ((btnclicked1 == false || btnclicked2 == false) && btnCnt ==1) ||
                                ((btnclicked1 == false || btnclicked2 == false || btnclicked3 == false) && btnCnt ==2)) {
                            mScore = 0;
                            scoreBounce();
                            mScoreTable.setText(Integer.toString(mScore));
                        }




                        tala = mRand.nextInt((12 - 1) + 1);
                        tala2 = mRand1.nextInt((12 - 1) + 1);
                        tala3 = mRand2.nextInt((12 - 1) + 1);
                        btnCnt = mRandx.nextInt(3);
                        btnclicked1 = false;
                        btnclicked2 = false;
                        btnclicked3 = false;
                        this.start();
                    }
                }.start();
            }
        }, 1000);
    }


    private void buttonBlink(final Button button) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.blink);
        button.startAnimation(anim);


        button.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.clearAnimation();
                // Handle your animation ending here
            }
        }, anim.getDuration());

    }


    private void buttonBounce(final Button button) {
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        anim.setInterpolator(bb);
        button.startAnimation(anim);


        button.postDelayed(new Runnable() {
            @Override
            public void run() {
                button.clearAnimation();
                // Handle your animation ending here
            }
        },anim.getDuration());

    }

    private void scoreBounce(){
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        anim.setInterpolator(bb);
        mScoreTable.startAnimation(anim);
        mScoreTable.postDelayed(new Runnable() {
            @Override
            public void run() {
                mScoreTable.clearAnimation();
                // Handle your animation ending here
            }
        },anim.getDuration());
    }

    private static final int[] Button_ids = {

            R.id.button1,
            R.id.button2,
            R.id.button3,
            R.id.button4,
            R.id.button5,
            R.id.button6,
            R.id.button7,
            R.id.button8,
            R.id.button9,
            R.id.button10,
            R.id.button11,
            R.id.button12,


    };

    public void wrongButton(final int index) {
        mbuttons.get(index).setBackgroundDrawable(getResources().getDrawable(R.drawable.buttonlost));
        new Handler().postDelayed(new Runnable() {

            public void run() {
                mbuttons.get(index).setBackgroundDrawable(getResources().getDrawable(R.drawable.button1));
            }
        }, 500);

    }


    public void backToMenu(View v) {
        mMediaPlayer.stop();
        musicStarted = false;
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
        finish();
    }

    @Override
    public void onBackPressed() {
        mMediaPlayer.stop();
        musicStarted = false;
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
        finish();
    }

    public void playSong(View v) {

    }
/*
    public void playsound1(View v) {
        Button button1 = (Button) findViewById(R.id.button1);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button1.startAnimation(myAnim);
        // sp.play(msound1,1.0f,1.0f,1,1,10f);
    }


    public void playsound2(View v) {
        Button button2 = (Button) findViewById(R.id.button2);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button2.startAnimation(myAnim);
        // sp.play(msound1,1.0f,1.0f,1,1,10f);

    }

    public void playsound3(View v) {
        Button button3 = (Button) findViewById(R.id.button3);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button3.startAnimation(myAnim);

    }

    public void playsound4(View v) {
        Button button4 = (Button) findViewById(R.id.button4);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button4.startAnimation(myAnim);

    }

    public void playsound5(View v) {
        Button button5 = (Button) findViewById(R.id.button5);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button5.startAnimation(myAnim);

    }

    public void playsound6(View v) {
        Button button6 = (Button) findViewById(R.id.button6);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button6.startAnimation(myAnim);

    }

    public void playsound7(View v) {
        Button button7 = (Button) findViewById(R.id.button7);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button7.startAnimation(myAnim);
    }

    public void playsound8(View v) {
        Button button8 = (Button) findViewById(R.id.button8);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button8.startAnimation(myAnim);
    }

    public void playsound9(View v) {
        Button button9 = (Button) findViewById(R.id.button9);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button9.startAnimation(myAnim);

    }

    public void playsound10(View v) {
        Button button10 = (Button) findViewById(R.id.button10);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button10.startAnimation(myAnim);

    }

    public void playsound11(View v) {
        Button button11 = (Button) findViewById(R.id.button11);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button11.startAnimation(myAnim);

    }

    public void playsound12(View v) {
        Button button12 = (Button) findViewById(R.id.button12);
        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        myAnim.setInterpolator(bb);
        button12.startAnimation(myAnim);

    }

 */
    /*
    private  Button[] randomizeArray(){
        Random randGen = new Random();
        for(int i = 0 ;i < Buttons.length;i++){
            int rndPos = randGen.nextInt(Buttons.length);
            Button temp = Buttons[i];
            Buttons[i] = Buttons[rndPos];
            Buttons[rndPos] = temp;
        }
        return Buttons;
    }

*/
}
