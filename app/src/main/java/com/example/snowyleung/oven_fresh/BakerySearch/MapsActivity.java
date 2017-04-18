package com.example.snowyleung.oven_fresh.BakerySearch;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.snowyleung.oven_fresh.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.HashMap;

public class MapsActivity extends FragmentActivity
        implements OnMapReadyCallback {

    private GoogleMap mMap;
    private HashMap<Marker, MyMarker> mMarkersHashMap;
    private ArrayList<MyMarker> mMyMarkersArray = new ArrayList<MyMarker>();

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

        mMarkersHashMap = new HashMap<>();

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop B1 Ground Floor of Nos. 152A, 152B, 152C & 152D Prince Edward Road West, Nos. 222G & 222H Fa Yuen Street, Kowloon", "sainthonore", Double.parseDouble("22.311806"), Double.parseDouble("114.224656")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop 10, Po Hei Court Shopping Centre, Po Hei Court, Sham Shui Po ", "sainthonore", Double.parseDouble("22.337158"), Double.parseDouble("114.159163")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nSG/F, 796 Cheung Sha Wan Rd.", "sainthonore", Double.parseDouble("22.337991"), Double.parseDouble("114.149292")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop No. K3, Upper Ground Floor, Olympian City 1, Olympian City, Kowloon", "sainthonore", Double.parseDouble("22.3169112"), Double.parseDouble("114.161869")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nPortion of Unit No. 42 (named as Shop 42C) on Ground Floor, Hunghom Commercial Centre, Nos. 37-39 Ma Tau Wai Road, Kowloon", "sainthonore", Double.parseDouble("22.309979"), Double.parseDouble("114.187767")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nFront Portion on Ground Floor, No. 68C To Kwa Wan Road, Kowloon", "sainthonore", Double.parseDouble("22.316177"), Double.parseDouble("114.189147")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nSShop G16, Whampoa Garden Site, Hung Hom", "sainthonore", Double.parseDouble("22.303014"), Double.parseDouble("114.190277")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nRm 205, Po Lam Shopping Ctr., Po Lam Estate, Junk Bay", "sainthonore", Double.parseDouble("22.326751"), Double.parseDouble("114.254692")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop No. 1-131 on Level 1 of the Commercial Portion of Tseung Kwan O Plaza, No. 1 Tong Tak Street, Tseung Kwan O, New Territories, Hong Kong", "sainthonore", Double.parseDouble("22.308644"), Double.parseDouble("114.262521")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop No. M03 & 04 on MTR Floor, Domain, Yau Tong, Kowloon", "sainthonore", Double.parseDouble("22.296571"), Double.parseDouble("114.238733")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop Unit 129, Paradise Mall, Hong Kong", "sainthonore", Double.parseDouble("22.277439"), Double.parseDouble("114.239736")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop B on Ground Floor, Nos. 19, 21 & 21A North Point Road, H.K.", "sainthonore", Double.parseDouble("22.291269"), Double.parseDouble("114.196220")));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop 330A, Level 3, New Jade Shopping Arcade, Chai Wan.", "sainthonore", Double.parseDouble("22.264290"), Double.parseDouble("114.236565")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop C-1a, Concourse Level, apm, Millennium City 5, 418 Kwun Tong Road, Kwun Tong, Kowloon", "yamazaki", Double.parseDouble("22.311806"), Double.parseDouble("114.224656")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop No. G3A on the Ground Floor, Site 11, Treasure World, Whampoa Garden, Hung Hom, Kowloon", "yamazaki", Double.parseDouble("22.305224"), Double.parseDouble("114.191172")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop 7, G/F, Union Centre, 771-775 Nathan Road, Kowloon", "yamazaki", Double.parseDouble("22.325552"), Double.parseDouble("114.167942")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop no. 1161, 1/F., Zone A, Lok Fu Plaza, 198 Junction Road, Kowloon", "yamazaki", Double.parseDouble("22.337747"), Double.parseDouble("114.186777")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop TAW 38, Paid Concourse, Tai Wai Station N.T. (East Rail Line)", "yamazaki", Double.parseDouble("22.372779"), Double.parseDouble("114.177988")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nUnit No. 127, 1st Floor, Dragon Centre, 37K Yen Chow Street, Shamshuipo, Kowloon", "yamazaki", Double.parseDouble("22.330972"), Double.parseDouble("114.159362")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nKiosk HOK 72, Unpaid Concourse, Hong Kong Station, H.K (Airport Express)", "yamazaki", Double.parseDouble("22.284892"), Double.parseDouble("114.158316")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop No. 112A, Level 1, Tsuen Wan Plaza, 4-30 Tai Pa Street, Tsuen Wan, N.T.", "yamazaki", Double.parseDouble("22.3707362"), Double.parseDouble("114.1112527")));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop 304, L 3/F, New Jade Gardens, Chai Wan, Inland Lot No.120, Hong Kong", "yamazaki", Double.parseDouble("22.263784"), Double.parseDouble("114.236375")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nWorkshop 5A, G/F., Kingsford Ind. Centre, 13 Wang Hoi Road, Kowloon Bay, Kln.", "kingbakery", Double.parseDouble("22.3223602"), Double.parseDouble("114.210606")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nUnit G8, 1 Hung To Road, Kwun Tong, Kln.", "kingbakery", Double.parseDouble("22.3145117"), Double.parseDouble("114.2185424")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop 5, G/F., Winning Centre, 29 Tai Yau Street, San Po Kong, Kln.", "kingbakery", Double.parseDouble("22.3371131"), Double.parseDouble("114.1982333")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nFactory B, G/F, Gee Luen Factory Building, 316-318 Kwun Tong Road, Kowloon.", "kingbakery", Double.parseDouble("22.3176156"), Double.parseDouble("114.2144358")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop 2, G/F., Lei Yue Mun Plaza, Yau Tong, Kowloon.", "kingbakery", Double.parseDouble("22.2967412"), Double.parseDouble("114.2393923")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nUnit No.1, G/F., Westley Square, 48 Hoi Yuen Road, Kwun Tong, Kln.", "kingbakery", Double.parseDouble("22.3089461"), Double.parseDouble("114.2232633")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nFactory A1, G/F., Block 1, Camelpaint Buildings, 62 Hoi Yuen Road, Kwun Tong, Kln.", "kingbakery", Double.parseDouble("22.3105221"), Double.parseDouble("114.224902")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop No. 21, G/F, Yat Tung Shopping Centre, Yat Tung Estate, Tung Chung, N.T.", "kingbakery", Double.parseDouble("22.2816892"), Double.parseDouble("113.9349039")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop No. 208A, 2/F, Wo Che Shopping Centre., Wo Che Estate, Shatin N.T.", "kingbakery", Double.parseDouble("22.3882857"), Double.parseDouble("114.1948104")));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop No. 9, 2/F, the Pacifica Mall, No. 9 Sham Shing Road, Lai Chi Kok, Kowloon", "kingbakery", Double.parseDouble("22.3348014"), Double.parseDouble("114.1496666")));

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling

            ActivityCompat.requestPermissions(MapsActivity.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_FINE_LOCATION_PERMISSION);

            return;
        }

        mMap.setMyLocationEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setMapToolbarEnabled(true);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(CityU));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(16));
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.getUiSettings().setAllGesturesEnabled(true);


        mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener()
        {
            @Override
            public boolean onMarkerClick(com.google.android.gms.maps.model.Marker marker)
            {
                marker.showInfoWindow();
                return true;
            }
        });

        plotMarkers(mMyMarkersArray);
    }

    private void plotMarkers(ArrayList<MyMarker> markers)
    {
        if(markers.size() > 0)
        {
            for (MyMarker myMarker : markers)
            {

                // Create user marker with custom icon and other options
                MarkerOptions markerOption = new MarkerOptions().position(new LatLng(myMarker.getmLatitude(), myMarker.getmLongitude()));
                markerOption.icon(BitmapDescriptorFactory.fromResource(R.drawable.currentlocation_icon));

                Marker currentMarker = mMap.addMarker(markerOption);
                mMarkersHashMap.put(currentMarker, myMarker);

                mMap.setInfoWindowAdapter(new MarkerInfoWindowAdapter());
            }
        }
    }
    private int manageMarkerIcon(String markerIcon)
    {
        if (markerIcon.equals("sainthonore"))
            return R.drawable.sainthonore;
        else if(markerIcon.equals("yamazaki"))
            return R.drawable.yamazaki;
        else if(markerIcon.equals("kingbakery"))
            return R.drawable.kingbakery;
        else
            return R.drawable.icondefault;
    }

    public class MarkerInfoWindowAdapter implements GoogleMap.InfoWindowAdapter
    {
        public MarkerInfoWindowAdapter()
        {
        }

        @Override
        public View getInfoWindow(Marker marker)
        {
            return null;
        }

        @Override
        public View getInfoContents(Marker marker)
        {
            View v  = getLayoutInflater().inflate(R.layout.infowindow_layout, null);

            MyMarker myMarker = mMarkersHashMap.get(marker);

            ImageView markerIcon = (ImageView) v.findViewById(R.id.marker_icon);

            TextView markerLabel = (TextView)v.findViewById(R.id.marker_label);

            markerIcon.setImageResource(manageMarkerIcon(myMarker.getmIcon()));

            markerLabel.setText(myMarker.getmLabel1());

            TextView anotherLabel = (TextView)v.findViewById(R.id.another_label);

            anotherLabel.setText(myMarker.getmLabel2());

            return v;
        }
    }
}
