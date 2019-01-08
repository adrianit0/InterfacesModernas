/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package noticias;

import java.awt.Color;
import java.awt.Component;
import java.awt.Frame;
import java.util.List;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import jpanelimage.ImagenFondo;
import jpanelimage.JPanelImage;
import tienda.Tienda;

/**
 *
 * @author Adrián
 */
public class Principal extends javax.swing.JFrame {

    // Mover posicion
    private boolean moving = false;
    private Point start;
    private int tabId;
    
    private Tienda mTienda;
    
    public Principal() {
        initComponents();
        
        setButton(0);
        
        // Configuramos que hacer cuando se cierre
        this.setSize(960, 640);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        
        // Configuramos los fondos de pantalla
        panelInicio.setImagenFondo(new ImagenFondo (new File("./imagenes/fondo.jpg"), 1f));
        panelUltimas.setImagenFondo(new ImagenFondo (new File("./imagenes/fondo.jpg"), 1f));
        
        // Botones extras
        botonTienda.setImagenFondo(new ImagenFondo (new File("./imagenes/iconoTienda.png"), 1f));
        final Principal _noticias = this;
        botonTienda.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (mTienda!=null){
                    JOptionPane.showMessageDialog(null, "No se ha podido abrir la tienda. Actualmente está abierta");
                    return;
                }
                    
                
                mTienda = new Tienda (_noticias);
                mTienda.setOnDispose();
                mTienda.setVisible(true);
            }

            @Override
            public void mousePressed(MouseEvent e) {
                botonTienda.setBackground(new Color(0,60,60));
                repaint();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                botonTienda.setBackground(new Color(0,104,52));
                repaint();
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                botonTienda.setOpaque(true);
                repaint();
            }

            @Override
            public void mouseExited(MouseEvent e) {
                botonTienda.setOpaque(false);
                repaint();
            }
        });
        
        // Lista de noticias
        List<Noticia> noticias = ListaNoticias.getNoticias();
        
        // Trasparencia al Scroll
        scroll.getViewport().setBackground(new Color(0,0,0,0));
        
        // Le pongo fondo a los textos
        textoNoticia1.setBackground(new Color(0,0,0,125));
        textoNoticia2.setBackground(new Color(0,0,0,125));
        textoNoticia3.setBackground(new Color(0,0,0,125));
        textoNoticia4.setBackground(new Color(0,0,0,125));
        textoNoticia5.setBackground(new Color(0,0,0,125));
        
        JPanelImage[] imagenes = new JPanelImage[] {
            imagenNoticia2,imagenNoticia1,imagenNoticia3,imagenNoticia4,imagenNoticia5
        };
        
        int iterador = 0;
        for (JPanelImage i : imagenes) {
            final int constante = iterador;
            i.setImagenFondo(new ImagenFondo(new File(noticias.get(iterador).getImagen()),1f));
            ((JLabel)i.getComponents()[0]).setText("<html><p align='center' style='padding:5px'>"+noticias.get(iterador).getTitulo()+"</p></html>");
            
            i.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setNoticia(noticias.get(constante));
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    onEnteredImage ((JPanelImage)e.getComponent());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    onExitedImage ((JPanelImage)e.getComponent());
                }
            });
            iterador++;
        }
        
        
        
        JLabel[] categorias = new JLabel[] {
            categoriaTodas, categoriaEspaña, categoriaInternacional, categoriaDeporte, categoriaCultura, categoriaCiencia, categoriaViajar
        };
        
        for (JLabel l : categorias) {
            l.addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    // Al pulsar
                }

                @Override
                public void mousePressed(MouseEvent e) {
                    onPressedLabel ((JLabel)e.getComponent());
                }

                @Override
                public void mouseReleased(MouseEvent e) {
                    onReleaseLabel ((JLabel)e.getComponent());
                }

                @Override
                public void mouseEntered(MouseEvent e) {
                    onEnteredLabel ((JLabel)e.getComponent());
                }

                @Override
                public void mouseExited(MouseEvent e) {
                    onExitedLabel ((JLabel)e.getComponent());
                }
            });
        }
        
        
        JPanel[] panelesNoticias = new JPanel[] {
            noticias1,noticias2,noticias3,noticias4,noticias5
        };
        
        
        int min = Math.min (noticias.size(), panelesNoticias.length);
        for (int i = 0; i < min; i++) {
            Component[] componentes = panelesNoticias[i].getComponents();
            final Noticia _noticia = noticias.get(i);
            for (Component c : componentes) {
                switch(c.getName()) {
                    case "foto":
                        ((JPanelImage)c).setImagenFondo(new ImagenFondo(new File(_noticia.getImagen()),1f));
                        break;
                    case "contenido":
                        String contenido = _noticia.getContenido();
                        contenido = (contenido.length()>300) ? contenido.substring(0,300)+"..." : contenido;
                        ((JLabel)c).setText("<html>"+contenido+"</html>");
                        break;
                    case "titulo":
                        ((JLabel)c).setText("<html>"+_noticia.getTitulo()+"</html>");
                        break;
                }
            }
            
            panelesNoticias[i].addMouseListener(new MouseListener() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    setNoticia(_noticia);
                }
                @Override
                public void mousePressed(MouseEvent e) {                }
                @Override
                public void mouseReleased(MouseEvent e) {                }
                @Override
                public void mouseEntered(MouseEvent e) {                }
                @Override
                public void mouseExited(MouseEvent e) {                }
            
            });
            
            // Movemos el panel de posición:
            panelesNoticias[i].setLocation(0, 10+170*i);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        brillo = new jpanelimage.JPanelImage();
        jLabel2 = new javax.swing.JLabel();
        botonInicio = new javax.swing.JLabel();
        botonNoticias = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        botonTienda = new jpanelimage.JPanelImage();
        jPanel2 = new javax.swing.JPanel();
        botonNoticias1 = new javax.swing.JLabel();
        botonNoticias2 = new javax.swing.JLabel();
        categoriaTodas = new javax.swing.JLabel();
        categoriaEspaña = new javax.swing.JLabel();
        categoriaInternacional = new javax.swing.JLabel();
        categoriaDeporte = new javax.swing.JLabel();
        categoriaCultura = new javax.swing.JLabel();
        categoriaCiencia = new javax.swing.JLabel();
        categoriaViajar = new javax.swing.JLabel();
        panelInicio = new jpanelimage.JPanelImage();
        imagenNoticia1 = new jpanelimage.JPanelImage();
        textoNoticia1 = new javax.swing.JLabel();
        imagenNoticia2 = new jpanelimage.JPanelImage();
        textoNoticia2 = new javax.swing.JLabel();
        imagenNoticia3 = new jpanelimage.JPanelImage();
        textoNoticia3 = new javax.swing.JLabel();
        imagenNoticia4 = new jpanelimage.JPanelImage();
        textoNoticia4 = new javax.swing.JLabel();
        imagenNoticia5 = new jpanelimage.JPanelImage();
        textoNoticia5 = new javax.swing.JLabel();
        panelUltimas = new jpanelimage.JPanelImage();
        scroll = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        noticias1 = new javax.swing.JPanel();
        jPanelImage1 = new jpanelimage.JPanelImage();
        textoNoticia6 = new javax.swing.JLabel();
        textoNoticia7 = new javax.swing.JLabel();
        noticias2 = new javax.swing.JPanel();
        jPanelImage2 = new jpanelimage.JPanelImage();
        textoNoticia8 = new javax.swing.JLabel();
        textoNoticia9 = new javax.swing.JLabel();
        noticias3 = new javax.swing.JPanel();
        jPanelImage3 = new jpanelimage.JPanelImage();
        textoNoticia10 = new javax.swing.JLabel();
        textoNoticia11 = new javax.swing.JLabel();
        noticias4 = new javax.swing.JPanel();
        jPanelImage4 = new jpanelimage.JPanelImage();
        textoNoticia12 = new javax.swing.JLabel();
        textoNoticia13 = new javax.swing.JLabel();
        noticias5 = new javax.swing.JPanel();
        jPanelImage5 = new jpanelimage.JPanelImage();
        textoNoticia14 = new javax.swing.JLabel();
        textoNoticia15 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(960, 640));
        setMinimumSize(new java.awt.Dimension(960, 640));
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(0, 28, 14));
        jPanel1.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                jPanel1MouseDragged(evt);
            }
        });
        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jPanel1MousePressed(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("_");
        jLabel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel1MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(900, 0, 30, 30));

        brillo.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        brillo.setVisible(false);
        jPanel1.add(brillo, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 90, 60));

        jLabel2.setFont(new java.awt.Font("Aparajita", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 204, 204));
        jLabel2.setText("NoticiAPP");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 140, 50));

        botonInicio.setBackground(new java.awt.Color(23, 116, 67));
        botonInicio.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonInicio.setForeground(new java.awt.Color(255, 255, 255));
        botonInicio.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonInicio.setText("INICIO");
        botonInicio.setOpaque(true);
        botonInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonInicioMouseClicked(evt);
            }
        });
        jPanel1.add(botonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 0, 90, 60));

        botonNoticias.setBackground(new java.awt.Color(0, 104, 52));
        botonNoticias.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        botonNoticias.setForeground(new java.awt.Color(255, 255, 255));
        botonNoticias.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonNoticias.setText("ÚLTIMAS");
        botonNoticias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botonNoticiasMouseClicked(evt);
            }
        });
        jPanel1.add(botonNoticias, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 0, 90, 60));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("x");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 0, 30, 30));

        botonTienda.setBackground(new java.awt.Color(23, 116, 67));
        botonTienda.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        jPanel1.add(botonTienda, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 0, 60, 60));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 960, 60));

        jPanel2.setBackground(new java.awt.Color(16, 53, 35));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        botonNoticias1.setBackground(new java.awt.Color(0, 104, 52));
        botonNoticias1.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        botonNoticias1.setForeground(new java.awt.Color(255, 255, 255));
        botonNoticias1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonNoticias1.setText("<html>\n<p align=\"center\">Programado y desarrollado por Adrián García para Desarrollo de Interface. <b>Versión 0.4</b></p>\n</htlm>");
        jPanel2.add(botonNoticias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 520, 170, 50));

        botonNoticias2.setBackground(new java.awt.Color(0, 104, 52));
        botonNoticias2.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        botonNoticias2.setForeground(new java.awt.Color(255, 255, 255));
        botonNoticias2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        botonNoticias2.setText("CATEGORÍAS");
        jPanel2.add(botonNoticias2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 60));

        categoriaTodas.setBackground(new java.awt.Color(0, 104, 52));
        categoriaTodas.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaTodas.setForeground(new java.awt.Color(255, 255, 255));
        categoriaTodas.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaTodas.setText("Todas");
        jPanel2.add(categoriaTodas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 80, 190, 40));

        categoriaEspaña.setBackground(new java.awt.Color(0, 104, 52));
        categoriaEspaña.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaEspaña.setForeground(new java.awt.Color(255, 255, 255));
        categoriaEspaña.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaEspaña.setText("España");
        jPanel2.add(categoriaEspaña, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 120, 190, 40));

        categoriaInternacional.setBackground(new java.awt.Color(0, 104, 52));
        categoriaInternacional.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaInternacional.setForeground(new java.awt.Color(255, 255, 255));
        categoriaInternacional.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaInternacional.setText("Internacional");
        jPanel2.add(categoriaInternacional, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 190, 40));

        categoriaDeporte.setBackground(new java.awt.Color(0, 104, 52));
        categoriaDeporte.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaDeporte.setForeground(new java.awt.Color(255, 255, 255));
        categoriaDeporte.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaDeporte.setText("Deporte");
        jPanel2.add(categoriaDeporte, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 190, 40));

        categoriaCultura.setBackground(new java.awt.Color(0, 104, 52));
        categoriaCultura.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaCultura.setForeground(new java.awt.Color(255, 255, 255));
        categoriaCultura.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaCultura.setText("Cultura");
        jPanel2.add(categoriaCultura, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 190, 40));

        categoriaCiencia.setBackground(new java.awt.Color(0, 104, 52));
        categoriaCiencia.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaCiencia.setForeground(new java.awt.Color(255, 255, 255));
        categoriaCiencia.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaCiencia.setText("Ciencia");
        jPanel2.add(categoriaCiencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 190, 40));

        categoriaViajar.setBackground(new java.awt.Color(0, 104, 52));
        categoriaViajar.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        categoriaViajar.setForeground(new java.awt.Color(255, 255, 255));
        categoriaViajar.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        categoriaViajar.setText("Viajar");
        jPanel2.add(categoriaViajar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 320, 190, 40));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 60, 190, 580));

        panelInicio.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        panelInicio.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        imagenNoticia1.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        imagenNoticia1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoNoticia1.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia1.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textoNoticia1.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia1.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia1.setOpaque(true);
        imagenNoticia1.add(textoNoticia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 430, 60));

        panelInicio.add(imagenNoticia1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 300, 430, 220));

        imagenNoticia2.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        imagenNoticia2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoNoticia2.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia2.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textoNoticia2.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia2.setText("<html>\n\n<p align='center'>La baja natalidad en España obliga este año a celebrar el sorteo de la Lotería con un solo niño de San Ildefonso</p>\n\n</html>");
        textoNoticia2.setOpaque(true);
        imagenNoticia2.add(textoNoticia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 160, 430, 60));

        panelInicio.add(imagenNoticia2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 430, 220));

        imagenNoticia3.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        imagenNoticia3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoNoticia3.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia3.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textoNoticia3.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia3.setText("<html>  <p align='center' style='padding:10px'>Felipe VI no dará el Mensaje de Navidad de este año porque no quiere “encasillarse”</p>  </html>");
        textoNoticia3.setOpaque(true);
        imagenNoticia3.add(textoNoticia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 70));

        panelInicio.add(imagenNoticia3, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 380, 250, 140));

        imagenNoticia4.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        imagenNoticia4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoNoticia4.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia4.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textoNoticia4.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia4.setText("<html>  <p align='center' style='padding:10px'>“Llevé a mi perro al veterinario y lo atendió un Golden Retriever”</p>  </html>");
        textoNoticia4.setOpaque(true);
        imagenNoticia4.add(textoNoticia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 70));

        panelInicio.add(imagenNoticia4, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 40, 250, 140));

        imagenNoticia5.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        imagenNoticia5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        textoNoticia5.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia5.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        textoNoticia5.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia5.setText("<html>  <p align='center' style='padding:10px'>Torra dice que no dialogará con Sánchez hasta que no se hayan bebido juntos tres botellas de ratafia”</p>  </html>");
        textoNoticia5.setOpaque(true);
        imagenNoticia5.add(textoNoticia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 250, 70));

        panelInicio.add(imagenNoticia5, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 210, 250, 140));

        getContentPane().add(panelInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 770, 580));

        panelUltimas.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        panelUltimas.setVisible(false);
        panelUltimas.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        scroll.setBorder(null);
        scroll.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scroll.setAlignmentX(2.0F);
        scroll.setOpaque(false);

        jPanel3.setBackground(new java.awt.Color(255, 102, 51));
        jPanel3.setMinimumSize(new java.awt.Dimension(0, 1000));
        jPanel3.setOpaque(false);
        jPanel3.setPreferredSize(new java.awt.Dimension(100, 880));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        noticias1.setBackground(new java.awt.Color(0, 153, 0));
        noticias1.setOpaque(false);
        noticias1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImage1.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        jPanelImage1.setName("foto"); // NOI18N
        noticias1.add(jPanelImage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 140));

        textoNoticia6.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textoNoticia6.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia6.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia6.setName("contenido"); // NOI18N
        noticias1.add(textoNoticia6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 440, 90));

        textoNoticia7.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoNoticia7.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia7.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia7.setName("titulo"); // NOI18N
        noticias1.add(textoNoticia7, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 440, 50));

        jPanel3.add(noticias1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 730, 160));

        noticias2.setBackground(new java.awt.Color(0, 153, 0));
        noticias2.setOpaque(false);
        noticias2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImage2.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        jPanelImage2.setName("foto"); // NOI18N
        noticias2.add(jPanelImage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 140));

        textoNoticia8.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textoNoticia8.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia8.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia8.setName("contenido"); // NOI18N
        noticias2.add(textoNoticia8, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 440, 90));

        textoNoticia9.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoNoticia9.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia9.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia9.setName("titulo"); // NOI18N
        noticias2.add(textoNoticia9, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 440, 50));

        jPanel3.add(noticias2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 350, 730, 160));

        noticias3.setBackground(new java.awt.Color(0, 153, 0));
        noticias3.setOpaque(false);
        noticias3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImage3.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        jPanelImage3.setName("foto"); // NOI18N
        noticias3.add(jPanelImage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 140));

        textoNoticia10.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textoNoticia10.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia10.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia10.setName("contenido"); // NOI18N
        noticias3.add(textoNoticia10, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 440, 90));

        textoNoticia11.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoNoticia11.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia11.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia11.setName("titulo"); // NOI18N
        noticias3.add(textoNoticia11, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 440, 50));

        jPanel3.add(noticias3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 530, 730, 160));

        noticias4.setBackground(new java.awt.Color(0, 153, 0));
        noticias4.setOpaque(false);
        noticias4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImage4.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        jPanelImage4.setName("foto"); // NOI18N
        noticias4.add(jPanelImage4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 140));

        textoNoticia12.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia12.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textoNoticia12.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia12.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia12.setName("contenido"); // NOI18N
        noticias4.add(textoNoticia12, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 440, 90));

        textoNoticia13.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia13.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoNoticia13.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia13.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia13.setName("titulo"); // NOI18N
        noticias4.add(textoNoticia13, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 440, 50));

        jPanel3.add(noticias4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 710, 730, 160));

        noticias5.setBackground(new java.awt.Color(0, 153, 0));
        noticias5.setOpaque(false);
        noticias5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanelImage5.setImagenFondo(new jpanelimage.ImagenFondo(new java.io.File("/home/alumno"), 0.5f));
        jPanelImage5.setName("foto"); // NOI18N
        noticias5.add(jPanelImage5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 260, 140));

        textoNoticia14.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        textoNoticia14.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia14.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia14.setName("contenido"); // NOI18N
        noticias5.add(textoNoticia14, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 440, 90));

        textoNoticia15.setBackground(new java.awt.Color(0, 0, 0));
        textoNoticia15.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        textoNoticia15.setForeground(new java.awt.Color(255, 255, 255));
        textoNoticia15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textoNoticia15.setText("<html>\n\n<p align='center' style='padding:10px'>Cómo decorar la casa de tus padres para que no se note que has vuelto a vivir con ellos</p>\n\n</html>");
        textoNoticia15.setName("titulo"); // NOI18N
        noticias5.add(textoNoticia15, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 10, 440, 50));

        jPanel3.add(noticias5, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 730, 160));

        scroll.setViewportView(jPanel3);

        panelUltimas.add(scroll, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 770, 580));

        getContentPane().add(panelUltimas, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 770, 580));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel1MouseClicked
        this.setState(Frame.ICONIFIED);
    }//GEN-LAST:event_jLabel1MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void jPanel1MouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseDragged
        onMoving();
    }//GEN-LAST:event_jPanel1MouseDragged

    private void jPanel1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MousePressed
        onStartMove();
    }//GEN-LAST:event_jPanel1MousePressed

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        onFinishMove();
    }//GEN-LAST:event_jPanel1MouseReleased

    private void botonNoticiasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonNoticiasMouseClicked
        setButton(1);
    }//GEN-LAST:event_botonNoticiasMouseClicked

    private void botonInicioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInicioMouseClicked
        setButton(0);
    }//GEN-LAST:event_botonInicioMouseClicked

    public void closeShop () {
        mTienda = null;
    }
    
    private void setNoticia(Noticia n) {
        VerNoticia _noticia = new VerNoticia(this, false, n);
        _noticia.setVisible(true);
    }
    
    private void setButton (int id) {
        tabId = id;
        
        botonInicio.setOpaque(id==0);
        panelInicio.setVisible(id==0);
        
        botonNoticias.setOpaque(id==1);
        panelUltimas.setVisible(id==1);
        this.repaint();
        
        // Añadir otros si hubiera
    }
    
    private void setAtras () {
        setButton(tabId);
    }
    
    private void onEnteredLabel (JLabel label){
        label.setOpaque(true);
        this.repaint();
    }
    
    private void onExitedLabel (JLabel label){
        label.setOpaque(false);
        this.repaint();
    }
    
    private void onPressedLabel (JLabel label) {
        label.setBackground(new Color(0,60,60));
        this.repaint();
    }
    
    private void onReleaseLabel (JLabel label) {
        label.setBackground(new Color(0,104,52));
        this.repaint();
    }
    
    private void onEnteredImage (JPanelImage label){
        label.getImagenFondo().setOpcidad(0.6f);
        this.repaint();
    }
    
    private void onExitedImage (JPanelImage label){
        label.getImagenFondo().setOpcidad(1f);
        this.repaint();
    }
    
    private void onStartMove () {
        moving = true;
        start = MouseInfo.getPointerInfo().getLocation();
    }
    
    private void onMoving () {
        if (!moving)
            return;
        
        Point actual = MouseInfo.getPointerInfo().getLocation();
        Point widow = this.getLocation();
        this.setLocation(widow.x + actual.x - start.x, widow.y + actual.y - start.y);
        start = actual;
    }
    
    private void onFinishMove() {
        moving = false;
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Principal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel botonInicio;
    private javax.swing.JLabel botonNoticias;
    private javax.swing.JLabel botonNoticias1;
    private javax.swing.JLabel botonNoticias2;
    private jpanelimage.JPanelImage botonTienda;
    private jpanelimage.JPanelImage brillo;
    private javax.swing.JLabel categoriaCiencia;
    private javax.swing.JLabel categoriaCultura;
    private javax.swing.JLabel categoriaDeporte;
    private javax.swing.JLabel categoriaEspaña;
    private javax.swing.JLabel categoriaInternacional;
    private javax.swing.JLabel categoriaTodas;
    private javax.swing.JLabel categoriaViajar;
    private jpanelimage.JPanelImage imagenNoticia1;
    private jpanelimage.JPanelImage imagenNoticia2;
    private jpanelimage.JPanelImage imagenNoticia3;
    private jpanelimage.JPanelImage imagenNoticia4;
    private jpanelimage.JPanelImage imagenNoticia5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private jpanelimage.JPanelImage jPanelImage1;
    private jpanelimage.JPanelImage jPanelImage2;
    private jpanelimage.JPanelImage jPanelImage3;
    private jpanelimage.JPanelImage jPanelImage4;
    private jpanelimage.JPanelImage jPanelImage5;
    private javax.swing.JPanel noticias1;
    private javax.swing.JPanel noticias2;
    private javax.swing.JPanel noticias3;
    private javax.swing.JPanel noticias4;
    private javax.swing.JPanel noticias5;
    private jpanelimage.JPanelImage panelInicio;
    private jpanelimage.JPanelImage panelUltimas;
    private javax.swing.JScrollPane scroll;
    private javax.swing.JLabel textoNoticia1;
    private javax.swing.JLabel textoNoticia10;
    private javax.swing.JLabel textoNoticia11;
    private javax.swing.JLabel textoNoticia12;
    private javax.swing.JLabel textoNoticia13;
    private javax.swing.JLabel textoNoticia14;
    private javax.swing.JLabel textoNoticia15;
    private javax.swing.JLabel textoNoticia2;
    private javax.swing.JLabel textoNoticia3;
    private javax.swing.JLabel textoNoticia4;
    private javax.swing.JLabel textoNoticia5;
    private javax.swing.JLabel textoNoticia6;
    private javax.swing.JLabel textoNoticia7;
    private javax.swing.JLabel textoNoticia8;
    private javax.swing.JLabel textoNoticia9;
    // End of variables declaration//GEN-END:variables
}
