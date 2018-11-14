package com.location.aravind.getlocationmain;

import android.location.Address;
import android.location.Geocoder;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.location.aravind.getlocation.GeoLocator;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tvValue;
    Button btGetData;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initWidgets();

        btGetData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                GeoLocator geoLocator = new GeoLocator(getApplicationContext(),MainActivity.this);
                tvValue.setText( geoLocator.getLattitude()+","+ geoLocator.getLongitude() + "\n" + geoLocator.getAddress());

            }
        });







    }


    public  void initWidgets(){

        tvValue = findViewById(R.id.tvValue);
        btGetData = findViewById(R.id.btGetData);



    }












}
