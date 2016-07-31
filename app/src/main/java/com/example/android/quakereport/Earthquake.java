package com.example.android.quakereport;

/**
 * Class for the earthquakes listed in the app
 */
public class Earthquake {
    // Stores the magnitude of the earthquake
    private double mMagnitude;
    // Stores the location of the earthquake
    private String mLocation;
    // Stores the time the earthquake happened in ms from the start of UNIX epoch time
    private long mTime;

    /**
     * Constructor for the Earthquake class
     *
     * @param magnitude is the magnitude if the new earthquake
     * @param location  is the new earthquake
     * @param time      is the time of the new earthquake
     */
    public Earthquake(double magnitude, String location, long time) {
        this.setMagnitude(magnitude);
        this.setLocation(location);
        this.setTime(time);
    }

    /**
     * Returns the magnitude of the earthquake
     *
     * @return the magnitude
     */
    public double getMagnitude() {
        return this.mMagnitude;
    }

    /**
     * Sets the magnitude of the earthquake
     *
     * @param magnitude is the new value of the magnitude
     */
    public void setMagnitude(double magnitude) {
        this.mMagnitude = magnitude;
    }

    /**
     * Returns the location of the earthquake
     *
     * @return the location
     */
    public String getLocation() {
        return this.mLocation;
    }

    /**
     * Sets the location of the earthquake
     *
     * @param location is the new location
     */
    public void setLocation(String location) {
        this.mLocation = location;
    }

    /**
     * Returns the date of the earthquake
     *
     * @return the date
     */
    public long getTime() {
        return this.mTime;
    }

    /**
     * Sets the date of the earthquake
     *
     * @param date is the new date
     */
    public void setTime(long date) {
        this.mTime = date;
    }

    @Override
    public String toString() {
        return "Earthquake of magnitude " + this.getMagnitude() + " at " + this.getLocation()
                + " in " + this.getTime();
    }
}
