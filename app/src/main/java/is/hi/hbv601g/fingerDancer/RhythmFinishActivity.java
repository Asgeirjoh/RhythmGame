package is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class RhythmFinishActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rhythm_finish);
        TextView textView = findViewById(R.id.scoreDisplay);
        textView.setText("Your Score: " + RhythmMainActivity.score);
    }


    public void backToMenu(View v){
        Intent i = new Intent(this,MenuActivity.class);
        startActivity(i);
    }




}
