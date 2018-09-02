package com.example.shadi.babycare.layout_view;

import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shadi.babycare.R;

public class ResRequestAnswerActivity extends ResRequestActivity {

    private Button accept, reject;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ConstraintLayout cl = findViewById(R.id.bs_answer_buttons);
        getLayoutInflater().inflate(R.layout.activity_res_request_answer, cl);

        accept = findViewById(R.id.button_accept);
        reject = findViewById(R.id.button_reject);

        accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO backend call, accettazione appuntamento
            }
        });

        reject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO backend call, rifiuto appuntamento
                //in base al risultato chiamare ko o ok activity
            }
        });

    }
}
