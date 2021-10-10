package com.example.songr.models;

public class Album {

    private int length;
    private int songCount;

    private String title;
    private String artist;
    private String imageUrl;

    public Album(String title, String artist, int length, int songCount, String imageUrl) {
        this.length = length;
        this.songCount = songCount;
        this.title = title;
        this.artist = artist;
        this.imageUrl = imageUrl;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSongCount() {
        return songCount;
    }

    public void setSongCount(int songCount) {
        this.songCount = songCount;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
