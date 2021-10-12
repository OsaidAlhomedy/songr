package com.example.songr.models;


import javax.persistence.*;
import java.util.List;

@Entity
public class Album {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private int length;
    private int songCount;

    private String title;
    private String artist;
    private String imageUrl;

    @OneToMany
    private List<Song> songList;


    public Album() {

    }


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Song> getSongList() {
        return songList;
    }

    public void setSongList(List<Song> songList) {
        this.songList = songList;
    }
}
