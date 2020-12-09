package com.example.android.quakereport;

/**
 * An {@link Earthquake} object contains information related to a single earthquake.
 */
public class Earthquake {

    private String mAlert;
    /**
     * Magnitude of the earthquake
     */
    private double mMagnitude;

    /**
     * Location of the earthquake
     */
    private String mLocation;

    /**
     * Time of the earthquake
     */
    private long mTimeInMilliseconds;

    /**
     * Website URL of the earthquake
     */
    private String mUrl;

    private double mLongitude;
    private double mLatitude;
    private double mDepth;

    private int mTsunami;
    private double mIntensity;


    /**
     * Constructs a new {@link Earthquake} object.
     *
     * @param magnitude          is the magnitude (size) of the earthquake
     * @param location           is the location where the earthquake happened
     * @param timeInMilliseconds is the time in milliseconds (from the Epoch) when the
     *                           earthquake happened
     * @param url                is the website URL to find more details about the earthquake
     */
    public Earthquake(double magnitude, String location, long timeInMilliseconds, String url,
                      double longitude, double latitude, double depth, String alert, int tsunami) {
        mMagnitude = magnitude;
        mLocation = location;
        mTimeInMilliseconds = timeInMilliseconds;
        mUrl = url;
        mLongitude = longitude;
        mLatitude = latitude;
        mDepth = depth;
        mAlert = alert;
        mTsunami = tsunami;
    }

    public double getIntensity() {
        return mIntensity;
    }


    /**
     * Returns the magnitude of the earthquake.
     */
    public double getMagnitude() {
        return mMagnitude;
    }

    /**
     * Returns the location of the earthquake.
     */
    public String getLocation() {
        return mLocation;
    }

    /**
     * Returns the time of the earthquake.
     */
    public long getTimeInMilliseconds() {
        return mTimeInMilliseconds;
    }

    /**
     * Returns the website URL to find more information about the earthquake.
     */
    public String getUrl() {
        return mUrl;
    }

    public double getLongitude() {
        return mLongitude;
    }

    public double getLatitude() {
        return mLatitude;
    }

    public double getDepth() {
        return mDepth;
    }

    public String getAlert() {
        return mAlert;
    }

    public int getTsunami() {
        return mTsunami;
    }
}
