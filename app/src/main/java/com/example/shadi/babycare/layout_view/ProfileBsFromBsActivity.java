package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

import model.Uzer;

public class ProfileBsFromBsActivity extends ProfileParFromBsActivity {

    private Button update, reviews, availabilities, payment;
    private Uzer u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.profile_variable_content);
        getLayoutInflater().inflate(R.layout.activity_profile_bs_from_bs, fl);
        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(3).setChecked(true);

        update = findViewById(R.id.update_profile);
        reviews = findViewById(R.id.see_reviews);
        availabilities = findViewById(R.id.set_availabilities);
        payment = findViewById(R.id.set_payment);

        u = (Uzer) getIntent().getSerializableExtra("profile");


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        super.setName(u.getData().getName());
        super.setSurname(u.getData().getSurname());
        super.setDistrict(u.getData().getDistrict());
        super.setNeighborhood(u.getData().getNeighborhood());
        super.setCity(u.getData().getCity());

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), UpdateProfileActivity.class);
                it.putExtra("profile", u);
                startActivity(it);
            }
        });

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //TODO REVIEWS
                Intent it = new Intent(getApplicationContext(), ReviewListActivity.class);
                startActivity(it);
            }
        });

        availabilities.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), SetAvailabilityActivity.class);
                startActivity(it);
            }
        });

        payment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), CreditCardActivity.class);
                startActivity(i);
            }
        });
    }
}
