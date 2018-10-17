package com.example.shadi.babycare.layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class SingleAvActivity extends BaseActivity {

    private TextView date, from, to, booked;
    private Button update, delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_single_av, fl);
        super.setTitle("Availability");

        date = findViewById(R.id.tv_availableDate_singleAv);
        from = findViewById(R.id.tv_availableStartTime_singleAv);
        to = findViewById(R.id.tv_availableEndTime_singleAv);

        update = findViewById(R.id.btn_update_singleAv);
        delete = findViewById(R.id.btn_delete_singleAv);
    }
}
