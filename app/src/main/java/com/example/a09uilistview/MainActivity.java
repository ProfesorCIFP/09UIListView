package com.example.a09uilistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvTitulares = null;
    private TextView txSeleccion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txSeleccion = findViewById(R.id.txSeleccion);
        lvTitulares = findViewById(R.id.lvPersonajes);

        ArrayList<PersonajeVo> personajes = creaPersonajes();

        AdaptadorPersonajes adaptadorPersonajes = new AdaptadorPersonajes(getApplicationContext(), personajes);


        lvTitulares.setAdapter(adaptadorPersonajes);

        lvTitulares.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {

                if (posicion != 0) {
                    String opcionSeleccionada = ((PersonajeVo) adapterView.getItemAtPosition(posicion)).getNombre();
                    txSeleccion.setText("Selección: " + opcionSeleccionada);
                }
            }
        });

        View cabecera = getLayoutInflater().inflate(R.layout.listview_cabecera, null);
        lvTitulares.addHeaderView(cabecera);
    }


    private ArrayList<PersonajeVo> creaPersonajes() {
        ArrayList<PersonajeVo> listaPersonajes = new ArrayList<>();

        listaPersonajes.add(new PersonajeVo("Krusty","Herschel Shmoikel Pinkus Yerocham Krustofsky, conocido como Krusty el payaso, es un personaje de la serie de dibujos animados Los Simpson.",R.drawable.krusti));
        listaPersonajes.add(new PersonajeVo("Homero","Homer Jay Simpson es uno de los protagonistas de la serie. Es el padre de la familia protagonista y uno de los personajes centrales y más importantes de la serie.",R.drawable.homero));
        listaPersonajes.add(new PersonajeVo("Marge","Marjorie \"Marge\" Bouvier Simpson una de los protagonistas de la serie. Es la esposa de Homer Simpson y madre de los tres hijos que ha tenido de esta unión amorosa: Bart, Lisa y Maggie. ",R.drawable.marge));
        listaPersonajes.add(new PersonajeVo("Bart","Bartholomew JoJo «Bart» Simpson, es uno de los protagonistas de la serie. Bart tiene 10 años y es el primogénito, y único hijo varón de Homer y Marge Simpson. ",R.drawable.bart));
        listaPersonajes.add(new PersonajeVo("Lisa","Lisa Marie Simpson es una de las protagonistas de la serie. Es la hija mediana de Homer y Marge Simpson, y hermana de Bart y Maggie. Goza de notable protagonismo y complejidad en la serie.",R.drawable.lisa));
        listaPersonajes.add(new PersonajeVo("Magie","Margaret Evelyn \"Maggie\" Simpson es una de las protagonistas de la serie. Es la tercera hija del matrimonio protagonista, Homer y Marge Simpson, y la más joven de ellos.",R.drawable.magie));
        listaPersonajes.add(new PersonajeVo("Flanders","Nedward «Ned» Flanders es un personaje ficticio de la serie de televisión de dibujos animados Los Simpson. La voz original en inglés es de Harry Shearer.",R.drawable.flanders));
        listaPersonajes.add(new PersonajeVo("Milhouse","Milhouse Mussolini Van Houten es un personaje ficticio de la serie animada Los Simpson, creado por Matt Groening.",R.drawable.milhouse));
        listaPersonajes.add(new PersonajeVo("Mr. Burns","Charles Montgomery Burns, más conocido como el señor Burns o Monty Burns, es un personaje ficticio recurrente de la serie de televisión de dibujos animados Los Simpson, creada por Matt Groening.",R.drawable.burns));

        return listaPersonajes;
    }

}
