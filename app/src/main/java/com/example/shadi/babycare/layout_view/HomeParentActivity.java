package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.os.Bundle;
import android.view.View;

import com.example.shadi.babycare.R;

public class HomeParentActivity extends HomeActivity {
    private ConstraintLayout variable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        variable = findViewById(R.id.variable_home_content);
        getLayoutInflater().inflate(R.layout.activity_home_parent, variable);

        variable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(getApplicationContext(), SearchingActivity.class);
                startActivity(it);
            }
        });



    }
}
