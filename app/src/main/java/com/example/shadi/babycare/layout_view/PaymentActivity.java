package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import model.Payment;

public class PaymentActivity extends BaseActivity {

    private TextView id, creation, amount, status, statusDate;
    private Payment p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_payment, fl);
        super.setTitle("Payment details");
        Intent i = getIntent();
        p = (Payment) i.getSerializableExtra("payment");

        id = findViewById(R.id.pay_id);
        creation = findViewById(R.id.pay_creationDate);
        amount = findViewById(R.id.pay_amount);
        status = findViewById(R.id.pay_status);
        statusDate = findViewById(R.id.pay_status_date);

    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        id.setText(p.getId());
        creation.setText(p.getCreationDate().toString());
        amount.setText(p.getAmount().toString() + " €");

        if(p.isCanceled()) {
            status.setText("CANCELED");
            statusDate.setText(p.getDatetimeCancelled().toString());
        }
        else if (p.isPaid()) {
            status.setText("PAID");
            statusDate.setText(p.getPaidDate().toString());
        }
        else
            status.setText("PENDING");


    }
}
