/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.Localidad;
import com.mycompany.inmodaw.model.Opcion;
import com.mycompany.inmodaw.model.Localidad;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class LocalidadController extends AbstractController<Localidad> {

    

    public LocalidadController() {
        super(Localidad::new);
        //this.load();
    }

    @Override
    @PostConstruct
    public void load() {
        
     
    }

    public String remove() {
        if (this.getSelected() != null) {
            this.repositorio.remove(this.getSelected());
        }
        return "remove";
    }

    @Override
    public String preEdit() {
      /*  Localidad t = new Localidad();
        t.setActivo(this.getSelected().isActivo());
        t.setId(this.getSelected().getId());
        t.setNombre(this.getSelected().getNombre());*/
        //this.setSelected(t);
        return "edit";
    }

    @Override
    public String add() {
        //si es nuevo
       /* if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.add(this.getSelected());
        } else {*/
            //si ya existe
          /*  Localidad t = this.getSelected().repositorio.getAll().stream().filter(item -> {
                return item.getId() == this.getSelected().getId();
            }).findFirst().get();
            t.setNombre(this.getSelected().getNombre());
            t.setActivo(this.getSelected().isActivo());
            this.setSelected(null);*/
      //  }
        return "sucess";
    }
}
