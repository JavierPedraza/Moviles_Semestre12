package com.example.mov_app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class act_recta extends AppCompatActivity {

    Button btnCalc;
    Button btnRegresar;
    EditText ancho;
    TextView area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_rectangulo);
        btnCalc = (Button) findViewById(R.id.btn_calc);
        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculo();
            }
        });

        btnRegresar = (Button) findViewById(R.id.btn_regresar);
        btnRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calculo(){
        area = (TextView) findViewById(R.id.txtv_area);

        ancho = (EditText) findViewById(R.id.etxt_ancho);
        String anchoS = ancho.getText().toString();
        float anchoI = Float.parseFloat(anchoS);

        ancho = (EditText) findViewById(R.id.etxt_largo);
        anchoS = ancho.getText().toString();
        float largoI = Float.parseFloat(anchoS);

        float areaI = largoI * anchoI;
        String areaS = String.valueOf(areaI);

        area.setText(areaS);
    }
}