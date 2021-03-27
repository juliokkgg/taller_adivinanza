package com.example.adivinanza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ActivityGame extends AppCompatActivity implements View.OnClickListener {


    int numerointentos;
    int numoculto;
    Button btnvalidar;
    TextView tvintentos;
    EditText ninput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        numerointentos = getIntent().getIntExtra("intentos", 5);


        ninput = findViewById(R.id.texto_numero);
        tvintentos = findViewById(R.id.intent_num);
        btnvalidar = findViewById(R.id.verificar_numero);



        Random rand = new Random();
        numoculto = rand.nextInt(101);

        //Toast.makeText(this," NO NULL"+ numoculto, Toast.LENGTH_SHORT).show();  //uquitar

       tvintentos.setText(Integer.toString(numerointentos));

        btnvalidar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.verificar_numero:
                String value = ninput.getText().toString();

                if(TextUtils.isEmpty(value)){
                    Toast.makeText(this," Ingrese un numero", Toast.LENGTH_SHORT).show();

                    return;
                }

                if(Integer.parseInt(value) > 100){
                    Toast.makeText(this, "Ingrese un numero del 0 o 100", Toast.LENGTH_SHORT).show();
                    ninput.setText("");
                }else {

                    if(Integer.parseInt(value) == numoculto){
                        Intent intent = new Intent(this, WinActivity.class);
                        startActivity(intent);
                        finish();

                    }else if(Integer.parseInt(value) > numoculto){
                        Toast.makeText(this, "El numero ingresado es demasiado alto", Toast.LENGTH_SHORT).show();
                        ninput.setText("");
                    }else{
                        Toast.makeText(this,"El numero ingresado es demasiado bajo", Toast.LENGTH_SHORT).show();
                        ninput.setText("");
                    }

                    numerointentos--;
                    tvintentos.setText(Integer.toString(numerointentos));

                    if(numerointentos == 0){
                        Intent intent = new Intent( ActivityGame.this, LoseActivity.class);
                      Toast.makeText(this,"El numero oculto era: "+ numoculto,Toast.LENGTH_LONG).show();
                        startActivity(intent);
                        finish();
                    }
                }

                break;
        }
    }





    }
