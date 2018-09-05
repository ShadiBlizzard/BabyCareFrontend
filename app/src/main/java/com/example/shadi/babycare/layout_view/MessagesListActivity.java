package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.MessageAdapter;
import model.Message;

public class MessagesListActivity extends BaseActivity {

    private ListView listView;
    private MessageAdapter msg;
    private ArrayList<Message> obj;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_messages_list, fl);

        NavigationView nv = findViewById(R.id.nav_view);
        nv.getMenu().getItem(1).setChecked(true);

        super.setTitle("Your inbox");
        listView = findViewById(R.id.msg_list);
        Intent i = getIntent();
        obj = (ArrayList<Message>) i.getSerializableExtra("messages");
        listCreation();
    }

    public void listCreation () {

        msg = new MessageAdapter(this, obj );
        listView.setAdapter(msg);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //se è parent ResRequestAnswer
                //TODO CHECKING RUOLO
                Intent i = new Intent(getApplicationContext(), ResRequestActivity.class);
                i.putExtra("message", obj.get(position));
                startActivity(i);
            }
        });
    }
}
