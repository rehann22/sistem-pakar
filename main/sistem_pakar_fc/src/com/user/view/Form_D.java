package com.user.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.user.controler.HasilKonsulltasi;
import com.user.controler.SessionUser;

public class Form_D extends javax.swing.JFrame {
      String logId = SessionUser.log_idPengguna();
      String logName = SessionUser.log_nama();

      public Form_D() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            txt_obat = new textfield.TextField();
            txt_namapenyakit = new textfield.TextField();
            textAreaScroll1 = new textarea.TextAreaScroll();
            txt_pencegahan = new textarea.TextArea();
            txt_kodepenyakit = new javax.swing.JTextField();
            buttonGradient1 = new swing.ButtonGradient();
            txt_kode = new textfield.TextField();
            jLabel2 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setPreferredSize(new java.awt.Dimension(520, 500));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_obat.setEditable(false);
            txt_obat.setBackground(new java.awt.Color(255, 255, 255));
            txt_obat.setForeground(new java.awt.Color(97, 103, 122));
            txt_obat.setLabelText("");
            txt_obat.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 320, 240, -1));

            txt_namapenyakit.setEditable(false);
            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapenyakit.setLabelText("");
            txt_namapenyakit.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 120, 240, 50));

            textAreaScroll1.setLabelText("");
            textAreaScroll1.setLineColor(new java.awt.Color(0, 255, 25));

            txt_pencegahan.setEditable(false);
            txt_pencegahan.setBackground(new java.awt.Color(255, 255, 255));
            txt_pencegahan.setColumns(20);
            txt_pencegahan.setForeground(new java.awt.Color(97, 103, 122));
            txt_pencegahan.setRows(5);
            textAreaScroll1.setViewportView(txt_pencegahan);

            jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 170, 240, 140));

            txt_kodepenyakit.setEditable(false);
            txt_kodepenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_kodepenyakit.setForeground(new java.awt.Color(255, 255, 255));
            txt_kodepenyakit.setBorder(null);
            jPanel1.add(txt_kodepenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 50, 40));

            buttonGradient1.setText("Simpan");
            buttonGradient1.setColor1(new java.awt.Color(40, 26, 220));
            buttonGradient1.setColor2(new java.awt.Color(0, 255, 25));
            buttonGradient1.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        buttonGradient1ActionPerformed(evt);
                  }
            });
            jPanel1.add(buttonGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 400, 240, 30));

            txt_kode.setBackground(new java.awt.Color(255, 255, 255));
            txt_kode.setForeground(new java.awt.Color(97, 103, 122));
            txt_kode.setLabelText("");
            txt_kode.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 64, 240, -1));

            jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Hasil Diagnosa Sistem");
            jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 450, 40));

            jLabel3.setForeground(new java.awt.Color(97, 103, 122));
            jLabel3.setText("Obat");
            jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 70, 40));

            jLabel4.setForeground(new java.awt.Color(97, 103, 122));
            jLabel4.setText("Id Konsultasi");
            jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 80, 90, 30));

            jLabel5.setForeground(new java.awt.Color(97, 103, 122));
            jLabel5.setText("Nama Penyakit");
            jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 130, 90, 40));

            jLabel6.setForeground(new java.awt.Color(97, 103, 122));
            jLabel6.setText("Pencegahan");
            jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 180, 90, 30));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 450, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void buttonGradient1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonGradient1ActionPerformed
           HasilKonsulltasi data = new HasilKonsulltasi();
           data.simpanHasilKonsultasi(logId, txt_kodepenyakit);
      }//GEN-LAST:event_buttonGradient1ActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_D().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient buttonGradient1;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel5;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JPanel jPanel1;
      private textarea.TextAreaScroll textAreaScroll1;
      public textfield.TextField txt_kode;
      public javax.swing.JTextField txt_kodepenyakit;
      public textfield.TextField txt_namapenyakit;
      public textfield.TextField txt_obat;
      public textarea.TextArea txt_pencegahan;
      // End of variables declaration//GEN-END:variables
}
