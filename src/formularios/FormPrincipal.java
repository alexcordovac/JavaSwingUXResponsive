/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import utiles.JPanelArrastrable;
import conexion.Conexion;
import controladores.ControladorMenu;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;
import jiconfont.swing.IconFontSwing;
import recursos.iconos.GoogleMaterialDesignIcons;
import utiles.Constantes;

/**
 *
 * @author Alex
 */
public class FormPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form FormPrincipal
     */
    public FormPrincipal() {
        configVentana();
        initComponents();
        pintarIconos();
        
    }
    
    /*Método para color iconos en la ventana principal*/
    private void pintarIconos() {
        IconFontSwing.register(GoogleMaterialDesignIcons.getIconFont());

        //Top bar
        lblIconSalir.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.CLOSE, 30, Constantes.COLOR_LIGERO));
        lblSistemaIco.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ROOM_SERVICE, 30, Constantes.COLOR_LIGERO));
        lblUsuarioIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ACCOUNT_CIRCLE, 25, Constantes.COLOR_LIGERO));
        lblNotificacionIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.NOTIFICATIONS, 25, Constantes.COLOR_LIGERO));
        lblCorazonIcon.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.FAVORITE, 25, Constantes.COLOR_LIGERO));

        //Botón esconder menu
        lblMostrarOcultarMenu.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.NAVIGATE_BEFORE, 50, Constantes.COLOR_LIGERO));
        
        //Menu items
        //jLabel2.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.ASSIGNMENT_IND, 30, Constantes.COLOR_PRIMARIO));
        //jLabel3.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.EQUALIZER, 30, Constantes.COLOR_PRIMARIO));
    }
    
    /*Ajustes a la ventana principal*/
    private void configVentana() {
        //Ajustar al 90% de la pantalla
        Toolkit tk = Toolkit.getDefaultToolkit();
        int xSize = ((int) tk.getScreenSize().getWidth());
        int ySize = ((int) tk.getScreenSize().getHeight());
        int gameHeight = (int) (Math.round(ySize * 0.90));
        int gameWidth = (int) (Math.round(xSize * 0.90));
        setPreferredSize(new Dimension(gameWidth, gameHeight));

        getContentPane().setBackground(new Color(230, 230, 230));
        setResizable(true);
        setUndecorated(true);

        //Redondear bordes
        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 40, 40));
            }
        });
    }
    
    /*Función para mostrar o ocultar el menú deslizable de la izquierda*/
    public void mostrarOcultarMenu(JPanel menushowhide) {
        if (menuShowed == true) {
            int width = menushowhide.getWidth();
            new Thread(() -> {
                    for (int i = width; i >= 50; i-=2) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        menushowhide.setPreferredSize(new Dimension(i, menushowhide.getHeight()));
                        menushowhide.revalidate();
                        menushowhide.repaint();
                }
            }).start();
            this.revalidate();
            lblMostrarOcultarMenu.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.MENU, 40, Constantes.COLOR_LIGERO));
            menuShowed = false;

        } else {
            int width = menushowhide.getWidth();
            new Thread(() -> {
                    for (int i = width; i <= 250; i+=2) {
                        try {
                            Thread.sleep(1);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(FormPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        menushowhide.setPreferredSize(new Dimension(i, menushowhide.getHeight()));
                        menushowhide.revalidate();
                        menushowhide.repaint();
                }
            }).start();
            lblMostrarOcultarMenu.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.NAVIGATE_BEFORE, 50, Constantes.COLOR_LIGERO));
            menuShowed = true;
        }
    }

    /*GETTER y SETTERS para el ControladorMenu*/

    public JPanel getPanelMenus() {
        return panelMenuExpandible;
    }

    public JPanel getPanelCuerpo() {
        return panelCuerpo;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelToolBar = new JPanelArrastrable();
        lblIconSalir = new javax.swing.JLabel();
        lblSistemaNombre = new javax.swing.JLabel();
        lblSistemaIco = new javax.swing.JLabel();
        lblCorazonIcon = new javax.swing.JLabel();
        lblUsuarioIcon = new javax.swing.JLabel();
        lblNotificacionIcon = new javax.swing.JLabel();
        panelMenuContenedor = new javax.swing.JPanel();
        panelMenu = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        lblMostrarOcultarMenu = new javax.swing.JLabel();
        panelMenuExpandible = new javax.swing.JPanel();
        panelCuerpo = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        panelToolBar.setBackground(Constantes.COLOR_PRIMARIO);
        panelToolBar.setPreferredSize(new java.awt.Dimension(900, 50));

        lblIconSalir.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblIconSalir.setAlignmentX(0.5F);
        lblIconSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        lblIconSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblIconSalirMouseClicked(evt);
            }
        });

        lblSistemaNombre.setText(Constantes.EMPRESA);
        lblSistemaNombre.setBackground(new java.awt.Color(255, 208, 127));
        lblSistemaNombre.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        lblSistemaNombre.setForeground(new java.awt.Color(255, 208, 127));

        javax.swing.GroupLayout panelToolBarLayout = new javax.swing.GroupLayout(panelToolBar);
        panelToolBar.setLayout(panelToolBarLayout);
        panelToolBarLayout.setHorizontalGroup(
            panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelToolBarLayout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addComponent(lblSistemaIco, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblSistemaNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 394, Short.MAX_VALUE)
                .addComponent(lblCorazonIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(lblNotificacionIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(lblUsuarioIcon, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(lblIconSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        panelToolBarLayout.setVerticalGroup(
            panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelToolBarLayout.createSequentialGroup()
                .addContainerGap(12, Short.MAX_VALUE)
                .addGroup(panelToolBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblIconSalir, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(lblSistemaNombre, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblSistemaIco, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblCorazonIcon, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblUsuarioIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblNotificacionIcon, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(panelToolBar, java.awt.BorderLayout.PAGE_START);

        panelMenuContenedor.setName(""); // NOI18N
        panelMenuContenedor.setPreferredSize(new java.awt.Dimension(250, 450));
        panelMenuContenedor.setLayout(new java.awt.BorderLayout());

        panelMenu.setBackground(Constantes.COLOR_PRIMARIO);
        panelMenu.setPreferredSize(new java.awt.Dimension(50, 450));
        panelMenu.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBackground(Constantes.COLOR_PRIMARIO);
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jPanel4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jPanel4MouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 10, Short.MAX_VALUE)
        );

        panelMenu.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 50, 10));

        lblMostrarOcultarMenu.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblMostrarOcultarMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lblMostrarOcultarMenuMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                lblMostrarOcultarMenuMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                lblMostrarOcultarMenuMouseExited(evt);
            }
        });
        panelMenu.add(lblMostrarOcultarMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 50, 40));

        panelMenuContenedor.add(panelMenu, java.awt.BorderLayout.LINE_START);

        panelMenuExpandible.setName("jpanel3");
        panelMenuExpandible.setBackground(Constantes.COLOR_LIGERO);
        panelMenuExpandible.setLayout(new javax.swing.BoxLayout(panelMenuExpandible, javax.swing.BoxLayout.Y_AXIS));
        panelMenuContenedor.add(panelMenuExpandible, java.awt.BorderLayout.CENTER);

        getContentPane().add(panelMenuContenedor, java.awt.BorderLayout.LINE_START);

        panelCuerpo.setBackground(Constantes.COLOR_BEIGE);
        panelCuerpo.setLayout(new java.awt.CardLayout());
        getContentPane().add(panelCuerpo, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void lblIconSalirMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblIconSalirMouseClicked
        System.exit(0);
    }//GEN-LAST:event_lblIconSalirMouseClicked

    private void jPanel4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseEntered
        jPanel4.setBackground(Constantes.COLOR_MEDIO);
    }//GEN-LAST:event_jPanel4MouseEntered

    private void jPanel4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseExited
        jPanel4.setBackground(Constantes.COLOR_PRIMARIO);
    }//GEN-LAST:event_jPanel4MouseExited

    private void lblMostrarOcultarMenuMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMostrarOcultarMenuMouseEntered
        jPanel4.setBackground(Constantes.COLOR_MEDIO);
    }//GEN-LAST:event_lblMostrarOcultarMenuMouseEntered

    private void lblMostrarOcultarMenuMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMostrarOcultarMenuMouseExited
        jPanel4.setBackground(Constantes.COLOR_PRIMARIO);
    }//GEN-LAST:event_lblMostrarOcultarMenuMouseExited
    
    boolean menuShowed = true;
    private void lblMostrarOcultarMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lblMostrarOcultarMenuMouseClicked
        mostrarOcultarMenu(this.panelMenuContenedor);
    }//GEN-LAST:event_lblMostrarOcultarMenuMouseClicked

   
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
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPrincipal vistaPrincipal = new FormPrincipal();
                vistaPrincipal.setLocationRelativeTo(null);
                vistaPrincipal.setVisible(true);
                
                new Thread( () -> {
                    Conexion a = new Conexion();
                    a.inicializarProps();
                    ControladorMenu ctrlMenu = new ControladorMenu(vistaPrincipal);
                
                }).start();
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel4;
    private javax.swing.JLabel lblCorazonIcon;
    private javax.swing.JLabel lblIconSalir;
    private javax.swing.JLabel lblMostrarOcultarMenu;
    private javax.swing.JLabel lblNotificacionIcon;
    private javax.swing.JLabel lblSistemaIco;
    private javax.swing.JLabel lblSistemaNombre;
    private javax.swing.JLabel lblUsuarioIcon;
    private javax.swing.JPanel panelCuerpo;
    private javax.swing.JPanel panelMenu;
    private javax.swing.JPanel panelMenuContenedor;
    private javax.swing.JPanel panelMenuExpandible;
    private javax.swing.JPanel panelToolBar;
    // End of variables declaration//GEN-END:variables
}
