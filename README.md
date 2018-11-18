[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-GeoLocator--Android-green.svg?style=flat )]( https://android-arsenal.com/details/1/7331 )

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
	       implementation 'com.github.AravindVijay7:GeoLocator-Android:1.0.2'

	}


# Usage


 ## Initaialize GeoLocator:
 
   > GeoLocator geoLocator = new GeoLocator(getApplicationContext(),MainActivity.this);
  
 ## get latitiude and lontitude by:
  
   > geoLocator.getLattitude()
   
   > geoLocator.getLongitude()
