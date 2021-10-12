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
}
