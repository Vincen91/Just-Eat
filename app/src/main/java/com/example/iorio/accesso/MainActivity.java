package com.example.iorio.accesso;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener,OnCheckedChangeListener {

    //OnCheckedChangeListener serve per vedere lo stato dello switch
    public static final String WELCOME = "WELCOME";
    private static final String TAG = "MainActivity";
    private static final int PASSWORD_LENGTH = 6;

    EditText emailET;
    EditText passwordET;

    Button loginBtn;
    Button registerBtn;

    Switch change;
    

    private boolean isValidEmail(){
        String email = emailET.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword() {
        String password = passwordET.getText().toString();
        return (password.length() > PASSWORD_LENGTH);

    }

    private void showErrorMessage(String message){
        Toast.makeText( this,message,Toast.LENGTH_LONG).show();
        Log.e(TAG, message);
    }

    private void showSuccessMessage(String message){

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();

        Log.e(TAG,message);
    }

    public void changeActivityRegister(){
        Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
        startActivity(intent);
    }

    public void changeActivityWelcome(){
        Intent intent = new Intent (this, WelcomeActivity.class);
        startActivity(intent);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"activity started");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"activity resumed");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"activity paused");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"activity stopped");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"activity destroyed");
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);

        loginBtn = findViewById(R.id.login_btn);
        registerBtn = findViewById(R.id.register_btn);

        registerBtn.setVisibility(View.VISIBLE);
        registerBtn.setOnClickListener(this);
        loginBtn.setOnClickListener(this);
        change = findViewById(R.id.change);
        change.setOnCheckedChangeListener(this);

        Log.i(TAG,"activity created");

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.login_btn) {

            if (!isValidEmail()) {
                showErrorMessage(getString(R.string.email_error));
                return;
            }
            if (!isValidPassword()) {
                showErrorMessage(getString(R.string.password_error));
                return;
            }
            showSuccessMessage(getString(R.string.login_success));
            Intent intent = new Intent(this,WelcomeActivity.class);
            intent.putExtra("email",emailET.getText().toString());
            startActivity(intent);
        }


        if (view.getId() == R.id.register_btn){

        changeActivityRegister();
        }
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if(isChecked){
           change.getRootView().setBackgroundColor(getResources().getColor(R.color.colorPrimaryDark));
        }else{
            change.getRootView().setBackgroundColor(getResources().getColor(R.color.white));
                //getResources prende dalle risorse il codice che ci serve

        }
    }
}
