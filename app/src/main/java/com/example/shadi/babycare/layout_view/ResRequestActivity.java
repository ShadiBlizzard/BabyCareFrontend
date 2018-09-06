package com.example.shadi.babycare.layout_view;

import android.location.Address;
import android.location.Geocoder;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.Message;

public class ResRequestActivity extends BaseActivity {
    private TextView timestamp, seen, text, from, to, date, location;
    private Message m;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_res_request, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(1).setChecked(true);
        super.setTitle("Message");

        m = (Message) getIntent().getSerializableExtra("message");

        timestamp = findViewById(R.id.res_msg_id);
        text = findViewById(R.id.res_msg_content);
      /*  sender = findViewById(R.id.res_msg_by);

        date = findViewById(R.id.res_msg_date);
        from = findViewById(R.id.res_msg_from);
        to = findViewById(R.id.res_msg_to);
        location = findViewById(R.id.res_msg_loc);*/

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        timestamp.setText(m.getTimestamp().toString());
        text.setText(m.getTxt());
      /*  sender.setText(m.getRes().getPa().getData().getName());

        date.setText(m.getRes().getWhen().toString());
        from.setText(m.getRes().getStart().toString());
        to.setText(m.getRes().getEnd().toString());

        Geocoder g = new Geocoder(this);
        List<Address> a = new ArrayList<>();
        try {
           a = g.getFromLocation(m.getRes().getLat(), m.getRes().getLongi(), 1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        location.setText(a.get(0).getLocality() + ", " + a.get(0).getThoroughfare());
*/



    }
}
