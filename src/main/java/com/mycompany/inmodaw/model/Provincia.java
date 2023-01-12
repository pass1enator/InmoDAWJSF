/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.model;

import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Pedro
 */
public class Provincia implements Cloneable{
    private String nombre;
    private boolean activo;
    private int id;
    private ArrayList<Localidad> localidades;
   public Provincia(){
       this.localidades= new ArrayList<>();
       this.id=-1;
   }
     /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
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

    /**
     * @return the localidades
     */
    public ArrayList<Localidad> getLocalidades() {
        return localidades;
    }
    public void addLocalidad(Localidad l){
        this.localidades.add(l);
    }
    /**
     * @param localidades the localidades to set
     */
    public void setLocalidades(ArrayList<Localidad> localidades) {
        this.localidades = localidades;
    }
   @Override
    protected Object clone(){
        Provincia item= new Provincia();
        item.activo=this.activo;
        item.id=this.id;
        item.nombre=this.nombre;
        item.setLocalidades((ArrayList<Localidad>) this.localidades.stream().collect(Collectors.toList()));
        return item;
    }
}
