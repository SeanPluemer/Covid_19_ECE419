package com.example.covid19;

import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class WatchData extends AppCompatActivity {
    public List<WatchData> watchDataArray = new ArrayList<>();


    String syncTime;
    String measuredTime;
    String watchAddress;
    double measuredTempC;
    double locationMeasured;

    public String getSyncTime() {
        return syncTime;
    }

    public void setSyncTime(String syncTime) {
        this.syncTime = syncTime;
    }

    public String getMeasuredTime() {
        return measuredTime;
    }

    public void setMeasuredTime(String measuredTime) {
        this.measuredTime = measuredTime;
    }

    public String getWatchAddress() {
        return watchAddress;
    }

    public void setWatchAddress(String watchAddress) {
        this.watchAddress = watchAddress;
    }

    public double getMeasuredTempC() {
        return measuredTempC;
    }

    public void setMeasuredTempC(double measuredTempC) {
        this.measuredTempC = measuredTempC;
    }

    public double getLocationMeasured() {
        return locationMeasured;
    }

    public void setLocationMeasured(double locationMeasured) {
        this.locationMeasured = locationMeasured;
    }

    public String toString() {
        return "Watch Data{" +
                "Sync Time=" + syncTime + '\'' +
                ", Measured Time = " + measuredTime +
                '}';
    }

    public void readWatchData() {
        try {
            // create token1
            String token1 = "";

            // for-each loop for calculating heat index of May - October

            // create Scanner inFile1
            Scanner inFile1 = new Scanner(new InputStreamReader(getClass().getResourceAsStream("test1.csv"))).useDelimiter(",");

            // Original answer used LinkedList, but probably preferable to use ArrayList in most cases
            // List<String> temps = new LinkedList<String>();
            List<String> temps = new ArrayList<String>();

            // while loop
            while (inFile1.hasNext()) {
                // find next line
                token1 = inFile1.next();
                temps.add(token1);
            }
            inFile1.close();

            String[] tempsArray = temps.toArray(new String[0]);

            for (String s : tempsArray) {
                System.out.println(s);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
/*
    public void readWatchData() {
        System.out.println("hello I am here");
        InputStream is = getResources().openRawResource(R.raw.test);

       
        System.out.println("!!!!!!");
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

                Log.d("MyActivity", "Just Created" + watchData);


            }

        } catch (IOException e) {
            Log.wtf("MyActivity", "Error reading data file on line" + line, e);
            e.printStackTrace();
        }

    }
    */
}
