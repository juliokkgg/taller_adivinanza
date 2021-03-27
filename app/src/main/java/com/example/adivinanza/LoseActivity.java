package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LoseActivity extends AppCompatActivity implements View.OnClickListener  {

    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lose);

        back= findViewById(R.id.again2);
        back.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}