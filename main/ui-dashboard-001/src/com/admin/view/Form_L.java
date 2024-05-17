package com.admin.view;

import com.formdev.flatlaf.FlatLightLaf;
import java.io.InputStream;
import java.sql.Connection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import javax.swing.JOptionPane;
import koneksi.db.ConnectionDb;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class Form_L extends javax.swing.JFrame {

      public Form_L() {
            initComponents();
      }

      @SuppressWarnings("unchecked")
      // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
      private void initComponents() {

            jPanel1 = new javax.swing.JPanel();
            btn_cetak = new swing.ButtonGradient();
            tanggal_1 = new com.toedter.calendar.JDateChooser();
            tanggal_2 = new com.toedter.calendar.JDateChooser();
            jLabel1 = new javax.swing.JLabel();
            jLabel3 = new javax.swing.JLabel();

            setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
            getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            jPanel1.setBackground(new java.awt.Color(255, 255, 255));
            jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

            btn_cetak.setText("Cetak");
            btn_cetak.setColor1(new java.awt.Color(93, 7, 130));
            btn_cetak.setColor2(new java.awt.Color(7, 65, 115));
            btn_cetak.addActionListener(new java.awt.event.ActionListener() {
                  public void actionPerformed(java.awt.event.ActionEvent evt) {
                        btn_cetakActionPerformed(evt);
                  }
            });
            jPanel1.add(btn_cetak, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, 180, 30));

            tanggal_1.setBackground(new java.awt.Color(255, 255, 255));
            tanggal_1.setForeground(new java.awt.Color(130, 130, 130));
            jPanel1.add(tanggal_1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 100, 180, 30));

            tanggal_2.setBackground(new java.awt.Color(255, 255, 255));
            tanggal_2.setForeground(new java.awt.Color(130, 130, 130));
            jPanel1.add(tanggal_2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 190, 180, 30));

            jLabel1.setForeground(new java.awt.Color(130, 130, 130));
            jLabel1.setText("Sampai Tanggal");
            jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 170, 120, -1));

            jLabel3.setForeground(new java.awt.Color(130, 130, 130));
            jLabel3.setText("Dari Tanggal");
            jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 80, 120, -1));

            getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 330, 390));

            pack();
            setLocationRelativeTo(null);
      }// </editor-fold>//GEN-END:initComponents

      private void btn_cetakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cetakActionPerformed
            
            Form_F form = new Form_F();
            
             try {
                  // Mendapatkan path menuju file .jasper
                  InputStream reportStream = getClass().getResourceAsStream("/com/admin/report/report1.jasper");
                  Connection conn = new ConnectionDb().connect();
                  HashMap<String, Object> param = new HashMap<>();

                 
                  if (form.cbb_filter.getSelectedItem().toString().equals("Cetak Semua")) {
                        
                        //jika kondisi tersebut terpenuhi maka kirim data berupa string kosong ke database
                        String data = "";
                        param.put("id_user", data);
                        
                        // Membuat objek SimpleDateFormat untuk mengubah format tanggal
                        SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy");
                        // Mendapatkan tanggal dari JDateChooser dalam format string
                        String dariTanggalStr = dateFormat.format(tanggal_1.getDate());
                        String sampaiTanggalStr = dateFormat.format(tanggal_2.getDate());

                        try {
                            // Mengonversi string tanggal menjadi objek Date
                            Date dariTanggal = dateFormat.parse(dariTanggalStr);
                            Date sampaiTanggal = dateFormat.parse(sampaiTanggalStr);

                            // Kemudian Anda dapat menambahkan nilai-nilai tanggal yang sudah dikonversi ke dalam parameter
                            param.put("tgl_1", dariTanggal);
                            param.put("tgl_2", sampaiTanggal);
                        } catch (ParseException e) {
                            // Tangani kesalahan jika parsing gagal
                            e.printStackTrace();
                        }

                        System.out.println(dariTanggalStr);
                        System.out.println(sampaiTanggalStr);  
                        System.out.println(form.cbb_filter);
                        JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);
                        JasperViewer.viewReport(jp, false);
                        
                  } else {
                        // Menggunakan parameter berdasarkan opsi yang dipilih
                        String selectedId = form.cbb_filter.getSelectedItem().toString();
                        // Jika selectedId null, ubah menjadi string kosong
                        selectedId = selectedId == null ? "" : selectedId;
                        param.put("id_user", selectedId);
                                               
                        // Membuat objek SimpleDateFormat untuk mengubah format tanggal
                        SimpleDateFormat dateFormat = new SimpleDateFormat("E MM/dd/yyyy");
                        // Mendapatkan tanggal dari JDateChooser dalam format string
                        String dariTanggalStr = dateFormat.format(tanggal_1.getDate());
                        String sampaiTanggalStr = dateFormat.format(tanggal_2.getDate());

                        try {
                            // Mengonversi string tanggal menjadi objek Date
                            Date dariTanggal = dateFormat.parse(dariTanggalStr);
                            Date sampaiTanggal = dateFormat.parse(sampaiTanggalStr);

                            // Kemudian Anda dapat menambahkan nilai-nilai tanggal yang sudah dikonversi ke dalam parameter
                            param.put("tgl_1", dariTanggal);
                            param.put("tgl_2", sampaiTanggal);
                        } catch (ParseException e) {
                            // Tangani kesalahan jika parsing gagal
                            e.printStackTrace();
                        }

                        System.out.println(dariTanggalStr);
                        System.out.println(sampaiTanggalStr);

                        JasperPrint jp = JasperFillManager.fillReport(reportStream, param, conn);
                        JasperViewer.viewReport(jp, false); // false untuk menutup aplikasi tanpa menutup laporan
                  }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, e);
                e.printStackTrace();
            }
            
            
      }//GEN-LAST:event_btn_cetakActionPerformed

      public static void main(String args[]) {
            FlatLightLaf.setup();
            /* Create and display the form */
            java.awt.EventQueue.invokeLater(new Runnable() {
                  public void run() {
                        new Form_L().setVisible(true);
                  }
            });
      }

      // Variables declaration - do not modify//GEN-BEGIN:variables
      private swing.ButtonGradient btn_cetak;
      private javax.swing.JLabel jLabel1;
      private javax.swing.JLabel jLabel3;
      private javax.swing.JPanel jPanel1;
      private com.toedter.calendar.JDateChooser tanggal_1;
      private com.toedter.calendar.JDateChooser tanggal_2;
      // End of variables declaration//GEN-END:variables
}
