/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jpanelimage;

import java.awt.AlphaComposite;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.Serializable;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author Adrián García
 */
public class JPanelImage extends JPanel implements Serializable {
    
    private ImagenFondo imagenFondo;
    
    private boolean ratonPresionado;
    private Point puntoPresion;
    private ArrastreListener listener;
    private long tiempoInicio;
    
    private final int MIN_ARRASTRE = 50;
    private final int MAX_TIME = 500;
    
    private int lastWidth = 0;
    private int lastHeight = 0;
    
   public JPanelImage () {
       setOpaque(false);
       this.addMouseListener(new MouseAdapter () {
           @Override
           public void mouseReleased(MouseEvent e) {
               if (ratonPresionado) {
                   Point posicionActual = e.getPoint();
                   long tiempoFin = System.currentTimeMillis();
                   if (Math.abs(puntoPresion.x-posicionActual.x)>MIN_ARRASTRE && tiempoFin-tiempoInicio < MAX_TIME) {
                       //System.out.println("ARRASTRADO");
                       if (listener != null)
                           listener.arrastre();
                   }
               }
               
               ratonPresionado = false;
           }

           @Override
           public void mousePressed(MouseEvent e) {
               tiempoInicio = System.currentTimeMillis();
               ratonPresionado = true;
               puntoPresion = e.getPoint();
           }
       });
       
       // Si se quiere se puede crear un hilo aparte para actualizar los gifs.
       // No es necesario si se va a usar imagenes planos.
       /*(new Thread (new Runnable () {
            @Override
            public void run() {
                while (true) {
                    repaint();
                    try {
                        Thread.sleep(50L);
                    } catch (InterruptedException ex) {
                        System.out.println("ERROR");
                    }
                }
            }
        })).start();*/
   }

    public ImagenFondo getImagenFondo() {
        return imagenFondo;
    }

    public void setImagenFondo(ImagenFondo imagenFondo) {
        this.imagenFondo = imagenFondo;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        
        if (imagenFondo!=null && imagenFondo.getImagen() != null && imagenFondo.getImagen().exists()) {
            ImageIcon img = new ImageIcon(imagenFondo.getImagen().getAbsolutePath());
            
            // Vamos a coger los valores para hacer los calculos
            double panelWidth = getWidth();
            double panelHeight = getHeight();
            
            double imgWidth = img.getIconWidth();
            double imgHeight = img.getIconHeight();
            
            if(imgHeight>0)
                panelHeight = (panelWidth/imgWidth)*imgHeight;
            
            img.setImage(img.getImage().getScaledInstance((int)Math.round(panelWidth), (int)Math.round(panelHeight), Image.SCALE_DEFAULT));
            
            Graphics2D g2d = (Graphics2D)g;
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, imagenFondo.getOpcidad()));
            g.drawImage(img.getImage(), 0, 0, null);
            g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1));
        }
    }
    
    public void AddArrastreListener (ArrastreListener arrastreListener) {
        this.listener = arrastreListener;
    }
    
    public void RemoveArrastreListener () {
        this.listener=null;
    }
}
