package is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class inGameHighScoreActivity extends AppCompatActivity {

    private TextView mScores;

    private int lastScore;
    int best1,best2,best3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingame_highscore);

        mScores = findViewById(R.id.scores);
        // load older scores.
        SharedPreferences preferences = getSharedPreferences("PREFS",0);
        lastScore = preferences.getInt("lastscore",0);
        best1 = preferences.getInt("best1",0);
        best2 = preferences.getInt("best2",0);
        best3 = preferences.getInt("best3",0);

        // replace if there is a highscore higher than the first 3 places.
        if(lastScore > best3){
            best3 = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3",best3);
            editor.apply();
        }

        if(lastScore > best2){
            int temp = best2;
            best2 = lastScore;
            best3  = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best3",best3);
            editor.putInt("best2",best2);
            editor.apply();
        }

        if(lastScore > best1){
            int temp = best1;
            best1 = lastScore;
            best2  = temp;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best2",best2);
            editor.putInt("best1",best1);
            editor.apply();
        }
        // display the scores
        mScores.setText("Last Score is:" + lastScore + "\n" + "1. " + best1 +"\n"
                + "2. " + best2 +"\n" + "3. " + best3 +"\n" );





    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(i);
        finish();
    }
}


