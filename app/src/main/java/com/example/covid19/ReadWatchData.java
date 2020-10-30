package com.example.covid19;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class ReadWatchData extends AppCompatActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_local_data);
        setTitle("Local Data");


        // readTemperatureData();
        readWatchData();
        //double a = watchDataArray.get(0).getMeasuredTempC();
        // System.out.println(a);

        readWatchData();
    }

    public List<WatchData> watchDataArray = new ArrayList<>();

    private void readWatchData() {
        InputStream is = getResources().openRawResource(R.raw.test);

        BufferedReader reader = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));

        String line = "";
        int i = 0;

        try {
            while ((line = reader.readLine()) != null) {
                //split by ,
                String[] tokens = line.split(",");

                //Read the Data
                WatchData watchData = new WatchData();
                watchData.setSyncTime(tokens[0]);
                watchData.setMeasuredTime(tokens[1]);
                watchData.setWatchAddress(tokens[2]);
                watchData.setMeasuredTempC(Double.parseDouble(tokens[3]));
                watchData.setLocationMeasured(Double.parseDouble(tokens[4]));

                //is this needed?
                watchDataArray.add(watchData);

                //Log.d("MyActivity", "Just Created" + watchData);
                // System.out.println("I is: " + i);
                i++;


            }

        } catch (IOException e) {
            Log.wtf("MyActivity", "Errpr reading data file on line" + line, e);
            e.printStackTrace();
        }
    }
}

