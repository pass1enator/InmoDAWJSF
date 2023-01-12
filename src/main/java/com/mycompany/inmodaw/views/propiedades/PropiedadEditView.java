/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.views.propiedades;

import com.mycompany.inmodaw.controller.OpcionController;
import com.mycompany.inmodaw.controller.PropiedadController;
import com.mycompany.inmodaw.controller.ProvinciaController;
import com.mycompany.inmodaw.controller.TipoController;
import com.mycompany.inmodaw.model.Imagen;
import com.mycompany.inmodaw.model.Localidad;
import com.mycompany.inmodaw.model.Opcion;
import com.mycompany.inmodaw.model.Propiedad;
import com.mycompany.inmodaw.model.Provincia;
import com.mycompany.inmodaw.model.Tipo;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import javax.crypto.AEADBadTagException;

/**
 *
 * @author Administrador
 */
@ViewScoped
@Named
public class PropiedadEditView implements Serializable {

    @Inject
    private ProvinciaController provinciacontroller;
    @Inject
    private TipoController tipocontroller;
    @Inject
    private OpcionController opcionController;
    @Inject
    private PropiedadController propiedadController;
    private Propiedad propiedad;
    private Provincia provincia;
    private Imagen imagenselected;
    //private Localidad localidad;
    //private Tipo tipo;

    //private Opcion opcion;
    //private List<Localidad> localidades;
    private String texto;

    public PropiedadEditView() {

    }

    /**
     * @return the t
     */
    public String getTipo() {
        if (this.propiedad.getTipo() != null) {
            return this.propiedad.getTipo().getNombre();
        } else {
            return "";
        }

    }

    /**
     * @param t the t to set
     */
    public void setTipo(String item) {
        Optional<Tipo> consulta = this.tipocontroller.getItems().stream().filter(element -> {
            return element.getNombre().equals(item);
        }).findFirst();
        if (!consulta.isEmpty()) {
            this.propiedad.setTipo(consulta.get());
        }
    }

    public void setLocalidad(String item) {
        Optional<Localidad> consulta = this.provincia.getLocalidades().stream().filter(element -> {
            return element.getNombre().equals(item);
        }).findFirst();
        if (!consulta.isEmpty()) {
            this.propiedad.setLocalidad(consulta.get());
        }
    }

    @PostConstruct
    public void init() {
        // this.tipo = new Tipo();
        if (this.propiedadController.getSelected() == null) {
            this.propiedad = new Propiedad();
        } else {
            //se clona por si se da a cancelar
            this.propiedad = (Propiedad) this.propiedadController.getSelected().clone(); //.getSelected();
            this.provincia = this.provinciacontroller.getProvinciaByLocalidad(this.propiedad.getLocalidad());

        }
    }

    public void onProvinciaChange() {
        Provincia p = this.provinciacontroller.getItems().get(0);

    }

    public void setProvincia(String item) {
        Optional<Provincia> consulta = this.provinciacontroller.getItems().stream().filter(element -> {
            return element.getNombre().equals(item);
        }).findFirst();
        if (!consulta.isEmpty()) {
            this.provincia = (consulta.get());
        } else {
            this.provincia = null;
        }
    }

    public List<Provincia> getProvincias() {
        return this.provinciacontroller.getItems();
    }

    public String getProvincia() {
        if (this.provincia != null) {
            return this.provincia.getNombre();
        } else {
            return "";
        }

    }

    public List<Localidad> getLocalidades() {

        if (this.provincia != null) {
            return this.provincia.getLocalidades();
        } else {
            return new ArrayList<Localidad>();
        }
    }

    public List<Opcion> getOpciones() {
        return this.opcionController.getItems();
    }

    public void setOpcion(String item) {
        Optional<Opcion> consulta = this.opcionController.getItems().stream().filter(element -> {
            return element.getNombre().equals(item);
        }).findFirst();
        if (!consulta.isEmpty()) {
            this.propiedad.setOpcion(consulta.get());
        }
    }

    public String getLocalidad() {
        if (this.propiedad.getLocalidad() != null) {
            return this.propiedad.getLocalidad().getNombre();
        } else {
            return "";
        }

    }

    public String getOpcion() {
        if (this.propiedad.getOpcion() != null) {
            return this.propiedad.getOpcion().getNombre(); //this.getPropiedad().getOpcion();
        } else {
            return "";
        }
    }

    public List<Tipo> getTipos() {
        return this.tipocontroller.getItems();
    }

    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }

    /**
     * @return the propiedad
     */
    public Propiedad getPropiedad() {
        return propiedad;
    }

    /**
     * @param propiedad the propiedad to set
     */
    public void setPropiedad(Propiedad propiedad) {
        this.propiedad = propiedad;
    }

    /**
     * @return the imagenselected
     */
    public Imagen getImagenselected() {
        return imagenselected;
    }

    /**
     * @param imagenselected the imagenselected to set
     */
    public void setImagenselected(Imagen imagenselected) {
        this.imagenselected = imagenselected;
    }

    public String add() {
        Propiedad p;
        if (this.propiedad != null) {
            if (this.propiedad.getId() != -1) {
                //se obtiene el original
                p = this.propiedadController.getPropiedadById(propiedad.getId());
                p.setDireccion(this.propiedad.getDireccion());
                p.setActivo(propiedad.isActivo());
                p.setLocalidad(propiedad.getLocalidad());
                p.setOpcion(propiedad.getOpcion());
                p.setTipo(propiedad.getTipo());
                p.setPrecio(propiedad.getPrecio());
                this.propiedadController.setSelected(null);
                return "sucess";
            } else {
                //nuevo
                this.propiedadController.setSelected(this.propiedad);
                this.propiedadController.add();
                return "sucess";
            }
        } else {
            this.propiedadController.setSelected(null);
            return "failed";
        }
      
    }

    public String preEdit() {
        return "edit";
    }

    public String create() {
        this.propiedadController.setSelected(null);
        this.propiedad = new Propiedad();
        return "create";
    }

    public String cancel() {
        this.propiedad = null;
        return "sucess";
    }
}
