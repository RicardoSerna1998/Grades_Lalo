package com.example.grades_lalo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Ingles extends AppCompatActivity {
    public static double sumaIngles= 0;
    public static EditText parcial1, parcial2, parcial3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingles);

        parcial1= findViewById(R.id.ETparcial1);
        parcial2= findViewById(R.id.ETparcial2);
        parcial3= findViewById(R.id.ETparcial3);
        Button calcular= findViewById(R.id.BtnCalcularFisica);
        final TextView prom= findViewById(R.id.TVpromedioFisica);

        //limitar numero de decimles
        final DecimalFormat df = new DecimalFormat(".00");
        df.setRoundingMode(RoundingMode.DOWN);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validar()){
                    sumaIngles= (Float.parseFloat(parcial1.getText().toString())+Float.parseFloat(parcial2.getText().toString())+Float.parseFloat(parcial3.getText().toString()))/3;

                    if(sumaIngles!=0){  //se ha ingresado algo
                        prom.setText("Promedio "+String.valueOf(df.format(sumaIngles)));

                    }else{
                        Toast.makeText(getApplicationContext(), "Ingresa almenos un número", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
    public boolean validar(){
        boolean aplica=true;
        if((TextUtils.isEmpty(parcial1.getText())) || (!TextUtils.isDigitsOnly(parcial1.getText()))) {  /// es vacio
            aplica=false;
            parcial1.setError("Ingresa un promedio válido");
        }
        else if((TextUtils.isEmpty(parcial2.getText())) || (!TextUtils.isDigitsOnly(parcial2.getText())   )) {  /// es vacio
            aplica=false;
            parcial2.setError("Ingresa un promedio válido");
        }
        else if((TextUtils.isEmpty(parcial3.getText())) || (!TextUtils.isDigitsOnly(parcial3.getText()))) {  /// es vacio
            aplica=false;
            parcial3.setError("Ingresa un promedio válido");
        }
        /*else{  ///hay algo
            if((Float.parseFloat(String.valueOf(cantidad.getText()))<total)){
                validado=false;
                cantidad.setError("Ingresa una cantidad válida");
            }
        }*/

        return aplica;
    }
}
