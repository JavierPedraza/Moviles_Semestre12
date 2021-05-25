package com.example.unidad2proyecto.ui.acelerometro;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.unidad2proyecto.R;


public class acelerometro extends Fragment implements SensorEventListener {

    double x=0, y=0, z=0, lonEu=0, le_max=0;
    TextView tvAX,tvAY,tvAZ, tvLE, tvMax, tvGravedad, tvContador;
    int contador=0;

    public acelerometro() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_acelerometro, container, false);

        double gravedad= SensorManager.STANDARD_GRAVITY;

        SensorManager administrador = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor acelerometro =  administrador.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        administrador.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_FASTEST);
        tvAX = v.findViewById(R.id.tvAX);
        tvAY = v.findViewById(R.id.tvAY);
        tvAZ = v.findViewById(R.id.tvAZ);
        tvLE = v.findViewById(R.id.tvLE);
        tvMax= v.findViewById(R.id.tvMax);
        tvContador = v.findViewById(R.id.tvContador);
        tvGravedad = v.findViewById(R.id.tvGrav);
        tvGravedad.setText(""+SensorManager.STANDARD_GRAVITY);

        new ClaseAsincrona().execute();

        return v;
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        x=event.values[0];
        y=event.values[1];
        z=event.values[2];
        lonEu = Math.sqrt(x*x + y*y + z*z);
        if(lonEu>le_max) le_max = lonEu;
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }

    class ClaseAsincrona extends AsyncTask<Void,Void,Void> {

        @Override
        protected Void doInBackground(Void... voids) {
            while(true){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                contador ++;
                publishProgress();
            }
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            //super.onProgressUpdate(values);
            tvAX.setText(""+x);
            tvAY.setText(""+y);
            tvAZ.setText(""+z);

            tvLE.setText(""+lonEu);
            tvMax.setText(""+le_max);
            tvContador.setText(""+contador);
        }
    }

}