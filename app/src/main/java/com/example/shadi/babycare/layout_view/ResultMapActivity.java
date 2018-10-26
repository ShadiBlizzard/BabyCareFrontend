package com.example.shadi.babycare.layout_view;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import model.AppointmentStatus;
import model.Availability;
import model.Reservation;
import model.Uzer;

public class ResultMapActivity extends BaseActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener{

    private MapsFragment mf;
    private List<Uzer> bs = new ArrayList<>(), convertedTags=new ArrayList<>();
    private Geocoder geocoder;
    private Calendar date, start, end;
    private String lat;
    private String lng;
    private GoogleMap map;
    private MarkerOptions main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent i = getIntent();
        lat = i.getStringExtra("lat");
        lng = i.getStringExtra("lng");
        bs = (List<Uzer>) i.getSerializableExtra("bs_list");

        //date and time of reservation
        date= (Calendar) i.getSerializableExtra("date");
        start= (Calendar) i.getSerializableExtra("start");
        end= (Calendar) i.getSerializableExtra("end");

        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_result_map, fl);


        super.setTitle("Available babysitters");

        //map setting
        mf = new MapsFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.map_container, mf).commit();


    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) mf.getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

        //phase 1, convert all babysitter addresses into geotag coordinates
        convertedTags = new ArrayList<>();
        geocoder = new Geocoder(this);

        for (int i = 0; i<bs.size(); i++) {
            List<Address> temp;
            Uzer currentBs = bs.get(i);
            try {
                temp = geocoder.getFromLocationName(currentBs.getData().getAddress(), 1);
                if(temp == null) {
                    throw new IllegalArgumentException("address not found");
                }
                convertedTags.add(currentBs);
                convertedTags.get(i).getData().setAddress(temp.get(0).getLatitude() + "+" +temp.get(0).getLongitude());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //setting zoom on street view
        map.setMinZoomPreference(15);
        this.changeLocation(Double.parseDouble(lat), Double.parseDouble(lng));
        main = new MarkerOptions();
        main.icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon_map));
        main.position(new LatLng(Double.parseDouble(lat), Double.parseDouble(lng)));
        main.title("Home");
        map.addMarker(main);


        //phase 2: add a marker for every babysitter on the map
        for(int i = 0; i<convertedTags.size(); i++) {
            //I retrieve latitude and longitude from the addresses
            String coord = convertedTags.get(i).getData().getAddress();
            int index = coord.indexOf('+');
            Double latitude = Double.parseDouble(coord.substring(0, index-1));
            Double longitude = Double.parseDouble(coord.substring(index+1, coord.length()-1));

            //I create a new marker for the bs
            MarkerOptions marker = new MarkerOptions();
            marker.icon(BitmapDescriptorFactory.fromResource(R.drawable.geotag_icon));
            marker.position(new LatLng(latitude, longitude));
            map.addMarker(marker);


        }

        map.setOnMarkerClickListener(this);
    }


    public void changeLocation(Double lat, Double lng) {
        LatLng position = new LatLng(lat, lng);
        map.moveCamera(CameraUpdateFactory.newLatLng(position));
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        LatLng coordinates = marker.getPosition();
        Double latiM = coordinates.latitude;
        Double longiM = coordinates.longitude;

        if (Double.compare(latiM, Double.parseDouble(lat))== 0 && Double.compare(longiM, Double.parseDouble(lng)) == 0) {
            marker.showInfoWindow();
            return true;
        }


        Uzer bs = null;
        //looking for the correct bs
        for (int i = 0; i< convertedTags.size(); i++) {
            String coord = convertedTags.get(i).getData().getAddress();
            int index = coord.indexOf('+');
            Double latitude = Double.parseDouble(coord.substring(0, index-1));
            Double longitude = Double.parseDouble(coord.substring(index+1, coord.length()-1));


            if(Double.compare(latiM, latitude) == 0 && Double.compare(longiM, longitude)== 0) {
                bs = convertedTags.get(i);
                break;
            }
        }

        Intent it = new Intent(getApplicationContext(), PopupBsInfoActivity.class);
        it.putExtra("profile", bs);

        //HARDCODED
        Availability a = new Availability();
        a.setBabysitter(bs);
        Reservation r = new Reservation(start, end, date, new Uzer(), a, AppointmentStatus.REQUESTED);

        it.putExtra("reservationData", r);
        startActivity(it);

        return true;

    }
}