package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class ResRequestActivity extends BaseActivity {
    private TextView timestamp, sender, text, from, to, date, location;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_res_request, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(1).setChecked(true);
        super.setTitle("Message");

        timestamp = findViewById(R.id.res_msg_id);
        sender = findViewById(R.id.res_msg_by);
        text = findViewById(R.id.res_msg_content);
        date = findViewById(R.id.res_msg_date);
        from = findViewById(R.id.res_msg_from);
        to = findViewById(R.id.res_msg_to);
        location = findViewById(R.id.res_msg_loc);

    }
}
