package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Capitalizer;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.ArrayList;
import java.util.List;

@Controller
public class mainController {

    @GetMapping("/hello")
    public String hello(@RequestParam(name = "name", defaultValue = "World", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "helloWorld";
    }

    @GetMapping("/capitalize/{hello}")
    public String capitalizer(@PathVariable String hello, Model model) {
        String capital = Capitalizer.wordCapital(hello);
        model.addAttribute("word", capital);
        return "capitalized";
    }

    @GetMapping("/albums")
    public String albumShower(Model model) {
        List<Album> albumList = new ArrayList<>();
        albumList.add(new Album("I'll Play the Blues for You", "Albert King", 2384, 8, "https://img.discogs.com/B9A6naj2sCCjr7xb8jhhuxj5Kqs=/fit-in/600x598/filters:strip_icc():format(jpeg):mode_rgb():quality(90)/discogs-images/R-2910864-1459939384-9401.jpeg.jpg"));
        albumList.add(new Album("Rammstein", "Rammstein", 2780, 11, "https://upload.wikimedia.org/wikipedia/en/1/16/Rammstein_-_Rammstein.png"));
        albumList.add(new Album("a head full of dreams", "Coldplay", 2745, 11, "https://upload.wikimedia.org/wikipedia/en/3/3d/Coldplay_-_A_Head_Full_of_Dreams.png"));

        model.addAttribute("albums", albumList);


        return "albums";

    }

    @GetMapping("/myInfo")
    public String userInfoGetter(@RequestHeader MultiValueMap<String, String> headers, Model model) {
        headers.forEach((key, value) -> System.out.println(String.format("Header '%s' = %s", key, String.join("|", value))));
        model.addAttribute("headerData",headers.get("user-agent"));
        return "userInfo";
    }


}
