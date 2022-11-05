package com.example.tallerdesarrolloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class Principal extends AppCompatActivity {

    ListView lista;
    ArrayList<String> usuarios = new ArrayList<String>();
    List<Usuario> usu = Usuario.find(Usuario.class, "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Intent intent = new Intent(this, Modificador.class);

        for (Usuario user : usu) {
            usuarios.add(user.getNombre());
        }

        lista = findViewById(R.id.lista);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, usuarios);
        lista.setAdapter(adaptador);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                intent.putExtra("usuario", usu.get(i).getnombreusuario());
                startActivity(intent);
            }
        });
    }
}