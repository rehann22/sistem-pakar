package com.admin.view;

import com.admin.controler.MasterDataKonsultasiUsers;
import com.admin.controler.MasterDataPenyakit;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_F extends javax.swing.JPanel {

    public Form_F() {
          initComponents();
          MasterDataKonsultasiUsers data = new MasterDataKonsultasiUsers();
          data.tampilDataKonsultasiUsers(tabel_laporan);
          data.TampilIdUsers(cbb_filter);
          
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

            panelBorder = new com.raven.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_laporan = new com.raven.swing.Table();
            btn_cetak = new swing.ButtonGradient();
            cbb_filter = new combobox.Combobox();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(127, 127, 127));
            jLabel1.setText("Data Konsultasi User");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

            spTable.setBorder(null);

            tabel_laporan.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tabel_laporan);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, 870, 470));

            btn_cetak.setText("Cetak");
            btn_cetak.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_cetakActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 30));

            cbb_filter.setForeground(new java.awt.Color(120, 120, 120));
            cbb_filter.setLabeText("Filter");
            cbb_filter.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cbb_filterItemStateChanged(evt);
                  }
            });
            panelBorder.add(cbb_filter, new org.netbeans.lib.awtextra.AbsoluteConstraints(625, 20, 130, -1));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void cbb_filterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbb_filterItemStateChanged
            MasterDataKonsultasiUsers data = new MasterDataKonsultasiUsers();
            data.pilihIdUser(tabel_laporan, cbb_filter);
      }//GEN-LAST:event_cbb_filterItemStateChanged

      private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
            Form_L form = new Form_L();
            form.setVisible(true);
      }//GEN-LAST:event_btn_cetakActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_cetak;
      public combobox.Combobox cbb_filter;
      private javax.swing.JLabel jLabel1;
      private com.raven.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      public com.raven.swing.Table tabel_laporan;
      // End of variables declaration//GEN-END:variables
}
