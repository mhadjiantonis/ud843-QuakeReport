package com.example.android.quakereport;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.io.IOException;
import java.net.URL;
import java.util.List;

/**
 * Loads a list of earthquakes after requesting data from the Internet
 */
public class EarthquakeLoader extends AsyncTaskLoader<List<Earthquake>> {

    private String mUrl;

    /**
     * Public constructor for the class
     *
     * @param context The context of the activity creating the Loader
     * @param url     The url from where to get earthquake data
     */
    public EarthquakeLoader(Context context, String url) {
        super(context);
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }

    @Override
    public List<Earthquake> loadInBackground() {
        URL queryUrl = QueryUtils.makeURL(mUrl);
        String jsonResponse = "";
        try {
            jsonResponse = QueryUtils.getJsonResponse(queryUrl);
        } catch (IOException e) {
            Log.e(EarthquakeActivity.LOG_TAG, "Error while getting response from the Internet", e);
        }
        return QueryUtils.extractEarthquakes(jsonResponse);
    }
}
