package com.example.tallerdesarrolloapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        TimerTask iniciosesion = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, InicioSesion.class);
                startActivity(intent);
                finish();
            }
        };

        TimerTask registro = new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this, Registro.class);
                startActivity(intent);
                finish();
            }
        };

        Timer tiempo = new Timer();
        List<Usuario> usu = Usuario.find(Usuario.class, "");

        if (usu.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Crea un Usuario para Ingresar", Toast.LENGTH_LONG).show();
            tiempo.schedule(registro, 1000);
        } else {
            tiempo.schedule(iniciosesion, 5000);
        }

    }
}