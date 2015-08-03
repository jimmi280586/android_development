package com.example.jimmi.gps2;

import android.text.Editable;

/**
 * Created by jimmi on 03-08-2015.
 */
public class Destination
{
    private double latitude;
    private double longitude;
    private String name;

    public Destination(double latitude, double longitude, String name)
    {
        this.latitude = latitude;
        this.longitude = longitude;
        this.name = name;
    }

    public Destination(double latitude, double longitude, Editable text) {
    }

    public double getLatitude()
    {
        return this.latitude;
    }
    public double getLongitude()
    {
        return this.longitude;
    }
    public String getName()
    {
        return this.name;
    }
}
