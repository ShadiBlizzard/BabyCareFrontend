package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import model.Reservation;
import model.Review;
import model.Uzer;

public class ProfileBsFromParActivity extends ProfileParFromBsActivity {

    private Button askapp, reviews;
    private Reservation res;
    private Uzer bs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout cl = findViewById(R.id.profile_variable_content);

        getLayoutInflater().inflate(R.layout.activity_profile_bs_from_par, cl);

        askapp = findViewById(R.id.ask_appointment);
        reviews = findViewById(R.id.see_reviews);

        res = (Reservation) getIntent().getSerializableExtra("res");
        bs = (Uzer) getIntent().getSerializableExtra("bs");


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        super.setName(bs.getData().getName());
        super.setSurname(bs.getData().getSurname());
        super.setDistrict(bs.getData().getDistrict());
        super.setNeighborhood(bs.getData().getNeighborhood());
        super.setCity(bs.getData().getCity());


        askapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ReservingActivity.class);
                it.putExtra("res", res);
                startActivity(it);
            }
        });

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO HARDCODE RETRIEVING LISTA REVIEW DAL PROFILO SPECIFICATO IN BS
                ArrayList<Review> obj = new ArrayList<>();
                obj.add(new Review());
                obj.add(new Review());

                Intent it = new Intent(getApplicationContext(), ReviewListActivity.class);
                it.putExtra("reviews", obj);
                startActivity(it);
            }
        });
    }
}
