package com.example.shadi.babycare.layout_view;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.WindowManager;

import com.example.shadi.babycare.R;

public class PopupBsInfoActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_bs_info);

        //popup window layout settings
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width*.7), (int) (height*.6));

        WindowManager.LayoutParams lm = getWindow().getAttributes();

        lm.gravity = Gravity.CENTER;

        lm.x=0;
        lm.y=-20;
        getWindow().setAttributes(lm);




    }
}
