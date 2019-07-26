package com.example.a09uilistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ListView lvDiasSemana = null;
    private TextView txSeleccion = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvDiasSemana = findViewById(R.id.lvDiasSemana);
        txSeleccion = findViewById(R.id.txSeleccion);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,
                                R.array.diasSemana,
                                R.layout.support_simple_spinner_dropdown_item);

        lvDiasSemana.setAdapter(adaptador);

        lvDiasSemana.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int posicion, long l) {
                if (posicion != 0)
                    txSeleccion.setText("Selección: " + adapterView.getItemAtPosition(posicion));

            }
        });

    }
}
