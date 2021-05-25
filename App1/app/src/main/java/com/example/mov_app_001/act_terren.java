package com.example.mov_app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class act_terren extends AppCompatActivity {
    Button btnCalc;
    Button btnRegr;
    EditText receptor;
    TextView precio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_terren);

        btnCalc = (Button) findViewById(R.id.btn_cal_terreno);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPrecio();
            }
        });

        btnRegr = (Button) findViewById(R.id.btn_regresar_terreno);
        btnRegr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularPrecio() {
        float ancho = getAncho();
        float largo = getLargo();
        float preciom2 = getPreciom2();

        float total = (ancho * preciom2) * largo;

        precio = (TextView) findViewById(R.id.txtv_preciototal);
        precio.setText(String.valueOf(total));

    }

    private float getAncho(){
        receptor = (EditText) findViewById(R.id.etxt_ancho_terreno);
        String anchoS = receptor.getText().toString();
        float ancho = Float.parseFloat(anchoS);
        return ancho;
    }

    private float getLargo(){
        receptor = (EditText) findViewById(R.id.etxt_largo_terreno);
        String largoS = receptor.getText().toString();
        float largo = Float.parseFloat(largoS);
        return largo;
    }
    private float getPreciom2(){
        receptor = (EditText) findViewById(R.id.etxt_preciom2);
        String anchoS = receptor.getText().toString();
        float precio = Float.parseFloat(anchoS);
        return precio;
    }
}