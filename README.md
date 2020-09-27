[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-GeoLocator--Android-green.svg?style=flat )]( https://android-arsenal.com/details/1/7331 ) &nbsp; &nbsp;  [![](https://jitpack.io/v/AravindVijay7/GeoLocator-Android.svg)](https://jitpack.io/#AravindVijay7/GeoLocator-Android)


# GeoLocator-Android
 Using GeoLocator-Android you could easily get you GPS based location from Android Devices
 
 
 
 
# Gradle / Maven dependency
At the moment we do not have a publishing mechanism to a maven repository so the easiest way to add the library to your app is via a JitPack Dependency 

 # Add this to you project.gradle

	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
 # Add this to your App.gradle
  
  	dependencies {
	       implementation 'com.github.AravindVijay7:GeoLocator-Android:2.0.0'
	}


# Usage


 ## Initialize GeoLocator:
 
   > GeoLocator geoLocator = new GeoLocator(getApplicationContext(),MainActivity.this);

     >or(Converting address to latitude and longitude)

   > GeoLocator geoLocator = new GeoLocator(getApplicationContext(),MainActivity.this,"Address String");

 ## get latitude and longitude by:
  
   > geoLocator.getLattitude()
   
   > geoLocator.getLongitude()

 ## get address by:

   > geoLocator.getAddress()
