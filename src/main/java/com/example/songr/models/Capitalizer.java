package com.example.songr.models;

import java.util.Locale;

public class Capitalizer {

    public static String wordCapital(String word){
        return word.toUpperCase(Locale.ROOT);
    }
}
