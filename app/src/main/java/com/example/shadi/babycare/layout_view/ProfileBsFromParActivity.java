package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import model.Review;

public class ProfileBsFromParActivity extends ProfileParFromBsActivity {

    private Button askapp, reviews;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO DOVRA' RICEVERE DATI IN INTENT O DAL BACKEND COME DRAFT
        super.onCreate(savedInstanceState);
        ConstraintLayout cl = findViewById(R.id.profile_variable_content);

        getLayoutInflater().inflate(R.layout.activity_profile_bs_from_par, cl);

        askapp = findViewById(R.id.ask_appointment);
        reviews = findViewById(R.id.see_reviews);

        askapp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ReservingActivity.class);
                startActivity(it);
            }
        });

        reviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO HARDCODE
                ArrayList<Review> obj = new ArrayList<>();
                obj.add(new Review(2.5f, "rev1", "babys1", "sbiribillo volante"));
                obj.add(new Review(3f, "rev2", "babys1", "sbiribillo volante"));

                Intent it = new Intent(getApplicationContext(), ReviewListActivity.class);
                it.putExtra("reviews", obj);
                startActivity(it);
            }
        });
    }
}
