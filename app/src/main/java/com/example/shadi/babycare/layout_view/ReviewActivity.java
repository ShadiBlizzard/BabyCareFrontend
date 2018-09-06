package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import model.Review;

public class ReviewActivity extends BaseActivity {

    private TextView bs, rw, timestamp, text;
    private RatingBar rating;
    private Review review;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_review, fl);

        super.setTitle("Review");

        bs = findViewById(R.id.review_detail_bs_name);
        rw = findViewById(R.id.rev_detail_pr_name);
       // title = findViewById(R.id.review_detail_title);
        timestamp = findViewById(R.id.review_detail_timestamp);
        text = findViewById(R.id.review_detail_txt);
        rating = findViewById(R.id.review_detail_rating);

        Intent i = getIntent();
        review = (Review) i.getSerializableExtra("review");


    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        bs.setText(review.getBs().getData().getName());
        rw.setText(review.getParent().getData().getName());

        rating.setRating(review.getRating());
        text.setText(review.getText());
        timestamp.setText(review.getTimestamp().getTime().toString());
    }
}
