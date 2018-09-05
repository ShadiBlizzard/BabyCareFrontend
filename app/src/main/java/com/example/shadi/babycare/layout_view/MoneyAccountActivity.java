package com.example.shadi.babycare.layout_view;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import model.MoneyAccount;

public class MoneyAccountActivity extends BaseActivity {

    private TextView actual, pending;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_money_account, fl);
        super.setTitle("Money Account");

        actual = findViewById(R.id.money_amount);
        pending = findViewById(R.id.money_pending);
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);


        //TODO HARDCODING
        MoneyAccount ma = new MoneyAccount();
        actual.setText(ma.getAmountAvailable().toString());
        pending.setText(ma.getPendingAmount().toString());

    }
}
