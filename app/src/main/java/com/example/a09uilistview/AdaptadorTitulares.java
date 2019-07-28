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
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listitem_titular, null);

        TextView tvTitulo = item.findViewById(R.id.tvTitulo);
        tvTitulo.setText(titulares.get(position).getTitulo());

        TextView tvSubtitulo = item.findViewById(R.id.tvSubtitulo);
        tvSubtitulo.setText(titulares.get(position).getSubtitulo());

        return item;
    }
}
