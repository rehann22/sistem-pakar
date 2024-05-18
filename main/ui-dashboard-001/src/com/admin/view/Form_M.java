package com.admin.view;

import com.admin.controler.AdminProfile;
import com.formdev.flatlaf.FlatLightLaf;

public class Form_M extends javax.swing.JFrame {

      public Form_M() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            txt_password = new textfield.TextField();
            txt_email = new textfield.TextField();
            btn_simpan = new swing.ButtonGradient();
            txt_id = new textfield.TextField();
            txt_nama = new textfield.TextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_password.setBackground(new java.awt.Color(255, 255, 255));
            txt_password.setForeground(new java.awt.Color(130, 130, 130));
            txt_password.setLabelText("Password");
            jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 250, -1));

            txt_email.setBackground(new java.awt.Color(255, 255, 255));
            txt_email.setForeground(new java.awt.Color(130, 130, 130));
            txt_email.setLabelText("Email");
            jPanel1.add(txt_email, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 250, -1));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(195, 36, 35));
            btn_simpan.setColor2(new java.awt.Color(7, 65, 115));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(77, 370, 240, 30));

            txt_id.setEditable(false);
            txt_id.setBackground(new java.awt.Color(255, 255, 255));
            txt_id.setForeground(new java.awt.Color(130, 130, 130));
            txt_id.setLabelText("Id");
            jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 250, -1));

            txt_nama.setBackground(new java.awt.Color(255, 255, 255));
            txt_nama.setForeground(new java.awt.Color(130, 130, 130));
            txt_nama.setLabelText("Nama");
            jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 250, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
            AdminProfile data = new AdminProfile();
            data.editData(txt_id, txt_nama, txt_email, txt_password);
      }//GEN-LAST:event_btn_simpanActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_M().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private javax.swing.JPanel jPanel1;
      public textfield.TextField txt_email;
      public textfield.TextField txt_id;
      public textfield.TextField txt_nama;
      public textfield.TextField txt_password;
      // End of variables declaration//GEN-END:variables
}
