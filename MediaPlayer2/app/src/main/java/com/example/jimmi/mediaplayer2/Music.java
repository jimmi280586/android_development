package com.example.jimmi.mediaplayer2;

public class Music
{
    private String name;
    private String track;

    public Music(String name, String track)
    {
        this.name = name;
        this.track = track;
    }

    public String getName()
    {
        return this.name;
    }

    public String getTrack()
    {
        return this.track;
    }
}
