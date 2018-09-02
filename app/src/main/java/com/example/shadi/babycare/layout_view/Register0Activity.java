package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.shadi.babycare.R;


public class Register0Activity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton radio1;
    private Button goOn;
    private String role;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register0);
        Intent intent = getIntent();
        bundle = intent.getExtras();

        radioGroup = findViewById(R.id.radioGroup);
        goOn = findViewById(R.id.goon0);

        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                        int selectedId = radioGroup.getCheckedRadioButtonId();
                        radio1 = findViewById(selectedId);
                        role = radio1.getText().toString();
                        goOn();

            }
        });

        this.setTitle("Register");
    }

    private void goOn() {
        //TODO in base a come è stato fatto il backend il bundle serve o meno (se passiamo ogni pagina non serve)
        bundle.putCharSequence("role", role);
        Intent it = new Intent(this, Register2Activity.class);
        it.putExtras(bundle);

        startActivity(it);
    }
}
