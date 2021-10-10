package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.NumbersApi;
import com.google.gson.Gson;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
public class APIController {

    @GetMapping("/number/{integer}")
    public String numbersApi(@PathVariable Integer integer) throws IOException {
        return NumbersApi.apiCaller(integer);
    }

    @GetMapping("/albumss")
    @ResponseBody
    public String albumsShower() {
        List<Album> albumList = new ArrayList<>();
        albumList.add(new Album("I'll Play the Blues for You", "Albert King", 2384, 8, "https://img.discogs.com/B9A6naj2sCCjr7xb8jhhuxj5Kqs=/fit-in/600x598/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-2910864-1459939384-9401.jpeg.jpg"));
        albumList.add(new Album("Rammstein", "Rammstein", 2780, 11, "https://upload.wikimedia.org/wikipedia/en/1/16/Rammstein_-_Rammstein.png"));
        albumList.add(new Album("a head full of dreams", "Coldplay", 2745, 11, "https://upload.wikimedia.org/wikipedia/en/3/3d/Coldplay_-_A_Head_Full_of_Dreams.png"));
        Gson gson = new Gson();
        return gson.toJson(albumList);

    }
}
