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

import java.util.Locale;

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
                        startActivity(resCaller);
                        break;
                    case R.id.nav_messages:
                        Intent msgCaller = new Intent(getApplicationContext(), MessagesListActivity.class);
                        startActivity(msgCaller);
                        break;
                    case R.id.nav_policy:
                        Intent policyCaller = new Intent(getApplicationContext(), PolicyActivity.class);
                        startActivity(policyCaller);
                        break;
                    case R.id.nav_profile:
                        //TODO PROFILE BASED ON USER ROLE
                        Intent profileCaller = new Intent(getApplicationContext(), ProfileParFromBsActivity.class);
                        startActivity(profileCaller);
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
