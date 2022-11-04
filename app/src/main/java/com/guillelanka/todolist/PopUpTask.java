package com.guillelanka.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;

public class PopUpTask extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_up_task);

        DisplayMetrics medidasVentanas = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(medidasVentanas);

        int ancho = medidasVentanas.widthPixels;
        int alto = medidasVentanas.heightPixels;

        getWindow().setLayout((int)(ancho * 0.85),(int)(alto * 0.4));

        Button bAñadir = findViewById(R.id.bAñadir);
        bAñadir.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

    }
}