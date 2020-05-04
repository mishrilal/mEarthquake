package com.example.android.quakereport;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EarthquakeMore extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_earthquake_more);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("json");

        TextView textView = (TextView) findViewById(R.id.url);
        textView.setText(message);

    }
}
