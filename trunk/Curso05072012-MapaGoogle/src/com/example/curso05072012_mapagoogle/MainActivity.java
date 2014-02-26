package com.example.curso05072012_mapagoogle;

import android.os.Bundle;
import android.view.Menu;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapView;

public class MainActivity extends MapActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        MapView mapView = (MapView) this.findViewById(R.id.mapa);
        
        double latitue = -25.442580;
        double longitude = -49.279840;
        
        int lat = (int) (latitue * 1E6);
        int lon = (int) (longitude * 1E6);
        
        GeoPoint geoPoint = new GeoPoint(lat,  lon);
        mapView.getController().animateTo(geoPoint);
        mapView.getController().setZoom(16);
        
        mapView.setBuiltInZoomControls(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }

	@Override
	protected boolean isRouteDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
    
   

    
}
