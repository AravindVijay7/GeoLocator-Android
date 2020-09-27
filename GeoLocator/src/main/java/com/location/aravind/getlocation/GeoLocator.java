package com.location.aravind.getlocation;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.provider.Settings;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class GeoLocator {


    private static final int REQUEST_LOCATION = 1;
    private static double lattitude, longitude;
    private Context context;
    private Activity activity;
    private String address, city, state, country, postalCode, knownName, conversionAddress;


    public GeoLocator(Context context, Activity activity) {
        this.context = context;
        this.activity = activity;
        GetLocation();
        geoAddress();
    }

    public GeoLocator(Context context, Activity activity, String address) {
        this.context = context;
        this.activity = activity;
        this.conversionAddress = address;
        getLocationFromAddress();
    }


    /**
     * Find coordinates from address
     */
    public void getLocationFromAddress() {

        Geocoder coder = new Geocoder(context);
        List<Address> address;

        try {
            address = coder.getFromLocationName(conversionAddress, 5);
            if (address != null) {
                Address location = address.get(0);
                lattitude = location.getLatitude();
                longitude = location.getLongitude();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Coordinates from  Location manager
     */

    public void GetLocation() {

        //Initialize Location manager
        LocationManager locationManager = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);

        if (locationManager != null) {
            if (!locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
                showSettingsAlert();
            } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {


                if (ActivityCompat.checkSelfPermission(context, Manifest.permission.ACCESS_FINE_LOCATION)
                        != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission
                        (context, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {

                    ActivityCompat.requestPermissions(activity, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION);

                } else {

                    //  Looking for location from Network Provides or GPS or Passive Provider

                    Location location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
                    Location location1 = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                    Location location2 = locationManager.getLastKnownLocation(LocationManager.PASSIVE_PROVIDER);

                    if (location != null) {

                        //Location data available from Network provider
                        lattitude= location.getLatitude();
                        longitude = location.getLongitude();

                    } else if (location1 != null) {

                        //Location data available from GPS
                        lattitude = location1.getLatitude();
                        longitude = location1.getLongitude();

                    } else if (location2 != null) {

                        //Location data available from Passive provider
                        lattitude = location2.getLatitude();
                        longitude = location2.getLongitude();

                    } else {
                        Toast.makeText(context, "Unable to Trace your location", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        } else {
            Toast.makeText(context, "Unable to Trace your location", Toast.LENGTH_SHORT).show();
        }
    }

    public double getLattitude() {
        return lattitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public LatLng getLatLong() {
        return new LatLng(lattitude, longitude);
    }

    /**
     * Converting coordinates to address
     */
    public void geoAddress() {
        Geocoder geocoder;
        List<Address> addresses;
        geocoder = new Geocoder(context, Locale.getDefault());

        try {
            addresses = geocoder.getFromLocation(lattitude, longitude, 1);
            if (addresses.size() > 0) {

                //Translate Required parameters from address array
                address = addresses.get(0).getAddressLine(0);
                city = addresses.get(0).getLocality();
                state = addresses.get(0).getAdminArea();
                country = addresses.get(0).getCountryName();
                postalCode = addresses.get(0).getPostalCode();
                knownName = addresses.get(0).getFeatureName();
            } else {
                //address array is empty
                Toast.makeText(context, "Unble to Trace your location", Toast.LENGTH_SHORT).show();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getKnownName() {
        return knownName;
    }

    /**
     * Checking if GPS is enabled
     */

    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(activity);
        // Setting Dialog Title
        alertDialog.setTitle("GPS is settings");

        // Setting Dialog Message
        alertDialog.setMessage("GPS is not enabled. Do you want to go to settings menu?");

        // On pressing Settings button
        alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                activity.startActivity(intent);
            }
        });

        // on pressing cancel button
        alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        // Showing Alert Message
        alertDialog.show();
    }

}
