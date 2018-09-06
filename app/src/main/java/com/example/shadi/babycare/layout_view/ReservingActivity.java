package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import java.util.Calendar;

import model.Reservation;


public class ReservingActivity extends BaseActivity {

    private Button confirm;
    private Reservation res;
    private TextView id, date, start, end, parent, bs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_reserving, fl);

        res = (Reservation) getIntent().getSerializableExtra("res");

        confirm = findViewById(R.id.confirm);
        id = findViewById(R.id.res_msg_id);
        date = findViewById(R.id.res_msg_date);
        start = findViewById(R.id.res_msg_from);
        end = findViewById(R.id.res_msg_to);
        parent = findViewById(R.id.res_msg_by);
        bs = findViewById(R.id.res_msg_for);

        super.setTitle("Create appointment");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        id.setText(res.getId());
        date.setText(res.getWhen().get(Calendar.DAY_OF_MONTH) + " - " + res.getWhen().get(Calendar.MONTH) + " - "
        + res.getWhen().get(Calendar.YEAR));
        start.setText(res.getStart().get(Calendar.HOUR_OF_DAY) + ":" + res.getStart().get(Calendar.MINUTE));
        end.setText(res.getEnd().get(Calendar.HOUR_OF_DAY) + ":" + res.getEnd().get(Calendar.MINUTE));
        parent.setText(res.getPa().getData().getName());
        bs.setText(res.getAv().getBabysitter().getData().getName());

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO backend call, inserimento nuovo appuntamento
            }
        });

    }
}
