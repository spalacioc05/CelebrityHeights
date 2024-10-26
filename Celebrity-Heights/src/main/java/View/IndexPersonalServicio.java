/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.SesionGlobal;
import Controller.Listar;
import Controller.Navegacion;
import javax.swing.JOptionPane;

/**
 *
 * @author spala
 */
public class IndexPersonalServicio extends javax.swing.JFrame {

    /**
     * Creates new form Index
     */
    public IndexPersonalServicio() {
        initComponents();
        this.setDefaultCloseOperation(HIDE_ON_CLOSE);
        this.setLocationRelativeTo(null);
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
        jPanel2 = new javax.swing.JPanel();
        jButtonActualizar = new javax.swing.JButton();
        jButtonSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButtonVerSolicitudes = new javax.swing.JButton();
        jButtonHorarios = new javax.swing.JButton();
        jButtonSolicitudIndicacion = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(247, 247, 247));

        jPanel2.setBackground(new java.awt.Color(197, 168, 128));

        jButtonActualizar.setBackground(new java.awt.Color(197, 168, 128));
        jButtonActualizar.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonActualizar.setForeground(new java.awt.Color(44, 44, 44));
        jButtonActualizar.setText("Actualizar Perfil");
        jButtonActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonActualizarActionPerformed(evt);
            }
        });

        jButtonSalir.setBackground(new java.awt.Color(197, 168, 128));
        jButtonSalir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSalir.setForeground(new java.awt.Color(44, 44, 44));
        jButtonSalir.setText("Cerrar Sesion");
        jButtonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSalirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(321, Short.MAX_VALUE)
                .addComponent(jButtonActualizar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonSalir)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonActualizar)
                    .addComponent(jButtonSalir))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(46, 74, 87));
        jLabel1.setText("Personal de Servicio");

        jButtonVerSolicitudes.setBackground(new java.awt.Color(197, 168, 128));
        jButtonVerSolicitudes.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonVerSolicitudes.setForeground(new java.awt.Color(44, 44, 44));
        jButtonVerSolicitudes.setText("Indicaciones");
        jButtonVerSolicitudes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonVerSolicitudesActionPerformed(evt);
            }
        });

        jButtonHorarios.setBackground(new java.awt.Color(197, 168, 128));
        jButtonHorarios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonHorarios.setForeground(new java.awt.Color(44, 44, 44));
        jButtonHorarios.setText("Horario de Zonas Comunes");
        jButtonHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonHorariosActionPerformed(evt);
            }
        });

        jButtonSolicitudIndicacion.setBackground(new java.awt.Color(197, 168, 128));
        jButtonSolicitudIndicacion.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jButtonSolicitudIndicacion.setForeground(new java.awt.Color(44, 44, 44));
        jButtonSolicitudIndicacion.setText("Solicitud de Indicacion");
        jButtonSolicitudIndicacion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSolicitudIndicacionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(jButtonVerSolicitudes)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonSolicitudIndicacion))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 134, Short.MAX_VALUE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 325, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(121, 121, 121))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(179, 179, 179)
                .addComponent(jButtonHorarios)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonVerSolicitudes)
                    .addComponent(jButtonSolicitudIndicacion))
                .addGap(29, 29, 29)
                .addComponent(jButtonHorarios)
                .addContainerGap(58, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonActualizarActionPerformed
        Navegacion.setVentanaAnterior(this);
        ActualizarEmpleado actualizarEmpleado = new ActualizarEmpleado();
        actualizarEmpleado.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonActualizarActionPerformed

    private void jButtonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSalirActionPerformed
        SesionGlobal.logout();
        this.dispose();
        Index index = new Index();
        index.setVisible(true);
    }//GEN-LAST:event_jButtonSalirActionPerformed

    private void jButtonVerSolicitudesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonVerSolicitudesActionPerformed
        Listar listar = new Listar();
        boolean suseso = listar.ListarIndicacionesPDF();
        if (suseso) {
            //JOptionPane.showMessageDialog(this, "El PDF se generó y abrió correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonVerSolicitudesActionPerformed

    private void jButtonHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonHorariosActionPerformed
        Listar listar = new Listar();
        boolean suseso = listar.ListarHorarioZonasComunesPDF();
        if (suseso) {
            //JOptionPane.showMessageDialog(this, "El PDF se generó y abrió correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Ocurrió un error al generar el PDF.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButtonHorariosActionPerformed

    private void jButtonSolicitudIndicacionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSolicitudIndicacionActionPerformed
        Navegacion.setVentanaAnterior(this);
        SolicitudIndicacion solicitudIndicacion = new SolicitudIndicacion();
        solicitudIndicacion.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButtonSolicitudIndicacionActionPerformed

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
            java.util.logging.Logger.getLogger(IndexPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IndexPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IndexPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IndexPropietario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IndexPersonalServicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonActualizar;
    private javax.swing.JButton jButtonHorarios;
    private javax.swing.JButton jButtonSalir;
    private javax.swing.JButton jButtonSolicitudIndicacion;
    private javax.swing.JButton jButtonVerSolicitudes;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
