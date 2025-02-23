package com.admin.view;

import com.admin.controler.MasterDataPenyakit;
import com.admin.controler.MasterDataRelasi;
import com.admin.controler.MasterDataUsers;
import com.model.Model_Card;
import com.model.StatusType;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class Form_D extends javax.swing.JPanel {

    public Form_D() {
            initComponents();
            MasterDataUsers data = new MasterDataUsers();
            data.tampilDataUsers(tabel_rule);

            spTable.setVerticalScrollBar(new ScrollBar());
            spTable.getVerticalScrollBar().setBackground(Color.WHITE);
            spTable.getViewport().setBackground(Color.WHITE);
            JPanel p = new JPanel();
            p.setBackground(Color.WHITE);
            spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
          
            MasterDataRelasi dataRelasi = new MasterDataRelasi();
            
            dataRelasi.TampilKodePenyakit(cbb_kodepenyakit);
            dataRelasi.TampilNamaPenyakit(cbb_kodepenyakit, txt_namapenyakit);   
    }

    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_rule = new com.swing.Table();
            btn_hapus = new swing.ButtonGradient();
            btn_tambah = new swing.ButtonGradient();
            txt_namapenyakit = new textfield.TextField();
            cbb_kodepenyakit = new combobox.Combobox();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Rule / Aturan");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, -1, -1));

            spTable.setBorder(null);

            tabel_rule.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tabel_rule);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 870, 440));

            btn_hapus.setText("Hapus");
            btn_hapus.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapusActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 110, 30));

            btn_tambah.setText("Tambah");
            btn_tambah.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 30));

            txt_namapenyakit.setEditable(false);
            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapenyakit.setLabelText("Nama Penyakit");
            panelBorder.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 150, 50));

            cbb_kodepenyakit.setForeground(new java.awt.Color(97, 103, 122));
            cbb_kodepenyakit.setLabeText("Kode penyakit");
            cbb_kodepenyakit.setLightWeightPopupEnabled(false);
            cbb_kodepenyakit.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cbb_kodepenyakitItemStateChanged(evt);
                  }
            });
            cbb_kodepenyakit.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        cbb_kodepenyakitActionPerformed(evt);
                  }
            });
            panelBorder.add(cbb_kodepenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 40, 130, 50));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void cbb_kodepenyakitItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_kodepenyakitItemStateChanged
                  MasterDataRelasi dataRelasi = new MasterDataRelasi();
                  Form_B data = new Form_B();
                  JTable tabel = data.tabel_gejala;
                  dataRelasi.pilihKodePenyakit(tabel , tabel_rule, cbb_kodepenyakit, txt_namapenyakit);
                  dataRelasi.TampilNamaPenyakit(cbb_kodepenyakit, txt_namapenyakit);
      }//GEN-LAST:event_cbb_kodepenyakitItemStateChanged

      private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
            MasterDataRelasi dataRelasi = new MasterDataRelasi();
            Form_I form = new Form_I();
            dataRelasi.TambahDataRelasi(cbb_kodepenyakit, form.txt_kode_penyakit, form.txt_namapenyakit, form.tbl_rule);
            form.setVisible(true);
      }//GEN-LAST:event_btn_tambahActionPerformed

      private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
            MasterDataRelasi dataRelasi = new MasterDataRelasi();
            Form_I form = new Form_I();
            dataRelasi.deleteRelasi(cbb_kodepenyakit.getSelectedItem().toString());
      }//GEN-LAST:event_btn_hapusActionPerformed

      private void cbb_kodepenyakitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbb_kodepenyakitActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_cbb_kodepenyakitActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_hapus;
      private swing.ButtonGradient btn_tambah;
      public combobox.Combobox cbb_kodepenyakit;
      private javax.swing.JLabel jLabel1;
      private com.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      private com.swing.Table tabel_rule;
      public textfield.TextField txt_namapenyakit;
      // End of variables declaration//GEN-END:variables
}
