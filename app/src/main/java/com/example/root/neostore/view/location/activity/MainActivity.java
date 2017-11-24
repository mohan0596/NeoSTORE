package com.example.root.neostore.view.location.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.root.neostore.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MainActivity extends AppCompatActivity implements OnMapReadyCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SupportMapFragment mapFragment= (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        LatLng mumbai = new LatLng(19.0760, 72.8777);

        LatLng pune = new LatLng(19.0213, 72.8424);
        LatLng nasik = new LatLng(19.0600, 72.8900);
        LatLng lonavala = new LatLng(19.2183, 72.9781);

        googleMap.addMarker(new MarkerOptions().position(mumbai)
                .title("Marker in mumbai"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(mumbai));


        googleMap.addMarker(new MarkerOptions().position(pune)
                .title("Marker in dadar"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(pune));


        googleMap.addMarker(new MarkerOptions().position(nasik)
                .title("Marker in kurla"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(nasik));


        googleMap.addMarker(new MarkerOptions().position(lonavala)
                .title("Marker in thane"));
        googleMap.moveCamera(CameraUpdateFactory.newLatLng(lonavala));



    }


}

