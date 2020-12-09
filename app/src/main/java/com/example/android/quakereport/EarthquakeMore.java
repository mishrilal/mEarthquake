package com.example.android.quakereport;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EarthquakeMore extends AppCompatActivity {

    private static final String LOCATION_SEPARATOR = " of ";
    String formattedLatitude ;
    String formattedLongitude;
    double mLatitude;
    double mLongitude;
    private String webURL;

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
        String url = bundle.getString("url");

        String formattedMagnitude = formatMagnitude(magnitude);
        // Get the original location string from the Earthquake object,
        // which can be in the format of "5km N of Cairo, Egypt" or "Pacific-Antarctic Ridge".

        // If the original location string (i.e. "5km N of Cairo, Egypt") contains
        // a primary location (Cairo, Egypt) and a location offset (5km N of that city)
        // then store the primary location separately from the location offset in 2 Strings,
        // so they can be displayed in 2 TextViews.
        String primaryLocation;
        String locationOffset;

        // Check whether the originalLocation string contains the " of " text
        if (location.contains(LOCATION_SEPARATOR)) {
            // Split the string into different parts (as an array of Strings)
            // based on the " of " text. We expect an array of 2 Strings, where
            // the first String will be "5km N" and the second String will be "Cairo, Egypt".
            String[] parts = location.split(LOCATION_SEPARATOR);
            // Location offset should be "5km N " + " of " --> "5km N of"
            locationOffset = parts[0] + LOCATION_SEPARATOR;
            // Primary location should be "Cairo, Egypt"
            primaryLocation = parts[1];
        } else {
            // Otherwise, there is no " of " text in the originalLocation string.
            // Hence, set the default location offset to say "Near the".
            locationOffset = getString(R.string.near_the);
            // The primary location will be the full location string "Pacific-Antarctic Ridge".
            primaryLocation = location;
        }

        // Create a new Date object from the time in milliseconds of the earthquake
        Date dateObject = new Date(time);

        // Find the TextView with view ID date
        TextView dateView = (TextView) findViewById(R.id.date);
        // Format the date string (i.e. "Mar 3, 1984")
        String formattedDate = formatDate(dateObject);
        // Display the date of the current earthquake in that TextView
        dateView.setText(formattedDate);

        // Find the TextView with view ID time
        TextView timeView = (TextView) findViewById(R.id.time);
        // Format the time string (i.e. "4:30PM")
        String formattedTime = formatTime(dateObject);

        // Display the time of the current earthquake in that TextView
        timeView.setText(formattedTime);

        TextView magnitudeView = (TextView) findViewById(R.id.magnitude);
        magnitudeView.setText(formattedMagnitude);


        // Find the TextView with view ID location
        TextView primaryLocationView = (TextView) findViewById(R.id.primary_location);

        // Display the location of the current earthquake in that TextView
        primaryLocationView.setText(primaryLocation);

        // Find the TextView with view ID location offset
        TextView locationOffsetView = (TextView) findViewById(R.id.location_offset);

        // Display the location offset of the current earthquake in that TextView
        locationOffsetView.setText(locationOffset);

        TextView depthView = (TextView) findViewById(R.id.depth);
        depthView.setText(depth + " km");

        String formattedTsunami = formatTsunami(tsunami);

        TextView tsunamiView = (TextView) findViewById(R.id.tsunami);
        tsunamiView.setText(formattedTsunami);

        String formattedAlert = formatAlert(alert);

        formattedLongitude = formatCoordinates(longitude);
        formattedLatitude = formatCoordinates(latitude);

        mLatitude = latitude;
        mLongitude = longitude;

        TextView latitudeView = (TextView) findViewById(R.id.latitude);
        latitudeView.setText("" + latitude);

        TextView longitudeView = (TextView) findViewById(R.id.longitude);
        longitudeView.setText("" + longitude);

        TextView alertView = (TextView) findViewById(R.id.alert);
        alertView.setText(formattedAlert);

        webURL = url;


        // textView.setText(message);

    }

    /**
     * Return the formatted magnitude string showing 1 decimal place (i.e. "3.2")
     * from a decimal magnitude value.
     */
    private String formatMagnitude(double magnitude) {
        DecimalFormat magnitudeFormat = new DecimalFormat("0.0");
        return magnitudeFormat.format(magnitude);
    }

    /**
     * Return the formatted date string (i.e. "Mar 3, 1984") from a Date object.
     */
    private String formatDate(Date dateObject) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("LLL dd, yyyy");
        return dateFormat.format(dateObject);
    }

    /**
     * Return the formatted date string (i.e. "4:30 PM") from a Date object.
     */
    private String formatTime(Date dateObject) {
        SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");
        return timeFormat.format(dateObject);
    }

    private String formatTsunami(int tsunami) {
        if (tsunami == 0) {
            return "No";
        } else {
            return "Yes";
        }
    }

    private String formatAlert(String alert) {
        if (alert.equals("null")) {
            return "No Alert";
        } else {
            return alert;
        }
    }

    private String formatCoordinates(double decimal) {
        String coordinates;

        int d = (int) decimal;
        double t1 = (decimal - d) * 60;
        int m = (int) t1;
        double s = (t1 - m) * 60;
        coordinates = d + "°" + m + "\'" + s + "\"";
        return coordinates;
    }

    public void moreDetails(View view) {
        // Create a new intent to view the earthquake URI
        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(webURL));
        // Send the intent to launch a new activity
        startActivity(websiteIntent);

    }


    public void openMap(View view) {

        String locationUrl = "https://www.google.com/maps/place/" + formattedLatitude + "+" + formattedLongitude
                + "/@" + mLatitude + "," + mLongitude + "," + "7z";

        Intent websiteIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(locationUrl));
        // Send the intent to launch a new activity
        startActivity(websiteIntent);


    }

}
