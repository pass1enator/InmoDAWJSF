/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.controller;

import com.mycompany.inmodaw.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.servlet.http.HttpSession;

/**
 *
 * @author Pedro
 */
@ViewScoped
public class LoginController {
    
    private User user;
   
    public LoginController(){
        
    }
    @PostConstruct
    public void init(){
        this.user.setUser("");
        this.user.setPassword("");
    }
    public String login(){
        //se podría validar por cualquier sistema: base de datos, ldap, ficheos, SO
        if(this.user.getUser().equals("pedro") && this.user.getPassword().equals("pedro")){
            this.user.setGroup("administrador");
            HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(true);
           session.setAttribute("usuario",this.user);
            return "login";
        }else
            return "";
    }
}
