package com.example.a09uilistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView lvDiasSemana = null;
    private TextView txSeleccion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDiasSemana = findViewById(R.id.lvDiasSemana);
        txSeleccion = findViewById(R.id.txSeleccion);

        ArrayList<String> diasSemana = creaDiasSemana();
//        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
//                                R.array.diasSemana,
//                                R.layout.support_simple_spinner_dropdown_item);
        ArrayAdapter adaptador = new ArrayAdapter(getApplicationContext(),
                                    R.layout.support_simple_spinner_dropdown_item,
                                    diasSemana);


        lvDiasSemana.setAdapter(adaptador);

        lvDiasSemana.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                txSeleccion.setText("Selección: " + adapterView.getItemAtPosition(posicion));

            }
        });

    }

    private ArrayList<String> creaDiasSemana() {
        ArrayList<String> diasSemana = new ArrayList<>();

        diasSemana.add("Lunes");
        diasSemana.add("Martes");
        diasSemana.add("Miércoles");
        diasSemana.add("Jueves");
        diasSemana.add("Viernes");
        diasSemana.add("Sabado");
        diasSemana.add("Domingo");

        return diasSemana;
    }
}
