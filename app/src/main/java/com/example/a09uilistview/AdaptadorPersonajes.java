package com.example.a09uilistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorPersonajes extends ArrayAdapter<PersonajeVo> {

    private ArrayList<PersonajeVo> personajes;

    public AdaptadorPersonajes(Context context, ArrayList<PersonajeVo> personajes) {
        super(context, R.layout.listitem_personaje, personajes);
        this.personajes = personajes;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitem_personaje, null);

            holder = new ViewHolder();
            holder.tvNombre = item.findViewById(R.id.tvNombre);
            holder.tvDescripcion = item.findViewById(R.id.tvDescripcion);
            holder.ivFoto = item.findViewById(R.id.ivFoto);

            item.setTag(holder);
        }
        else {
            holder = (ViewHolder) item.getTag();
        }

        holder.tvNombre.setText(personajes.get(position).getNombre());
        holder.tvDescripcion.setText(personajes.get(position).getDescripcion());
        holder.ivFoto.setImageResource(personajes.get(position).getFoto());

        return item;
    }

    static class ViewHolder {
        TextView tvNombre;
        TextView tvDescripcion;
        ImageView ivFoto;
    }
}
