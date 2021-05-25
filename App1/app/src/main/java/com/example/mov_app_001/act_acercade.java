package com.example.mov_app_001;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class act_acercade extends AppCompatActivity {
    Button btnRegr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_acercade);
        btnRegr = (Button) findViewById(R.id.btn_regresar_acercade);
        btnRegr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}