/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimage;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author Adrián García
 */
public class ImagenFondo implements Serializable {
    
    private File imagen;
    private Float opacidad;

    public ImagenFondo(File imagen, Float opcidad) {
        this.imagen = imagen;
        this.opacidad = opcidad;
    }

    public File getImagen() {
        return imagen;
    }

    public void setImagen(File imagen) {
        this.imagen = imagen;
    }

    public Float getOpcidad() {
        return opacidad;
    }

    public void setOpcidad(Float opcidad) {
        this.opacidad = opcidad;
    }
    
    
    
}
