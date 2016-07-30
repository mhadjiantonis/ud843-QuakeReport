package com.example.android.quakereport;

/**
 * Class for the earthquakes listed in the app
 */
public class Earthquake {
    // Stores the magnitude of the earthquake
    private float mMagnitude;
    // Stores the location of the earthquake
    private String mLocation;
    // Stores the date of the earthquake
    private String mDate;

    /**
     * Constructor for the Earthquake class
     *
     * @param magnitude is the magnitude if the new earthquake
     * @param location  is the new earthquake
     * @param date      is the date of the new earthquake
     */
    public Earthquake(float magnitude, String location, String date) {
        this.setMagnitude(magnitude);
        this.setLocation(location);
        this.setDate(date);
    }

    /**
     * Returns the magnitude of the earthquake
     *
     * @return the magnitude
     */
    public float getMagnitude() {
        return this.mMagnitude;
    }

    /**
     * Sets the magnitude of the earthquake
     *
     * @param magnitude is the new value of the magnitude
     */
    public void setMagnitude(float magnitude) {
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
    public String getDate() {
        return this.mDate;
    }

    /**
     * Sets the date of the earthquake
     *
     * @param date is the new date
     */
    public void setDate(String date) {
        this.mDate = date;
    }

    @Override
    public String toString() {
        return "Earthquake of magnitude " + this.getMagnitude() + " at " + this.getLocation()
                + " in " + this.getDate();
    }
}
