package com.admin.view;

import com.admin.controler.MasterDataPenyakit;
import com.admin.controler.MasterDataUsers;
import com.admin.controler.TabelPertanyaan;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Form_E extends javax.swing.JPanel {

    public Form_E() {
          initComponents();
          spTable.setVerticalScrollBar(new ScrollBar());
          spTable.getVerticalScrollBar().setBackground(Color.WHITE);
          spTable.getViewport().setBackground(Color.WHITE);
          JPanel p = new JPanel();
          p.setBackground(Color.WHITE);
          spTable.setCorner(JScrollPane.UPPER_RIGHT_CORNER, p);
          
          TabelPertanyaan t = new TabelPertanyaan();
          t.TampilDataPertanyaan(tabel_pertanyaan);
    }

    @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            panelBorder = new com.raven.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_pertanyaan = new com.raven.swing.Table();
            buttonGradient1 = new swing.ButtonGradient();
            buttonGradient3 = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(127, 127, 127));
            jLabel1.setText("List Pertanyaan");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

            spTable.setBorder(null);

            tabel_pertanyaan.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tabel_pertanyaan);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 480));

            buttonGradient1.setText("Diagnosa");
            panelBorder.add(buttonGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 140, 30));

            buttonGradient3.setText("Refresh Checkbox");
            panelBorder.add(buttonGradient3, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 140, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient buttonGradient1;
      private swing.ButtonGradient buttonGradient3;
      private javax.swing.JLabel jLabel1;
      private com.raven.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      private com.raven.swing.Table tabel_pertanyaan;
      // End of variables declaration//GEN-END:variables
}
