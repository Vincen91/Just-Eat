package com.example.iorio.accesso;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {
    TextView welcomeTW;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.welcome_main);

        welcomeTW = findViewById(R.id.welcome_tv);

        String mail = getIntent().getStringExtra("email");

        welcomeTW.setText(getString(R.string.welcome) + " " + mail);


    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(Intent.ACTION_SEND);
        i.putExtra(Intent.EXTRA_EMAIL, new String[]{
                welcomeTW.getText().toString()});
        i.setType("message/rfc822");
        startActivity(i);

    }
}



