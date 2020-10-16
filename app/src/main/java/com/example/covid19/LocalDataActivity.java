package com.example.covid19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

public class LocalDataActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_local_data);
        setTitle("Local Data");


        readTemperatureData();
    }
    private List<TemperatureSample> temperatureSample = new ArrayList<>();
    private void readTemperatureData(){
        InputStream is = getResources().openRawResource(R.raw.data);

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(is, Charset.forName("UTF-8"))
        );
        String line = "";
            try {
                while ((line = reader.readLine()) != null) {
                    //split by ,
                    String[] tokens = line.split(",");

                    //Read the Data
                    TemperatureSample temperature = new TemperatureSample();
                    temperature.setDate(tokens[0]);
                    temperature.setMeasuredTemperature(Double.parseDouble(tokens[1]));

                    temperatureSample.add(temperature);

                    Log.d("MyActivity", "Just Created" + temperature);



                }

            } catch (IOException e) {
                Log.wtf("MyActivity","Errpr reading data file on line" + line, e);
                e.printStackTrace();
            }

        }
    }
