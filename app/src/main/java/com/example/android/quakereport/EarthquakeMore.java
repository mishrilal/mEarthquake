package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EarthquakeMore extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_more);

        /*
         * Getting Data from EarthquakeActivity
         */
        Bundle bundle = getIntent().getExtras();

        String alert = bundle.getString("alert");
        String location = bundle.getString("location");
        double longitude = bundle.getDouble("longitude");
        double latitude = bundle.getDouble("latitude");
        double depth = bundle.getDouble("depth");
        double magnitude = bundle.getDouble("magnitude");
        long time = bundle.getLong("time");
        int tsunami = bundle.getInt("tsunami");

        TextView textView = (TextView) findViewById(R.id.url);
        String message = "Alert: " + alert + "\nLocation: " + location + "\nLongitude: " + longitude + "\nLatitude: " + latitude
                + "\nDepth: " + depth + "\nMagnitude: " + magnitude + "\nTime: " + time + "\nTsunami: " + tsunami;
        textView.setText(message);


    }


}
