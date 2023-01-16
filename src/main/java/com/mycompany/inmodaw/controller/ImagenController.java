/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.Imagen;
import com.mycompany.inmodaw.model.Localidad;
import com.mycompany.inmodaw.model.Opcion;
import com.mycompany.inmodaw.model.Propiedad;
import com.mycompany.inmodaw.model.Provincia;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.Optional;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class ImagenController extends AbstractController<Imagen> {

    @Inject
    PropiedadController propiedadcontroller;
    private Imagen selected;
    public ImagenController() {
        super(Imagen::new);
        //this.load();
    }

    @Override
    public Imagen getSelected() {
        return this.selected;
    }

    @Override
    @PostConstruct
    public void load() {
      
    }
    
    public String remove() {
        if (this.getSelected() != null && this.propiedadcontroller.getSelected()!=null) {
            this.propiedadcontroller.getSelected().getImagenes().remove(this.selected);
        }
        return "remove";
    }

    @Override
    public String preEdit() {
        /*Provincia t = new Provincia();
        t.setActivo(this.getSelected().isActivo());
        t.setId(this.getSelected().getId());
        t.setNombre(this.getSelected().getNombre());
        t.setLocalidades(this.getSelected().getLocalidades());
        this.setSelected(t);*/
        return "edit";
    }

    public String preEditLocalidad() {
        return "edit_localidad";
    }

    public String precreateLocalidad() {
        //this.localidadontroller.create();
        // l.setId(this.getSelected().getLocalidades().size());
        // this.getSelected().getLocalidades().add(l);
        return "create";
    }

  

  
    public Imagen getById(int id){
        Imagen p=null;
        Optional<Imagen> element = this.propiedadcontroller.getSelected().getImagenes().stream().filter(item->{
            return item.getId()==id;}).findFirst();
        if(!element.isEmpty())
            p=element.get();
        return p;
    }

    @Override
    public String add() {
        //si es nuevo
         if(this.selected!=null && this.selected.getId()==-1 && this.propiedadcontroller.getSelected()!=null) {
            if (this.getSelected().getId() == -1) {
                this.getSelected().setId(this.propiedadcontroller.getSelected().getImagenes().size() + 1);
                this.propiedadcontroller.getSelected().getImagenes().add(this.getSelected());
            } else {
              
                this.setSelected(null);
            }
        }
        return "sucess";
    }
}
