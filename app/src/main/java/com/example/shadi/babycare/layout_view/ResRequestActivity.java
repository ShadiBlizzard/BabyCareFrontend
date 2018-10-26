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
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import model.Message;

public class ResRequestActivity extends BaseActivity {
    private TextView timestamp, id, sender, seen, text, from, to, date, location;
    private Message m = new Message();
    private String msg = "Hi Alessia, you have just received an appointment request, here the details";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_res_request, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(1).setChecked(true);
        super.setTitle("Message");

       // m = (Message) getIntent().getSerializableExtra("message");


        timestamp = findViewById(R.id.timestamp);
        id = findViewById(R.id.res_msg_id);
        text = findViewById(R.id.res_msg_content);
        sender = findViewById(R.id.res_msg_by);

        date = findViewById(R.id.res_msg_date);
        from = findViewById(R.id.res_msg_from);
        to = findViewById(R.id.res_msg_to);
        location = findViewById(R.id.res_msg_loc);



    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        Calendar d = m.getTimestamp();

        int month = d.get(Calendar.MONTH)+1;
         timestamp.setText(d.get(Calendar.DAY_OF_MONTH) + "/" + month + "/" + d.get(Calendar.YEAR) + " "
           + d.get(Calendar.HOUR_OF_DAY) + ":" + d.get(Calendar.MINUTE));
         id.setText("4672");
         text.setText(msg);
         sender.setText("Roberto Piano");

        date.setText(d.get(Calendar.DAY_OF_MONTH) + "/" + month + "/" + d.get(Calendar.YEAR));
        from.setText("18:00");
        to.setText("22:00");

        location.setText("milano, via bonardi 4");



    }
}
