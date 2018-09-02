package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.example.shadi.babycare.R;

public class LoginActivity extends AppCompatActivity {
;
    private EditText email;
    private EditText password;
    private Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Login");
        email = findViewById(R.id.maillogin);
        password = findViewById(R.id.passwordlogin);
        login = findViewById(R.id.loginsubmit);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int res = checkInputValidity();
                if (res == 0)
                    login();
            }
        });

    }

    public void login() {
        //TODO verifico che cosa sia il client che fa il login, in base a quello lo reindirizzo alla home dedicata
        Intent intent = new Intent(this, HomeBabysitterActivity.class);
        startActivity(intent);
    }

    public int checkInputValidity () {
        int ok = 0;
        CharSequence em = email.getText().toString();
        CharSequence pw = password.getText().toString();
        if (!Patterns.EMAIL_ADDRESS.matcher(em).matches() || TextUtils.isEmpty(em)) {
            ok++;
            Toast toast = Toast.makeText(this, "Fill e-mail field correctly", Toast.LENGTH_SHORT);
            toast.show();
        }
        else if (TextUtils.isEmpty(pw)) {
            ok++;
            Toast toast = Toast.makeText(this, "Password not correct", Toast.LENGTH_SHORT);
            toast.show();
        }

        return  ok;
    }
}
