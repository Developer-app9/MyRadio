package com.example.user.myradio.services;

import com.example.user.myradio.model.Station;

import java.util.ArrayList;

/**
 * Created by User on 25/06/2017.
 */

public class DataService {
    private static final DataService ourInstance = new DataService();

    public static DataService getInstance() {
        return ourInstance;
    }

    private DataService() {
    }

    public ArrayList<Station> getFeaturedStations()
    {
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Flight Plan (Tunes for travel)", "flightplanmusic"));
        list.add(new Station("Two wheelin'(Biking playlist)", "bicyclemusic"));
        list.add(new Station("Kids Jams (Music for children)", "kidsmusic"));
        return list;
    }

    public ArrayList<Station> getRecentStations()
    {
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("Travelling playlist (Trippin')", "vinylmusic"));
        list.add(new Station("My Playlist (Created by you)", "socialmusic"));
        list.add(new Station("Good night's sleep (Infusing sleep)", "keymusic"));
        return list;
    }

    public ArrayList<Station> getPartyStations()
    {
        ArrayList<Station> list = new ArrayList<>();
        list.add(new Station("DJ Night (Best of crazy dance party)", "kidsmusic"));
        list.add(new Station("Long drive hip-hop (Crazy drive)", "bicyclemusic"));
        list.add(new Station("Top 10 (Winning songs)", "vinylmusic"));
        return list;
    }
}