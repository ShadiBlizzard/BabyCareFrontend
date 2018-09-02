package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shadi.babycare.R;

public class HomeAdminActivity extends AppCompatActivity {

    private Button parents, bs, notification, activate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_admin);

        parents = findViewById(R.id.adm_parents);
        bs = findViewById(R.id.adm_bs);
        notification = findViewById(R.id.adm_not);
        activate = findViewById(R.id.adm_act);
        this.setTitle("control panel");

        parents.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ProfileListActivity.class);
                startActivity(it);
            }
        });

        bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), ProfileListActivity.class);
                startActivity(it);
            }
        });


    }
}
