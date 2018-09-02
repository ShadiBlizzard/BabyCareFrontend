package adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RatingBar;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import model.Review;

public class ReviewAdapter extends BaseAdapter {
    Activity context;
    ArrayList<Review> rvw;
    private static LayoutInflater inflater = null;

    public ReviewAdapter (Activity context, ArrayList<Review> rvw) {
        this.context = context;
        this.rvw = rvw;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return rvw.size();
    }

    @Override
    public Review getItem(int position) {
        return rvw.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.review_item, null): itemView;
        TextView title = (TextView) itemView.findViewById(R.id.review_title);
        RatingBar rating = (RatingBar) itemView.findViewById(R.id.ratingBar);
        TextView reviewed = (TextView) itemView.findViewById(R.id.reviewed_name);

        Review sel_rvw = rvw.get(position);
        title.setText(sel_rvw.getTitle());
        reviewed.setText(sel_rvw.getReviewed_bs());
        rating.setRating(sel_rvw.getRating());

        return itemView;

    }
}
