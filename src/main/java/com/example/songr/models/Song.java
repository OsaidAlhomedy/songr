package com.example.songr.models;

import javax.persistence.*;

@Entity
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "track_number", nullable = false)
    private Long trackNumber;

    private String title;
    private int length;

    @ManyToOne
    @JoinColumn(name = "album_id", nullable = false)
    private Album album;

    public Song() {
    }

    public Song(String title, int length, Album album) {
        this.title = title;
        this.length = length;
        this.album = album;
    }

    public Long getTrackNumber() {
        return trackNumber;
    }

    public void setTrackNumber(Long trackNumber) {
        this.trackNumber = trackNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
