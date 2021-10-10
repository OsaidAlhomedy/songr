package com.example.songr.models;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class NumbersApi {

    public static String apiCaller(int number) throws IOException {

        URL url = new URL("http://numbersapi.com/" + number);
        HttpURLConnection con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        int responseCode = con.getResponseCode();

        if (responseCode == HttpURLConnection.HTTP_OK) {

            InputStreamReader inputStreamReader = new InputStreamReader(con.getInputStream());
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String data = bufferedReader.readLine();
            bufferedReader.close();

            return data;

        } else {
            return "There was a problem";
        }
    }
}
