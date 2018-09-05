package com.example.shadi.babycare.layout_view;

import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.shadi.babycare.R;

public class CreditCardActivity extends BaseActivity {

    private EditText name, number, ccv;
    private Spinner expmonth, expyear;
    private CharSequence item1, item2;
    private Button confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_credit_card, fl);
        super.setTitle("Payment settings");

        name = findViewById(R.id.cc_owner);
        number = findViewById(R.id.cc_number);
        ccv = findViewById(R.id.cc_ccv);
        expmonth = findViewById(R.id.cc_month);
        expyear = findViewById(R.id.cc_year);
        confirm = findViewById(R.id.cc_confirm);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        ArrayAdapter<CharSequence> month = ArrayAdapter.createFromResource(this, R.array.month, R.layout.spinner_item);
        ArrayAdapter<CharSequence> year = ArrayAdapter.createFromResource(this, R.array.year, R.layout.spinner_item);

        month.setDropDownViewResource(R.layout.spinner_item);
        year.setDropDownViewResource(R.layout.spinner_item);

        expmonth.setAdapter(month);
        expyear.setAdapter(year);

        expmonth.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item1 = (CharSequence) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                item1 = null;
            }
        });

        expyear.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                item2 = (CharSequence) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                item2 = null;
            }
        });

        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int result = checkValidity();
                if(result==1) {
                    //TODO BACKEND TASKS
                }
            }
        });
    }

    private int checkValidity() {
        if (TextUtils.isEmpty(name.getText().toString()) || TextUtils.isEmpty(number.getText().toString()) ||
                TextUtils.isEmpty(ccv.getText().toString()) || item1==null || item2==null) {
            Toast t = Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT);
            t.show();
            return 1;
        }
        return 0;
    }
}
