package com.leonetardo.petagram.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.leonetardo.petagram.pojo.Mascota;
import com.leonetardo.petagram.R;

import java.util.ArrayList;

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{

    ArrayList<Mascota> mascotas;
    private Activity activity;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    //Esto va a inflar el layout y lo pasará al viewholderpara que obtenga los views
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    //asocia cada elemento de la lista a con cada view
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {
        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgMascota.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvCantidadLikes.setText(Integer.toString(mascota.getLikes()));

        mascotaViewHolder.btnHuesoBlanco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste like a " + mascota.getNombre(), Toast.LENGTH_SHORT).show();
                mascota.setOneMoreLike();
                mascotaViewHolder.tvCantidadLikes.setText(Integer.toString(mascota.getLikes()));
            }
        });
    }

    //cantidad de elementos que contiene la lista
    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgMascota;
        private TextView  tvNombreCV;
        private ImageView btnHuesoBlanco;
        private TextView  tvCantidadLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgMascota      = (ImageView) itemView.findViewById(R.id.imgMascota);
            tvNombreCV      = (TextView) itemView.findViewById(R.id.nombreMascota);
            btnHuesoBlanco  = (ImageView) itemView.findViewById(R.id.btnHuesoBlanco);
            tvCantidadLikes = (TextView) itemView.findViewById(R.id.tvCantidadLikes);
        }
    }
}