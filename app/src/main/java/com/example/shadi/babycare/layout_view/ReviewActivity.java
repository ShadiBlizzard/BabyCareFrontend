package com.example.shadi.babycare.layout_view;

import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shadi.babycare.R;

public class ReviewActivity extends BaseActivity {

    private TextView bs, rw, title, text;
    private RatingBar rating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO dettagli review
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_review, fl);

        super.setTitle("Review");

        bs = findViewById(R.id.review_detail_bs_name);
        rw = findViewById(R.id.rev_detail_pr_name);
        title = findViewById(R.id.review_detail_title);
        text = findViewById(R.id.review_detail_txt);
        rating = findViewById(R.id.review_detail_rating);


    }
}
