package adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import model.Payment;

public class PaymentAdapter extends BaseAdapter {

    Activity context;
    ArrayList<Payment> payments;
    private static LayoutInflater inflater=null;


    public PaymentAdapter (Activity context, ArrayList<Payment> list) {
        this.context = context;
        this.payments = list;
        this.inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        itemView = (itemView == null) ? inflater.inflate(R.layout.payment_item, null): itemView;

        TextView timestamp = itemView.findViewById(R.id.payment_timestamp);
        TextView amount = itemView.findViewById(R.id.payment_amount);
        TextView status = itemView.findViewById(R.id.payment_status);

        timestamp.setText(payments.get(i).getCreationDate().toString());
        amount.setText(payments.get(i).getAmount().toString());

        if(payments.get(i).isPaid())
            status.setText("PAID");
        else if (payments.get(i).isCanceled())
            status.setText("CANCELED");
        else
            status.setText("PENDING");

        return itemView;
    }
}
