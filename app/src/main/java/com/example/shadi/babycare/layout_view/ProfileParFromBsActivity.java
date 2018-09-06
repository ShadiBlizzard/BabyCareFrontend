package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class ProfileParFromBsActivity extends BaseActivity {

    private TextView name, surname;
    private TextView description, city, district, neighborhood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_profile_par_from_bs, fl);

        name = findViewById(R.id.name_pro);
        surname = findViewById(R.id.surname_pro);
      //  description = findViewById(R.id.description_pro);
        city = findViewById(R.id.city_pro);
        district = findViewById(R.id.district_pro);
        neighborhood = findViewById(R.id.neighborhood_pro);

        super.setTitle("Profile");
    }

    public TextView getName() {
        return name;
    }

    public void setName(String n) {
        this.name.setText(n);
    }

    public TextView getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname.setText(surname);
    }

    public TextView getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city.setText(city);
    }

    public TextView getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district.setText(district);
    }

    public TextView getNeighborhood() {
        return neighborhood;
    }

    public void setNeighborhood(String neighborhood) {
        this.neighborhood.setText(neighborhood);
    }
}


