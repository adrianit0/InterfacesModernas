/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias;

import java.awt.Color;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import javax.swing.JDialog;
import javax.swing.JFrame;
import jpanelimage.ImagenFondo;

/**
 *
 * @author Adrián
 */
public class VerNoticia extends javax.swing.JDialog {
    
    // Mover posicion
    private boolean moving = false;
    private Point start;

    /**
     * Creates new form VerNoticia
     */
    public VerNoticia(java.awt.Frame parent, boolean modal, Noticia n) {
        super(parent, modal);
        
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        
        initComponents();
        
        this.setSize(770, 580);
        
        panelNoticia.setImagenFondo(new ImagenFondo (new File("./imagenes/fondo.jpg"), 0.7f));
        scroll2.getViewport().setBackground(new Color(0,0,0,0));
        scroll2.setViewportBorder(null);
        
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        
        setNoticia(n);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelNoticia = new jpanelimage.JPanelImage();
        scroll2 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        imagenNoticia = new jpanelimage.JPanelImage();
        contenidoNoticia = new javax.swing.JLabel();
        tituloNoticia = new javax.swing.JLabel();
        jPanelImage1 = new jpanelimage.JPanelImage();
        botonAtras1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanelImage2 = new jpanelimage.JPanelImage();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelNoticia.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("C:/Program Files/NetBeans 8.2"), 0.5f));
        panelNoticia.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll2.setBorder(null);
        scroll2.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll2.setOpaque(false);

        jPanel4.setOpaque(false);
        jPanel4.setPreferredSize(new java.awt.Dimension(100, 1000));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenNoticia.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("C:/Program Files/NetBeans 8.2"), 0.5f));
        jPanel4.add(imagenNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 50, 680, 370));

        contenidoNoticia.setBackground(new java.awt.Color(255, 51, 51));
        contenidoNoticia.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        contenidoNoticia.setForeground(new java.awt.Color(255, 255, 255));
        contenidoNoticia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        contenidoNoticia.setText("TITULO");
        contenidoNoticia.setVerticalAlignment(javax.swing.SwingConstants.TOP);
        jPanel4.add(contenidoNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 570, 660, 400));

        tituloNoticia.setBackground(new java.awt.Color(0, 104, 52));
        tituloNoticia.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        tituloNoticia.setForeground(new java.awt.Color(255, 255, 255));
        tituloNoticia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tituloNoticia.setText("TITULO");
        jPanel4.add(tituloNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 440, 660, 100));

        scroll2.setViewportView(jPanel4);

        panelNoticia.add(scroll2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 50, 770, 530));

        jPanelImage1.setBackground(new java.awt.Color(102, 255, 102));
        jPanelImage1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanelImage1MouseDragged(evt);
            }
        });
        jPanelImage1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanelImage1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanelImage1MouseReleased(evt);
            }
        });
        jPanelImage1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonAtras1.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        botonAtras1.setForeground(new java.awt.Color(255, 255, 255));
        botonAtras1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        botonAtras1.setText("< Atras");
        botonAtras1.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
        botonAtras1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonAtras1MouseClicked(evt);
            }
        });
        jPanelImage1.add(botonAtras1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 30));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("x");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanelImage1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 0, 30, 30));

        panelNoticia.add(jPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 50));

        getContentPane().add(panelNoticia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));

        jPanelImage2.setBackground(new java.awt.Color(0, 0, 0));
        jPanelImage2.setOpaque(true);

        javax.swing.GroupLayout jPanelImage2Layout = new javax.swing.GroupLayout(jPanelImage2);
        jPanelImage2.setLayout(jPanelImage2Layout);
        jPanelImage2Layout.setHorizontalGroup(
            jPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
        );
        jPanelImage2Layout.setVerticalGroup(
            jPanelImage2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 580, Short.MAX_VALUE)
        );

        getContentPane().add(jPanelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonAtras1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAtras1MouseClicked
        this.dispose();
    }//GEN-LAST:event_botonAtras1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        this.dispose();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanelImage1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelImage1MousePressed
        moving = true;
        start = MouseInfo.getPointerInfo().getLocation();
    }//GEN-LAST:event_jPanelImage1MousePressed

    private void jPanelImage1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelImage1MouseReleased
        moving = false;
    }//GEN-LAST:event_jPanelImage1MouseReleased

    private void jPanelImage1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanelImage1MouseDragged
        if (!moving)
            return;
        
        Point actual = MouseInfo.getPointerInfo().getLocation();
        Point widow = this.getLocation();
        this.setLocation(widow.x + actual.x - start.x, widow.y + actual.y - start.y);
        start = actual;
    }//GEN-LAST:event_jPanelImage1MouseDragged

    private void setNoticia (Noticia n) {
        imagenNoticia.setImagenFondo(new ImagenFondo (new File (n.getImagen()),1f));
        tituloNoticia.setText("<html><h1 align='center' style='padding:5px'>"+n.getTitulo()+"</h1></html>");
        contenidoNoticia.setText("<html><p align='center' style='padding:5px'>"+n.getContenido()+"</p></html>");
        
        this.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonAtras1;
    private javax.swing.JLabel contenidoNoticia;
    private jpanelimage.JPanelImage imagenNoticia;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel4;
    private jpanelimage.JPanelImage jPanelImage1;
    private jpanelimage.JPanelImage jPanelImage2;
    private jpanelimage.JPanelImage panelNoticia;
    private javax.swing.JScrollPane scroll2;
    private javax.swing.JLabel tituloNoticia;
    // End of variables declaration//GEN-END:variables
}
