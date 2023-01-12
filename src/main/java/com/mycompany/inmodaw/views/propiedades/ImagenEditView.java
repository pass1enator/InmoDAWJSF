/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.views.propiedades;

import com.mycompany.inmodaw.controller.ImagenController;
import com.mycompany.inmodaw.controller.PropiedadController;
import com.mycompany.inmodaw.model.Imagen;
import com.mycompany.inmodaw.model.Propiedad;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;

/**
 *
 * @author Administrador
 */
@Named
@ViewScoped

public class ImagenEditView implements Serializable {
    @Inject
    private PropiedadController propiedadcontroller;
    @Inject 
    private ImagenController imagenecontroller;
    private Propiedad propiedad;
    private Imagen imagen;
    public ImagenEditView(){
        
    }
    @PostConstruct
    public void init(){
        //se obtiene la información para esta ventana
        Propiedad p=this.propiedadcontroller.getSelected();
        if(this.imagenecontroller.getSelected()==null){
            this.imagen= new Imagen();
        }
        else{
            this.imagen=this.imagenecontroller.getSelected();
        }
    }
    public void
}
