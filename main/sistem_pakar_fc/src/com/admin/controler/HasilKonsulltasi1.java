package com.admin.controler;

import com.user.controler.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import koneksi.db.ConnectionDb;

public class HasilKonsulltasi1 {
      
      public String autoNumber() {
            String idKonsultasi = "K";
                  try {
                      Connection conn = new ConnectionDb().connect();
                      Statement st = conn.createStatement();
                      String query = "SELECT COUNT(*) AS total_data FROM tbl_hasil_diagnosa;";
                      ResultSet rs = st.executeQuery(query);

                        if (rs.next()) {
                            int totalData = rs.getInt("total_data");
                            System.out.println("Total data: " + totalData);  // Debug
                            int kode = totalData + 1;
                            idKonsultasi = "K" + kode;
                            System.out.println("ID baru: " + idKonsultasi);  // Debug
                        }

                      rs.close();
                      st.close();
                      conn.close();
                  } catch (Exception ex) {
                      System.out.println(ex.getMessage());
                  }
                return idKonsultasi;
      }

      public void simpanHasilKonsultasi(String id, JTextField kodePenyakit) {
          String idKonsultasi = autoNumber();

            try {
                Connection conn = new ConnectionDb().connect();
                String query = "INSERT INTO tbl_hasil_diagnosa VALUES (?,?,?,NOW())";
                PreparedStatement st = conn.prepareStatement(query);

                st.setString(1, id);
                st.setString(2, idKonsultasi);
                st.setString(3, kodePenyakit.getText());
                st.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data Konsultasi Berhasil Disimpan");

                st.close();
                conn.close();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            System.out.println(idKonsultasi);
      }
      
      
}
