package com.admin.view;

import com.admin.controler.MasterDataRelasi;
import com.formdev.flatlaf.FlatLightLaf;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_I extends javax.swing.JFrame {

      public Form_I() {
          initComponents();
          spTable.setVerticalScrollBar(new ScrollBar());
          spTable.getVerticalScrollBar().setBackground(Color.WHITE);
          spTable.getViewport().setBackground(Color.WHITE);
          JPanel p = new JPanel();
          p.setBackground(Color.WHITE);
          spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            txt_namapenyakit = new textfield.TextField();
            btn_simpan = new swing.ButtonGradient();
            txt_kode_penyakit = new textfield.TextField();
            spTable = new javax.swing.JScrollPane();
            tbl_rule = new com.raven.swing.Table();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_namapenyakit.setEditable(false);
            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapenyakit.setLabelText("Nama Penyakit");
            jPanel1.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, 170, -1));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
            btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(97, 440, 180, 30));

            txt_kode_penyakit.setEditable(false);
            txt_kode_penyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_kode_penyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_kode_penyakit.setLabelText("Kode Penyakit");
            jPanel1.add(txt_kode_penyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 80, -1));

            spTable.setBorder(null);

            tbl_rule.setModel(new javax.swing.table.DefaultTableModel(
                  new Object [][] {

                  },
                  new String [] {
                        "Name", "Email", "User Type", "Joined", "Status"
                  }
            ) {
                  boolean[] canEdit = new boolean [] {
                        false, false, false, false, false
                  };

                  public boolean isCellEditable(int rowIndex, int columnIndex) {
                        return canEdit [columnIndex];
                  }
            });
            spTable.setViewportView(tbl_rule);

            jPanel1.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 330, 350));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
            MasterDataRelasi dataRelasi = new MasterDataRelasi();
            dataRelasi.handleDataRelasi(tbl_rule, txt_kode_penyakit);  
      }//GEN-LAST:event_btn_simpanActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_I().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private javax.swing.JPanel jPanel1;
      private javax.swing.JScrollPane spTable;
      public com.raven.swing.Table tbl_rule;
      public textfield.TextField txt_kode_penyakit;
      public textfield.TextField txt_namapenyakit;
      // End of variables declaration//GEN-END:variables
}
