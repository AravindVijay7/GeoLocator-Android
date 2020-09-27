package com.location.aravind.getlocationmain;

import android.app.Activity;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.location.aravind.getlocation.GeoLocator;

public class MainActivity extends Activity {

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
                GeoLocator geoLocator = new GeoLocator(getApplicationContext(), MainActivity.this);
                tvValue.setText(String.format("%s,%s\n%s", geoLocator.getLattitude(), geoLocator.getLongitude(), geoLocator.getAddress()));
            }
        });
    }

    public void initWidgets() {
        tvValue = findViewById(R.id.tvValue);
        btGetData = findViewById(R.id.btGetData);
    }
}
