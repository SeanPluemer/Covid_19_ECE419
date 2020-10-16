package com.example.covid19;

public class TemperatureSample {
    private String date;
    private double measuredTemperature;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getMeasuredTemperature() {
        return measuredTemperature;
    }

    public void setMeasuredTemperature(double measuredTemperature) {
        this.measuredTemperature = measuredTemperature;
    }

    @Override
    public String toString() {
        return "TemperatureSample{" +
                "date='" + date + '\'' +
                ", measuredTemperature=" + measuredTemperature +
                '}';
    }
}
