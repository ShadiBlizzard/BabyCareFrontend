package com.example.shadi.babycare.layout_view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import model.Reservation;
import model.Uzer;

public class PopupBsInfoActivity extends Activity {

    private TextView name, surname, hourlyCost;
    private RatingBar rating;
    private Button profile, reserve;
    private ImageView close;
    private Uzer bs;
    private Reservation pendingRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_bs_info);
        Intent i = getIntent();
        bs = (Uzer) i.getSerializableExtra("profile");
        pendingRes = (Reservation) i.getSerializableExtra("reservationData");


        name = findViewById(R.id.popup_bsname);
        surname = findViewById(R.id.popup_bssurname);
        hourlyCost = findViewById(R.id.popup_hourlycost);
        rating = findViewById(R.id.popup_rating);
        profile = findViewById(R.id.popup_profile);
        reserve = findViewById(R.id.popup_reserve);
        close = findViewById(R.id.popup_close);

        name.setText(bs.getData().getName());
        surname.setText(bs.getData().getSurname());
        hourlyCost.setText(bs.getHourlyPrice() + " €/h");
        rating.setRating(bs.getRating());

        //popup window layout settings
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.6));

        WindowManager.LayoutParams lm = getWindow().getAttributes();

        lm.gravity = Gravity.CENTER;

        lm.x=0;
        lm.y=-10;
        getWindow().setAttributes(lm);




    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ProfileBsFromParActivity.class);
                i.putExtra("bs", bs);
                i.putExtra("res", pendingRes);
                startActivity(i);
            }
        });

        reserve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //attivita di prenotazione
                Intent i = new Intent(getApplicationContext(), OkActivity.class);
                startActivity(i);
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
