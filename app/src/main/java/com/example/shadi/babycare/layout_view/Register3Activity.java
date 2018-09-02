package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shadi.babycare.R;

public class Register3Activity extends AppCompatActivity {

    private EditText address;
    private Spinner district, neighborhood;
    private Bundle bundle;
    private Button goOn;
    private CharSequence item1, item2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register3);
        this.setTitle("Register");
        address = findViewById(R.id.address);
        district = findViewById(R.id.district);
        neighborhood = findViewById(R.id.neighborhood);
        goOn = findViewById(R.id.goon3);
        Intent intent = getIntent();
        bundle = intent.getExtras();
    //TODO ADD DEFAULT VALUE TO SPINNER
        //setting the spinners with hardcoded data TODO here we have to extract data
        //https://stackoverflow.com/questions/9476665/how-to-change-spinner-text-size-and-text-color
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.planets_array,
                R.layout.spinner_item);
        ArrayAdapter<CharSequence> districta = ArrayAdapter.createFromResource(this, R.array.planets_array1,
                R.layout.spinner_item);
        adapter.setDropDownViewResource(R.layout.spinner_item);
        district.setAdapter(districta);
        neighborhood.setAdapter(adapter);

        //listener for district
        district.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item1 = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                item1 = null;
            }
        });

        //listener for district
        neighborhood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                item2 = (CharSequence) parent.getItemAtPosition(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                item2 = null;
            }
        });

        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int result = checkInputValidity();
                if (result == 0)
                    goOn ();
            }
        });

    }

    private void goOn() {
        Intent intent = new Intent(this, Register4Activity.class);
        intent.putExtras(bundle);
        intent.putExtra("address", address.getText().toString());
        intent.putExtra("district", item1);
        intent.putExtra("neighborhood", item2);

        startActivity(intent);
    }

    private int checkInputValidity() {
        int ok = 0;
        if (item1==null || item2 == null) {
            Toast t = Toast.makeText(this, "You must select a district and a neighborhood", Toast.LENGTH_SHORT);
            t.show();
            ok++;
        }

        if (TextUtils.isEmpty(address.getText().toString())) {
            address.setError("Please, insert an address");
            ok++;
        }
         return ok;

    }
}
