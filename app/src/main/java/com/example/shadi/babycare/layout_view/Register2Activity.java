package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shadi.babycare.R;

public class Register2Activity extends AppCompatActivity {

    private Bundle bundle;
    private EditText edit1, edit2, edit3, edit4, edit5;
    private Button goOn;
    private TextView errorText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        this.setTitle("Register");
        Intent intent = getIntent();
        bundle = intent.getExtras();
        edit1 = findViewById(R.id.name);
        edit2 = findViewById(R.id.surname);
        edit3 = findViewById(R.id.idNumber);
        edit4 = findViewById(R.id.ssn);
        edit5 = findViewById(R.id.phone);
        goOn = findViewById(R.id.goon2);
        errorText = findViewById(R.id.errorregister2);

        goOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO in base a come è stato fatto il backend il bundle serve o meno (se passiamo ogni pagina non serve)
                int result = checkInputValidity ();
                if (result == 0)
                    goOn();
            }
        });
    }

    /**
     * Check all inputs validity
     * @return 0 if correct
     */
    private int checkInputValidity() {
        int ok = 0;
        if (isEmpty(edit1)) {
            edit1.setError("name must be filled!");
            ok++;
        }
        else if (!isComposedOnlyByLetters(edit1)) {
            Toast t = Toast.makeText(this, "Please insert a valid name", Toast.LENGTH_SHORT);
            t.show();
            ok++;
        }
        if(isEmpty(edit2)) {
            edit2.setError("surname must be filled!");
            ok++;
        }
        else if (!isComposedOnlyByLetters(edit2)) {
            Toast t = Toast.makeText(this, "Please insert a valid surname", Toast.LENGTH_SHORT);
            t.show();
            ok++;
        }
        if(isEmpty(edit3)) {
            edit3.setError("idNumber must be filled!");
            ok++;
        }
        if(isEmpty(edit4)) {
            edit4.setError("SSN must be filled!");
            ok++;
        }
        if(!isPhone(edit5)) {
            edit5.setError("phone must be filled!");
            ok++;
        }
        return ok;
    }

    /**
     * verify if a field is empty
     * @param e
     * @return TRUE if empty
     */
    private boolean isEmpty (EditText e) {
        CharSequence input = e.getText().toString();
        return TextUtils.isEmpty(input);
    }

    /**
     * verify if the sequence is a phone
     * @param e
     * @return TRUE if yes
     */
    private boolean isPhone (EditText e) {
        CharSequence input = e.getText().toString();
        return (!isEmpty(e) && Patterns.PHONE.matcher(input).matches());
    }

    /**
     * check if the parameter contains only letters
     * @param e
     * @return TRUE if so
     */
    private boolean isComposedOnlyByLetters (EditText e) {
        String input = e.getText().toString();
        return input.matches("[A-zA-Z]+");
    }

    /**
     * The activity is changed if all data are ok
     */
    public void goOn () {
        Intent intent = new Intent(this, Register3Activity.class);

        bundle.putCharSequence("name", edit1.getText().toString());
        bundle.putCharSequence("surname", edit2.getText().toString());
        bundle.putCharSequence("idNumber", edit3.getText().toString());
        bundle.putCharSequence("ssn", edit4.getText().toString());
        bundle.putCharSequence("phone", edit5.getText().toString());
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
