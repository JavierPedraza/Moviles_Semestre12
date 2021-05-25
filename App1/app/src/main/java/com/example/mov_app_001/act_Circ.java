package com.example.mov_app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class act_Circ extends AppCompatActivity {
    Button btnCalc;
    Button btnRegr;
    EditText receptor;
    TextView area;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_circ);
        btnCalc = (Button)findViewById(R.id.btn_calc_circ);
        btnRegr = (Button)findViewById(R.id.btn_regresar_circ);

        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularArea();
            }
        });

        btnRegr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularArea() {
        double radioD = getRadio();

        double areaD = radioD*3.1416;
        String radioS = String.valueOf(areaD);
        printArea(radioS);

    }

    private double getRadio(){
        receptor = (EditText)findViewById(R.id.etxt_radio_circ);
        String radioS = receptor.getText().toString();
        double radioD = Double.parseDouble(radioS);

        return radioD;
    }

    private void printArea(String radioS) {
        area = findViewById(R.id.txtv_area_circ);
        area.setText(radioS);
    }

}