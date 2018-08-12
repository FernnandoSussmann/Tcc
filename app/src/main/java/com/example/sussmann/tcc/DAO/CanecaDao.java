package com.example.sussmann.tcc.DAO;

import com.github.mikephil.charting.data.BarEntry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CanecaDao {
    private Date diaUso;
    private ArrayList<Float> temperaturas;

    public CanecaDao(Date diaUso, ArrayList<Float> temperaturas){
        this.diaUso = diaUso;
        this.temperaturas = temperaturas;
    }

    public CanecaDao(){
    }

    public Date getDiaUso() {
        return diaUso;
    }

    public ArrayList<Float> getTemperaturas() {
        return temperaturas;
    }

    public List<BarEntry> getUsageAsBarEntry(InputStream is, String date) throws IOException, ParseException {
        List<CanecaDao> canecas = readLogs(is, date);
        List<BarEntry> entries = new ArrayList<BarEntry>();


        for (CanecaDao caneca: canecas){
            for (Float temperatura : caneca.getTemperaturas()) {
                entries.add(new BarEntry(temperatura,temperatura));
            }
        }

        return entries;
    }

    public ArrayList<CanecaDao> readLogs(InputStream is, String date) throws IOException, ParseException {
        ArrayList<CanecaDao> canecaList = new ArrayList<CanecaDao>();
        String str;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        if (is != null) {
            while ((str = reader.readLine()) != null) {
                String[] arrStr = str.split(";");
                if (arrStr[0].equals(date)) {
                    Date dia = format.parse(arrStr[0]);
                    ArrayList<Float> temps = new ArrayList<Float>();

                    for (int i = 1; i < arrStr.length; i++) {
                        temps.add(Float.parseFloat(arrStr[i]));
                    }

                    canecaList.add(new CanecaDao(dia, temps));
                }
            }
        }

        return canecaList;
    }
}
