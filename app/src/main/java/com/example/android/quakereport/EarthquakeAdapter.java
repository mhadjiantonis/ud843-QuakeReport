package com.example.android.quakereport;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Custom adapter for list of Earthquake objects
 */
public class EarthquakeAdapter extends ArrayAdapter<Earthquake> {
    // Used to separate the location when formatting
    private static final String LOCATION_SEPARATOR = " of ";

    /**
     * Constructor for the adapter
     *
     * @param context     is the context
     * @param earthquakes is a list of earthquakes
     */
    public EarthquakeAdapter(Context context, ArrayList<Earthquake> earthquakes) {
        super(context, 0, earthquakes);
    }


    /**
     * Provides a view for the list view
     * @param position The position in the list of earthquakes to be displayed
     * @param convertView The recycled view to populate
     * @param parent The parent ViewGroup
     * @return The view for the position in ListView
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        // Inflate a new view if none is provided
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.earthquake_view, parent, false);
        }

        // Find the TextView items in the view
        TextView magnitudeTextView = (TextView) listItemView.findViewById(R.id.magnitude_text);
        TextView locationOffsetTextView = (TextView) listItemView.findViewById(
                R.id.location_offset_text);
        TextView primaryLocationTextView = (TextView) listItemView.findViewById(
                R.id.primary_location_text);
        TextView dateTextView = (TextView) listItemView.findViewById(R.id.date_text);
        TextView timeTextView = (TextView) listItemView.findViewById(R.id.time_text);

        // Find the earthquake to be displayed
        Earthquake earthquake = this.getItem(position);

        //Format the time to be displayed
        Date dateObject = new Date(earthquake.getTime());
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MMM dd, yyyy");
        SimpleDateFormat timeFormatter = new SimpleDateFormat("hh:mm aa");
        String dateToDisplay = dateFormatter.format(dateObject);
        String timeToDisplay = timeFormatter.format(dateObject);

        //Format the location to be displayed
        String location = earthquake.getLocation();
        String primaryLocation;
        String locationOffset;
        if (location.contains(LOCATION_SEPARATOR)) {
            int indexToCut = location.indexOf(LOCATION_SEPARATOR) + 4;
            locationOffset = location.substring(0, indexToCut);
            primaryLocation = location.substring(indexToCut, location.length());
        } else {
            locationOffset = getContext().getString(R.string.near_the);
            primaryLocation = location;
        }

        // Set the text in the TextView items
        magnitudeTextView.setText(String.valueOf(earthquake.getMagnitude()));
        locationOffsetTextView.setText(locationOffset);
        primaryLocationTextView.setText(primaryLocation);
        dateTextView.setText(dateToDisplay);
        timeTextView.setText(timeToDisplay);

        return listItemView;

    }
}
