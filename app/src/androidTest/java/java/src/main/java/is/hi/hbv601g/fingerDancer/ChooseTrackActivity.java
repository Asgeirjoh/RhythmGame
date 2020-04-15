package java.src.main.java.is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import is.hi.hbv601g.fingerDancer.MenuActivity;
import is.hi.hbv601g.fingerDancer.R;
import is.hi.hbv601g.fingerDancer.RhythmMainActivity;

public class ChooseTrackActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_track);


    }

    public void openRhythmMain(View V){
        Intent i = new Intent(this, RhythmMainActivity.class);
        startActivity(i);
    }


    public void backtMenu(View v){
        Intent i = new Intent(this, MenuActivity.class);
        startActivity(i);
    }

    public void openStartMenu(View v){
        Intent i = new Intent(this,startMenuActivity.class);
        startActivity(i);
    }




}
