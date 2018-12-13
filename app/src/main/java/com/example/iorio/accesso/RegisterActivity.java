package com.example.iorio.accesso;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {

    //quando faccio l'implements devo fare subito l'override


    private static final String TAG = "MainActivity";
    private static final int PASSWORD_LENGTH = 6;

    EditText emailET;
    EditText passwordET;
    EditText phoneET;

    Button registerBtn;


    private boolean isValidEmail() {
        String email = emailET.getText().toString();
        return android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches();
    }

    private boolean isValidPassword() {
        String password = passwordET.getText().toString();
        return (password.length() > PASSWORD_LENGTH);

    }

    private boolean isValidPhone(){
        String number = phoneET.getText().toString();
        return android.util.Patterns.PHONE.matcher(number).matches();

    }

    private void showErrorMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
        Log.e(TAG, message);
    }

    private void showSuccessMessage(String message){

        Toast.makeText(this,message,Toast.LENGTH_LONG).show();
        Log.e(TAG,message);
    }

    public void changeActivity(){
        Intent intent = new Intent(RegisterActivity.this, WelcomeActivity.class);
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
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_main);
        emailET = findViewById(R.id.email_et);
        passwordET = findViewById(R.id.password_et);
        phoneET = findViewById(R.id.phone_et);
        registerBtn = findViewById(R.id.register_btn);

        registerBtn.setVisibility(View.VISIBLE);
        registerBtn.setOnClickListener(this);
        Log.i(TAG,"activity created");
    }

    @Override
        public void onClick (View view) {

            if (!isValidEmail()) {
                showErrorMessage(getString(R.string.email_error));
                return;
            }

            if (!isValidPassword()) {
                showErrorMessage(getString(R.string.password_error));
            return;
            }
            if (!isValidPhone()) {
                showErrorMessage(getString(R.string.phone_error));
                return;
            }
            showSuccessMessage(getString(R.string.register_success));
             changeActivity();

         }
    }
