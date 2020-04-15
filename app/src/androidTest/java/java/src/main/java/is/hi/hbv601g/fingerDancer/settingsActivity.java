package java.src.main.java.is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import androidx.appcompat.app.AppCompatActivity;

import is.hi.hbv601g.fingerDancer.R;

public class settingsActivity extends AppCompatActivity {

    private Button mMuteBtn;
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        mMuteBtn = findViewById(R.id.btnMuteSound);

        mMuteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checked = ((CheckBox) v).isChecked();
                if(checked) {
                    mAudioManager.setMode(AudioManager.MODE_IN_CALL);
                    mAudioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, true);
                } else{
                    mAudioManager.setMode(AudioManager.MODE_NORMAL );
                    mAudioManager.setStreamSolo(AudioManager.STREAM_VOICE_CALL, false);

            }
        }
        });
    }


    public void viewInstructions(View v) {
        setContentView(R.layout.activity_instructions);

    }
}

