package com.example.tallerdesarrolloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Modificador extends AppCompatActivity {

    EditText nombreusuario, pin, nombre, direccion, telefono;
    String user;
    List<Usuario> usu;
    Usuario verusu;

    String newnombreusuario, newpin, newnombre, newdireccion, newtelefono;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificador);

        user = getIntent().getStringExtra("usuario");
        usu = Usuario.find(Usuario.class, "nombreusuario = ?", user);
        verusu = usu.get(0);

        nombreusuario = findViewById(R.id.txtUsuario);
        pin = findViewById(R.id.txtPin);
        nombre = findViewById(R.id.txtNombre);
        direccion = findViewById(R.id.txtDireccion);
        telefono = findViewById(R.id.txtTelefono);

        nombreusuario.setText(verusu.getnombreusuario());
        nombre.setText(verusu.getNombre());
        direccion.setText(verusu.getDireccion());
        telefono.setText(verusu.getTelefono());
    }

    public void Actualizar (View view) {
        newnombreusuario = nombreusuario.getText().toString();
        newpin = pin.getText().toString();
        newnombre = nombre.getText().toString();
        newdireccion = direccion.getText().toString();
        newtelefono = telefono.getText().toString();

        if (newnombreusuario.isEmpty() || newpin.isEmpty() || newnombre.isEmpty() || newdireccion.isEmpty() || newtelefono.isEmpty()){
            Toast.makeText(getApplicationContext(), "Ingresa los datos solicitados", Toast.LENGTH_SHORT).show();
        } else {
            verusu.setnombreusuario(newnombreusuario);
            verusu.setPin(newpin);
            verusu.setNombre(newnombre);
            verusu.setDireccion(newdireccion);
            verusu.setTelefono(newtelefono);
            verusu.save();

            Toast.makeText(getApplicationContext(), "Usuario Actualizado", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Principal.class);
            startActivity(intent);
        }
    }

    public void Eliminar (View view) {
        verusu.delete();
        List<Usuario> usu = Usuario.find(Usuario.class, "");

        if (usu.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Usuario Eliminado, Crea un Usuario para volver a Ingresar", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Registro.class);
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(), "Usuario Eliminado", Toast.LENGTH_LONG).show();
            Intent intent = new Intent(this, Principal.class);
            startActivity(intent);
        }

    }
}