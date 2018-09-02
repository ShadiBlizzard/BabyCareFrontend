package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;

import com.example.shadi.babycare.R;

public class ProfileUserFromAdmin extends ProfileParFromBsActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout cl = findViewById(R.id.profile_variable_content);
        getLayoutInflater().inflate(R.layout.activity_profile_user_from_admin, cl);

        //TODO ACTIVITIES PER ATTIVAZIONE E SEND NOTIFICATION
    }
}
