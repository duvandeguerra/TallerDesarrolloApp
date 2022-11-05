package com.example.tallerdesarrolloapp;

import com.orm.SugarRecord;

public class Usuario extends SugarRecord<Usuario> {

    //Atributos
    private String nombreusuario;
    private String pin;
    private String nombre;
    private String direccion;
    private String telefono;

    //Contructores
    public Usuario(){

    }

    public Usuario(String nombreusuario, String pin, String nombre, String direccion, String telefono) {
        this.nombreusuario = nombreusuario;
        this.pin = pin;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }

    //Métodos
    public String getnombreusuario() {
        return nombreusuario;
    }

    public void setnombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
