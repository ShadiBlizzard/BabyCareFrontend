package com.example.shadi.babycare.layout_view;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.ReviewAdapter;
import model.Review;

public class ReviewListActivity extends BaseActivity {


    private ListView listView;
    private ReviewAdapter reviewAdapter;
    private ArrayList<Review> obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO backend call, ritrovo tutte le review di un profilo
        super.onCreate(savedInstanceState);

        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_review_list, fl);


        super.setTitle("Reviews");

        listView = findViewById(R.id.review_list);

        Intent i = getIntent();
        obj = (ArrayList<Review>) i.getSerializableExtra("reviews");
        listInitialization();
    }

    private void listInitialization() {

        reviewAdapter = new ReviewAdapter(this, obj);
        listView.setAdapter(reviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent i = new Intent(getApplicationContext(), ReviewActivity.class);
                i.putExtra("review", obj.get(position));
                startActivity(i);
            }
        });

    }
}
