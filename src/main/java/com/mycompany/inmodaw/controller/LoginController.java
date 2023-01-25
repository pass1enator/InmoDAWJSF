/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import jakarta.servlet.http.HttpSession;
import java.io.Serializable;

/**
 *
 * @author Pedro
 */
@Named
@ViewScoped
public class LoginController implements Serializable{

    private User user;

    public LoginController() {
         this.user= new User();
        this.user.setUser("");
        this.user.setPassword("");
    }
    
    @PostConstruct
    public void init() {
       /* this.user= new User();
        this.getUser().setUser("");
        this.getUser().setPassword("");*/
    }

    public String login() {
        //se podría validar por cualquier sistema: base de datos, ldap, ficheos, SO
        if (this.getUser().getUser().equals("pedro") && this.getUser().getPassword().equals("pedro")) {
            this.getUser().setGroup("administrador");
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
            session.setAttribute("usuario", this.getUser());
            return "login";
        } else {
            return "";
        }
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
