/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias;

import java.util.Date;

/**
 *
 * @author Adrián
 */
public class Noticia {
    
    private String titulo;
    private String contenido;
    private String imagen;
    private Date fechaInicio;

    public Noticia(String titulo, String contenido, String imagen) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
        fechaInicio = new Date();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
}
