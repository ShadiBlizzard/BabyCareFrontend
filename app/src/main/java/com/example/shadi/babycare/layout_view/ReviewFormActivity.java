package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shadi.babycare.R;

public class ReviewFormActivity extends BaseActivity {

    private TextView name;
    private EditText title, text;
    private RatingBar ratingBar;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_review_form, fl);


        super.setTitle("New review");

        name = findViewById(R.id.reviewed_bs_name);
        title = findViewById(R.id.new_review_title);
        text = findViewById(R.id.new_review_text);
        ratingBar = findViewById(R.id.new_review_rating);
        send = findViewById(R.id.send_new_review);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkInputValidity();
                //TODO sending the review data to server
            }
        });
    }

    private void checkInputValidity() {
        if (TextUtils.isEmpty(title.getText().toString()) || TextUtils.isEmpty(text.getText().toString())) {
            Toast t = Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT);
            t.show();
        }
    }
}
