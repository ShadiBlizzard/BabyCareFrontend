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

import de.hdodenhof.circleimageview.CircleImageView;
import model.Uzer;

public class ProfileAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Uzer> bs;
    private static LayoutInflater inflater= null;

    public ProfileAdapter(Activity context, ArrayList<Uzer> list) {
        this.context=context;
        this.bs=list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return bs.size();
    }

    @Override
    public Uzer getItem(int position) {
        return bs.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.profile_item, null): itemView;

        TextView namesurname = (TextView) itemView.findViewById(R.id.profile_name);
        RatingBar ratingBar = (RatingBar) itemView.findViewById(R.id.profile_rating);
        CircleImageView circleImageView = (CircleImageView) itemView.findViewById(R.id.profile_pic);

        Uzer sel_bs = bs.get(position);
        namesurname.setText(sel_bs.getData().getName()+ " " + sel_bs.getData().getName());
        ratingBar.setRating(sel_bs.getRating());
         //TODO profile pic per ora default
        return itemView;

    }
}
