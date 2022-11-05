package com.example.tallerdesarrolloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class Registro extends AppCompatActivity {

    EditText nombreusuario, pin, nombre, direccion, telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        nombreusuario = findViewById(R.id.txtUsuario);
        pin = findViewById(R.id.txtPin);
        nombre = findViewById(R.id.txtNombre);
        direccion = findViewById(R.id.txtDireccion);
        telefono = findViewById(R.id.txtTelefono);
    }

    public void RegistrarUsuario(View view) {
        String user = nombreusuario.getText().toString();
        String pass = pin.getText().toString();
        String nom = nombre.getText().toString();
        String dir = direccion.getText().toString();
        String tel = telefono.getText().toString();

        if (user.isEmpty() || pass.isEmpty() || nom.isEmpty() || dir.isEmpty() || tel.isEmpty()){
            Toast.makeText(getApplicationContext(), "Ingresa los datos solicitados", Toast.LENGTH_SHORT).show();
        } else {
            List<Usuario> verusu = Usuario.find(Usuario.class, "nombreusuario = ?", user);

            if (verusu.isEmpty()) {
                Usuario usu = new Usuario(user, pass, nom, dir, tel);
                usu.save();

                Toast.makeText(getApplicationContext(), "Usuario Creado con Éxito", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, InicioSesion.class);
                startActivity(intent);

                nombreusuario.setText("");
                pin.setText("");
                nombre.setText("");
                direccion.setText("");
                telefono.setText("");
            }
            else {
                Toast.makeText(getApplicationContext(), "Nombre de Usuario ya utilizado, usa otro", Toast.LENGTH_LONG).show();
            }

        }
    }
}