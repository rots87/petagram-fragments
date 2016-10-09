package com.leonetardo.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.leonetardo.petagram.pojo.Mascota;
import com.leonetardo.petagram.R;
import java.util.ArrayList;
import java.util.Random;

public class PerfilAdaptador extends RecyclerView.Adapter<PerfilAdaptador.PerfilViewHolder>{

    ArrayList<Mascota> mascotas;

    public PerfilAdaptador(ArrayList<Mascota> mascotas){
        this.mascotas = mascotas;
    }

    //Esto va a inflar el layout y lo pasará al viewholderpara que obtenga los views
    @Override
    public PerfilViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fotos, parent, false);
        return new PerfilViewHolder(v);
    }

    //asocia cada elemento de la lista a con cada view
    @Override
    public void onBindViewHolder(PerfilViewHolder perfilViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        perfilViewHolder.imgMascota.setImageResource(mascota.getFoto());
        Random rand = new Random();
        perfilViewHolder.tvCantidadLikes.setText(String.valueOf(rand.nextInt(100/2) *2));
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PerfilViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private TextView  tvCantidadLikes;

        public PerfilViewHolder(View itemView) {
            super(itemView);
            imgMascota      = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvCantidadLikes = (TextView) itemView.findViewById(R.id.tvCantidadLikes);
        }
    }
}