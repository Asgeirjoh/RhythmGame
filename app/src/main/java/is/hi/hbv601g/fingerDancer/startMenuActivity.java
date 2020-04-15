package is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class startMenuActivity  extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bstart);


    }

    public void playGame(View V){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }

    public void chooseTrack(){

    }

    public void backtMenu(View v){
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }




}
