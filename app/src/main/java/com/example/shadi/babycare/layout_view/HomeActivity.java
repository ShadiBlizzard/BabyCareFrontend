package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.NavigationView;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.shadi.babycare.R;

public class HomeActivity extends BaseActivity {

    private ConstraintLayout res_cons, mes_cons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_home, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(0).setChecked(true);

        res_cons = findViewById(R.id.res_cons);
        mes_cons = findViewById(R.id.mes_cons);

        super.setTitle("Home");

        res_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ReservationsListActivity.class);
                startActivity(it);
            }
        });

        mes_cons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), MessagesListActivity.class);
                startActivity(it);
            }
        });
    }
}
