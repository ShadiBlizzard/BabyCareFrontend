package com.example.shadi.babycare.layout_view;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.shadi.babycare.R;

import java.util.ArrayList;

import adapters.ProfileAdapter;
import model.ProfileBs;

public class ProfileListActivity extends BaseActivity {

    private ListView listView;
    private ProfileAdapter adapter;
    private TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO backend call, creazione di una lista in base alla richiesta dell'utente
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_profile_list, fl);
        super.setTitle("Babysitters profiles");

        listView = findViewById(R.id.favlist);
        txt = findViewById(R.id.proflisttxt);

        listCreation();
    }

    private void listCreation() {
        ArrayList<ProfileBs> bs= new ArrayList<>();

        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));
        bs.add(new ProfileBs("Sbiribilla", "Volante", "pic", "via tot", 0.6f));

        if (bs.isEmpty()) {
            txt.setText("No results found");
        }
        else {
            txt.setText("Results");
            adapter = new ProfileAdapter(this, bs);
            listView.setAdapter(adapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    //TODO backend call dettagli profilo
                }
            });
        }

    }
}
