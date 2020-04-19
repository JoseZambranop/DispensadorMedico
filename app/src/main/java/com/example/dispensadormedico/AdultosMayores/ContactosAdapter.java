package com.example.dispensadormedico.AdultosMayores;


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

import com.example.dispensadormedico.Login.Person;
import com.example.dispensadormedico.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ContactosAdapter extends RecyclerView.Adapter<ContactosAdapter.ContactosViewHolder> {
    private List<Person> items;

    public static class ContactosViewHolder extends RecyclerView.ViewHolder{
        public CardView contactosCardView;
        public ImageView imagen;
        public TextView nombre;
        public TextView edad;
        public TextView  email;
        public ContactosViewHolder(View v){
            super(v);
            contactosCardView=(CardView)v.findViewById(R.id.person_card);
            imagen = (ImageView)v.findViewById(R.id.Imagen);
            nombre=(TextView)v.findViewById(R.id.nombre);
            email=(TextView)v.findViewById(R.id.correo);
            edad=(TextView)v.findViewById(R.id.edad);

        }

    }
    @Override
    public ContactosViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.person_card,viewGroup,false);
        return new ContactosViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactosViewHolder viewHolder, final int i) {

        Picasso.with(viewHolder.imagen.getContext())
                .load(items.get(i).getImagen()).into(viewHolder.imagen);

        //viewHolder.iD.setText("Id: "+items.get(i).getId());
        viewHolder.nombre.setText("Name: "+items.get(i).getNombre());
        viewHolder.edad.setText("Age: "+items.get(i).getEdad());
        viewHolder.email.setText("Email: "+items.get(i).getCorreo());

        viewHolder.contactosCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =new Bundle();
                //bundle.putString("ctImagen",items.get(i).getImagen());
                bundle.putString("ctnombre",items.get(i).getNombre());
                bundle.putString("ctid",items.get(i).getId());
               /* bundle.putString("ctEmail",items.get(i).getEmail());
                bundle.putString("ctAddress",items.get(i).getAddress());
                bundle.putString("ctGender",items.get(i).getGender());
                bundle.putString("ctMobile",items.get(i).getMobile());
                bundle.putString("ctHome",items.get(i).getHome());
                bundle.putString("ctOffice",items.get(i).getOffice());*/
                Intent Intent =new Intent(view.getContext(), activity_bio_AdultoMayores.class);
                Intent.putExtras(bundle);
                view.getContext().startActivity(Intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    public ContactosAdapter(List<Person>items){
        this.items=items;
    }

    public List<Person> getItems(){
        return this.items;
    }

}
