package com.example.songr.repositry;

import com.example.songr.models.Album;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlbumRepositry extends JpaRepository<Album,Long> {
}
