package com.user.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class TabelHasilKonsultasi {
      String logName = SessionUser.log_nama();
      String logId = SessionUser.log_idPengguna();
      private DefaultTableModel tabMode;

      public void showTable(String idPengguna, JTable tabel) {
          Object[] rows = {"Id Konsultasi", "Kode Penyakit", "Nama Penyakit", "Obat", "Tanggal"};
          tabMode = new DefaultTableModel(null, rows);
          tabel.setModel(tabMode);

          try {
              Connection conn = new ConnectionDb().connect();              
              String query = "SELECT tbl_hasil_diagnosa.id_konsultasi, tbl_hasil_diagnosa.kode_penyakit, tbl_penyakit.nama_penyakit, tbl_penyakit.obat, tbl_hasil_diagnosa.tanggal FROM tbl_hasil_diagnosa INNER JOIN tbl_penyakit ON tbl_hasil_diagnosa.kode_penyakit = tbl_penyakit.kode_penyakit WHERE tbl_hasil_diagnosa.id_user = ? ORDER BY tbl_hasil_diagnosa.tanggal DESC";
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setString(1, idPengguna);
              ResultSet rs = ps.executeQuery();

              while (rs.next()) {
                  String a = rs.getString("id_konsultasi");
                  String b = rs.getString("kode_penyakit");
                  String c = rs.getString("nama_penyakit");
                  String d = rs.getString("obat");
                  String e = rs.getString("tanggal");

                  String[] data = {a, b, c, d, e};
                  tabMode.addRow(data);
              }
              conn.close();

          } catch (SQLException e) {
              System.out.println("Error dataTabel: " + e.getMessage());
          }
          
          tabel.getColumnModel().getColumn(0).setPreferredWidth(90);
          tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
          tabel.getColumnModel().getColumn(2).setPreferredWidth(250);
          tabel.getColumnModel().getColumn(3).setPreferredWidth(250);
          tabel.getColumnModel().getColumn(4).setPreferredWidth(120);
      }
      
      public void DetailHasilKonsultasi (JTable clickTable, JTextField namaPeternak, JTextField namaPenyakit, JTextArea deskripsi, JTextArea gejala, JTextArea pencegahan, JTextField obat, JTextField tanggal) {
          try {
              int selectedRow = clickTable.getSelectedRow();
              String kodePenyakit = clickTable.getValueAt(selectedRow, 1).toString();
              System.out.println(kodePenyakit);
              Connection conn = new ConnectionDb().connect();
              String query = "SELECT tbl_hasil_diagnosa.kode_penyakit, tbl_penyakit.nama_penyakit, tbl_penyakit.deskripsi, tbl_penyakit.gejala, tbl_penyakit.pencegahan, tbl_penyakit.obat, tbl_hasil_diagnosa.tanggal FROM tbl_hasil_diagnosa INNER JOIN tbl_penyakit ON tbl_hasil_diagnosa.kode_penyakit = tbl_penyakit.kode_penyakit WHERE tbl_hasil_diagnosa.kode_penyakit = ? ";
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setString(1, kodePenyakit);
              ResultSet rs = ps.executeQuery();

              String[] data = new String[7];
              if (rs.next()) {
                  data[0] = rs.getString("kode_penyakit");
                  data[1] = rs.getString("nama_penyakit");
                  data[2] = rs.getString("deskripsi");
                  data[3] = rs.getString("gejala");
                  data[4] = rs.getString("pencegahan");
                  data[5] = rs.getString("obat");
                  data[6] = rs.getString("tanggal");
              }

              namaPeternak.setText(logName);
              namaPenyakit.setText(data[1]);

              deskripsi.setText((data[2]));
              gejala.setText((data[3]));
              pencegahan.setText((data[4]));

              obat.setText(data[5]);
              tanggal.setText(data[6]);

              conn.close();
              rs.close();

          } catch (SQLException ex) {
              System.out.println(ex);
              System.out.println("Error di displayDataOnLabel");
          }
      }      
      
      public void CariIdPenyakit (String kodePenyakit, JTable tabel, String idUSer) {
            Object[] rows = {"Id Konsultasi", "Kode Penyakit", "Nama Penyakit", "Obat", "Tanggal"};
            tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
            
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT tbl_hasil_diagnosa.id_konsultasi, tbl_hasil_diagnosa.kode_penyakit, tbl_penyakit.nama_penyakit, tbl_penyakit.obat, tbl_hasil_diagnosa.tanggal FROM tbl_hasil_diagnosa INNER JOIN tbl_penyakit ON tbl_hasil_diagnosa.kode_penyakit = tbl_penyakit.kode_penyakit WHERE tbl_hasil_diagnosa.kode_penyakit LIKE ? and tbl_hasil_diagnosa.id_user = ?";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, kodePenyakit);
                  ps.setString(2, logId); System.out.println(logId);
                  ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                        String a = rs.getString("id_konsultasi");
                        String b = rs.getString("kode_penyakit");
                        String c = rs.getString("nama_penyakit");
                        String d = rs.getString("obat");
                        String e = rs.getString("tanggal");

                        String[] data = {a, b, c, d, e};
                        tabMode.addRow(data);
                  }
                  conn.close();
                  
                        tabel.getColumnModel().getColumn(0).setPreferredWidth(90);
                        tabel.getColumnModel().getColumn(1).setPreferredWidth(100);
                        tabel.getColumnModel().getColumn(2).setPreferredWidth(250);
                        tabel.getColumnModel().getColumn(3).setPreferredWidth(250);
                        tabel.getColumnModel().getColumn(4).setPreferredWidth(120);
            } catch (SQLException e) {
                System.out.println("Error dataTabel: " + e.getMessage());
            }
      }  
      

}
