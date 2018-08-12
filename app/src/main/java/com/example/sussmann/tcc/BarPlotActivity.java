package com.example.sussmann.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.sussmann.tcc.DAO.CanecaDao;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.Arrays;
import java.util.List;

public class BarPlotActivity extends AppCompatActivity {

    private Button btnRetorno;
    private Button btnChart;
    private Intent mainIntent;
    private BarChart chart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barplot);

        mainIntent = new Intent(this, CanecaActivity.class);

        btnRetorno = (Button) findViewById(R.id.ret_button);
        btnChart = (Button) findViewById(R.id.chart_button);
        chart = (BarChart) findViewById(R.id.chart);
    }

    public void voltaTelaInicial(View v){
        startActivity(mainIntent);
        finishActivity(0);
    }

    public void geraGrafico(View v) throws IOException, ParseException {
        InputStream is = getResources().openRawResource(R.raw.logs);
        String date = "2018-08-01";
        List<BarEntry> entries = new CanecaDao().getUsageAsBarEntry(is, date);

        BarDataSet dataSet = new BarDataSet(entries, "Uso do dia " + date);
        int [] color = {255,255,255};
        dataSet.setColors(color,255);
        dataSet.setBarBorderColor(200);
        dataSet.setLabel("Uso do dia " + date);
        BarData barData = new BarData(dataSet);
        barData.setBarWidth(0.2f);
        chart.setData(barData);
        chart.setFitBars(true);
        Legend l = chart.getLegend();
        l.setEnabled(true);
        l.setFormSize(20);
        l.setTextColor(0);
        l.setTextSize(20);
        chart.invalidate();
        btnRetorno.invalidate();
        btnChart.invalidate();
    }
}
