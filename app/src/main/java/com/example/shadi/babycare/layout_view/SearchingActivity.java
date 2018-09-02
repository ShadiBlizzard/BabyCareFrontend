package com.example.shadi.babycare.layout_view;

import android.Manifest;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.PersistableBundle;
import android.provider.Settings;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.shadi.babycare.R;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Executable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;


public class SearchingActivity extends BaseActivity {

    private EditText calendar;
    private EditText timer1;
    private EditText timer2;
    private Calendar mCurrentDate, mCurrentTime;
    private Button search;
    private int yearChosen, monthChosen, dayChosen, startingHourChosen, endingHourChosen, startingMinuteChosen, endingMinuteChosen;
    private Double lat, lng;

    private EditText manualAddress;
    private ImageButton locator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TODO PINS PER INDIRIZZO
        super.onCreate(savedInstanceState);
        //this is needed in order to have the drawer in all activities
        FrameLayout fl = findViewById(R.id.content_frame);
        getLayoutInflater().inflate(R.layout.activity_searching, fl);

        super.setTitle("Find a babysitter");

        calendar = findViewById(R.id.calendarview);
        timer1 = findViewById(R.id.timeview);
        timer2 = findViewById(R.id.timeview2);
        search = findViewById(R.id.search);
        manualAddress = findViewById(R.id.manual_address);
        locator = findViewById(R.id.locator);
        initialize();
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        calendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int year = mCurrentDate.get(Calendar.YEAR);
                int month = mCurrentDate.get(Calendar.MONTH);
                int day = mCurrentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(SearchingActivity.this, R.style.DialogTheme, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month++;
                        calendar.setText(dayOfMonth + " - " + month + " - " + year);
                        mCurrentDate.set(year, month, dayOfMonth);
                        yearChosen = year;
                        monthChosen = month;
                        dayChosen = dayOfMonth;

                    }
                }, year, month, day);
                datePickerDialog.show();
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
            }
        });

        timer1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentTime = Calendar.getInstance();
                int startingHour = mCurrentTime.get(Calendar.HOUR_OF_DAY);
                int startingMinute = mCurrentTime.get(Calendar.MINUTE);

                TimePickerDialog tpd = new TimePickerDialog(SearchingActivity.this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        timer1.setText(hourOfDay + ":" + String.format("%02d", minute));
                        startingHourChosen = hourOfDay;
                        startingMinuteChosen = minute;
                    }
                }, startingHour, startingMinute, true);
                tpd.show();

            }
        });

        timer2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentDate = Calendar.getInstance();
                int endingHour = mCurrentDate.get(Calendar.HOUR_OF_DAY);
                int endingMinute = mCurrentDate.get(Calendar.MINUTE);

                TimePickerDialog tpd2 = new TimePickerDialog(SearchingActivity.this, R.style.DialogTheme, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

                        timer2.setText(hourOfDay + ":" + String.format("%02d", minute));
                        endingHourChosen = hourOfDay;
                        endingMinuteChosen = minute;
                    }
                }, endingHour, endingMinute, true);
                tpd2.show();

            }
        });

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dateTimeParametersConstraints();
                Calendar date = Calendar.getInstance();
                date.set(yearChosen, monthChosen, dayChosen);

                Calendar startTime = Calendar.getInstance();
                startTime.set(Calendar.HOUR, startingHourChosen);
                startTime.set(Calendar.MINUTE, startingMinuteChosen);

                Calendar endTime = Calendar.getInstance();
                endTime.set(Calendar.HOUR, endingHourChosen);
                endTime.set(Calendar.MINUTE, endingMinuteChosen);
                //TODO robe da mandare al backend

                //map things
                try {
                    Geocoder g = new Geocoder(getApplicationContext());
                    List<Address> a = g.getFromLocationName(manualAddress.getText().toString(), 1);
                    if(a == null)
                        throw new IllegalArgumentException("set a correct address");

                    lat = a.get(0).getLatitude();
                    lng = a.get(0).getLongitude();
                    Intent results = new Intent(getApplicationContext(), ResultMapActivity.class);
                    results.putExtra("lat", lat.toString());
                    results.putExtra("lng", lng.toString());
                    startActivity(results);
                }
                catch (Exception e) {
                    e.printStackTrace();
                    Toast t =Toast.makeText(getApplicationContext(), "please insert a valid address", Toast.LENGTH_SHORT);
                    t.show();
                }

            }
        });

    }

    private void initialize() {
        dayChosen = -1;
        startingHourChosen = -1;
        endingHourChosen = -1;
    }




    private void dateTimeParametersConstraints() {
        if(dayChosen ==-1 || startingHourChosen ==-1 || endingHourChosen ==-1) {
            Toast t = Toast.makeText(this, "you must fill all the parameters", Toast.LENGTH_SHORT);
            t.show();
        }

        else if(startingHourChosen == endingHourChosen) {
            if (startingMinuteChosen >= endingMinuteChosen) {
                timer1.setError("set correct time space");
                Toast t = Toast.makeText(this, "set correct time space", Toast.LENGTH_SHORT);
                t.show();
            }
        }
        else if (startingHourChosen >= endingHourChosen) {
            timer1.setError("set correct time space");
            Toast t = Toast.makeText(this, "set correct time space", Toast.LENGTH_SHORT);
            t.show();
        }



    }



}