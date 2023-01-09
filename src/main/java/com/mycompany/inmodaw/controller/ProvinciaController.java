/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.Localidad;
import com.mycompany.inmodaw.model.Opcion;
import com.mycompany.inmodaw.model.Provincia;

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
public class ProvinciaController extends AbstractController<Provincia> {

    @Inject
    LocalidadController localidadontroller;

    public ProvinciaController() {
        super(Provincia::new);
        //this.load();
    }

    @Override
    @PostConstruct
    public void load() {
        Localidad l;
        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-1);
        this.getSelected().setNombre("Alicante");
        l = new Localidad();
        l.setId(44);
        l.setNombre("Rojales");
        l.setActivo(true);
        this.getSelected().getLocalidades().add(l);
        l = new Localidad();
        l.setId(46);
        l.setNombre("erterter");
        l.setActivo(true);
        this.getSelected().getLocalidades().add(l);
        l = new Localidad();
        l.setId(44);
        l.setNombre("terterter");
        l.setActivo(true);
        this.getSelected().getLocalidades().add(l);
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(-2);
        this.getSelected().setNombre("Murcia");
        this.add();

        this.create();
        this.getSelected().setActivo(true);
        //this.getSelected().setId(3);
        this.getSelected().setNombre("Albacete");
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
        Provincia t = new Provincia();
        t.setActivo(this.getSelected().isActivo());
        t.setId(this.getSelected().getId());
        t.setNombre(this.getSelected().getNombre());
        this.setSelected(t);
        return "edit";
    }
    public String preEditLocalidad(){
        return "edit_localidad";
    }
   public String precreateLocalidad(){
      this.localidadontroller.create();
      // l.setId(this.getSelected().getLocalidades().size());
      // this.getSelected().getLocalidades().add(l);
       return "create";
   }
  public String addLocalidad(){
       Localidad l= this.localidadontroller.getSelected();
       l.setId(this.getSelected().getLocalidades().size());
       this.getSelected().getLocalidades().add(l);
       return "sucess";
   }
    public String removeLocalidad(){
       Localidad l= this.localidadontroller.getSelected();
       this.getSelected().getLocalidades().remove(l);
       return "remove";
   } 
   @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.add(this.getSelected());
        } else {
            //si ya existe
            Provincia t = this.repositorio.getAll().stream().filter(item -> {
                return item.getId() == this.getSelected().getId();
            }).findFirst().get();
            t.setNombre(this.getSelected().getNombre());
            t.setActivo(this.getSelected().isActivo());
            this.setSelected(null);
        }
        return "sucess";
    }
}
