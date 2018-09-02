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

import model.Message;

public class MessageAdapter extends BaseAdapter{

    Activity context;
    ArrayList<Message> msg;
    private static LayoutInflater inflater = null;

    public MessageAdapter (Activity context, ArrayList<Message> msg) {
        this.context = context;
        this.msg = msg;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return msg.size();
    }

    @Override
    public Message getItem(int position) {
        return msg.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;
        itemView = (itemView == null) ? inflater.inflate(R.layout.message_item, null): itemView;
        TextView timestamp = (TextView) itemView.findViewById(R.id.time_msg);
        TextView sender = (TextView) itemView.findViewById(R.id.sender);
        Message sel_msg = msg.get(position);
        timestamp.setText(sel_msg.getTimestamp());
        sender.setText(sel_msg.getSender());
        return itemView;

    }
}
