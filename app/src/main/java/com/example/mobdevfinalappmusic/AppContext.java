package com.example.mobdevfinalappmusic;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class AppContext {
    public static AppContext instance;

    private ArrayList<Song> songsList;

    private int index;
    private AppContext() {}

    public static AppContext getInstance() {
        if (instance == null) {
            instance = new AppContext();
        }

        return instance;
    }

    public ArrayList<Song> getSongsList() {
        return songsList;
    }

    public void setSongsList(ArrayList<Song> songsList) {
        this.songsList = songsList;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
