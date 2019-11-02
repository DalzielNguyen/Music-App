package com.example.mobdevfinalappmusic;

public class Song {
    private String songName;
    private String singerName;
    private int songImg;
    private int fileSong;

    public Song(String songname, String singername, int songimg, int filesong) {
        songName = songname;
        singerName = singername;
        songImg = songimg;
        fileSong = filesong;
    }

    public int getFileSong() {
        return fileSong;
    }

    public int getSongImg() {
        return songImg;
    }

    public String getSingerName() {
        return singerName;
    }

    public String getSongName() {
        return songName;
    }

}
