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

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            txt_obat.setEditable(false);
            txt_obat.setBackground(new java.awt.Color(255, 255, 255));
            txt_obat.setForeground(new java.awt.Color(97, 103, 122));
            txt_obat.setLabelText("Kami Merekomendasikan Obat");
            txt_obat.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_obat, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 400, 360, -1));

            txt_namapenyakit.setEditable(false);
            txt_namapenyakit.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapenyakit.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapenyakit.setLabelText("Ikan Terkena Penyakit");
            txt_namapenyakit.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_namapenyakit, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 110, 360, -1));

            textAreaScroll1.setLabelText("Deskripsi");
            textAreaScroll1.setLineColor(new java.awt.Color(0, 255, 25));

            txt_deskripsi.setEditable(false);
            txt_deskripsi.setBackground(new java.awt.Color(255, 255, 255));
            txt_deskripsi.setColumns(20);
            txt_deskripsi.setForeground(new java.awt.Color(97, 103, 122));
            txt_deskripsi.setRows(5);
            textAreaScroll1.setViewportView(txt_deskripsi);

            jPanel1.add(textAreaScroll1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 160, 360, 70));

            btn_cetak.setText("Cetak");
            btn_cetak.setColor1(new java.awt.Color(40, 26, 220));
            btn_cetak.setColor2(new java.awt.Color(0, 255, 25));
            btn_cetak.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_cetakActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 530, 280, 30));

            txt_namapeternak.setBackground(new java.awt.Color(255, 255, 255));
            txt_namapeternak.setForeground(new java.awt.Color(97, 103, 122));
            txt_namapeternak.setLabelText("Nama Peternak");
            txt_namapeternak.setLineColor(new java.awt.Color(0, 255, 25));
            jPanel1.add(txt_namapeternak, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 50, 360, -1));

            textAreaScroll3.setLabelText("Pencegahan");
            textAreaScroll3.setLineColor(new java.awt.Color(0, 255, 25));

            txt_pencegahan.setEditable(false);
            txt_pencegahan.setBackground(new java.awt.Color(255, 255, 255));
            txt_pencegahan.setColumns(20);
            txt_pencegahan.setForeground(new java.awt.Color(97, 103, 122));
            txt_pencegahan.setRows(5);
            textAreaScroll3.setViewportView(txt_pencegahan);

            jPanel1.add(textAreaScroll3, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 320, 360, 70));

            textAreaScroll4.setLabelText("Gejala");
            textAreaScroll4.setLineColor(new java.awt.Color(0, 255, 25));

            txt_gejala.setEditable(false);
            txt_gejala.setBackground(new java.awt.Color(255, 255, 255));
            txt_gejala.setColumns(20);
            txt_gejala.setForeground(new java.awt.Color(97, 103, 122));
            txt_gejala.setRows(5);
            textAreaScroll4.setViewportView(txt_gejala);

            jPanel1.add(textAreaScroll4, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 240, 360, 70));

            txt_tanggal.setEditable(false);
            txt_tanggal.setBackground(new java.awt.Color(255, 255, 255));
            txt_tanggal.setForeground(new java.awt.Color(97, 103, 122));
            txt_tanggal.setLabelText("Tanggal Diagnosa");
            txt_tanggal.setLineColor(new java.awt.Color(0, 255, 25));
            txt_tanggal.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        txt_tanggalActionPerformed(evt);
                  }
            });
            jPanel1.add(txt_tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 460, 360, -1));

            jLabel2.setFont(new java.awt.Font("Segoe UI Semibold", 0, 18)); // NOI18N
            jLabel2.setForeground(new java.awt.Color(97, 103, 122));
            jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            jLabel2.setText("Detail Hasil Diagnosa");
            jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 40));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 490, 590));

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
      private javax.swing.JLabel jLabel2;
      private javax.swing.JPanel jPanel1;
      private textarea.TextAreaScroll textAreaScroll1;
      private textarea.TextAreaScroll textAreaScroll3;
      private textarea.TextAreaScroll textAreaScroll4;
      public textarea.TextArea txt_deskripsi;
      public textarea.TextArea txt_gejala;
      public textfield.TextField txt_namapenyakit;
      public textfield.TextField txt_namapeternak;
      public textfield.TextField txt_obat;
      public textarea.TextArea txt_pencegahan;
      public textfield.TextField txt_tanggal;
      // End of variables declaration//GEN-END:variables
}
