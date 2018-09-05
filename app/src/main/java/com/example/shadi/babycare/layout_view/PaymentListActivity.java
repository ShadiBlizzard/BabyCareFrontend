package com.example.shadi.babycare.layout_view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.PaymentAdapter;
import model.Payment;

public class PaymentListActivity extends BaseActivity {

    private ListView listView;
    private PaymentAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_payment_list, fl);
        super.setTitle("Your payments");

        listView = findViewById(R.id.payment_list);
        listCreation();

    }

    private void listCreation() {

        //TODO BACKEND CALL
        ArrayList<Payment> payments = new ArrayList<>();
        payments.add(new Payment());
        payments.add(new Payment());
        payments.add(new Payment());
        payments.add(new Payment());
        payments.add(new Payment());
        payments.add(new Payment());
        payments.add(new Payment());
        payments.add(new Payment());
        payments.add(new Payment());

        adapter = new PaymentAdapter(this, payments);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> payment, View view, int position, long id) {
                //TODO chiamata all'activity con pagamento singolo


            }
        });


    }
}
