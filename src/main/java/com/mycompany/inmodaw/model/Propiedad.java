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
        this.direccion = "hla";
        this.activo = true;
        this.tipo = new Tipo();
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the precio
     */
    public int getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(int precio) {
        this.precio = precio;
    }

    /**
     * @return the tipo
     */
    public Tipo getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the opcion
     */
    public Opcion getOpcion() {
        return opcion;
    }

    /**
     * @param opcion the opcion to set
     */
    public void setOpcion(Opcion opcion) {
        this.opcion = opcion;
    }

    /**
     * @return the localidad
     */
    public Localidad getLocalidad() {
        return localidad;
    }

    /**
     * @param localidad the localidad to set
     */
    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }

    /**
     * @return the imagenes
     */
    public ArrayList<Imagen> getImagenes() {
        return imagenes;
    }

    /**
     * @param imagenes the imagenes to set
     */
    public void setImagenes(ArrayList<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    /**
     * @return the activo
     */
    public boolean isActivo() {
        return activo;
    }

    /**
     * @param activo the activo to set
     */
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
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
        //faltan las imagenes
        return p;
    }
}
