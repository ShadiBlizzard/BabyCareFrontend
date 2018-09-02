package com.example.shadi.babycare.layout_view;


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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO backend call, ritrovo tutte le review di un profilo
        super.onCreate(savedInstanceState);

        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_review_list, fl);


        super.setTitle("Reviews");

        listView = findViewById(R.id.review_list);
        listInitialization();
    }

    private void listInitialization() {
        //temporaneous hardcoding
        ArrayList<Review> obj = new ArrayList<>();
        obj.add(new Review(2.5f, "rev1", "babys1", "sbiribillo volante"));
        obj.add(new Review(3f, "rev2", "babys1", "sbiribillo volante"));
        obj.add(new Review(3f, "rev3", "babys1", "sbiribillo volante"));
        obj.add(new Review(2.5f, "rev4", "babys1", "sbiribillo volante"));
        obj.add(new Review(2.5f, "rev5", "babys1", "sbiribillo volante"));
        obj.add(new Review(2.5f, "rev6", "babys1", "sbiribillo volante"));
        obj.add(new Review(2.5f, "rev7", "babys1", "sbiribillo volante"));
        obj.add(new Review(2.5f, "rev8", "babys1", "sbiribillo volante"));

        reviewAdapter = new ReviewAdapter(this, obj);
        listView.setAdapter(reviewAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //TODO manda ad una determinata review
            }
        });

    }
}
