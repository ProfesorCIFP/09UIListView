package com.example.a09uilistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class AdaptadorTitulares extends ArrayAdapter<Titular> {

    private ArrayList<Titular> titulares;

    public AdaptadorTitulares(Context context, ArrayList<Titular> titulares) {
        super(context, R.layout.listitem_titular, titulares);
        this.titulares = titulares;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View item = convertView;
        ViewHolder holder;

        // MEJORAS:
        // MEJORA 1:
        // Evitamos inflar el Layout cada vez que se muestra un nuevo elemento.
        // En convertView recibimos algún layout que pueda ser reutilizado.

        // MEJORA 2:
        // Los findViewById son muy costosas y se están haciendo en todas las llamadas, para
        // mostrar cada uno de los elementos del ListView.
        // Vamos a guardar la referencia a los controles usando el patrón ViewHolder.

        if (item == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            item = inflater.inflate(R.layout.listitem_titular, null);

            holder = new ViewHolder();
            holder.titulo = item.findViewById(R.id.tvTitulo);
            holder.subtitulo = item.findViewById(R.id.tvSubtitulo);

            item.setTag(holder);
        }
        else {
            holder = (ViewHolder) item.getTag();
        }

        holder.titulo.setText(titulares.get(position).getTitulo());
        holder.subtitulo.setText(titulares.get(position).getSubtitulo());

        return item;
    }

    static class ViewHolder {
        TextView titulo;
        TextView subtitulo;
    }
}
