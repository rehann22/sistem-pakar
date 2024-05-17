package com.admin.view;

import com.admin.controler.MasterDataPenyakit;
import com.admin.controler.MasterDataRelasi;
import com.admin.controler.MasterDataUsers;
import com.raven.model.Model_Card;
import com.raven.model.StatusType;
import com.raven.swing.ScrollBar;
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

            panelBorder = new com.raven.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_rule = new com.raven.swing.Table();
            buttonGradient1 = new swing.ButtonGradient();
            buttonGradient2 = new swing.ButtonGradient();
            txt_namapenyakit = new textfield.TextField();
            cbb_kodepenyakit = new combobox.Combobox();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(127, 127, 127));
            jLabel1.setText("Rule / Aturan");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, -1, -1));

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

            buttonGradient1.setText("Tambah");
            panelBorder.add(buttonGradient1, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 70, 110, 30));

            buttonGradient2.setText("Hapus");
            panelBorder.add(buttonGradient2, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 30, 110, 30));

            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(120, 120, 120));
            txt_namapenyakit.setLabelText("Nama Penyakit");
            panelBorder.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 150, 50));

            cbb_kodepenyakit.setForeground(new java.awt.Color(120, 120, 120));
            cbb_kodepenyakit.setLabeText("Kode penyakit");
            cbb_kodepenyakit.setLightWeightPopupEnabled(false);
            cbb_kodepenyakit.addItemListener(new java.awt.event.ItemListener() {
                  public void itemStateChanged(java.awt.event.ItemEvent evt) {
                        cbb_kodepenyakitItemStateChanged(evt);
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


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient buttonGradient1;
      private swing.ButtonGradient buttonGradient2;
      private combobox.Combobox cbb_kodepenyakit;
      private javax.swing.JLabel jLabel1;
      private com.raven.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      private com.raven.swing.Table tabel_rule;
      private textfield.TextField txt_namapenyakit;
      // End of variables declaration//GEN-END:variables
}
