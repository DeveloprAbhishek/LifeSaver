package com.masai.lifesaver

import android.app.Application
import com.google.android.libraries.places.api.Places
import com.google.maps.GeoApiContext
import com.masai.lifesaver.simulator.Simulator

class RideSharingApp : Application() {

    override fun onCreate() {
        super.onCreate()
        Places.initialize(applicationContext, getString(R.string.google_maps_key));
        Simulator.geoApiContext = GeoApiContext.Builder()
            .apiKey(getString(R.string.google_maps_key))
            .build()
    }

}