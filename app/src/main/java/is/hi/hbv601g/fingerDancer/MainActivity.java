package is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private SoundPool sp;
    private int sound1;
    private int sound2;
    private int sound3;
    private int sound5;
    private int sound6;
    private int sound7;
    private int sound8;
    private int sound9;

    private int track;
    private int score;
    private int combo;
    private int difficulty;
    private int fadeInTime;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = new SoundPool(2, AudioManager.STREAM_MUSIC,0);
        sound1 = sp.load(getApplicationContext(),R.raw.sound1,1);
        sound2 = sp.load(getApplicationContext(),R.raw.sound2,1);
        sound3 = sp.load(getApplicationContext(),R.raw.sound3,1);
        sound5 = sp.load(getApplicationContext(),R.raw.sound5,1);
        sound6 = sp.load(getApplicationContext(),R.raw.sound6,1);
        sound7 = sp.load(getApplicationContext(),R.raw.sound7,1);
        sound8 = sp.load(getApplicationContext(),R.raw.sound8,1);
        sound9 = sp.load(getApplicationContext(),R.raw.sound9,1);
    }


    // Return to Main Menu
    public void backToMenu(View v){
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }

    // Experimental sounds to play when you press the Note buttons

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
