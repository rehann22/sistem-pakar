package com.user.view;

import com.raven.swing.ScrollBar;
import com.user.controler.SessionUser;
import com.user.controler.TabelHasilKonsultasi;
import java.awt.Color;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import koneksi.db.ConnectionDb;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Form_C extends javax.swing.JPanel {
      String logId = SessionUser.log_idPengguna();
      String logName = SessionUser.log_nama();
      
      public Form_C() {
              initComponents();
              TabelHasilKonsultasi data = new TabelHasilKonsultasi();
              data.showTable(logId, tabel_riwayat);

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

            panelBorder = new com.raven.swing.PanelBorder();
            jLabel1 = new javax.swing.JLabel();
            spTable = new javax.swing.JScrollPane();
            tabel_riwayat = new com.raven.swing.Table();
            btn_detail = new swing.ButtonGradient();
            btn_cetak = new swing.ButtonGradient();
            txt_cari = new textfield.TextField();
            jLabel4 = new javax.swing.JLabel();

            setBackground(new java.awt.Color(242, 242, 242));
            setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            panelBorder.setBackground(new java.awt.Color(255, 255, 255));
            panelBorder.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Riwayat Diagnosa Ikan");
            panelBorder.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, -1, -1));

            spTable.setBorder(null);

            tabel_riwayat.setModel(new javax.swing.table.DefaultTableModel(
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
            spTable.setViewportView(tabel_riwayat);

            panelBorder.add(spTable, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 70, 870, 450));

            btn_detail.setText("Detail");
            btn_detail.setColor1(new java.awt.Color(40, 26, 220));
            btn_detail.setColor2(new java.awt.Color(0, 255, 25));
            btn_detail.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_detailActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_detail, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 30, 110, 30));

            btn_cetak.setText("Cetak");
            btn_cetak.setColor1(new java.awt.Color(40, 26, 220));
            btn_cetak.setColor2(new java.awt.Color(0, 255, 25));
            btn_cetak.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_cetakActionPerformed(evt);
                  }
            });
            panelBorder.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 30, 110, 30));

            txt_cari.setBackground(new java.awt.Color(255, 255, 255));
            txt_cari.setForeground(new java.awt.Color(97, 103, 122));
            txt_cari.setLabelText("Cari Kode Penyakit");
            txt_cari.setLineColor(new java.awt.Color(0, 255, 25));
            txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
                  public void keyPressed(java.awt.event.KeyEvent evt) {
                        txt_cariKeyPressed(evt);
                  }
            });
            panelBorder.add(txt_cari, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 10, 120, -1));

            jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/raven/icon/refresh (1).png"))); // NOI18N
            jLabel4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
            jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
                  public void mouseClicked(java.awt.event.MouseEvent evt) {
                        jLabel4MouseClicked(evt);
                  }
            });
            panelBorder.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 520, 30, 40));

            add(panelBorder, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 915, 570));
      }// </editor-fold>//GEN-END:initComponents

      private void btn_detailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_detailActionPerformed
            TabelHasilKonsultasi data = new TabelHasilKonsultasi();
            Form_E form = new Form_E();
            form.txt_namapeternak.setText(logName);
            data.DetailHasilKonsultasi(tabel_riwayat, form.txt_namapeternak, form.txt_namapenyakit, form.txt_deskripsi, form.txt_gejala, form.txt_pencegahan, form.txt_obat, form.txt_tanggal);
            form.setVisible(true);
      }//GEN-LAST:event_btn_detailActionPerformed

      private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
            try {   
                  // Mendapatkan path menuju file .jasper
                  InputStream reportStream = getClass().getResourceAsStream("/com/user/report/HasilDiagnosa.jasper");

                  Connection conn = new ConnectionDb().connect();
                  
                  // Mendefinisikan parameter
                  HashMap <String, Object> param = new HashMap<> ();
                  param.put("id_user", logId);
                  param.put("nama_user", logName);
                  
                  
                  String kodePenyakit = txt_cari.getText();
                  if (kodePenyakit.isEmpty()) {
                        param.put("kode_penyakit", null); // Set nilai parameter menjadi null
                        JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);
                        JasperViewer.viewReport(jp, false);
                  } else {
                        param.put("kode_penyakit", kodePenyakit);
                        JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);
                        System.out.println("Nilai kode_penyakit: " + kodePenyakit);
                        JasperViewer.viewReport(jp, false);
                  }
            } catch (Exception e) {
                  e.printStackTrace();  
            }
//                  Mengisi laporan dengan data
//                  JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);
//
//                  Menampilkan laporan
//                  JasperViewer.viewReport(jp, false); // false untuk menutup aplikasi tanpa menutup laporan
      }//GEN-LAST:event_btn_cetakActionPerformed

      private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
            TabelHasilKonsultasi data = new TabelHasilKonsultasi();
            data.showTable(logId, tabel_riwayat);
      }//GEN-LAST:event_jLabel4MouseClicked

      private void txt_cariKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyPressed
            int kode = evt.getKeyCode();
            if (kode == evt.VK_ENTER) {
                  TabelHasilKonsultasi data = new TabelHasilKonsultasi();
                  data.CariIdPenyakit(txt_cari.getText(), tabel_riwayat, logId);
            }
      }//GEN-LAST:event_txt_cariKeyPressed


      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_cetak;
      private swing.ButtonGradient btn_detail;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel4;
      private com.raven.swing.PanelBorder panelBorder;
      private javax.swing.JScrollPane spTable;
      public com.raven.swing.Table tabel_riwayat;
      private textfield.TextField txt_cari;
      // End of variables declaration//GEN-END:variables
}
