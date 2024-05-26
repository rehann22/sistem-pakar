package com.user.view;

import com.formdev.flatlaf.FlatLightLaf;
import com.user.controler.HasilKonsulltasi;
import com.user.controler.SessionUser;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import koneksi.db.ConnectionDb;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Form_E extends javax.swing.JFrame {
      String logId = SessionUser.log_idPengguna();
      String logName = SessionUser.log_nama();

      public Form_E() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            txt_obat = new textfield.TextField();
            txt_namapenyakit = new textfield.TextField();
            textAreaScroll1 = new textarea.TextAreaScroll();
            txt_deskripsi = new textarea.TextArea();
            btn_cetak = new swing.ButtonGradient();
            txt_namapeternak = new textfield.TextField();
            textAreaScroll3 = new textarea.TextAreaScroll();
            txt_pencegahan = new textarea.TextArea();
            textAreaScroll4 = new textarea.TextAreaScroll();
            txt_gejala = new textarea.TextArea();
            txt_tanggal = new textfield.TextField();
            jLabel2 = new javax.swing.JLabel();
            txt_kodekonsultasi = new textfield.TextField();
            jLabel1 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();
            jLabel4 = new javax.swing.JLabel();
            jLabel5 = new javax.swing.JLabel();
            jLabel6 = new javax.swing.JLabel();
            jLabel7 = new javax.swing.JLabel();
            jLabel8 = new javax.swing.JLabel();
            jLabel9 = new javax.swing.JLabel();
            jLabel10 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_obat.setEditable(false);
            txt_obat.setBackground(new java.awt.Color(255, 255, 255));
            txt_obat.setForeground(new java.awt.Color(97, 103, 122));
            txt_obat.setLabelText("");
            txt_obat.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 405, 370, 50));

            txt_namapenyakit.setEditable(false);
            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapenyakit.setLabelText("");
            txt_namapenyakit.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 370, -1));

            textAreaScroll1.setLabelText("");
            textAreaScroll1.setLineColor(new java.awt.Color(0, 255, 25));

            txt_deskripsi.setEditable(false);
            txt_deskripsi.setBackground(new java.awt.Color(255, 255, 255));
            txt_deskripsi.setColumns(20);
            txt_deskripsi.setForeground(new java.awt.Color(97, 103, 122));
            txt_deskripsi.setRows(5);
            textAreaScroll1.setViewportView(txt_deskripsi);

            jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 160, 370, 90));

            btn_cetak.setText("Cetak");
            btn_cetak.setColor1(new java.awt.Color(40, 26, 220));
            btn_cetak.setColor2(new java.awt.Color(0, 255, 25));
            btn_cetak.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_cetakActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 530, 320, 30));

            txt_namapeternak.setEditable(false);
            txt_namapeternak.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapeternak.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapeternak.setLabelText("");
            txt_namapeternak.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_namapeternak, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 370, 40));

            textAreaScroll3.setLabelText("");
            textAreaScroll3.setLineColor(new java.awt.Color(0, 255, 25));

            txt_pencegahan.setEditable(false);
            txt_pencegahan.setBackground(new java.awt.Color(255, 255, 255));
            txt_pencegahan.setColumns(20);
            txt_pencegahan.setForeground(new java.awt.Color(97, 103, 122));
            txt_pencegahan.setRows(5);
            textAreaScroll3.setViewportView(txt_pencegahan);

            jPanel1.add(textAreaScroll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 320, 370, 80));

            textAreaScroll4.setLabelText("");
            textAreaScroll4.setLineColor(new java.awt.Color(0, 255, 25));

            txt_gejala.setEditable(false);
            txt_gejala.setBackground(new java.awt.Color(255, 255, 255));
            txt_gejala.setColumns(20);
            txt_gejala.setForeground(new java.awt.Color(97, 103, 122));
            txt_gejala.setRows(5);
            textAreaScroll4.setViewportView(txt_gejala);

            jPanel1.add(textAreaScroll4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 240, 370, 80));

            txt_tanggal.setBackground(new java.awt.Color(255, 255, 255));
            txt_tanggal.setForeground(new java.awt.Color(97, 103, 122));
            txt_tanggal.setLabelText("");
            txt_tanggal.setLineColor(new java.awt.Color(0, 255, 25));
            txt_tanggal.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txt_tanggalActionPerformed(evt);
                  }
            });
            jPanel1.add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 460, 370, 40));

            jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Detail Diagnosa Sistem");
            jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, 610, 30));

            txt_kodekonsultasi.setEditable(false);
            txt_kodekonsultasi.setBackground(new java.awt.Color(255, 255, 255));
            txt_kodekonsultasi.setForeground(new java.awt.Color(97, 103, 122));
            txt_kodekonsultasi.setLabelText("");
            txt_kodekonsultasi.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_kodekonsultasi, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 40, 370, 40));

            jLabel1.setForeground(new java.awt.Color(97, 103, 122));
            jLabel1.setText("Konsultasi");
            jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 480, 90, 30));

            jLabel3.setForeground(new java.awt.Color(97, 103, 122));
            jLabel3.setText("Id Konsultasi");
            jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 90, 30));

            jLabel4.setForeground(new java.awt.Color(97, 103, 122));
            jLabel4.setText("Nama Peternak");
            jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, 90, 30));

            jLabel5.setForeground(new java.awt.Color(97, 103, 122));
            jLabel5.setText("Nama Penyakit");
            jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 130, 90, 30));

            jLabel6.setForeground(new java.awt.Color(97, 103, 122));
            jLabel6.setText("Deskripsi");
            jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 180, 90, 30));

            jLabel7.setForeground(new java.awt.Color(97, 103, 122));
            jLabel7.setText("Gejala");
            jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 250, 90, 30));

            jLabel8.setForeground(new java.awt.Color(97, 103, 122));
            jLabel8.setText("Pencegahan");
            jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 330, 90, 30));

            jLabel9.setForeground(new java.awt.Color(97, 103, 122));
            jLabel9.setText("Obat");
            jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 420, 90, 30));

            jLabel10.setForeground(new java.awt.Color(97, 103, 122));
            jLabel10.setText("Tanggal ");
            jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 470, 90, 20));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 610, 590));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
            try {
                  // Mendapatkan path menuju file .jasper
                  InputStream reportStream = getClass().getResourceAsStream("/com/user/report/DetailPenyakit.jasper");

                  Connection conn = new ConnectionDb().connect();
                  
                  // Mendefinisikan parameter
                  HashMap <String, Object> param = new HashMap<> ();
                  
                  param.put("nama_user", logName);
                  param.put("nama_peny", txt_namapenyakit.getText());
                  
                  JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);
                  JasperViewer.viewReport(jp, false);
            } catch (Exception e) {
                  JOptionPane.showMessageDialog(rootPane, e);
                  e.printStackTrace();
            }
      }//GEN-LAST:event_btn_cetakActionPerformed

      private void txt_tanggalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_tanggalActionPerformed
            // TODO add your handling code here:
      }//GEN-LAST:event_txt_tanggalActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_E().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_cetak;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel10;
      private javax.swing.JLabel jLabel2;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JLabel jLabel4;
      private javax.swing.JLabel jLabel5;
      private javax.swing.JLabel jLabel6;
      private javax.swing.JLabel jLabel7;
      private javax.swing.JLabel jLabel8;
      private javax.swing.JLabel jLabel9;
      private javax.swing.JPanel jPanel1;
      private textarea.TextAreaScroll textAreaScroll1;
      private textarea.TextAreaScroll textAreaScroll3;
      private textarea.TextAreaScroll textAreaScroll4;
      public textarea.TextArea txt_deskripsi;
      public textarea.TextArea txt_gejala;
      public textfield.TextField txt_kodekonsultasi;
      public textfield.TextField txt_namapenyakit;
      public textfield.TextField txt_namapeternak;
      public textfield.TextField txt_obat;
      public textarea.TextArea txt_pencegahan;
      public textfield.TextField txt_tanggal;
      // End of variables declaration//GEN-END:variables
}
