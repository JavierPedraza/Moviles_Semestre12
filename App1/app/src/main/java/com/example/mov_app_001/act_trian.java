package com.example.mov_app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class act_trian extends AppCompatActivity {

    Button btnCalc;
    Button btnRegr;
    EditText receptor;
    TextView area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_trian);

        btnCalc = (Button) findViewById(R.id.btn_calc_triangulo);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularArea();
            }
        });

        btnRegr = (Button) findViewById(R.id.btn_regresar_triangulo);
        btnRegr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    private void calcularArea() {
        float ancho = getAncho();
        float altura = getAltura();
        float area = (float) (ancho*altura);
        area =(float) area/2;
        printArea(String.valueOf(area));
    }

    private float getAncho(){
        receptor = (EditText) findViewById(R.id.etxt_largo_triangulo);
        String anchoS = receptor.getText().toString();
        float ancho = Float.parseFloat(anchoS);
        return ancho;
    }

    private float getAltura(){
        receptor = (EditText) findViewById(R.id.etxt_altura_triangulo);
        String anchoS = receptor.getText().toString();
        float ancho = Float.parseFloat(anchoS);
        return ancho;
    }

    private void printArea(String areaS){
        area = (TextView) findViewById(R.id.txtv_area_triangulo);
        area.setText(areaS);
    }
}