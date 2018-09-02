package com.example.shadi.babycare.layout_view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import model.ProfileBs;

public class PopupBsInfoActivity extends Activity {

    private TextView name, surname, hourlyCost;
    private RatingBar rating;
    private Button profile, close;
    private ProfileBs bs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_bs_info);
        Intent i = getIntent();
        bs = (ProfileBs) i.getSerializableExtra("profile");


        name = findViewById(R.id.popup_bsname);
        surname = findViewById(R.id.popup_bssurname);
        hourlyCost = findViewById(R.id.popup_hourlycost);
        rating = findViewById(R.id.popup_rating);
        profile = findViewById(R.id.popup_profile);
        close = findViewById(R.id.popup_close);

        name.setText(bs.getName());
        surname.setText(bs.getSurname());
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
                //TODO bisogna aprire il profilo corretto

            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}