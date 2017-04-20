package com.example.snowyleung.oven_fresh.BakerySearch;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.MaskFilter;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
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
    private TextView markerlatlng;

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

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop B1 Ground Floor of Nos. 152A, 152B, 152C & 152D Prince Edward Road West, Nos. 222G & 222H Fa Yuen Street, Kowloon", "sainthonore", Double.parseDouble("22.311806"), Double.parseDouble("114.224656"), "https://www.google.com.hk/maps/place/聖安娜餅屋/@22.3338505,114.1704223,13z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0xaa72e24a4a6b29f!8m2!3d22.3244824!4d114.1701901"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop 10, Po Hei Court Shopping Centre, Po Hei Court, Sham Shui Po ", "sainthonore", Double.parseDouble("22.337158"), Double.parseDouble("114.159163"), "https://www.google.com.hk/maps/place/聖安娜餅屋/@22.3306748,114.1565177,13z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0xf4b16584749b8182!8m2!3d22.3353991!4d114.1563284"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nSG/F, 796 Cheung Sha Wan Rd.", "sainthonore", Double.parseDouble("22.337991"), Double.parseDouble("114.149292"), "https://www.google.com.hk/maps/place/聖安娜餅屋/@22.3306748,114.1565177,13z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0xf4b16584749b8182!8m2!3d22.3353991!4d114.1563284"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop No. K3, Upper Ground Floor, Olympian City 1, Olympian City, Kowloon", "sainthonore", Double.parseDouble("22.3169112"), Double.parseDouble("114.161869"), "https://www.google.com.hk/maps/place/聖安娜餅屋/@22.320354,114.1433219,13.92z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x94f8757b0a928e37!8m2!3d22.3247901!4d114.1614461"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nPortion of Unit No. 42 (named as Shop 42C) on Ground Floor, Hunghom Commercial Centre, Nos. 37-39 Ma Tau Wai Road, Kowloon", "sainthonore", Double.parseDouble("22.309979"), Double.parseDouble("114.187767"), "https://www.google.com.hk/maps/place/聖安娜_紅磡商業中心/@22.3179145,114.1540522,13.92z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x6cd9a140ee8b79ff!8m2!3d22.3100313!4d114.1877317"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nFront Portion on Ground Floor, No. 68C To Kwa Wan Road, Kowloon", "sainthonore", Double.parseDouble("22.316177"), Double.parseDouble("114.189147"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.3179145,114.1540522,13.92z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x98575c809ddcc49d!8m2!3d22.3160561!4d114.1891801"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nSShop G16, Whampoa Garden Site, Hung Hom", "sainthonore", Double.parseDouble("22.303014"), Double.parseDouble("114.190277"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.3179145,114.1540522,13.92z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x39948941fe7d545e!8m2!3d22.302974!4d114.1903174"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nRm 205, Po Lam Shopping Ctr., Po Lam Estate, Junk Bay", "sainthonore", Double.parseDouble("22.326751"), Double.parseDouble("114.254692"), "https://www.google.com.hk/maps/place/聖安娜餅屋/@22.325798,114.2521895,16.3z/data=!4m5!3m4!1s0x3404040e50b0d2bb:0x8ac64de41dbcfbe6!8m2!3d22.3266851!4d114.2545596"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop No. 1-131 on Level 1 of the Commercial Portion of Tseung Kwan O Plaza, No. 1 Tong Tak Street, Tseung Kwan O, New Territories, Hong Kong", "sainthonore", Double.parseDouble("22.308644"), Double.parseDouble("114.262521"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.3071524,114.2546565,15.07z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x7858aa4d2757212c!8m2!3d22.3087161!4d114.2622972"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop No. M03 & 04 on MTR Floor, Domain, Yau Tong, Kowloon", "sainthonore", Double.parseDouble("22.296571"), Double.parseDouble("114.238733"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.2935074,114.2256822,13.98z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0xeb53cdf83d49f0b1!8m2!3d22.2965615!4d114.2385113"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop Unit 129, Paradise Mall, Hong Kong", "sainthonore", Double.parseDouble("22.277439"), Double.parseDouble("114.239736"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.2708011,114.2315216,14z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0xb0d56decb6fbdc98!8m2!3d22.2769649!4d114.2397183"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop B on Ground Floor, Nos. 19, 21 & 21A North Point Road, H.K.", "sainthonore", Double.parseDouble("22.291269"), Double.parseDouble("114.196220"),"https://www.google.com.hk/maps/place/聖安娜+-+北角1/@22.2873129,114.2042245,14z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x937726b1c37512b2!8m2!3d22.291196!4d114.1964382"));

        mMyMarkersArray.add(new MyMarker("Saint Honore", "Address: \nShop 330A, Level 3, New Jade Shopping Arcade, Chai Wan.", "sainthonore", Double.parseDouble("22.264290"), Double.parseDouble("114.236565"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop C-1a, Concourse Level, apm, Millennium City 5, 418 Kwun Tong Road, Kwun Tong, Kowloon", "yamazaki", Double.parseDouble("22.311806"), Double.parseDouble("114.224656"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop No. G3A on the Ground Floor, Site 11, Treasure World, Whampoa Garden, Hung Hom, Kowloon", "yamazaki", Double.parseDouble("22.305224"), Double.parseDouble("114.191172"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop 7, G/F, Union Centre, 771-775 Nathan Road, Kowloon", "yamazaki", Double.parseDouble("22.325552"), Double.parseDouble("114.167942"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop no. 1161, 1/F., Zone A, Lok Fu Plaza, 198 Junction Road, Kowloon", "yamazaki", Double.parseDouble("22.337747"), Double.parseDouble("114.186777"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop TAW 38, Paid Concourse, Tai Wai Station N.T. (East Rail Line)", "yamazaki", Double.parseDouble("22.372779"), Double.parseDouble("114.177988"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nUnit No. 127, 1st Floor, Dragon Centre, 37K Yen Chow Street, Shamshuipo, Kowloon", "yamazaki", Double.parseDouble("22.330972"), Double.parseDouble("114.159362"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nKiosk HOK 72, Unpaid Concourse, Hong Kong Station, H.K (Airport Express)", "yamazaki", Double.parseDouble("22.284892"), Double.parseDouble("114.158316"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop No. 112A, Level 1, Tsuen Wan Plaza, 4-30 Tai Pa Street, Tsuen Wan, N.T.", "yamazaki", Double.parseDouble("22.3707362"), Double.parseDouble("114.1112527"),"https://www.google.com.hk/maps/place/荃灣廣場/@22.3714864,114.1092069,14.67z/data=!4m12!1m6!3m5!1s0x3403f8eefe75c097:0x25cd1485b5fe9494!2z6I2D54Gj5buj5aC0!8m2!3d22.370735!4d114.111309!3m4!1s0x3403f8eefe75c097:0x25cd1485b5fe9494!8m2!3d22.370735!4d114.111309"));

        mMyMarkersArray.add(new MyMarker("Yamazaki", "Address: \nShop 304, L 3/F, New Jade Gardens, Chai Wan, Inland Lot No.120, Hong Kong", "yamazaki", Double.parseDouble("22.263784"), Double.parseDouble("114.236375"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nWorkshop 5A, G/F., Kingsford Ind. Centre, 13 Wang Hoi Road, Kowloon Bay, Kln.", "kingbakery", Double.parseDouble("22.3223602"), Double.parseDouble("114.210606"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nUnit G8, 1 Hung To Road, Kwun Tong, Kln.", "kingbakery", Double.parseDouble("22.3145117"), Double.parseDouble("114.2185424"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop 5, G/F., Winning Centre, 29 Tai Yau Street, San Po Kong, Kln.", "kingbakery", Double.parseDouble("22.3371131"), Double.parseDouble("114.1982333"),"https://www.google.com.hk/maps/search/山琦麵包/@22.296215,114.192152,13.31z"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nFactory B, G/F, Gee Luen Factory Building, 316-318 Kwun Tong Road, Kowloon.", "kingbakery", Double.parseDouble("22.3176156"), Double.parseDouble("114.2144358"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop 2, G/F., Lei Yue Mun Plaza, Yau Tong, Kowloon.", "kingbakery", Double.parseDouble("22.2967412"), Double.parseDouble("114.2393923"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nUnit No.1, G/F., Westley Square, 48 Hoi Yuen Road, Kwun Tong, Kln.", "kingbakery", Double.parseDouble("22.3089461"), Double.parseDouble("114.2232633"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nFactory A1, G/F., Block 1, Camelpaint Buildings, 62 Hoi Yuen Road, Kwun Tong, Kln.", "kingbakery", Double.parseDouble("22.3105221"), Double.parseDouble("114.224902"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop No. 21, G/F, Yat Tung Shopping Centre, Yat Tung Estate, Tung Chung, N.T.", "kingbakery", Double.parseDouble("22.2816892"), Double.parseDouble("113.9349039"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop No. 208A, 2/F, Wo Che Shopping Centre., Wo Che Estate, Shatin N.T.", "kingbakery", Double.parseDouble("22.3882857"), Double.parseDouble("114.1948104"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

        mMyMarkersArray.add(new MyMarker("King Bakery", "Address: \nShop No. 9, 2/F, the Pacifica Mall, No. 9 Sham Shing Road, Lai Chi Kok, Kowloon", "kingbakery", Double.parseDouble("22.3348014"), Double.parseDouble("114.1496666"),"https://www.google.com.hk/maps/place/聖安娜餅屋/@22.296215,114.192152,13.31z/data=!4m8!1m2!2m1!1z6IGW5a6J5aic!3m4!1s0x0:0x268b2ba338a2032c!8m2!3d22.2639982!4d114.2370093"));

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

        mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
            @Override
            public void onMarkerDragStart(Marker marker) {
                String Url = markerlatlng.getText().toString();
                Intent mapIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(Url));
                mapIntent.setPackage("com.google.android.apps.maps");
                startActivity(mapIntent);
            }

            @Override
            public void onMarkerDrag(Marker marker) {

            }

            @Override
            public void onMarkerDragEnd(Marker marker) {

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

                Marker currentMarker = mMap.addMarker(markerOption.draggable(true));
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

            markerlatlng = (TextView)v.findViewById(R.id.textLatLng);

            markerlatlng.setText(myMarker.getmIP());

            return v;
        }
    }
}
