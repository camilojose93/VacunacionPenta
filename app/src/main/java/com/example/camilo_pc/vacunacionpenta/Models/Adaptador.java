package com.example.camilo_pc.vacunacionpenta.Models;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.camilo_pc.vacunacionpenta.R;

import java.util.List;

/**
 * Created by CAMILO-PC on 19/10/2017.
 */

public class Adaptador extends RecyclerView.Adapter<Adaptador.ViewHolder> {


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView municipio, valor;
        private CardView card;


        public ViewHolder(View itemView) {
            super(itemView);

            municipio = (TextView) itemView.findViewById(R.id.textView3);
            valor = (TextView) itemView.findViewById(R.id.textView);
            card=(CardView)itemView.findViewById(R.id.cardView);

        }
    }

    public List<Vacunacion> lista;

    public Adaptador(List<Vacunacion> lista) {
        this.lista = lista;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.municipio.setText(lista.get(position).getMunicipio());
        holder.valor.setText(lista.get(position).getValor());

        //YoYo.with(Techniques.ZoomIn).playOn(holder.card);

    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

}
