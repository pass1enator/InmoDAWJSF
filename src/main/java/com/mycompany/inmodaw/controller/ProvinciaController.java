/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.Localidad;
import com.mycompany.inmodaw.model.Opcion;
import com.mycompany.inmodaw.model.Propiedad;
import com.mycompany.inmodaw.model.Provincia;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.faces.event.ValueChangeEvent;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.util.List;

/**
 *
 * @author Pedro
 */
@Named
@ApplicationScoped
public class ProvinciaController extends AbstractController<Provincia> {

    @Inject
    LocalidadController localidadontroller;
    @Inject
    PropiedadController propiedadcontroller;

    public ProvinciaController() {
        super(Provincia::new);
        //this.load();
    }

    @Override
    public Provincia getSelected() {
        return super.getSelected();
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
        this.getSelected().addLocalidad(l);
        l = new Localidad();
        l.setId(46);
        l.setNombre("erterter");
        l.setActivo(true);
        this.getSelected().addLocalidad(l);
        l = new Localidad();
        l.setId(44);
        l.setNombre("terterter");
        l.setActivo(true);
        this.getSelected().addLocalidad(l);
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
        List<Localidad> localidades;

        if (this.getSelected() != null) {
            localidades = this.getSelected().getLocalidades();
            //se mira si existe alguna propiedad con alguna localidad de la provincia
            if (this.propiedadcontroller.getItems().stream().filter(
                    item -> localidades.stream().anyMatch(
                            localidad -> item.getLocalidad().getId() == localidad.getId()
                    )
            ).count() == 0) {

                this.repositorio.remove(this.getSelected());
                return "remove";
            } else {
                return "";
            }
            // this.repositorio.remove(this.getSelected());
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
        this.localidadontroller.create();
        return "create";
    }

    public String addLocalidad() {
        Localidad l = this.localidadontroller.getSelected();
        l.setId(this.getSelected().getLocalidades().size());
        this.getSelected().getLocalidades().add(l);
        return "sucess";
    }

  
    public Provincia getProvinciaByLocalidad(Localidad l) {
        Provincia p = null;

        for (int i = 0; i < this.getItems().size() && p == null; i++) {
            if (this.getItems().get(i).getLocalidades().stream().anyMatch(item -> {
                return item == l;
            })) {
                p = this.getItems().get(i);
            }
        }
        return p;
    }

    public String removeLocalidad() {
        Localidad l = this.localidadontroller.getSelected();
        this.getSelected().getLocalidades().remove(l);
        return "remove";
    }

    public void selectedChange(ValueChangeEvent event) {
        Provincia pr = this.repositorio.getAll().stream().filter(p
                -> {
            return p.getNombre().equals(event.getNewValue().toString());
        }
        ).findFirst().get();
        this.setSelected(pr);
    }

    @Override
    public String add() {
        //si es nuevo
        if (this.getSelected().getId() == -1) {
            this.getSelected().setId(this.repositorio.getAll().size() + 1);
            this.repositorio.create(this.getSelected());
        } else {
            this.repositorio.update(this.getSelected());
        }
        return "sucess";
    }
}
