package is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import is.hi.hbv601g.fingerDancer.R;

public class SettingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    // Open activity_instructions.xml
    public void viewInstructions(View v) {
        setContentView(R.layout.activity_instructions);
    }

    // Mute checkbox
     public void onMute(View v) {
         boolean checked = ((CheckBox) v).isChecked();
     }

}

