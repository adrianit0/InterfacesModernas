/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.MouseInfo;
import java.awt.Point;
import java.io.File;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import jpanelimage.ImagenFondo;
import jpanelimage.JPanelImage;
import org.netbeans.lib.awtextra.AbsoluteConstraints;
import org.netbeans.lib.awtextra.AbsoluteLayout;

/**
 *
 * @author Adrián
 */
public class FinalizarCompra extends javax.swing.JDialog {

    // Mover posicion
    private boolean moving = false;
    private Point start;
    private HashMap<Producto, Integer> productos;
    private DecimalFormat format = new DecimalFormat("0.00");
    
    private double tuMonedero;
    private double total;
    
    private Tienda tienda;
    
    /**
     * Creates new form FinalizarCompra
     */
    public FinalizarCompra(java.awt.Frame parent, boolean modal, Tienda tienda, HashMap<Producto, Integer> productos, double monedero) {
        super(parent, modal);
        
        this.setUndecorated(true);
        
        initComponents();
        
        this.tuMonedero = monedero;
        this.productos = productos;
        this.tienda  = tienda;
        
        // Configuramos que hacer cuando se cierre
        this.setSize(550, 700);
        this.setLocationRelativeTo(null);
        
        fondoPantalla.setImagenFondo(new ImagenFondo(new File("./imagenes/fondoTienda.jpg"), 1f));
                
        scroll.getViewport().setBackground(new Color(0,0,0,0));
        scroll.setViewportBorder(null);
        
        crearTodosLosPaneles();
    }
    
    private void crearTodosLosPaneles() {
        if (productos==null)
            return;
        
        total=0;
        
        int index = 0;
        for (Map.Entry<Producto, Integer> entry : productos.entrySet()) {
            crearPanel(index, entry.getKey(), entry.getValue());
            index++;
        }
        
        // Ajustes finales
        contenidoScroll.setPreferredSize(new Dimension(500,85*(productos!=null?productos.size():0)));
        textoTotal.setText(format.format(total)+"€");
        textoMonedero.setText(format.format(tuMonedero)+"€");
        double diferencia = tuMonedero-total;
        textoDiferencia.setText(format.format(diferencia)+"€");
        
        textoDiferencia.setForeground((diferencia>=0)?Color.white:Color.red);
        
        repaint();
    }
    
    private JPanel crearPanel (int index, final Producto p, int cantidad) {
        // Principal
        JPanel principal = new JPanel(new AbsoluteLayout());
        contenidoScroll.add(principal, new AbsoluteConstraints(0, 0 + 85*index, 510, 80));
        principal.setOpaque(false);
        //principal.setBackground(new Color (index*20, index*20, index*20));
        
        // Imagen
        JPanelImage imagen =new JPanelImage ();
        principal.add (imagen, new AbsoluteConstraints(10, 10, 80, 60));
        imagen.setImagenFondo(new ImagenFondo(new File(p.getImage()), 1f));
        
        // Textos
        JLabel l1 = new JLabel (p.getNombre());
        JLabel l2 = new JLabel (format.format(p.getPrecio())+"€");
        JLabel l3 = new JLabel ("x"+cantidad);
        
        l1.setForeground(Color.WHITE);
        l2.setForeground(Color.WHITE);
        l3.setForeground(Color.WHITE);
        
        principal.add(l1, new AbsoluteConstraints(110, 10, -1, 20));
        principal.add(l2, new AbsoluteConstraints(110, 30, -1, 20));
        principal.add(l3, new AbsoluteConstraints(110, 50, -1, 20));
        
        // Botón
        JButton boton = new JButton();
        boton.setBackground(new java.awt.Color(255, 102, 102));
        boton.setFont(new java.awt.Font("Kartika", 1, 14)); // NOI18N
        boton.setForeground(new java.awt.Color(255, 255, 255));
        boton.setText("X");
        boton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        principal.add(boton, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 20, 40, 40));
        boton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                if (productos!=null)
                    productos.remove(p);
                borrarPaneles();
                crearTodosLosPaneles();
                repaint();
            }
        });
        
        // Sumamos al final
        total+=p.getPrecio()*cantidad;
        
        return principal;
    }
    
    private void borrarPaneles () {
        contenidoScroll.removeAll();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        fondoPantalla = new jpanelimage.JPanelImage();
        panelBarra = new javax.swing.JPanel();
        equis = new javax.swing.JLabel();
        contenido = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        botonFinalizar = new javax.swing.JButton();
        categoriaTodas4 = new javax.swing.JLabel();
        textoDiferencia = new javax.swing.JLabel();
        categoriaTodas6 = new javax.swing.JLabel();
        categoriaTodas7 = new javax.swing.JLabel();
        textoTotal = new javax.swing.JLabel();
        textoMonedero = new javax.swing.JLabel();
        scroll = new javax.swing.JScrollPane();
        contenidoScroll = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        fondoPantalla.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("C:/Program Files/NetBeans 8.2"), 0.5f));
        fondoPantalla.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelBarra.setBackground(new java.awt.Color(0, 51, 153));
        panelBarra.setOpaque(false);
        panelBarra.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                panelBarraMouseDragged(evt);
            }
        });
        panelBarra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                panelBarraMousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                panelBarraMouseReleased(evt);
            }
        });
        panelBarra.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        equis.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        equis.setForeground(new java.awt.Color(255, 255, 255));
        equis.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        equis.setText("x");
        equis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                equisMouseClicked(evt);
            }
        });
        panelBarra.add(equis, new org.netbeans.lib.awtextra.AbsoluteConstraints(510, 0, 40, 39));

        fondoPantalla.add(panelBarra, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 10, 550, 60));

        contenido.setOpaque(false);
        contenido.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(204, 204, 0));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 375, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1, Short.MAX_VALUE)
        );

        contenido.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 525, 375, 1));

        botonFinalizar.setBackground(new java.awt.Color(51, 153, 0));
        botonFinalizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        botonFinalizar.setForeground(new java.awt.Color(255, 255, 255));
        botonFinalizar.setText("Pagar y finalizar");
        botonFinalizar.setBorder(null);
        botonFinalizar.setOpaque(false);
        botonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonFinalizarActionPerformed(evt);
            }
        });
        contenido.add(botonFinalizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 560, 150, 40));

        categoriaTodas4.setBackground(new java.awt.Color(0, 104, 52));
        categoriaTodas4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaTodas4.setForeground(new java.awt.Color(255, 255, 255));
        categoriaTodas4.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        categoriaTodas4.setText("Diferencia:");
        contenido.add(categoriaTodas4, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 600, -1, 20));

        textoDiferencia.setBackground(new java.awt.Color(0, 104, 52));
        textoDiferencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoDiferencia.setForeground(new java.awt.Color(255, 255, 255));
        textoDiferencia.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textoDiferencia.setText("0€");
        contenido.add(textoDiferencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 600, -1, 20));

        categoriaTodas6.setBackground(new java.awt.Color(0, 104, 52));
        categoriaTodas6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaTodas6.setForeground(new java.awt.Color(255, 255, 255));
        categoriaTodas6.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        categoriaTodas6.setText("Tu monedero:");
        contenido.add(categoriaTodas6, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 570, -1, 20));

        categoriaTodas7.setBackground(new java.awt.Color(0, 104, 52));
        categoriaTodas7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaTodas7.setForeground(new java.awt.Color(255, 255, 255));
        categoriaTodas7.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        categoriaTodas7.setText("Total (+21% IVA):");
        contenido.add(categoriaTodas7, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 540, -1, 20));

        textoTotal.setBackground(new java.awt.Color(0, 104, 52));
        textoTotal.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoTotal.setForeground(new java.awt.Color(255, 255, 255));
        textoTotal.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textoTotal.setText("0€");
        contenido.add(textoTotal, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 540, -1, 20));

        textoMonedero.setBackground(new java.awt.Color(0, 104, 52));
        textoMonedero.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoMonedero.setForeground(new java.awt.Color(255, 255, 255));
        textoMonedero.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        textoMonedero.setText("0€");
        contenido.add(textoMonedero, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 570, -1, 20));

        scroll.setBorder(null);
        scroll.setToolTipText("");
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        contenidoScroll.setOpaque(false);
        contenidoScroll.setPreferredSize(new java.awt.Dimension(500, 488));
        contenidoScroll.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        scroll.setViewportView(contenidoScroll);

        contenido.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 530, 490));

        fondoPantalla.add(contenido, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 70, 550, 640));

        getContentPane().add(fondoPantalla, new org.netbeans.lib.awtextra.AbsoluteConstraints(-210, -10, 1310, 860));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void equisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_equisMouseClicked
        tienda.actualizarCarrito();
        this.dispose();
    }//GEN-LAST:event_equisMouseClicked

    private void panelBarraMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraMouseDragged
        if (!moving)
        return;

        Point actual = MouseInfo.getPointerInfo().getLocation();
        Point widow = this.getLocation();
        this.setLocation(widow.x + actual.x - start.x, widow.y + actual.y - start.y);
        start = actual;
    }//GEN-LAST:event_panelBarraMouseDragged

    private void panelBarraMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraMousePressed
        moving = true;
        start = MouseInfo.getPointerInfo().getLocation();
    }//GEN-LAST:event_panelBarraMousePressed

    private void panelBarraMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelBarraMouseReleased
        moving = false;
    }//GEN-LAST:event_panelBarraMouseReleased

    private void botonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonFinalizarActionPerformed
        if (productos==null || productos.size()==0)  {
            JOptionPane.showMessageDialog(null, "No hay productos para comprar");
            return;
        } else if (tuMonedero-total<0) {
            JOptionPane.showMessageDialog(null, "No tienes suficiente crédito para comprar");
            return;
        }
         
        productos.clear();
        tienda.setMonedero(tuMonedero-total);
        this.dispose();
        JOptionPane.showMessageDialog(null, "Compra realizada correctamente");
        
    }//GEN-LAST:event_botonFinalizarActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botonFinalizar;
    private javax.swing.JLabel categoriaTodas4;
    private javax.swing.JLabel categoriaTodas6;
    private javax.swing.JLabel categoriaTodas7;
    private javax.swing.JPanel contenido;
    private javax.swing.JPanel contenidoScroll;
    private javax.swing.JLabel equis;
    private jpanelimage.JPanelImage fondoPantalla;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel panelBarra;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel textoDiferencia;
    private javax.swing.JLabel textoMonedero;
    private javax.swing.JLabel textoTotal;
    // End of variables declaration//GEN-END:variables
}
