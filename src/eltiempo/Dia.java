/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eltiempo;

import java.io.File;
import javax.swing.JLabel;
import jpanelimage.ImagenFondo;
import jpanelimage.JPanelImage;

/**
 *
 * @author Adrián
 */
public class Dia {

    private jpanelimage.JPanelImage imagenDia;
    private javax.swing.JLabel labelDia;
    private int degrees=0;
    private Principal.ESTADO estado;

    public Dia(JPanelImage imagenDia, JLabel labelDia) {
        this.imagenDia = imagenDia;
        this.labelDia = labelDia;
    }

    public JPanelImage getImagenDia() {
        return imagenDia;
    }

    public void setImagenDia(JPanelImage imagenDia) {
        this.imagenDia = imagenDia;
    }

    public JLabel getLabelDia() {
        return labelDia;
    }

    public void setLabelDia(JLabel labelDia) {
        this.labelDia = labelDia;
    }

    public void setImg(Principal.ESTADO tipo) {
        estado = tipo;
        imagenDia.setImagenFondo(new ImagenFondo(new File(tipo.getIcono()), 1f));
    }

    public void setTemperatura(int degress) {
        this.degrees=degress;
        labelDia.setText(degress + "º");
    }
    
    public int getTemperatura() {
        return degrees;
    }
    
    public Principal.ESTADO getEstado () {
        return estado;
    }
}
