package com.example.a09uilistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;

public class MainActivity extends AppCompatActivity {

    private ListView lvTitulares = null;
    private TextView txSeleccion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txSeleccion = findViewById(R.id.txSeleccion);
        lvTitulares = findViewById(R.id.lvTitulares);

        ArrayList<Titular> titulares = creaTitulares();

        AdaptadorTitulares adaptadorTitulares = new AdaptadorTitulares(getApplicationContext(), titulares);


        lvTitulares.setAdapter(adaptadorTitulares);

        lvTitulares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                String opcionSeleccionada = ((Titular) adapterView.getItemAtPosition(posicion)).getTitulo();
                txSeleccion.setText("Selección: " + opcionSeleccionada);
            }
        });
    }


    private ArrayList<Titular> creaTitulares() {
        ArrayList<Titular> titulares = new ArrayList<>();

        for (int i = 0; i < 50; i++)
            titulares.add(new Titular("Titulo " + i, "Subtitulo con más texto " + i));

        return titulares;
    }

}
