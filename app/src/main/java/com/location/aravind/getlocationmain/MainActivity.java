package com.location.aravind.getlocationmain;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.location.aravind.getlocation.GeoLocator;

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
                tvValue.setText( geoLocator.getLattitude()+","+ geoLocator.getLongitude());

            }
        });







    }


    public  void initWidgets(){

        tvValue = findViewById(R.id.tvValue);
        btGetData = findViewById(R.id.btGetData);



    }


/*
    Geocoder geocoder;
    List<Address> addresses;
    geocoder = new Geocoder(this, Locale.getDefault());

    addresses = geocoder.getFromLocation(latitude, longitude, 1); // Here 1 represent max location result to returned, by documents it recommended 1 to 5

    String address = addresses.get(0).getAddressLine(0); // If any additional address line present than only, check with max available address lines by getMaxAddressLineIndex()
    String city = addresses.get(0).getLocality();
    String state = addresses.get(0).getAdminArea();
    String country = addresses.get(0).getCountryName();
    String postalCode = addresses.get(0).getPostalCode();
    String knownName = addresses.get(0).getFeatureName();*/






}
