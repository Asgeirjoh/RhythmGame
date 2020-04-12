package is.hi.hbv601g.fingerDancer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MenuActivity extends AppCompatActivity {

    private Button btnLogin;
    private Button btnSignup;
    private Button btnCreateUser;
    private Button getBtnLogin;
    private Button btnPlay;
    private Button btnHighScore;
    private Button btnSettings;
    private Button btnAddTracks;
    private EditText txtUsername;
    private EditText txtPassword;
    private EditText txtEmail;
    private Button btnLoginUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);
        btnCreateUser = (Button) findViewById(R.id.btnCreateUser);
        txtUsername = (EditText) findViewById(R.id.txtUsername);
        txtPassword = (EditText) findViewById(R.id.txtPassword);
        txtEmail = (EditText) findViewById(R.id.txtEmail);
        btnLoginUser = (Button) findViewById(R.id.btnLoginUser);


        txtUsername.setVisibility(View.GONE);
        txtPassword.setVisibility(View.GONE);
        txtEmail.setVisibility(View.GONE);
        btnCreateUser.setVisibility(View.GONE);
        btnLoginUser.setVisibility(View.GONE);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername.setVisibility(View.VISIBLE);
                txtPassword.setVisibility(View.VISIBLE);
                txtEmail.setVisibility(View.GONE);
                btnCreateUser.setVisibility(View.GONE);
                btnLoginUser.setVisibility(View.VISIBLE);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtUsername.setVisibility(View.VISIBLE);
                txtPassword.setVisibility(View.VISIBLE);
                btnLogin.setVisibility(View.VISIBLE);
                txtEmail.setVisibility(View.VISIBLE);
                btnCreateUser.setVisibility(View.VISIBLE);
                btnLoginUser.setVisibility(View.GONE);
            }
        });

    }

    public void playGame(View v) {
        Intent i = new Intent(this, startMenuActivity.class);
        startActivity(i);

    }

    public void viewSettings(View v) {
        Intent i = new Intent(this, settingsActivity.class);
        startActivity(i);
    }

    public void viewHighScore(View v){
        Intent i = new Intent(this,HighscoreActivity.class);
        startActivity(i);
    }



    }

