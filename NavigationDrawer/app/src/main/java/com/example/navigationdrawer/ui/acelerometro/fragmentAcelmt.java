package com.example.navigationdrawer.ui.acelerometro;

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

import com.example.navigationdrawer.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link fragmentAcelmt#newInstance} factory method to
 * create an instance of this fragment.
 */
public class fragmentAcelmt extends Fragment implements SensorEventListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    double x=0, y=0, z=0, lonEu=0, le_max=0;
    TextView tvAX,tvAY,tvAZ, tvLE, tvMax, tvGravedad, tvContador;
    int contador=0;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public fragmentAcelmt() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment fragmentAcelmt.
     */
    // TODO: Rename and change types and number of parameters
    public static fragmentAcelmt newInstance(String param1, String param2) {
        fragmentAcelmt fragment = new fragmentAcelmt();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }



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


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        double gravedad= SensorManager.STANDARD_GRAVITY;

        SensorManager administrador = (SensorManager) getActivity().getSystemService(Context.SENSOR_SERVICE);
        Sensor acelerometro =  administrador.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        administrador.registerListener(this,acelerometro,SensorManager.SENSOR_DELAY_FASTEST);
        tvAX = getView().findViewById(R.id.tvAX);
        tvAY = getView().findViewById(R.id.tvAY);
        tvAZ = getView().findViewById(R.id.tvAZ);
        tvLE = getView().findViewById(R.id.tvLE);
        tvMax= getView().findViewById(R.id.tvMax);
        tvContador = getView().findViewById(R.id.tvContador);
        tvGravedad = getView().findViewById(R.id.tvGrav);
        tvGravedad.setText(""+SensorManager.STANDARD_GRAVITY);

        new ClaseAsincrona().execute();

        return inflater.inflate(R.layout.fragment_acelmt, container, false);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}