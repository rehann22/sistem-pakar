package com.user.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.user.controler.EditProfile;

public class Form_F extends javax.swing.JFrame {

      public Form_F() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            txt_password = new textfield.TextField();
            txt_username = new textfield.TextField();
            txt_id = new textfield.TextField();
            txt_nama = new textfield.TextField();
            btn_simpan = new swing.ButtonGradient();
            jLabel2 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_password.setBackground(new java.awt.Color(255, 255, 255));
            txt_password.setForeground(new java.awt.Color(97, 103, 122));
            txt_password.setLabelText("Password");
            txt_password.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_password, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 310, 250, -1));

            txt_username.setBackground(new java.awt.Color(255, 255, 255));
            txt_username.setForeground(new java.awt.Color(97, 103, 122));
            txt_username.setLabelText("Username");
            txt_username.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_username, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 250, -1));

            txt_id.setEditable(false);
            txt_id.setBackground(new java.awt.Color(255, 255, 255));
            txt_id.setForeground(new java.awt.Color(97, 103, 122));
            txt_id.setLabelText("Id");
            txt_id.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 100, 250, -1));

            txt_nama.setBackground(new java.awt.Color(255, 255, 255));
            txt_nama.setForeground(new java.awt.Color(97, 103, 122));
            txt_nama.setLabelText("Nama");
            txt_nama.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_nama, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 170, 250, -1));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(40, 26, 220));
            btn_simpan.setColor2(new java.awt.Color(0, 255, 25));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 390, 240, 30));

            jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Perbarui Data Kamu");
            jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 390, 40));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
            EditProfile data = new EditProfile();
            data.EditDataUsers(txt_id, txt_nama, txt_username, txt_password);
      }//GEN-LAST:event_btn_simpanActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_F().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JPanel jPanel1;
      public textfield.TextField txt_id;
      public textfield.TextField txt_nama;
      public textfield.TextField txt_password;
      public textfield.TextField txt_username;
      // End of variables declaration//GEN-END:variables
}
