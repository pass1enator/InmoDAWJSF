/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inmodaw.views;

import com.mycompany.inmodaw.controller.ImagenController;
import com.mycompany.inmodaw.controller.PropiedadController;
import com.mycompany.inmodaw.model.Imagen;
import com.mycompany.inmodaw.model.Propiedad;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletContext;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.file.UploadedFile;
import org.primefaces.shaded.owasp.SafeFile;
import org.primefaces.shaded.owasp.ValidationException;

/**
 *
 * @author Administrador
 */
@Named
@RequestScoped
public class ImagenEditView implements Serializable {

    @Inject
    private PropiedadController propiedadcontroller;
    @Inject
    private ImagenController imagenecontroller;
    private Propiedad propiedad;
    private Imagen imagen;
    private UploadedFile file;
    private String destination = "C:\\Users\\Pedro\\Desktop\\payara6\\glassfish\\domains\\domain1\\docroot\\img";

    public ImagenEditView() {

    }

    @PostConstruct
    public void init() {
        //se obtiene la información para esta ventana
        this.propiedad= this.propiedadcontroller.getSelected();
        if (this.imagenecontroller.getSelected() == null) {
            this.imagen = new Imagen();

        } else {
            this.imagen = this.imagenecontroller.getSelected();
        }
    }

    /**
     * @return the file
     */
    public UploadedFile getFile() {
        return file;
    }

    /**
     * @param file the file to set
     */
    public void setFile(UploadedFile file) {
        this.file = file;
    }

    public Imagen getImagen() {
        return this.imagen;
    }

    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }

    public void copyFile(String fileName, InputStream in) {
        try {
            // write the inputStream to a FileOutputStream
            OutputStream out = new FileOutputStream(new File(fileName));
            int read = 0;
            byte[] bytes = new byte[1024];
            while ((read = in.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
            in.close();
            out.flush();
            out.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public String save() {
        String extension;
        String path;
        if (this.file != null) {

            ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
            extension = this.file.getFileName().substring(
                    this.file.getFileName().lastIndexOf('.'), this.file.getFileName().length());
            path = this.destination + "/" + this.propiedad.getId() + this.propiedad.getImagenes().size()  + extension;
            this.imagen.setId(this.propiedad.getId() + this.propiedad.getImagenes().size());
            this.imagen.setPath( this.propiedad.getId() +""+ this.propiedad.getImagenes().size()  + extension);
            this.imagenecontroller.setSelected(imagen);
            try {
                this.copyFile(path, this.file.getInputStream());

            } catch (Exception ex) {
                Logger.getLogger(ImagenEditView.class.getName()).log(Level.SEVERE, null, ex);

                return "fail";
            }
            this.propiedad.getImagenes().add(imagen);
            return "sucess";
        } else {
            return "";
        }

    }

    public String cancel() {
        return "cancel";
    }
}
