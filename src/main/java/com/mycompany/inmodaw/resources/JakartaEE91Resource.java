package com.mycompany.inmodaw.resources;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import jakarta.xml.ws.WebServiceRef;
/**
 *
 * @author 
 */
@Path("jakartaee9")
public class JakartaEE91Resource {
   // @WebServiceRef(wsdlLocation="httр://lосаlhоst:8080/hellоserviсe/hellо?wsdl")
    //    private  AccountWSItf provider;
    @GET

    public Response ping(){
        return Response
                .ok("ping Jakarta EE")
                .build();
    }
}
