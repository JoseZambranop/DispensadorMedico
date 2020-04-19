package com.example.dispensadormedico.Medicamento;


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

public class PastillaAdapter extends RecyclerView.Adapter<PastillaAdapter.PastillaViewHolder> {
    private List<Pastilla> items;

    public static class PastillaViewHolder extends RecyclerView.ViewHolder{
        public CardView pastillaCardView;
        public ImageView imagen;
        public TextView nombre;
        public TextView gramos;
        public PastillaViewHolder(View v) {
            super(v);
            pastillaCardView = (CardView) v.findViewById(R.id.pastilla_card);
        //imagen = (ImageView)v.findViewById(R.id.Imagen);
            nombre=(TextView)v.findViewById(R.id.nombre);
            gramos=(TextView)v.findViewById(R.id.txtgramos);

        }

    }
    @Override
    public PastillaViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.pastilla_card,viewGroup,false);
        return new PastillaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PastillaViewHolder viewHolder, final int i) {

        /*Picasso.with(viewHolder.imagen.getContext())
                .load(items.get(i).getImagen()).into(viewHolder.imagen);*/

        //viewHolder.iD.setText("Id: "+items.get(i).getId());
        viewHolder.nombre.setText("Name: "+items.get(i).getNombre());
        viewHolder.gramos.setText("Milligrams: "+items.get(i).getGramos());
        //viewHolder.email.setText("Email: "+items.get(i).getCorreo());

        /*viewHolder.contactosCardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Bundle bundle =new Bundle();
                bundle.putString("ctImagen",items.get(i).getImagen());
                bundle.putString("ctId",items.get(i).getId());
                bundle.putString("ctNombre",items.get(i).getName());
                bundle.putString("ctEmail",items.get(i).getEmail());
                bundle.putString("ctAddress",items.get(i).getAddress());
                bundle.putString("ctGender",items.get(i).getGender());
                bundle.putString("ctMobile",items.get(i).getMobile());
                bundle.putString("ctHome",items.get(i).getHome());
                bundle.putString("ctOffice",items.get(i).getOffice());
                Intent iconIntent =new Intent(view.getContext(), Detalle.class);
                iconIntent.putExtras(bundle);
                view.getContext().startActivity(iconIntent);
            }
        });*/
    }

    @Override
    public int getItemCount() {
        return this.items.size();
    }
    public PastillaAdapter(List<Pastilla>items){
        this.items=items;
    }

    public List<Pastilla> getItems(){
        return this.items;
    }

}
