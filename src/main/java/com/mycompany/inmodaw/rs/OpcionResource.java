/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/WebServices/GenericResource.java to edit this template
 */
package com.mycompany.inmodaw.rs;

import com.mycompany.inmodaw.controller.OpcionController;
import com.mycompany.inmodaw.model.Opcion;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PUT;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import java.util.List;

/**
 * REST Web Service
 *
 * @author Pedro
 */
@Path("opcion")
@RequestScoped
public class OpcionResource {

    @Context
    private UriInfo context;

    @Inject
    OpcionController controlador;

    public OpcionResource() {
    }

    @GET
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public List<Opcion> getAllJSon() {
        return this.controlador.getItems();
    }

    @GET
    @Path("{name}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Opcion get(@PathParam("name") String name) {
        return this.controlador.findByName(name);//.getItems().get(0);//Person p= new Person();
    }

    @DELETE
    @Path("{name}")
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Opcion delete(@PathParam("name") String name) {
         Opcion o=this.controlador.findByName(name);
        this.controlador.setSelected(o);
        this.controlador.remove();
        return o;
    }

    @PUT
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Opcion put(Opcion o) {
        Opcion op2=this.controlador.findById(o.getId());
        op2.setActivo(o.isActivo());
        op2.setNombre(o.getNombre());;
        return op2;
    }

    @POST
    @Consumes(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    @Produces(jakarta.ws.rs.core.MediaType.APPLICATION_JSON)
    public Opcion post() {
       /* this.controlador.setSelected(o);
        this.controlador.add();
        return o;*/
       Opcion o= new Opcion();
       o.setActivo(true);
       o.setNombre("dfsdfsd");
       return o;
    }
}
