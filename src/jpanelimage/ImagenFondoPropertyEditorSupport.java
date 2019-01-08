/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimage;

import java.awt.Component;
import java.beans.PropertyEditorSupport;

/**
 *
 * @author Adrián García
 */
public class ImagenFondoPropertyEditorSupport extends PropertyEditorSupport{

    private ImagenFondoPanel imagenFondoPanel = new ImagenFondoPanel();
    
    @Override
    public boolean supportsCustomEditor() {
        return true;
    }

    @Override
    public Component getCustomEditor() {
        return imagenFondoPanel; 
    }

    @Override
    public String getJavaInitializationString() {
        ImagenFondo fondo = imagenFondoPanel.getSelectedValue();
        
        // Si se ejecuta en un Windows (Comprobado al menos en Windows 7, pero debería funcionar para cualquier otra versión)
        if (System.getProperty("os.name").split(" ")[0].toLowerCase().equals("windows")){
            return ("new jpanelimage.ImagenFondo(new java.io.File(\""+fondo.getImagen().getAbsolutePath()+"\"), "+fondo.getOpcidad()+"f)").replace("\\", "/"); 
        }
        // Si se ejecuta en cualquier otro sistema operativo
        return "new jpanelimage.ImagenFondo(new java.io.File(\""+fondo.getImagen().getAbsolutePath()+"\"), "+fondo.getOpcidad()+"f)"; 
    }

    @Override
    public Object getValue() {
        return imagenFondoPanel.getSelectedValue(); 
    }
}
