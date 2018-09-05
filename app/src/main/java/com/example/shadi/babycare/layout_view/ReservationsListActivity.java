package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import adapters.ReservationAdapter;
import model.AppointmentStatus;
import model.Uzer;
import model.Reservation;

public class ReservationsListActivity extends BaseActivity {

    private ListView resList;
    private ReservationAdapter resAdp;
    private ArrayList<Reservation> res;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO backend call per lista reservation
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_reservation_list, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(2).setChecked(true);

        super.setTitle("Your reservations");
        resList = findViewById(R.id.res_list);
        res = (ArrayList<Reservation>) getIntent().getSerializableExtra("reservations");
        listCreation();

    }

    private void listCreation(){

        resAdp = new ReservationAdapter(this, res);
        resList.setAdapter(resAdp);
        resList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ReservationDetailsActivity.class);
                i.putExtra("res", res.get(position));
                startActivity(i);
            }
        });
    }
}
