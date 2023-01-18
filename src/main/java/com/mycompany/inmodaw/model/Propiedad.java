/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.model;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class Propiedad implements Cloneable {

    private String direccion;
    private int precio;
    private Tipo tipo;
    private Opcion opcion;
    private Localidad localidad;
    private ArrayList<Imagen> imagenes;
    private Imagen principal;
    private boolean activo;
    private int id;

    public Propiedad() {
        this.imagenes = new ArrayList<>();
        this.id = -1;
        this.direccion = "";
        this.activo = true;
        this.tipo = new Tipo();
    }

    public String getDireccion() {
        return direccion;
    }
    public Localidad getLocalidad(){
        return this.localidad;
    }
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public int getPrecio() {
        return precio;
    }
    public void setPrecio(int precio) {
        this.precio = precio;
    }
    public Tipo getTipo() {
        return tipo;
    }
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }
    public Opcion getOpcion() {
        return opcion;
    }
    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }
    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void removeImagen(Imagen img) {
            this.imagenes.removeIf(
                    item->{ return item.getId()==img.getId();}
            );
    }

    @Override
    public Object clone() {
        Propiedad p = new Propiedad();
        p.setId(id);
        p.setDireccion(direccion);
        p.setActivo(activo);
        p.setPrecio(precio);
        //copia superficial
        p.setLocalidad(localidad);
        p.setOpcion(opcion);
        p.setTipo(tipo);
        p.setImagenes(this.imagenes);
        //faltan las imagenes
        return p;
    }
}
