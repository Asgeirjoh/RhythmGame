package is.hi.hbv601g.fingerDancer;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MenuActivity extends AppCompatActivity {

    private Retrofit retrofit;
    private RetrofitInterface retrofitInterface;
    // BASE_URL Leads to local host on computer
    private String BASE_URL = "http://10.0.2.2:3000";
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

        retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        retrofitInterface = retrofit.create(RetrofitInterface.class);

        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnSignup = (Button) findViewById(R.id.btnSignup);


        // Login Button btnLogin: calls handleLoginDialog()
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleLoginDialog();
            }
        });

        // Sign up Button: btnSignup calls handleSignupDialog()
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleSignupDialog();
            }
        });

    }

    // Opens Login Dialog and sends login information to server to check if user exists
    private void handleLoginDialog() {
        View view = getLayoutInflater().inflate(R.layout.login_dialog, null);
        final AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).show();
        Button loginBtn = view.findViewById(R.id.login);
        final EditText usernameEdit = view.findViewById(R.id.usernameEdit);
        final EditText passwordEdit = view.findViewById(R.id.passwordEdit);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();
                map.put("name", usernameEdit.getText().toString());
                map.put("password", passwordEdit.getText().toString());
                Call<User> call = retrofitInterface.executeLogin(map);
                call.enqueue(new Callback<User>() {
                    @Override
                    // Response if http request is successful
                    public void onResponse(Call<User> call, Response<User> response) {
                        // Returns User info when Login info is correct
                        if (response.code() == 200) {
                            User results = response.body();
                            AlertDialog.Builder builder1 = new AlertDialog.Builder(MenuActivity.this);
                            builder1.setTitle(results.getName());
                            builder1.setMessage(results.getEmail());
                            builder1.show();
                        }
                        // Returns Toast message if Login info is wrong
                        else if (response.code() == 404) {
                            Toast.makeText(MenuActivity.this,
                                    "Wrong Login info", Toast.LENGTH_LONG).show();
                        }
                    }

                    // Returns error Toast message when http request fails
                    @Override
                    public void onFailure(Call<User> call, Throwable t) {
                        Toast.makeText(MenuActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    // Opens Sign Up dialog and sends inserted user information to server
    private void handleSignupDialog() {
        View view = getLayoutInflater().inflate(R.layout.signup_dialog, null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setView(view).show();
        Button signupBtn = view.findViewById(R.id.signup);
        final EditText usernameEdit = view.findViewById(R.id.usernameEdit);
        final EditText emailEdit = view.findViewById(R.id.emailEdit);
        final EditText passwordEdit = view.findViewById(R.id.passwordEdit);
        signupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                HashMap<String, String> map = new HashMap<>();
                map.put("name", usernameEdit.getText().toString());
                map.put("email", emailEdit.getText().toString());
                map.put("password", passwordEdit.getText().toString());
                Call<Void> call = retrofitInterface.executeSignup(map);
                call.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        // Return Toast message when new User is created
                        if (response.code() == 200) {
                            Toast.makeText(MenuActivity.this,
                                    "Signed up succesfully", Toast.LENGTH_LONG).show();
                        }
                        // Return Toast message when User already exists
                        else if (response.code() == 400) {
                            Toast.makeText(MenuActivity.this,
                                    "User already exists", Toast.LENGTH_LONG).show();
                        }
                    }

                    // Returns error Toast message when http request fails
                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        Toast.makeText(MenuActivity.this, t.getMessage(),
                                Toast.LENGTH_LONG).show();
                    }
                });
            }
        });
    }

    // Starts MainActivity, function called by Play Button: btnPlay in activity_menu.xml
    public void playGame(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);

    }

    // Starts SettingsActivity, function called by Settings Button: btnSettings in activity_menu.xml
    public void viewSettings(View v) {
        Intent i = new Intent(this, SettingsActivity.class);
        startActivity(i);
    }

    // Starts HighscoreActivity, function called by High Score Button: btnHighScore in activity_menu.xml
    public void viewHighScore(View v) {
        Intent i = new Intent(this,HighscoreActivity.class);
        startActivity(i);
    }

    }

