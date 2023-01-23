/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/WebService.java to edit this template
 */
package com.mycompany.inmodaw.ws;

import com.mycompany.inmodaw.controller.OpcionController;
import com.mycompany.inmodaw.model.Opcion;
import jakarta.inject.Inject;
import jakarta.jws.WebService;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Pedro
 */
@WebService(serviceName = "OpcionService")
public class OpcionService {
    @Inject
    OpcionController controlador;
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }
     @WebMethod(operationName = "list")
    public List<Opcion> getAll(){
        return this.controlador.getItems();
    }
    public String addOpcion(Opcion o){
        this.controlador.setSelected(o);
        return this.controlador.add();
    }
    public Opcion getById(int id){
        
        Optional <Opcion> o;
        o=this.controlador.getItems().stream().filter(item->
        { return item.getId()==id; }
                ).findFirst();
        if(o.isPresent())
            return o.get();
        else
            return null;
    }
    public String removeById(int id){
        Optional <Opcion> o;
        o=this.controlador.getItems().stream().filter(item->
        { return item.getId()==id; }
                ).findFirst();
        if(o.isPresent()){
            this.controlador.setSelected(o.get());
            return this.controlador.remove();
        }
        else
            return null;
    }
}
