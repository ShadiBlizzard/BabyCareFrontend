package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Calendar;

import model.AppointmentStatus;
import model.Message;
import model.Reservation;
import model.Uzer;

public class HomeActivity extends BaseActivity {

    private ConstraintLayout res_cons, mes_cons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_home, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(0).setChecked(true);

        res_cons = findViewById(R.id.res_cons);
        mes_cons = findViewById(R.id.mes_cons);

        super.setTitle("Home");

        res_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO RETRIEVE RES
                Intent it = new Intent(getApplicationContext(), ReservationsListActivity.class);
                ArrayList<Reservation> res = new ArrayList<>();
                res.add(new Reservation(45.4642035, 9.186515999999983, Calendar.getInstance(),
                        Calendar.getInstance(), Calendar.getInstance(),
                        new Uzer("mozzarella", "volante", "pic", "Milano, piazza leonardo", 5), new Uzer("name", "surname", "pic", "milano piazza duomo", 3), AppointmentStatus.REQUESTED));
                it.putExtra("reservations", res);
                startActivity(it);
            }
        });

        mes_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO RETRIEVE MESS
                Intent it = new Intent(getApplicationContext(), MessagesListActivity.class);
                ArrayList<Message> obj = new ArrayList<>();
                obj.add(new Message());
                obj.add(new Message());
                obj.add(new Message());

                it.putExtra("messages", obj);
                startActivity(it);
            }
        });
    }
}
