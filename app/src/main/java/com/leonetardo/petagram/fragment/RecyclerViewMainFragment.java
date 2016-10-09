package com.leonetardo.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.leonetardo.petagram.R;
import com.leonetardo.petagram.adapter.MascotaAdaptador;
import com.leonetardo.petagram.pojo.Mascota;

import java.util.ArrayList;

public class RecyclerViewMainFragment extends Fragment{

    ArrayList<Mascota> mascotas;
    private RecyclerView  listaMascotas;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //esta linea equivale al setContentView... asocia esta clase al fragment
        View v = inflater.inflate(R.layout.fragment_recyclerview_main, container, false);

        listaMascotas = (RecyclerView) v.findViewById(R.id.rvMascotas);

        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        //GridLayoutManager glm = new GridLayoustManager(getContext(), 2);
        listaMascotas.setLayoutManager(llm);
        //listaMascotas.setLayoutManager(glm);
        inicializarListaContactos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaContactos(){
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Lisa"  ,   R.drawable.mascota1,  0));
        mascotas.add(new Mascota("Maggie",   R.drawable.mascota2,  0));
        mascotas.add(new Mascota("Negrita",  R.drawable.mascota3,  0));
        mascotas.add(new Mascota("Cachila",  R.drawable.mascota4,  0));
        mascotas.add(new Mascota("Ernestina",R.drawable.mascota5,  0));
        mascotas.add(new Mascota("Federica", R.drawable.mascota6,  0));
        mascotas.add(new Mascota("Alquimia", R.drawable.mascota7,  0));
        mascotas.add(new Mascota("Pipa",     R.drawable.mascota8,  0));
        mascotas.add(new Mascota("Lucía",    R.drawable.mascota9,  0));
        mascotas.add(new Mascota("Pepa",     R.drawable.mascota10, 0));
    }
}