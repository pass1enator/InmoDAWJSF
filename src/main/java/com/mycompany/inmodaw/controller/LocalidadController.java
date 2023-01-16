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

    @Inject
    ProvinciaController provinciaController;
    @Inject
    PropiedadController propiedadController;

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
            if (this.propiedadController.getItems().stream().filter(item -> {
                return this.getSelected() == item.getLocalidad();
            }).count() == 0) {
                this.provinciaController.getSelected().getLocalidades().remove(this.getSelected());

            }
            //this.repositorio.remove(this.getSelected());
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
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.provinciaController.getSelected().getLocalidades().size() + 1);

            this.provinciaController.getSelected().addLocalidad(this.getSelected());//.repositorio.add(this.getSelected());
        } else {
            //si ya existe
            //en este caso no se hace nada
            //this.setSelected(null);
        }
        return "sucess";
    }
}
