package com.admin.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class Dashboard {
      public DefaultTableModel tabMode;

      public int totalPenyakit() {
          int total = 0; // Inisialisasi total
          try {
              Connection conn = new ConnectionDb().connect();
              String query = "SELECT COUNT(*) AS total_data FROM tbl_penyakit";
              PreparedStatement st = conn.prepareStatement(query);
              ResultSet rs = st.executeQuery();
              if (rs.next()) {
                  total = rs.getInt("total_data");
              }
              rs.close(); // Tutup ResultSet
              st.close(); // Tutup PreparedStatement
              conn.close(); // Pastikan untuk menutup koneksi setelah selesai
          } catch (Exception ex) {
              ex.printStackTrace();
          }
          return total;
      }


      
      public int totalGejala () {
            int totalG = 0 ;
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT COUNT(*) AS total_data FROM tbl_gejala";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  if (rs.next()) {
                        totalG = rs.getInt("total_data");
                  }
                  conn.close(); // Pastikan untuk menutup koneksi setelah selesai
            } catch (Exception ex) {
              ex.printStackTrace();
            }
            return totalG;
      }
      
      public int totalRule() {
            int totalData = 0 ;
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT COUNT(*) AS total_data FROM tbl_gejalapenyakit";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  if (rs.next()) {
                      totalData = rs.getInt("total_data");
                  }
                  conn.close(); // Pastikan untuk menutup koneksi setelah selesai
            } catch (Exception ex) {
              ex.printStackTrace();
            }
            return totalData;
      }
      
      public int totalUser () {
            int totalData = 0;
                  try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT COUNT(*) AS total_data FROM tbl_users";
                  PreparedStatement st = conn.prepareStatement(query);
                  ResultSet rs = st.executeQuery();
                  if (rs.next()) {
                      totalData = rs.getInt("total_data");
                  }
                  conn.close(); // Pastikan untuk menutup koneksi setelah selesai
            } catch (Exception ex) {
              ex.printStackTrace();
            } 
            return totalData;
      }
      
      public void tabelDashboard (JTable tabel) {
            Object[] rows = {"Nama Penyakit", "Total Ikan Terjangkit"};
            tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
            try {
                  Connection conn = new ConnectionDb().connect();
            String query = "SELECT tbl_hasil_diagnosa.kode_penyakit,\n" +
                "tbl_penyakit.nama_penyakit,\n" +
                "COUNT(DISTINCT tbl_hasil_diagnosa.id_konsultasi) AS total_ikan_terjangkit\n" +
                "FROM tbl_hasil_diagnosa\n" +
                "INNER JOIN tbl_penyakit ON tbl_hasil_diagnosa.kode_penyakit = tbl_penyakit.kode_penyakit\n" +
                "GROUP BY tbl_hasil_diagnosa.kode_penyakit, tbl_penyakit.nama_penyakit\n" +
                "ORDER BY total_ikan_terjangkit DESC";

                  PreparedStatement ps = conn.prepareStatement(query);
                  ResultSet rs = ps.executeQuery();

                  while (rs.next()) {
                        //String a = rs.getString("kode_penyakit");
                        String a = rs.getString("nama_penyakit");
                        String b = rs.getString("total_ikan_terjangkit");

                        String[] data = {a, b};
                        tabMode.addRow(data);
               }
               conn.close();
            } catch (Exception e) {
                  System.out.println("eror tabel dashboard");
                  e.printStackTrace();
   
            }
      }
      
}
