package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.shadi.babycare.R;

public class HomeBabysitterActivity extends HomeActivity {

    private ConstraintLayout variable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variable = findViewById(R.id.variable_home_content);
        getLayoutInflater().inflate(R.layout.activity_home_babysitter, variable);

        variable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent availab_caller = new Intent(getApplicationContext(), SetAvailabilityActivity.class);
                startActivity(availab_caller);
            }
        });


    }
}
