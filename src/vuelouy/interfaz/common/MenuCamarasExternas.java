/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vuelouy.interfaz.common;

import vuelouy.idiomas.ManejadorDeLenguajes;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Usuario
 */
public class MenuCamarasExternas extends javax.swing.JPanel implements Observer {

    /**
     * Creates new form MenuCamarasExternas
     */
    private ComunicacionPaneles comunicacion;

    /**
     *
     */
    public MenuCamarasExternas() {
        initComponents();
    }

    /**
     * @param p
     */
    public MenuCamarasExternas(ComunicacionPaneles p) {
        comunicacion = p;
        comunicacion.addObserver(this);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnVolver = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        lblCamaraExterna = new javax.swing.JLabel();

        btnVolver.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vuelouy/image/Volver.png"))); // NOI18N
        btnVolver.setBorder(null);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setPreferredSize(new java.awt.Dimension(96, 96));
        btnVolver.setPressedIcon(new javax.swing.ImageIcon(getClass().getResource("/vuelouy/image/VolverP.png"))); // NOI18N
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vuelouy/image/Camara Avion Volteado.gif"))); // NOI18N

        lblCamaraExterna.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        lblCamaraExterna.setText("Cámara Externa");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(130, 130, 130)
                                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(lblCamaraExterna)))
                                .addContainerGap(136, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblCamaraExterna)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 134, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(93, 93, 93)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        comunicacion.setBPanel(true);
        comunicacion.cambio("Entretenimiento");
    }//GEN-LAST:event_btnVolverActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel lblCamaraExterna;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        if (comunicacion.getBPanel()) {
            this.setVisible(false);
            comunicacion.getVentanaInicioP().mostrarSubMenu(comunicacion.getPanel());
            comunicacion.setBPanel(false);
        }

        lblCamaraExterna.setText(ManejadorDeLenguajes.getInstancia().getIdiomaActual().getCamaraExterna());
    }
}
