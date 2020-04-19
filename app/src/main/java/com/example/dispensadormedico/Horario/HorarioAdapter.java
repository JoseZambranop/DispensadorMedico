package com.example.dispensadormedico.Horario;


import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dispensadormedico.AdultosMayores.activity_bio_AdultoMayores;
import com.example.dispensadormedico.Login.Person;
import com.example.dispensadormedico.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HorarioAdapter extends RecyclerView.Adapter<HorarioAdapter.HorarioViewHolder> {
    private List<Horario> items;

    public static class HorarioViewHolder extends RecyclerView.ViewHolder{
        public CardView HorarioCardView;
        public TextView hora;
        public TextView fecha;
        public HorarioViewHolder(View v){
            super(v);
            HorarioCardView=(CardView)v.findViewById(R.id.horario_card);
            hora= (TextView) v.findViewById(R.id.txthora);
            fecha=(TextView)v.findViewById(R.id.txtFecha);

        }

    }
    @Override
    public HorarioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horario_card,viewGroup,false);
        return new HorarioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull HorarioViewHolder viewHolder, final int i) {

        /*Picasso.with(viewHolder.imagen.getContext())
                .load(items.get(i).getImagen()).into(viewHolder.imagen);*/

        //viewHolder.iD.setText("Id: "+items.get(i).getId());
        viewHolder.hora.setText(""+items.get(i).getHora());
        viewHolder.fecha.setText(""+items.get(i).getFecha());
/*
        viewHolder.HorarioCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        */
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    public HorarioAdapter(List<Horario>items){
        this.items=items;
    }

    public List<Horario> getItems(){
        return this.items;
    }

}
