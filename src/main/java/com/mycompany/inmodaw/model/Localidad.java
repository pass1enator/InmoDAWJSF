/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.model;

/**
 *
 * @author Pedro
 */
public class Localidad implements Comparable<Localidad>, Cloneable {
     private String nombre;
    private boolean activo;
    private int id;
    public Localidad(){
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

    @Override
    public int compareTo(Localidad o) {
        if(o==null)
            return -1;
        else{
            if(o.getId()==this.id)
                return 0;
            else
                return 1;
        }
    }
     @Override
    protected Object clone(){
        Localidad l= new Localidad();
        l.activo=this.activo;
        l.id=this.id;
        l.nombre=this.nombre;
        return l;
    }
}
