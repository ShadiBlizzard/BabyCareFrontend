package com.example.shadi.babycare.layout_view;

import android.location.Address;
import android.location.Geocoder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

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
import java.util.Date;
import java.util.List;

import model.Message;
import model.Uzer;

public class ResRequestActivity extends BaseActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {
    private TextView timestamp, id, sender, seen, text, from, to, date, location;
    private Message m = new Message();
    private String msg = "Hi Alessia, you have just received an appointment request, here the details";
    private MapsFragment mf;
    private GoogleMap map;
    private Address loc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_res_request, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(1).setChecked(true);
        super.setTitle("Message");

       // m = (Message) getIntent().getSerializableExtra("message");


        timestamp = findViewById(R.id.timestamp);
        id = findViewById(R.id.res_msg_id);
        text = findViewById(R.id.res_msg_content);
        sender = findViewById(R.id.res_msg_by);

        date = findViewById(R.id.res_msg_date);
        from = findViewById(R.id.res_msg_from);
        to = findViewById(R.id.res_msg_to);
//      location = findViewById(R.id.res_msg_loc);


        //map setting
        mf = new MapsFragment();
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().replace(R.id.map_container2, mf).commit();

        Geocoder geocoder = new Geocoder(this);
        List<Address> temp;

        try {
            temp = geocoder.getFromLocationName("Milano, via Bonardi 4", 1);
            if (temp == null) {
                throw new IllegalArgumentException("address not found");
            }

           loc = temp.get(0);
        }
        catch(Exception e) {
            e.printStackTrace();
        }



    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        SupportMapFragment mapFragment =
                (SupportMapFragment) mf.getChildFragmentManager().findFragmentById(R.id.map_fragment);
        mapFragment.getMapAsync(this);

        Calendar d = m.getTimestamp();

        int month = d.get(Calendar.MONTH)+1;
        String day = '0'+String.valueOf(d.get(Calendar.DAY_OF_MONTH));
         timestamp.setText(day + "/" + month + "/" + d.get(Calendar.YEAR) + " "
           + d.get(Calendar.HOUR_OF_DAY) + ":" + d.get(Calendar.MINUTE));
         id.setText("4672");
         text.setText(msg);
         sender.setText("Roberto Piano");

        date.setText(day + "/" + month + "/" + d.get(Calendar.YEAR));
        from.setText("19:00");
        to.setText("22:00");

       //location.setText("via Bonardi 4, 20133, Milano");



    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        return true;
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        //setting zoom on street view
        map.setMinZoomPreference(15);
        this.changeLocation(loc.getLatitude(), loc.getLongitude());
        MarkerOptions mk = new MarkerOptions();
        mk.icon(BitmapDescriptorFactory.fromResource(R.drawable.home_icon_map));
        mk.position(new LatLng(loc.getLatitude(), loc.getLongitude()));
        mk.title("Home");
        map.addMarker(mk);
        map.setOnMarkerClickListener(this);

    }

    public void changeLocation(Double lat, Double lng) {
        LatLng position = new LatLng(lat, lng);
        map.moveCamera(CameraUpdateFactory.newLatLng(position));
    }

}
