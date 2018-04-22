package com.example.sussmann.tcc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CanecaActivity extends AppCompatActivity {

    private Button btnTemperaturaDia;
    private Button btnInformacoesUso;
    private Button btnComoUsar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caneca);

        btnTemperaturaDia = (Button) findViewById(R.id.barplot_button);
        btnInformacoesUso = (Button) findViewById(R.id.historical_info);
        btnComoUsar = (Button) findViewById(R.id.how_to_use);
    }

    public void abrirTela(View v){
        switch (v.getId()){
            case R.id.barplot_button:
                setContentView(R.layout.activity_barplot);
                break;
            case R.id.historical_info:
                setContentView(R.layout.activity_info);
                break;
            case R.id.how_to_use:
                setContentView(R.layout.activity_howtouse);
        }
    }
}
