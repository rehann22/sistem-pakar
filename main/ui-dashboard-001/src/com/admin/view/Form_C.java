package com.admin.view;

import com.admin.controler.MasterDataUsers;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_C extends javax.swing.JPanel {

    public Form_C() {
            initComponents();
            MasterDataUsers data = new MasterDataUsers();
            data.tampilDataUsers(tabel_pengguna);

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
            tabel_pengguna = new com.raven.swing.Table();
            btn_refresh = new swing.ButtonGradient();
            btn_ubah = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Data Pengguna");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

            spTable.setBorder(null);

            tabel_pengguna.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tabel_pengguna);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 480));

            btn_refresh.setText("Refresh");
            btn_refresh.setColor1(new java.awt.Color(35, 20, 226));
            btn_refresh.setColor2(new java.awt.Color(209, 18, 235));
            btn_refresh.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_refreshActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 30, 110, 30));

            btn_ubah.setText("Ubah");
            btn_ubah.setColor1(new java.awt.Color(35, 20, 226));
            btn_ubah.setColor2(new java.awt.Color(209, 18, 235));
            btn_ubah.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_ubahActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_ubah, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_ubahActionPerformed
            MasterDataUsers data = new MasterDataUsers();
            Form_K form = new Form_K();
            data.FormDataPengguna(tabel_pengguna, form.txt_id, form.txt_nama, form.txt_username, form.txt_password);
            form.setVisible(true);
      }//GEN-LAST:event_btn_ubahActionPerformed

      private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
            MasterDataUsers data = new MasterDataUsers();
            data.tampilDataUsers(tabel_pengguna);
      }//GEN-LAST:event_btn_refreshActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_refresh;
      private swing.ButtonGradient btn_ubah;
      private javax.swing.JLabel jLabel1;
      private com.raven.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      public com.raven.swing.Table tabel_pengguna;
      // End of variables declaration//GEN-END:variables
}
