package com.example.mov_app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act_main extends AppCompatActivity {

    Button btnCuadrado;
    Button btnRecta;
    Button btnTrian;
    Button btnCirc;
    Button btnTerreno;
    Button btnAcerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        btnCuadrado = (Button) findViewById(R.id.btn_cuadrado);
        btnCuadrado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcCuadrado();
            }
        });

        btnAcerc = (Button) findViewById(R.id.btn_acercaDe);
        btnAcerc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                acercaDe();
            }
        });

        btnRecta = (Button) findViewById(R.id.btn_rect);
        btnRecta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcRect();
            }
        });

        btnTrian = (Button) findViewById(R.id.btn_trian);
        btnTrian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTrian();
            }
        });

        btnCirc = (Button) findViewById(R.id.btn_circulo);
        btnCirc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculoCirculo();
            }
        });

        btnTerreno = (Button) findViewById(R.id.btn_terreno);
        btnTerreno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcTerreno();
            }
        });


    }

    private void calculoCirculo() {
        Intent inte = new Intent(this, act_Circ.class);
        startActivity(inte);
    }

    private void calcTerreno() {
        Intent inte = new Intent(this, act_terren.class);
        startActivity(inte);
    }

    private void calcTrian() {
        Intent inte = new Intent(this, act_trian.class);
        startActivity(inte);
    }

    private void calcCuadrado(){
        Intent inte = new Intent(this, act_cuadrado.class);
        startActivity(inte);
    }

    private void calcRect(){
        Intent inte = new Intent(this, act_recta.class);
        startActivity(inte);
    }

    private void acercaDe(){
        Intent inte = new Intent(this, act_acercade.class);
        startActivity(inte);
    }


}