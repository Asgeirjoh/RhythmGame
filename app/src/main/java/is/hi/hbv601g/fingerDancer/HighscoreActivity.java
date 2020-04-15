package is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class HighscoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);
    }

    public void onBackPressed() {
        MainActivity.musicStarted = true;
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
