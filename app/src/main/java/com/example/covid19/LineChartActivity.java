package com.example.covid19;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class LineChartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_chart);



        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);


        setTitle("LineChartTime");
        LineChart lineChart = findViewById(R.id.lineChart);

        findViewById(R.id.buttonUpdateGraph).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(getApplicationContext(), LocalDataActivity.class));
                WatchData test = new WatchData();
                test.readWatchData();
                //test.WatchData();




                double a = test.getLocationMeasured();
                System.out.println("I am here: " + test);

                //new LocalDataActivity();
                //startActivity(new Intent(getApplicationContext(), LocalDataActivity.class));
            }
        });

        // no description text
        lineChart.getDescription().setEnabled(false);

        // background color
        lineChart.setBackgroundColor(Color.WHITE);

        // disable description text
        lineChart.getDescription().setEnabled(false);

        // set listeners

        lineChart.setDrawGridBackground(false);

        // enable touch gestures
        lineChart.setTouchEnabled(true);

        lineChart.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        lineChart.setDragEnabled(true);
        lineChart.setScaleEnabled(true);
        lineChart.setDrawGridBackground(false);
        lineChart.setHighlightPerDragEnabled(true);

        // force pinch zoom along both axis
        lineChart.setPinchZoom(true);

        // set an alternative background color
        lineChart.setBackgroundColor(Color.WHITE);
        lineChart.setViewPortOffsets(0f, 0f, 0f, 0f);

        // create marker to display box when values are selected
       // MyMarkerView mv = new MyMarkerView(this, R.layout.custom_marker_view);
        //Does not work rn


        XAxis xAxis;
        {   // // X-Axis Style // //
            xAxis = lineChart.getXAxis();

            // vertical grid lines
            xAxis.enableGridDashedLine(10f, 10f, 0f);
        }

        YAxis yAxis;
        {   // // Y-Axis Style // //
            yAxis = lineChart.getAxisLeft();

            // disable dual axis (only use LEFT axis)
            lineChart.getAxisRight().setEnabled(false);

            // horizontal grid lines
            yAxis.enableGridDashedLine(10f, 10f, 0f);

            // axis range
            //yAxis.setAxisMaximum(200f);
           // yAxis.setAxisMinimum(-50f);
        }




        ArrayList<Entry> visitors = new ArrayList<>();
        visitors.add(new Entry(2014,420));
        visitors.add(new Entry(2015,843));
        visitors.add(new Entry(2016,526));
        visitors.add(new Entry(2017,634));
        visitors.add(new Entry(2018,235));
        visitors.add(new Entry(2019,532));



        LineDataSet lineDataSet = new LineDataSet(visitors,"visitors");
        lineDataSet.setColors(ColorTemplate.MATERIAL_COLORS);
        lineDataSet.setValueTextColor(Color.BLACK);
        lineDataSet.setValueTextSize(16f);

        LineData lineData = new LineData(lineDataSet);

        //lineChart.setFitBars(true);
        lineChart.setData(lineData);
        lineChart.getDescription().setText("Line Chart Example");
        //lineChart.animateX(200);


        {   // // Create Limit Lines // //
            LimitLine llXAxis = new LimitLine(9f, "Index 10");
            llXAxis.setLineWidth(4f);
            llXAxis.enableDashedLine(10f, 10f, 0f);
            llXAxis.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
            llXAxis.setTextSize(10f);
            //llXAxis.setTypeface(tfRegular);

            LimitLine ll1 = new LimitLine(845f, "Upper Limit");
            //Will need to make a function to get the average for these limits
            ll1.setLineWidth(4f);
            ll1.enableDashedLine(10f, 10f, 0f);
            ll1.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_TOP);
            ll1.setTextSize(10f);
           // ll1.setTypeface(tfRegular);

            LimitLine ll2 = new LimitLine(235f, "Lower Limit");
            //Will need to make a function to get the average for these limits

            ll2.setLineWidth(4f);
            ll2.enableDashedLine(10f, 10f, 0f);
            ll2.setLabelPosition(LimitLine.LimitLabelPosition.RIGHT_BOTTOM);
            ll2.setTextSize(10f);
            //ll2.setTypeface(tfRegular);

            // draw limit lines behind data instead of on top
            yAxis.setDrawLimitLinesBehindData(true);
            xAxis.setDrawLimitLinesBehindData(true);

            // add limit lines
            yAxis.addLimitLine(ll1);
            yAxis.addLimitLine(ll2);
            //xAxis.addLimitLine(llXAxis);
        }


    }
}