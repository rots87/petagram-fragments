package com.leonetardo.petagram;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.leonetardo.petagram.adapter.MascotaAdaptador;
import com.leonetardo.petagram.pojo.Mascota;

import java.util.ArrayList;

public class Favoritas extends AppCompatActivity{
    RecyclerView listaMascotas;
    ArrayList<Mascota> mascotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favoritas);

        //estas dos lineas son para ocultar la estrella en el activity de favoritas
        FloatingActionButton estrella = (FloatingActionButton) findViewById(R.id.btnEstrella);
        estrella.setVisibility(View.INVISIBLE);

        ImageView huella = (ImageView) findViewById(R.id.imgHuella);
        huella.setVisibility(View.INVISIBLE);

        //este bloque es para que se vea la flechita de back en el toolbar de favoritas
        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        listaMascotas = (RecyclerView) findViewById(R.id.rvFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaMascotas.setLayoutManager(llm);
        inicializarListaMascotas();
        inicializarAdaptador();
    }

    public void inicializarAdaptador() {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, this);
        listaMascotas.setAdapter(adaptador);


    }

    public void inicializarListaMascotas() {
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Federica", R.drawable.mascota6,  5));
        mascotas.add(new Mascota("Alquimia", R.drawable.mascota7,  3));
        mascotas.add(new Mascota("Pipa",     R.drawable.mascota8,  6));
        mascotas.add(new Mascota("Lucía",    R.drawable.mascota9,  4));
        mascotas.add(new Mascota("Pepa",     R.drawable.mascota10, 2));
    }
}
