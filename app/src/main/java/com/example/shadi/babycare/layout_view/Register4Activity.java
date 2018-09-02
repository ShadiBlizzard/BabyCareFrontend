package com.example.shadi.babycare.layout_view;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;

import android.util.Base64;
import android.view.View;
import android.widget.Button;

import android.widget.ImageView;

import com.example.shadi.babycare.R;

import org.apache.http.NameValuePair;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;


public class Register4Activity extends AppCompatActivity implements View.OnClickListener{

    private Bundle bundle;
    private static final int SELECTED_PICTURE = 0;
    private ImageView img;
    private Button upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register4);
        this.setTitle("Register");
        Intent intent = getIntent();
        bundle = intent.getExtras();

        img = findViewById(R.id.imageView);
        upload = findViewById(R.id.upload);

        img.setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == SELECTED_PICTURE && resultCode == RESULT_OK && data!= null) {
            Uri selectedImage = data.getData();
            img.setImageURI(selectedImage);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageView:
                Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                startActivityForResult(intent, SELECTED_PICTURE);
                break;
            case R.id.upload:
                //TODO how to send to the server the image uploaded and all the previous data bundle
                /*basing on the result of the registration, we could have two results, one of
                correctness that call RegisterOkActivity, One with error that will call RegiterErrorActivity
                NOW I HARDCODE THE OK
                 */

                Bitmap image = ((BitmapDrawable) img.getDrawable()).getBitmap();
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                image.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                String encodedImage = Base64.encodeToString(byteArray, Base64.DEFAULT);



                //hardcoded result
                Intent ok = new Intent(this, RegistrationOkActivity.class);
                startActivity(ok);
                break;
        }
    }

}
