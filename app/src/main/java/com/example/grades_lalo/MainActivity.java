package com.example.grades_lalo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView promedioTotal= findViewById(R.id.TVpromedioTotal);
        Button calcular= findViewById(R.id.BtnCalcularTotal);
        Button fisica= findViewById(R.id.BtnFisica);
        Button ingles= findViewById(R.id.BtnIngles);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                promedioTotal.setText("Promedio general "+String.valueOf((Fisica.sumaFisica+Ingles.sumaIngles)/2));
            }
        });

        fisica.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), Fisica.class);
                startActivityForResult(intent, 0);
            }
        });

        ingles.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent (getApplicationContext(), Ingles.class);
                startActivityForResult(intent, 0);
            }
        });

    }
}
