package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;

public class Form_J extends javax.swing.JFrame {

      public Form_J() {
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
            jLabel1 = new javax.swing.JLabel();
            txt_kode = new textfield.TextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_obat.setEditable(false);
            txt_obat.setBackground(new java.awt.Color(255, 255, 255));
            txt_obat.setForeground(new java.awt.Color(97, 103, 122));
            txt_obat.setLabelText("Kami Merekomendasikan Obat");
            jPanel1.add(txt_obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 330, 280, -1));

            txt_namapenyakit.setEditable(false);
            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapenyakit.setLabelText("Ikan Terjangkit Penyakit");
            jPanel1.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 150, 280, -1));

            textAreaScroll1.setLabelText("Pencegahan");

            txt_pencegahan.setEditable(false);
            txt_pencegahan.setBackground(new java.awt.Color(255, 255, 255));
            txt_pencegahan.setColumns(20);
            txt_pencegahan.setForeground(new java.awt.Color(97, 103, 122));
            txt_pencegahan.setRows(5);
            textAreaScroll1.setViewportView(txt_pencegahan);

            jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 210, 280, 110));

            txt_kodepenyakit.setEditable(false);
            txt_kodepenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_kodepenyakit.setForeground(new java.awt.Color(255, 255, 255));
            txt_kodepenyakit.setBorder(null);
            jPanel1.add(txt_kodepenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 400, 90, 40));

            jLabel1.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel1.setText("Hasil Diagnosa Sistem");
            jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 390, 40));

            txt_kode.setEditable(false);
            txt_kode.setBackground(new java.awt.Color(255, 255, 255));
            txt_kode.setForeground(new java.awt.Color(97, 103, 122));
            txt_kode.setLabelText("Kode Konsultasi");
            jPanel1.add(txt_kode, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 90, 280, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_J().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private javax.swing.JLabel jLabel1;
      private javax.swing.JPanel jPanel1;
      private textarea.TextAreaScroll textAreaScroll1;
      public textfield.TextField txt_kode;
      public javax.swing.JTextField txt_kodepenyakit;
      public textfield.TextField txt_namapenyakit;
      public textfield.TextField txt_obat;
      public textarea.TextArea txt_pencegahan;
      // End of variables declaration//GEN-END:variables
}
