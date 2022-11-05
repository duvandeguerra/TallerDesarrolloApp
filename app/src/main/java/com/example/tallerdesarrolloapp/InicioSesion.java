package com.example.tallerdesarrolloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class InicioSesion extends AppCompatActivity {

    EditText nombreusuario, pin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_sesion);

        nombreusuario = findViewById(R.id.editTextTextPersonName);
        pin = findViewById(R.id.editTextTextPassword);


    }

    public void Ingresar(View view){

        String user = nombreusuario.getText().toString();
        String pass = pin.getText().toString();

        if (user.isEmpty() || pass.isEmpty()){
            Toast.makeText(getApplicationContext(), "Ingresa los datos solicitados", Toast.LENGTH_SHORT ).show();
        } else {
                List<Usuario> usu = Usuario.find(Usuario.class, "nombreusuario = ? AND pin = ?", user, pass);
            if (usu.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Usuario y/o Pin incorrectos", Toast.LENGTH_LONG).show();
            }else{
                Intent intent = new Intent(this, Principal.class);
                startActivity(intent);

                nombreusuario.setText("");
                pin.setText("");
            }
        }
    }

    public void Registro(View view){
        Intent intent = new Intent(this, Registro.class);
        startActivity(intent);
    }
}