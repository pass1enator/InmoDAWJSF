/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.inmodaw.controller.repository;

import java.util.ArrayList;

/**
 *
 * @author Pedro
 */
public interface IRepository<T> {
    public void add(T item);
    public void remove(int id);
    public void remove (T item);
    public ArrayList<T> getAll();
    public T getByid(int id);
    
    
}
