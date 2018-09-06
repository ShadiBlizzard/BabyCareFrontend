package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;
import java.util.List;

import adapters.PaymentAdapter;
import model.Payment;

public class PaymentListActivity extends BaseActivity {

    private ListView listView;
    private PaymentAdapter adapter;
    private ArrayList<Payment> payments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_payment_list, fl);
        super.setTitle("Your payments");

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(5).setChecked(true);

        listView = findViewById(R.id.payment_list);
        payments = (ArrayList<Payment>) getIntent().getSerializableExtra("payments");
        listCreation();

    }

    private void listCreation() {
        adapter = new PaymentAdapter(this, payments);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> payment, View view, int position, long id) {
                Payment p = payments.get(position);
                Intent i = new Intent(getApplicationContext(), PaymentActivity.class);
                i.putExtra("payment", p);
                startActivity(i);

            }
        });


    }
}
