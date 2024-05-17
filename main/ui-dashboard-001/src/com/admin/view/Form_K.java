package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;

public class Form_K extends javax.swing.JFrame {

      public Form_K() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            textField1 = new textfield.TextField();
            textField3 = new textfield.TextField();
            buttonGradient1 = new swing.ButtonGradient();
            buttonGradient2 = new swing.ButtonGradient();
            textField4 = new textfield.TextField();
            textField5 = new textfield.TextField();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            textField1.setBackground(new java.awt.Color(255, 255, 255));
            textField1.setForeground(new java.awt.Color(130, 130, 130));
            jPanel1.add(textField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 270, 250, -1));

            textField3.setBackground(new java.awt.Color(255, 255, 255));
            textField3.setForeground(new java.awt.Color(130, 130, 130));
            jPanel1.add(textField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 200, 250, -1));

            buttonGradient1.setText("Ubah");
            buttonGradient1.setColor1(new java.awt.Color(195, 36, 35));
            buttonGradient1.setColor2(new java.awt.Color(7, 65, 115));
            jPanel1.add(buttonGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 370, 117, 30));

            buttonGradient2.setText("Simpan");
            buttonGradient2.setColor1(new java.awt.Color(93, 7, 130));
            buttonGradient2.setColor2(new java.awt.Color(7, 65, 115));
            jPanel1.add(buttonGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 370, 117, 30));

            textField4.setBackground(new java.awt.Color(255, 255, 255));
            textField4.setForeground(new java.awt.Color(130, 130, 130));
            jPanel1.add(textField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 70, 250, -1));

            textField5.setBackground(new java.awt.Color(255, 255, 255));
            textField5.setForeground(new java.awt.Color(130, 130, 130));
            jPanel1.add(textField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 130, 250, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_K().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient buttonGradient1;
      private swing.ButtonGradient buttonGradient2;
      private javax.swing.JPanel jPanel1;
      private textfield.TextField textField1;
      private textfield.TextField textField3;
      private textfield.TextField textField4;
      private textfield.TextField textField5;
      // End of variables declaration//GEN-END:variables
}
