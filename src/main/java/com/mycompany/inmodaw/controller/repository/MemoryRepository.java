/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller.repository;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public class MemoryRepository<T>  implements IRepository<T>{
   private ArrayList<T> elements;
   public MemoryRepository(){
       this.elements= new ArrayList<>();
   }

    @Override
    public void create(T item) {
        this.elements.add(item);
    }
    @Override
    public void update(T item){
        //en este caso no se hace nada ya que se encuentra actualizado
    }
    public void remove (T item){
        this.elements.remove(item);
    }
    @Override
    public void remove(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<T> getAll() {
        return this.elements;
       // throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public T getByid(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
}
