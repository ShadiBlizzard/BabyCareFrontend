package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.content.res.Configuration;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

import model.AppointmentStatus;
import model.Availability;
import model.Message;
import model.MoneyAccount;
import model.Payment;
import model.Reservation;
import model.Uzer;

public class BaseActivity extends AppCompatActivity {

    private DrawerLayout mDrLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        NavigationView nv= findViewById(R.id.nav_view);
        mDrLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrLayout, R.string.open, R.string.close);
        mDrLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //changing language
        Locale locale = new Locale("en_US");
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getApplicationContext().getResources().updateConfiguration(config, null);

        //code for clicked navigation item
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.nav_home:
                        //TODO HOME BASED ON USER ROLE
                        Intent homeCaller = new Intent(getApplicationContext(), HomeParentActivity.class);
                        startActivity(homeCaller);
                        break;
                    case R.id.nav_reservations:
                        Intent resCaller = new Intent(getApplicationContext(), ReservationsListActivity.class);

                        //TODO BACKEND RETRIEVE RESERVATIONS
                        ArrayList<Reservation> res = new ArrayList<>();
                        res.add(new Reservation( Calendar.getInstance(),
                                Calendar.getInstance(), Calendar.getInstance(),
                                new Uzer(), new Availability(), AppointmentStatus.REQUESTED));
                        resCaller.putExtra("reservations", res);
                        startActivity(resCaller);
                        break;
                    case R.id.nav_messages:
                        Intent msgCaller = new Intent(getApplicationContext(), MessagesListActivity.class);
                        //TODO BACKEND RETRIEVE MESSAGES
                        ArrayList<Message> obj = new ArrayList<>();
                        obj.add(new Message());
                        obj.add(new Message());
                        obj.get(1).setSeen(true);
                        obj.add(new Message());

                        msgCaller.putExtra("messages", obj);
                        startActivity(msgCaller);
                        break;
                    case R.id.nav_profile:
                        //TODO PROFILE BASED ON USER ROLE
                        Intent profileCaller = new Intent(getApplicationContext(), ProfileParFromBsActivity.class);
                        startActivity(profileCaller);
                        break;
                    case R.id.nav_money:
                        Intent moneyCaller = new Intent(getApplicationContext(), MoneyAccountActivity.class);
                        startActivity(moneyCaller);
                        break;
                    case R.id.nav_payments:
                        //TODO PAYMENT LIST RETRIEVAL
                        Intent payCaller = new Intent(getApplicationContext(), PaymentListActivity.class);
                        ArrayList<Payment> pay = new ArrayList<>();
                        pay.add(new Payment());
                        pay.add(new Payment());
                        pay.add(new Payment());

                        payCaller.putExtra("payments", pay);
                        startActivity(payCaller);
                        break;
                    case R.id.nav_logout:
                        //TODO LOGOUT MANAGING
                        break;
                }

                return false;
            }
        });


    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
