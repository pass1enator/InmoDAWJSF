/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.ICopyable;
import jakarta.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 *
 * @author Pedro
 * @param <T>
 * @param <Supplier>
 */
public interface IController<T> {

    @PostConstruct
    public abstract void load();

    public String create();

    public String add();
    public String cancel();
    public T getSelected();

    public void setSelected(T element);
    //public void setSelected(T selected);
    public String preEdit();
    public List<T> getItems();

}
