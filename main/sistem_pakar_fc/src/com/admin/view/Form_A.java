package com.admin.view;

import com.admin.controler.MasterDataPenyakit;
import com.swing.ScrollBar;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_A extends javax.swing.JPanel {

    public Form_A() {
            initComponents();            
            MasterDataPenyakit data = new MasterDataPenyakit();
            data.showTable(tabel_penyakit);
            
            //  add row table
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

            panelBorder = new com.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_penyakit = new com.swing.Table();
            btn_tambah = new swing.ButtonGradient();
            btn_hapus = new swing.ButtonGradient();
            btn_ubah = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Data Penyakit");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

            spTable.setBorder(null);

            tabel_penyakit.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tabel_penyakit);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 450));

            btn_tambah.setText("Tambah");
            btn_tambah.setColor1(new java.awt.Color(35, 20, 226));
            btn_tambah.setColor2(new java.awt.Color(209, 18, 235));
            btn_tambah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_tambahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_tambah, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 30, 110, 30));

            btn_hapus.setText("Hapus");
            btn_hapus.setColor1(new java.awt.Color(35, 20, 226));
            btn_hapus.setColor2(new java.awt.Color(209, 18, 235));
            btn_hapus.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_hapusActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_hapus, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 30));

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 110, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
            MasterDataPenyakit data = new MasterDataPenyakit();
            Form_G form = new Form_G();
            form.setVisible(true);
            data.clearForm(form.txt_kodepenyakit, form.txt_namapenyakit, form.txt_deskripsi, form.txt_gejala, form.txt_pencegahan, form.txt_obat);
            data.autoNumber(form.txt_kodepenyakit);
            data.showTable(tabel_penyakit);
      }//GEN-LAST:event_btn_tambahActionPerformed

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
            MasterDataPenyakit data = new MasterDataPenyakit();
            Form_G form = new Form_G();
            data.tampilFormEditPenyakit(tabel_penyakit, form.txt_kodepenyakit, form.txt_namapenyakit, form.txt_deskripsi, form.txt_gejala, form.txt_pencegahan, form.txt_obat);
            form.setVisible(true);       
      }//GEN-LAST:event_btn_ubahActionPerformed

      private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
            MasterDataPenyakit data = new MasterDataPenyakit();
            Form_G form = new Form_G();  
            data.hapusPenyakit(tabel_penyakit, form.txt_kodepenyakit);
      }//GEN-LAST:event_btn_hapusActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_hapus;
      private swing.ButtonGradient btn_tambah;
      private swing.ButtonGradient btn_ubah;
      private javax.swing.JLabel jLabel1;
      private com.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      public com.swing.Table tabel_penyakit;
      // End of variables declaration//GEN-END:variables
}
