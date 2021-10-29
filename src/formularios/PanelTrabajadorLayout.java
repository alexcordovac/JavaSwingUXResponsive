/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package formularios;

import java.awt.Color;
import java.awt.Font;
import jiconfont.swing.IconFontSwing;
import recursos.iconos.GoogleMaterialDesignIcons;
import utiles.Constantes;
import utiles.TextPrompt;

/**
 *
 * @author Alex
 */
public class PanelTrabajadorLayout extends javax.swing.JPanel {

    /**
     * Creates new form NewJPanel
     */
    public PanelTrabajadorLayout() {
        initComponents();
        pintarIconos();
        pintarFormTrabajador();
        
        //Placeholder de la fecha
        TextPrompt phFecha = new TextPrompt("yyyy/mm/dd", jTextField1);
        phFecha.changeAlpha(0.75f);
        phFecha.changeStyle(Font.ITALIC);
    }
    
    private void pintarIconos(){
        jLabel1.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.FLAG, 30, Color.WHITE));
        jLabel3.setIcon(IconFontSwing.buildIcon(GoogleMaterialDesignIcons.SAVE, 30, Color.WHITE));
    }
    
    private void pintarFormTrabajador(){
        for (int i = 1; i <= 3; i++) {
            panelTrabajadores.add(new FormTrabajador(i));
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

        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        panelIniciarJornada = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        panelRegistrar = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        panelTrabajadores = new javax.swing.JPanel();

        setPreferredSize(new java.awt.Dimension(650, 450));
        setLayout(new java.awt.BorderLayout());

        jPanel4.setBackground(Constantes.COLOR_BEIGE);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Fecha:");

        jTextField1.setBackground(Constantes.COLOR_BEIGE);
        jTextField1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jTextField1.setToolTipText("");
        jTextField1.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel6.setForeground(Constantes.COLOR_LIGERO);
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("Asignar trabajo");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(420, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel1.setBackground(Constantes.COLOR_BEIGE);
        jPanel1.setName(""); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(650, 150));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        jPanel3.setBackground(Constantes.COLOR_BEIGE);

        panelIniciarJornada.setBackground(Constantes.COLOR_PRIMARIO);
        panelIniciarJornada.setPreferredSize(new java.awt.Dimension(150, 51));
        panelIniciarJornada.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelIniciarJornadaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelIniciarJornadaMouseExited(evt);
            }
        });
        panelIniciarJornada.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelIniciarJornada.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 52, 51));

        jLabel2.setBackground(new java.awt.Color(204, 204, 204));
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Iniciar jornada");
        panelIniciarJornada.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 14, 90, 20));

        panelRegistrar.setBackground(Constantes.COLOR_PRIMARIO);
        panelRegistrar.setPreferredSize(new java.awt.Dimension(150, 51));
        panelRegistrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                panelRegistrarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                panelRegistrarMouseExited(evt);
            }
        });
        panelRegistrar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        panelRegistrar.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 52, 51));

        jLabel4.setBackground(new java.awt.Color(204, 204, 204));
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Registrar");
        panelRegistrar.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 14, 90, 20));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addComponent(panelIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(panelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(panelRegistrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(panelIniciarJornada, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel3, new java.awt.GridBagConstraints());

        add(jPanel1, java.awt.BorderLayout.PAGE_END);

        panelTrabajadores.setBackground(Constantes.COLOR_BEIGE);
        panelTrabajadores.setPreferredSize(new java.awt.Dimension(650, 300));
        panelTrabajadores.setLayout(new java.awt.GridLayout(1, 3));
        add(panelTrabajadores, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void panelIniciarJornadaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelIniciarJornadaMouseEntered
        panelIniciarJornada.setBackground(Constantes.COLOR_MEDIO);
    }//GEN-LAST:event_panelIniciarJornadaMouseEntered

    private void panelIniciarJornadaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelIniciarJornadaMouseExited
        panelIniciarJornada.setBackground(Constantes.COLOR_PRIMARIO);
    }//GEN-LAST:event_panelIniciarJornadaMouseExited

    private void panelRegistrarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrarMouseEntered
        panelRegistrar.setBackground(Constantes.COLOR_MEDIO);
    }//GEN-LAST:event_panelRegistrarMouseEntered

    private void panelRegistrarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_panelRegistrarMouseExited
        panelRegistrar.setBackground(Constantes.COLOR_PRIMARIO);
    }//GEN-LAST:event_panelRegistrarMouseExited


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JPanel panelIniciarJornada;
    private javax.swing.JPanel panelRegistrar;
    private javax.swing.JPanel panelTrabajadores;
    // End of variables declaration//GEN-END:variables
}
