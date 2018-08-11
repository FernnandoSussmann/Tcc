package com.example.sussmann.tcc;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CanecaActivity extends AppCompatActivity {

    private Button btnTemperaturaDia;
    private Button btnInformacoesUso;
    private Button btnComoUsar;
    Intent htuIntent;
    Intent bpIntent;
    Intent iIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caneca);
        htuIntent = new Intent(this,HowToUseActivity.class);
        bpIntent = new Intent(this, BarPlotActivity.class);
        iIntent = new Intent(this,InfoActivity.class);

        btnTemperaturaDia = (Button) findViewById(R.id.barplot_button);
        btnInformacoesUso = (Button) findViewById(R.id.historical_info);
        btnComoUsar = (Button) findViewById(R.id.how_to_use);
    }

    public void abrirTela(View v){
        switch (v.getId()){
            case R.id.barplot_button:
                startActivity(bpIntent);
                finishActivity(0);
                break;
            case R.id.historical_info:
                startActivity(iIntent);
                finishActivity(0);
                break;
            case R.id.how_to_use:
                startActivity(htuIntent);
                finishActivity(0);
                break;
        }
    }
}
