package com.admin.view;

import com.admin.controler.HasilKonsulltasi;
import com.admin.controler.MasterDataPenyakit;
import com.admin.controler.MasterDataUsers;
import com.admin.controler.TabelPertanyaan;
import com.model.Model_Card;
import com.model.StatusType;
import com.swing.ScrollBar;
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

            panelBorder = new com.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_pertanyaan = new com.swing.Table();
            btn_diagnosa = new swing.ButtonGradient();
            btn_refresh = new swing.ButtonGradient();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
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
            tabel_pertanyaan.setSelectionBackground(new java.awt.Color(209, 18, 235));
            spTable.setViewportView(tabel_pertanyaan);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 480));

            btn_diagnosa.setText("Diagnosa");
            btn_diagnosa.setColor1(new java.awt.Color(35, 20, 226));
            btn_diagnosa.setColor2(new java.awt.Color(209, 18, 235));
            btn_diagnosa.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_diagnosaActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_diagnosa, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 30, 140, 30));

            btn_refresh.setText("Refresh Checkbox");
            btn_refresh.setColor1(new java.awt.Color(35, 20, 226));
            btn_refresh.setColor2(new java.awt.Color(209, 18, 235));
            btn_refresh.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_refreshActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_refresh, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 30, 140, 30));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_diagnosaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_diagnosaActionPerformed
            TabelPertanyaan pertanyaan = new TabelPertanyaan();
            Form_J form = new Form_J();
            HasilKonsulltasi data = new HasilKonsulltasi();
            form.txt_kode.setText(data.autoNumber());
                  int selectedCount = 0;
                  for (int i = 0; i < tabel_pertanyaan.getRowCount(); i++) {
                      Boolean isSelected = (Boolean)tabel_pertanyaan.getValueAt(i, 3); // Asumsi kolom ke-3 adalah kolom centang
                      if (isSelected != null && isSelected) {
                          selectedCount++;
                         
                      }
                  }
                  String kodeP ;
                  kodeP = form.txt_kodepenyakit.getText();
                  pertanyaan.DiagnosaPenyakit(form,selectedCount,tabel_pertanyaan,form.txt_kodepenyakit, form.txt_namapenyakit, form.txt_pencegahan, form.txt_obat, form.txt_kode);
                  if (selectedCount >= 2 && !form.txt_kodepenyakit.getText().isEmpty()) {
                        form.setVisible(true);
                  }
            System.out.println("Total Ceklis " + selectedCount);
            System.out.println(kodeP);
      }//GEN-LAST:event_btn_diagnosaActionPerformed

      private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
            TabelPertanyaan data = new TabelPertanyaan();
            data.refreshCheckbox(tabel_pertanyaan);
      }//GEN-LAST:event_btn_refreshActionPerformed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_diagnosa;
      private swing.ButtonGradient btn_refresh;
      private javax.swing.JLabel jLabel1;
      private com.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      private com.swing.Table tabel_pertanyaan;
      // End of variables declaration//GEN-END:variables
}
