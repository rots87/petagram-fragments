package com.leonetardo.petagram.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.leonetardo.petagram.R;
import com.leonetardo.petagram.adapter.PerfilAdaptador;
import com.leonetardo.petagram.pojo.Mascota;
import java.util.ArrayList;

public class PerfilFragment extends Fragment {

    ArrayList<Mascota> mascotas;
    private RecyclerView fotosPerfilMascota;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_perfil, container, false);
        fotosPerfilMascota = (RecyclerView) v.findViewById(R.id.rvFotos);
        GridLayoutManager glm = new GridLayoutManager(getContext(), 3);
        fotosPerfilMascota.setLayoutManager(glm);
        inicializarListaFotos();
        inicializarAdaptador();

        return v;
    }

    public void inicializarAdaptador(){
        PerfilAdaptador adaptador = new PerfilAdaptador(mascotas);
        fotosPerfilMascota.setAdapter(adaptador);
    }

    public void inicializarListaFotos(){
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
        mascotas.add(new Mascota("Lisa"  ,   R.drawable.mascota1,  0));
        mascotas.add(new Mascota("Maggie",   R.drawable.mascota2,  0));
        mascotas.add(new Mascota("Negrita",  R.drawable.mascota3,  0));
        mascotas.add(new Mascota("Cachila",  R.drawable.mascota4,  0));
        mascotas.add(new Mascota("Ernestina",R.drawable.mascota5,  0));
        mascotas.add(new Mascota("Federica", R.drawable.mascota6,  0));
        mascotas.add(new Mascota("Alquimia", R.drawable.mascota7,  0));
        mascotas.add(new Mascota("Pipa",     R.drawable.mascota8,  0));
    }
}