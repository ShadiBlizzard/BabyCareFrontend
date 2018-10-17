package com.example.shadi.babycare.layout_view;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TimePicker;

import com.example.shadi.babycare.R;

import java.util.Calendar;

public class SetAvailabActivity extends BaseActivity {

    private EditText date, from, to;
    private Button send;
    private int yearChosen, monthChosen, dayChosen;
    private int startHour, endHour, startMinute, endMinute;
    private Calendar mCurrentDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_set_availab, fl);
        super.setTitle("Set availability");

        date = findViewById(R.id.et_availabilityDate_setAvail);
        from = findViewById(R.id.et_availabilityStartTime_setAvail);
        to = findViewById(R.id.et_availabilityEndTime_setAvail);
        send = findViewById(R.id.btn_sendAvailability_setAvail);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);

        date.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int year = mCurrentDate.get(Calendar.YEAR);
                int month = mCurrentDate.get(Calendar.MONTH);
                int day = mCurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SetAvailabActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month++;
                        date.setText(dayOfMonth+" - "+ month +" - "+year);
                        mCurrentDate.set(year, month, dayOfMonth);
                        yearChosen = year;
                        monthChosen = month;
                        dayChosen = dayOfMonth;

                    }
                }, year, month, day);
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis()-1000);
            }
        });

        from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int startingHour = mCurrentDate.get(Calendar.HOUR_OF_DAY);
                int startingMinute = mCurrentDate.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(SetAvailabActivity.this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String hour = String.valueOf(hourOfDay);
                        if (hourOfDay<10)
                            hour = '0'+hour;
                        from.setText(hour + " : " + String.format("%02d", minute));
                        startHour = hourOfDay;
                        startMinute = minute;
                    }
                }, startingHour, startingMinute, true);
                tpd.show();

            }
        });

        to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int startingHour = mCurrentDate.get(Calendar.HOUR_OF_DAY);
                int startingMinute = mCurrentDate.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(SetAvailabActivity.this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        String hour = String.valueOf(hourOfDay);
                        if (hourOfDay<10)
                            hour = '0'+hour;
                        to.setText(hour + " : " + String.format("%02d", minute));
                        endHour = hourOfDay;
                        endMinute = minute;
                    }
                }, startingHour, startingMinute, true);
                tpd.show();

            }
        });
    }
}
