package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shadi.babycare.R;

import model.Uzer;

public class ProfileParFromParActivity extends ProfileParFromBsActivity {

    private Button update, payment;
    private Uzer u;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout fl = findViewById(R.id.profile_variable_content);
        getLayoutInflater().inflate(R.layout.activity_profile_par_from_par, fl);
        u = (Uzer) getIntent().getSerializableExtra("profile");

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(3).setChecked(true);

        update = findViewById(R.id.update_profile);
        payment = findViewById(R.id.set_payment);


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
                Intent i = new Intent(getApplicationContext(), UpdateProfileActivity.class);
                i.putExtra("prof", u);
                startActivity(i);
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
