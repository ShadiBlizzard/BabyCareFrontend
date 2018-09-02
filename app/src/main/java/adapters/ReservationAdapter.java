package adapters;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import model.Reservation;


public class ReservationAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Reservation> res;
    private static LayoutInflater inflater;
    public ReservationAdapter (Activity context, ArrayList<Reservation> res) {
        this.context = context;
        this.res = res;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return res.size();
    }

    @Override
    public Reservation getItem(int position) {
        return res.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.res_item, null) : itemView;
        TextView timestamp = (TextView) itemView.findViewById(R.id.time_res);
        TextView counterpart = (TextView) itemView.findViewById(R.id.counterpart_name);
        TextView status = (TextView) itemView.findViewById(R.id.status_res);
        Reservation sel_res = res.get(position);
        timestamp.setText(sel_res.getTimestamp());
        counterpart.setText(sel_res.getCounterpart());
        status.setText(sel_res.getStatus());
        return itemView;

    }
    }


