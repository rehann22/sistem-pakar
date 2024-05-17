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
            buttonGradient2 = new swing.ButtonGradient();
            textAreaScroll1 = new textarea.TextAreaScroll();
            txt_pencegahan = new textarea.TextArea();
            txt_kodepenyakit = new javax.swing.JTextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_obat.setEditable(false);
            txt_obat.setBackground(new java.awt.Color(255, 255, 255));
            txt_obat.setForeground(new java.awt.Color(130, 130, 130));
            txt_obat.setLabelText("Kami Merekomendasikan Obat");
            jPanel1.add(txt_obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 300, 250, -1));

            txt_namapenyakit.setEditable(false);
            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(130, 130, 130));
            txt_namapenyakit.setLabelText("Ikan Terjangkit Penyakit");
            jPanel1.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 60, 250, -1));

            buttonGradient2.setText("Simpan");
            buttonGradient2.setColor1(new java.awt.Color(93, 7, 130));
            buttonGradient2.setColor2(new java.awt.Color(7, 65, 115));
            jPanel1.add(buttonGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 390, 170, 30));

            textAreaScroll1.setLabelText("Pencegahan");

            txt_pencegahan.setEditable(false);
            txt_pencegahan.setBackground(new java.awt.Color(255, 255, 255));
            txt_pencegahan.setColumns(20);
            txt_pencegahan.setForeground(new java.awt.Color(130, 130, 130));
            txt_pencegahan.setRows(5);
            textAreaScroll1.setViewportView(txt_pencegahan);

            jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 240, 130));

            txt_kodepenyakit.setEditable(false);
            txt_kodepenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_kodepenyakit.setForeground(new java.awt.Color(255, 255, 255));
            txt_kodepenyakit.setBorder(null);
            jPanel1.add(txt_kodepenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 430, 90, 40));

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
      private swing.ButtonGradient buttonGradient2;
      private javax.swing.JPanel jPanel1;
      private textarea.TextAreaScroll textAreaScroll1;
      public javax.swing.JTextField txt_kodepenyakit;
      public textfield.TextField txt_namapenyakit;
      public textfield.TextField txt_obat;
      public textarea.TextArea txt_pencegahan;
      // End of variables declaration//GEN-END:variables
}
