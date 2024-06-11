package com.admin.view;

import com.admin.controler.MasterDataGejala;
import com.formdev.flatlaf.FlatLightLaf;

public class Form_H extends javax.swing.JFrame {

      public Form_H() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            txt_gejala = new textfield.TextField();
            txt_kodegejala = new textfield.TextField();
            btn_ubah = new swing.ButtonGradient();
            btn_simpan = new swing.ButtonGradient();
            cbb_organ = new combobox.Combobox();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_gejala.setBackground(new java.awt.Color(255, 255, 255));
            txt_gejala.setForeground(new java.awt.Color(97, 103, 122));
            txt_gejala.setLabelText("Gejala");
            jPanel1.add(txt_gejala, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 240, 250, -1));

            txt_kodegejala.setEditable(false);
            txt_kodegejala.setBackground(new java.awt.Color(255, 255, 255));
            txt_kodegejala.setForeground(new java.awt.Color(97, 103, 122));
            txt_kodegejala.setLabelText("Kode Gejala");
            jPanel1.add(txt_kodegejala, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, 250, -1));

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 350, 120, 30));

            btn_simpan.setText("Simpan");
            btn_simpan.setColor1(new java.awt.Color(35, 20, 226));
            btn_simpan.setColor2(new java.awt.Color(209, 18, 235));
            btn_simpan.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_simpanActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_simpan, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 350, 120, 30));

            cbb_organ.setForeground(new java.awt.Color(97, 103, 122));
            cbb_organ.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Insang", "Kepala", "Kulit", "Organ Dalam", "Punggung ", "Sirip", "Sisik", "Tubuh" }));
            cbb_organ.setSelectedIndex(-1);
            cbb_organ.setLabeText("Organ");
            jPanel1.add(cbb_organ, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 160, 240, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 390, 500));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
            MasterDataGejala data = new MasterDataGejala();
            Form_B form = new Form_B();
            data.addDataGejala(form.tabel_gejala,txt_kodegejala, cbb_organ, txt_gejala);
      }//GEN-LAST:event_btn_simpanActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
            MasterDataGejala data = new MasterDataGejala();
            Form_B form = new Form_B();
            data.editDataGejala(form.tabel_gejala, txt_kodegejala, cbb_organ, txt_gejala);
      }//GEN-LAST:event_btn_ubahActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_H().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_simpan;
      private swing.ButtonGradient btn_ubah;
      public combobox.Combobox cbb_organ;
      private javax.swing.JPanel jPanel1;
      public textfield.TextField txt_gejala;
      public textfield.TextField txt_kodegejala;
      // End of variables declaration//GEN-END:variables
}
