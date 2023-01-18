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
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpServletRequest;
import java.util.Optional;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class PropiedadController extends AbstractController<Propiedad> {

    @Inject
    LocalidadController localidadontroller;
    @Inject
    private ProvinciaController provinciacontroller;
    @Inject
    private TipoController tipocontroller;
    @Inject
    private OpcionController opcionController;
   // private String image_path;
    public PropiedadController() {
        super(Propiedad::new);
        //this.load();
    }

    @Override
    public Propiedad getSelected() {
        return super.getSelected();
    }

    @Override
    @PostConstruct
    public void load() {
     // this.image_path=origRequest.getRequestURI();
        this.create();
        this.getSelected().setDireccion("ejemplo1");
        this.getSelected().setOpcion(this.opcionController.getItems().get(0));
        this.getSelected().setTipo(this.tipocontroller.getItems().get(0));
        this.getSelected().setLocalidad(this.provinciacontroller.getItems().get(0).getLocalidades().get(0));
        this.getSelected().setActivo(true);
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
        return "edit";
    }
  
    public void selectedChange(ValueChangeEvent event) {
        this.setSelected((Propiedad) event.getNewValue());
    }
    public Propiedad getPropiedadById(int id){
        Propiedad p=null;
        Optional<Propiedad> element = this.getItems().stream().filter(item->{
            return item.getId()==id;}).findFirst();
        if(!element.isEmpty())
            p=element.get();
        return p;
    }
    public void removeImage(Imagen img){
       this.getSelected().removeImagen(img);
    }
    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected() != null) {
            if (this.getSelected().getId() == -1) {
                this.getSelected().setId(this.repositorio.getAll().size() + 1);
                this.repositorio.create(this.getSelected());
            } else {
                
                this.repositorio.update(this.getSelected());
            }
        }
        return "sucess";
    }
}
