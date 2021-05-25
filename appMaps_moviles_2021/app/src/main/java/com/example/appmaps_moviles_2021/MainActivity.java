package com.example.appmaps_moviles_2021;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    GoogleMap mapa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (googleServiciosDisponible()){
            Toast.makeText(this,"Disponible...",Toast.LENGTH_LONG).show();
            //setContentView(R.layout.activity_main);
            iniciaMapap();
        }


    }

    private void iniciaMapap() {
        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.fragMapEC);

        mapFragment.getMapAsync( this);
    }

    public boolean googleServiciosDisponible() {
        GoogleApiAvailability api = GoogleApiAvailability.getInstance();
        int estaDisponible = api.isGooglePlayServicesAvailable(this);
        if (estaDisponible == ConnectionResult.SUCCESS){
            return true;
        }
        else if (api.isUserResolvableError(estaDisponible)){
            Dialog dialog = api.getErrorDialog(this, estaDisponible,0);
            dialog.show();
        } else{
            Toast.makeText(this,"No es posible enlazar Google Services", Toast.LENGTH_LONG).show();
        }
        return false;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mapa = googleMap;
        LatLng ll = new LatLng(19.647522, -101.240918);

        CameraUpdate update = CameraUpdateFactory.newLatLngZoom(ll,15);

        LatLng kokis = new LatLng(19.63990,-101.23166);
        googleMap.addMarker(new MarkerOptions().position(kokis).title("Kokis Pizza"));

        LatLng cheddar = new LatLng(19.64907, -101.23956);
        googleMap.addMarker(new MarkerOptions().position(cheddar).title("Cheddar Pizza"));

        LatLng trif = new LatLng(19.64827, -101.23684);
        googleMap.addMarker(new MarkerOptions().position(trif).title("Tacos trífasicos"));

        LatLng nichos = new LatLng(19.69551, -101.18785);
        googleMap.addMarker(new MarkerOptions().position(nichos).title("Nichos Pizzeria"));

        LatLng quesasInd = new LatLng(19.69586, -101.18896);
        googleMap.addMarker(new MarkerOptions().position(quesasInd).title("Quesadillas Independencia"));

        LatLng siza = new LatLng(19.68115, -101.21702);
        googleMap.addMarker(new MarkerOptions().position(siza).title("Little Ceasar's"));

        mapa.moveCamera(update);
    }
}