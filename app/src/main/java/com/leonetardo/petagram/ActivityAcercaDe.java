package com.leonetardo.petagram;


import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ActivityAcercaDe extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acerca_de);

        //estas dos lineas son para ocultar la estrella en el activity de favoritas
        FloatingActionButton estrella = (FloatingActionButton) findViewById(R.id.btnEstrella);
        estrella.setVisibility(View.INVISIBLE);
    }
}
