package com.example.shadi.babycare.layout_view;

import android.location.Address;
import android.location.Geocoder;
import android.support.annotation.IdRes;
import android.support.annotation.Nullable;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Reservation;

public class ReservationDetailsActivity extends BaseActivity {

    private TextView status, name1, name2, timestamp, address;
    private ConstraintLayout cl;
    private Reservation res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_reservation_details, fl);

        status = findViewById(R.id.status_det);
        name1 = findViewById(R.id.part_parent_name);
        name2 = findViewById(R.id.part_bs_name);
        timestamp = findViewById(R.id.part_timestamp);
//        address = findViewById(R.id.part_address);
        cl = findViewById(R.id.part_cons);

        super.setTitle("Reservation details");

        res = (Reservation) getIntent().getSerializableExtra("res");

    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        status.setText(res.getStatus().toString());
        name1.setText(res.getPa().getData().getName());
        name2.setText(res.getAv().getBabysitter().getData().getName());
        timestamp.setText(res.getWhen().toString());

        String stat = status.getText().toString();
        //setting the opt button dynamically
        Button opt = new Button(getApplicationContext());
        opt.setBackgroundResource(R.drawable.button);
        opt.setId(R.id.opt);
        /*ConstraintSet cs = new ConstraintSet();
        cs.clone(cl);
        cs.connect(opt.getId(), ConstraintSet.START, cl.getId(), ConstraintSet.START);
        cs.connect(opt.getId(), ConstraintSet.END, cl.getId(), ConstraintSet.END);
        cs.applyTo(cl);*/

        if(stat.equals("ACCEPTED"))
            opt.setText("CANCEL");
    }


}

