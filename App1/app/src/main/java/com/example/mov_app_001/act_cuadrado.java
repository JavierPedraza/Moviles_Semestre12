package com.example.mov_app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class act_cuadrado extends AppCompatActivity {
    Button btnCalc;
    Button btnRegr;
    EditText receptor;
    TextView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_cuadrado);

        btnCalc = (Button) findViewById(R.id.btn_calc_cuadrado);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularArea();
            }
        });

        btnRegr = (Button) findViewById(R.id.btn_regresar_cuadrado);
        btnRegr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void calcularArea() {
        float lado = getLado();
        float areaF = lado*lado;

        printArea(String.valueOf(areaF));

    }

    private void printArea(String areaS) {
        area = findViewById(R.id.txtv_area_cuadrado);
        area.setText(areaS);
    }

    private float getLado(){
        receptor = (EditText) findViewById(R.id.etxt_largo_cuadrado);
        String anchoS = receptor.getText().toString();
        float ancho = Float.parseFloat(anchoS);
        return ancho;
    }
}