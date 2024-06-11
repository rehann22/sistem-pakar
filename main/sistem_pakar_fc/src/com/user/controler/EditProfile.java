package com.user.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import koneksi.db.ConnectionDb;

public class EditProfile {
      String logId = SessionUser.log_idPengguna();
      String logName = SessionUser.log_nama();
      
      public void EditDataUsers (JTextField id, JTextField nama, JTextField username, JTextField password) {
            try {
                  Connection conn = new ConnectionDb().connect();
                  String query = "UPDATE `tbl_users` SET `nama`=?, `username`=?, `password`=? WHERE `id`=?";
                  PreparedStatement st = conn.prepareStatement(query);
                  st.setString(1, nama.getText());
                  st.setString(2, username.getText());
                  st.setString(3, password.getText());
                  st.setString(4, id.getText());
                  st.executeUpdate();
                  
                  JOptionPane.showMessageDialog(null, "Data Pengguna Berhasil Diubah");
                  tampiDataUser(id, nama, username, password);
            } catch (SQLException ex) {
                  System.out.println("Eror edit data user\n" + ex);
            }
      }
     
      
      public void tampiDataUser (JTextField id, JTextField nama, JTextField username, JTextField password) {
            try {
                  
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM `tbl_users` WHERE `id` = ? ";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, logId);
                  ResultSet rs = ps.executeQuery();

              String[] data = new String[4];
              if (rs.next()) {
                  data[0] = rs.getString("id");
                  data[1] = rs.getString("nama");
                  data[2] = rs.getString("username");
                  data[3] = rs.getString("password");
              }
              
              id.setText(data[0]);
              nama.setText(data[1]);
              username.setText((data[2]));
              password.setText((data[3]));
              
              conn.close();
              rs.close();
                  
            } catch (SQLException ex) {
                  System.out.println("Eror Form Data Pengguna\n" + ex );
            }
      }
}
