package com.example.snowyleung.oven_fresh.BakerySearch;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.example.snowyleung.oven_fresh.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;

    private static final int REQUEST_FINE_LOCATION_PERMISSION = 102;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        LatLng CityU = new LatLng(22.337144, 114.173166);
        mMap.addMarker(new MarkerOptions().position(CityU).title("City University of Hong Kong").visible(false));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.324244, 114.170535))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.337158, 114.159163))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.337991, 114.149292))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.318142, 114.158991))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.309979, 114.187767))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.316177, 114.189147))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.303014, 114.190277))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.326751, 114.254692))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.308644, 114.262521))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.296571, 114.238733))
                .title("Saint Honore"));

        mMap.addMarker(new MarkerOptions()
                .position(new LatLng(22.277439, 114.239736))
                .title("Saint Honore"));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION_PERMISSION);
            //requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, REQUEST_COARSE_LOCATION_PERMISSION);

            return;
        }
        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CityU));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);
    }
}
