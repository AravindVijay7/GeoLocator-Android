package com.location.aravind.getlocation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class GeoLocator {


    private static double lattitude ,longitude;
    private static final int REQUEST_LOCATION = 1;
    private Context context;
    private Activity activity;



    public GeoLocator(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;

        GetLocation();

    }

    public void GetLocation(){


        LocationManager locationManager = (LocationManager) context.getSystemService(context.LOCATION_SERVICE);


        if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {


           Toast.makeText(context,"Permission Denied",Toast.LENGTH_SHORT).show();

        } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)){




            if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                    != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                    (context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

            } else {
                Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);

                Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);

                Location location2 = locationManager.getLastKnownLocation(LocationManager. PASSIVE_PROVIDER);

                if (location != null) {
                    double latti = location.getLatitude();
                    double longi = location.getLongitude();
                    lattitude = latti;
                    longitude = longi;



                } else  if (location1 != null) {
                    double latti = location1.getLatitude();
                    double longi = location1.getLongitude();
                    lattitude = latti;
                    longitude = longi;




                } else  if (location2 != null) {
                    double latti = location2.getLatitude();
                    double longi = location2.getLongitude();
                    lattitude = latti;
                    longitude = longi;


                }else{

                    Toast.makeText(context,"Unble to Trace your location",Toast.LENGTH_SHORT).show();

                }
            }





        }






        }

    public   double getLattitude() {
        return lattitude;
    }

    public  double getLongitude() {
        return longitude;
    }



}
