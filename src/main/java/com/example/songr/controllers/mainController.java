package com.example.songr.controllers;

import com.example.songr.models.Album;
import com.example.songr.models.Capitalizer;
import com.example.songr.repositry.AlbumRepositry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

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

    @Autowired
    AlbumRepositry albumRepositry;

    @GetMapping("/albums")
    public String albumShower(Model model) {
        List<Album> list =albumRepositry.findAll();
        model.addAttribute("albumss", list);
        return "albums";

    }

    @GetMapping("/myInfo")
    public String userInfoGetter(@RequestHeader MultiValueMap<String, String> headers, Model model) {
        headers.forEach((key, value) -> System.out.println(String.format("Header '%s' = %s", key, String.join("|", value))));
        model.addAttribute("headerData", headers.get("user-agent"));
        return "userInfo";
    }

    @GetMapping("/addalbum")
    public String addAlbumPage() {
        return "addAlbum";
    }

    @PostMapping("/albums")
    public RedirectView addAlbum(Album album) {
        System.out.println(album);
        albumRepositry.save(album);
        return new RedirectView("/albums");
    }


}
