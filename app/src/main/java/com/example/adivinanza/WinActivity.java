package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class WinActivity extends AppCompatActivity implements View.OnClickListener {

    Button back2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);


        back2=findViewById(R.id.again);
        back2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent( this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}