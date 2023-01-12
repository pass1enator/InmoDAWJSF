/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.Tipo;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class TipoController extends AbstractController<Tipo> {

    public TipoController() {
        super(Tipo::new);
        //this.load();
    }

    @Override
    @PostConstruct
    public void load() {
        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-1);
        this.getSelected().setNombre("Piso");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-2);
        this.getSelected().setNombre("Chalet");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(3);
        this.getSelected().setNombre("Planta baja");
        this.add();
    }

    public String remove() {
        if (this.getSelected() != null) {
            this.repositorio.remove(this.getSelected());
        }
        return "remove";
    }

    @Override
    public String preEdit() {
        Tipo t= new Tipo();
        t.setActivo(this.getSelected().isActivo());
        t.setId(this.getSelected().getId());
        t.setNombre(this.getSelected().getNombre());
         this.setSelected(t);
        return "edit";
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.add(this.getSelected());
        } else {
            //si ya existe
            Tipo t = this.repositorio.getAll().stream().filter(item -> {
                return item.getId() == this.getSelected().getId();
            }).findFirst().get();
            t.setNombre(this.getSelected().getNombre());
            t.setActivo(this.getSelected().isActivo());
            this.setSelected(null);
        }
        return "sucess";
    }
}
