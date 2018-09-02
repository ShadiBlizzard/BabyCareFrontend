package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class ProfileParFromBsActivity extends BaseActivity {

    private TextView name, surname;
    private TextView description, city, district, neighborhood, birthday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO backend call, profile details
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_profile_par_from_bs, fl);

        name = findViewById(R.id.name_pro);
        surname = findViewById(R.id.surname_pro);
        description = findViewById(R.id.description_pro);
        city = findViewById(R.id.city_pro);
        district = findViewById(R.id.district_pro);
        neighborhood = findViewById(R.id.neighborhood_pro);
        birthday = findViewById(R.id.birthday_pro);

        super.setTitle("Profile");
    }
}
