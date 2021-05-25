package com.example.mov_app_pizza.dialogos;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.mov_app_pizza.R;
import com.example.mov_app_pizza.interfaces.AutorizacionEnvio;

public class DialogoProcedeEnvio extends DialogFragment {
    AutorizacionEnvio mainActivityReference;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if(context instanceof Activity){
            mainActivityReference = (AutorizacionEnvio) context;

        }
    }

    //Mensaje del dialogo
    String nota;
    public void setNota(String _nota){
        nota = _nota;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        //Generador de Dialogos
        AlertDialog.Builder generador = new AlertDialog.Builder(getActivity()); //Necesita la referencia de la actividad en la que estamos
        generador.setTitle("¿Desea proceder con el envio?")
                .setIcon(android.R.drawable.ic_menu_send)
                .setMessage(nota)
                .setPositiveButton("Proceder", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mainActivityReference.envioProcede();
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        mainActivityReference.envioRechazo();
                    }
                });
        return generador.create();

    }
}

