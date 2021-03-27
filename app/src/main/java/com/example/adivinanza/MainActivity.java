package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
                                implements View.OnClickListener, AdapterView.OnItemSelectedListener{
    Button iniciarBtn;
    Spinner spinner;
    int selectSpinner = 5;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      spinner= findViewById(R.id.intentos_seleccion);

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, getResources().getStringArray(R.array.intentosop));
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(myAdapter);
        spinner.setOnItemSelectedListener(this);

        iniciarBtn = findViewById(R.id.iniciar);
        iniciarBtn.setOnClickListener(this);
    }


    //Event button
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.iniciar:
                Intent intent = new Intent( MainActivity.this, ActivityGame.class);
                intent.putExtra("intentos", selectSpinner);
                startActivity(intent);
                finish();
                break;
        }
    }



    //selected position spinner
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        selectSpinner = Integer.parseInt(parent.getItemAtPosition(position).toString());
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}



