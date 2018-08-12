package com.example.sussmann.tcc;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class HowToUseActivity extends AppCompatActivity {

    private Button btnRetorno;
    private Intent mainIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_howtouse);

        mainIntent = new Intent(this, CanecaActivity.class);

        btnRetorno = (Button) findViewById(R.id.ret_button);
    }

    public void voltaTelaInicial(View v){
        startActivity(mainIntent);
        finishActivity(0);
    }
}