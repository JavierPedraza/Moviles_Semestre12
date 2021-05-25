package com.example.mov_app_pizza.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mov_app_pizza.R;
import com.example.mov_app_pizza.interfaces.AutorizacionEnvio;
import com.example.mov_app_pizza.interfaces.AutorizacionSms;

public class DialogoSMS extends DialogFragment {
    AutorizacionSms actividad;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if(context instanceof Activity){
            actividad = (AutorizacionSms) context;
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        return crearDialogo();
    }

    private AlertDialog crearDialogo() {
        AlertDialog.Builder generador = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View v = inflater.inflate(R.layout.lay_dialogo_datos_entrega, null);
        generador.setView(v);

        Button btnEnviar = v.findViewById(R.id.diagBtn_EnviarSms);
        Button btnCancelar = v.findViewById(R.id.diagBtn_Cancelar);
        final EditText etDomicilio = v.findViewById(R.id.diagEtxt_Domicilio);
        final EditText etNombre = v.findViewById(R.id.diagEtxt_Nombre);

        btnEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombre.getText().toString();
                String domi = etDomicilio.getText().toString();
                actividad.smsProcede(nombre, domi);
                //Esto cierra el dialogo de forma segura
                dismiss();
            }
        });

        btnCancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                actividad.smsRechazo();
                dismiss();
            }
        });
        return generador.create();
    }


}
