package com.example.mov_app_pizza;


import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mov_app_pizza.dialogos.DialogoProcedeEnvio;
import com.example.mov_app_pizza.dialogos.DialogoSMS;
import com.example.mov_app_pizza.interfaces.AutorizacionEnvio;
import com.example.mov_app_pizza.interfaces.AutorizacionSms;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements AutorizacionEnvio, AutorizacionSms {
    ConfiguracionPizza ConfiguracionPizza;
    ImageView imgPizza;
    Spinner tipoPizza;
    TextView tv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configurarSpinnerTipoPizza();
        
        configurarRadioGTam();

        configurarCheckboxExtras();

        configurarSeekCoccion();

        configurarBtnEnvioPedido();
    }

    private void configurarBtnEnvioPedido() {
        Button enviar = findViewById(R.id.ambtn_initenvio);
        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fragDriver = getSupportFragmentManager();
                DialogoProcedeEnvio procenvio = new DialogoProcedeEnvio();
                //Contruye el Mensaje
                String nota = "Pizza x \n Precio 100";
                procenvio.setNota(nota);
                procenvio.show(fragDriver, "Dialog Calling");
            }
        });
    }

    private void configurarSeekCoccion() {
        SeekBar seek = findViewById(R.id.amSkbar_coccion);
        TextView coccion = findViewById(R.id.amTxtv_coccion);
        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                switch (progress){
                    case 0:
                        coccion.setText("Cocción: Normal");
                        break;
                    case 1:
                        coccion.setText("Cocción: Bien cosida");
                        break;
                    case 2:
                        coccion.setText("Cocción: Dorada");
                        break;
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    private void configurarCheckboxExtras() {
        CheckBox chbxing = findViewById(R.id.amChbx_eingrediente);
        chbxing.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ConfiguracionPizza.extraingrediente = isChecked;
                actualizarPrecio();
            }
        });

        CheckBox chbxqu = findViewById(R.id.amChbx_eQueso);
        chbxqu.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ConfiguracionPizza.extraqueso = isChecked;
                actualizarPrecio();
            }
        });

        CheckBox chbxtom = findViewById(R.id.amChbx_etomate);
        chbxtom.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ConfiguracionPizza.extratomate = isChecked;
                actualizarPrecio();
            }
        });

    }

    private void configurarRadioGTam() {
        RadioGroup radgp = findViewById(R.id.amRadG_Tam);
        radgp.check(R.id.amRbtn_Chica);
        radgp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.amRbtn_Chica : ConfiguracionPizza.TAM = 0; break;
                    case R.id.amRbtn_Mediana : ConfiguracionPizza.TAM = 1; break;
                    case R.id.amRbtn_Grande : ConfiguracionPizza.TAM = 2; break;
                }
                actualizarPrecio();


            }
        });


    }


    private void configurarSpinnerTipoPizza(){
        imgPizza = findViewById(R.id.amimgv_pizza);
        tipoPizza = findViewById(R.id.amspnr_tipo_pizza);
        tipoPizza.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                ConfiguracionPizza.TIPO = position;
                
                switch (position){
                    case 0:
                        imgPizza.setImageResource(R.drawable.pizza_pepperoni);
                        break;
                    case 1:
                        imgPizza.setImageResource(R.drawable.pizza_hawaiana);
                        break;
                    case 2:
                        imgPizza.setImageResource(R.drawable.pizza_mexicana);
                        break;
                    case 3:
                        imgPizza.setImageResource(R.drawable.pizza_americana);
                        break;
                    case 4:
                        imgPizza.setImageResource(R.drawable.pizza_napolitana);
                        break;
                    case 5:
                        imgPizza.setImageResource(R.drawable.pizza_mediterranea);
                        break;
                    default:
                        break;
                }
                actualizarPrecio();

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    private void actualizarPrecio() {
        double[][] precios = {
                {80.0, 130.0, 180.0},
                {85.0, 135.0, 185.0},
                {90.0, 140.0, 190.0},
                {95.0, 145.0, 195.0},
                {100.0, 150.0, 200.0},
                {105.0, 155.0, 205.0}

        };
        tv = findViewById(R.id.amtxtv_precio);
        double precio = precios[ConfiguracionPizza.TIPO][ConfiguracionPizza.TAM];

        if(ConfiguracionPizza.extratomate) precio+=7;
        if(ConfiguracionPizza.extraqueso) precio+=10;
        if(ConfiguracionPizza.extraingrediente) precio+=15;

        tv.setText(""+precio);
    }

    @Override
    public void envioProcede() {
        FragmentManager fragDriver = getSupportFragmentManager();
        DialogoSMS dialog = new DialogoSMS();
        dialog.show(fragDriver, "diagSMS");
    }

    @Override
    public void envioRechazo() {
        Toast.makeText(this, "Envío Cancelado",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void smsProcede(String nombre, String domicilio) {
        String num = "3521129380";
        //String texto = "Su pedido para: " +nombre + "\nen el domicilio: "+ domicilio +"\nHa Sido registrado";
        String texto = "avisame si te llego este mensaje";
        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(num, null, texto,null, null);

    }

    @Override
    public void smsRechazo() {
        Toast.makeText(this, "Envío SMS Cancelado",Toast.LENGTH_SHORT).show();
    }
}