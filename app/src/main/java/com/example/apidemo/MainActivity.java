package com.example.apidemo;


import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import java.io.*;
import java.net.*;



public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Variables
        final String api_key = "8f2af0277a8c138e80c2b785b01e3c0d";
        final String finalStringP1 = "https://api.openweathermap.org/data/2.5/weather?lat=";
        double latitude = 40.7128,longitude = 74.0060;
        String theUrl = finalStringP1 + latitude + "&lon=" + longitude + "&appid=" + api_key;



        // Creation of Additional Core




        // Parsing
        //TODO: MOVE TO ASYNCH THREAD
        String current = "";
        new ParseData().execute(theUrl, null, current);
        Log.d("TAG",current + "THE DATA");



        //String hourly = getData(""); // 4 day Hourly
        //String sixteenDay = getData(""); // Daily Forecast 16 Days





    }


    // Threading Threads
    //TODO: LEARN HOW TO USE ASYNCH THREADS
    private class ParseData extends AsyncTask<String, Void, String> {
        protected String doInBackground(URL... urls) {

            return "totalSize";
        }

        @Override
        protected String doInBackground(String... strings) {
            return "totalSize";
        }
    }



    // Getting Data from URL
    public String getData(String theUrl){
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().permitAll().build());
        StringBuilder output = new StringBuilder();

        try
        {
            URL url = new URL(theUrl);
            URLConnection urlConnection = url.openConnection();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
            String line;

            while ((line = bufferedReader.readLine()) != null)
            {
                output.append(line).append("\n");
            }
            bufferedReader.close();
        }
        catch(Exception e)
        {
            Log.d("CATCH","MET WITH EXCEPTION: " + e);
        }
        return output.toString();
    }
}