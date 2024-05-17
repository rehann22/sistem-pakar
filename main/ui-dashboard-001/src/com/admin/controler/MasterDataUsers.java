package com.admin.controler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class MasterDataUsers {
      DefaultTableModel tabMode;
      
      public void tampilDataUsers (JTable tabel) {
            Object[] rows = {"Id", "Nama", "Username","Password"};
            tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
         
           try {
               Connection conn = new ConnectionDb().connect();
               String query = "SELECT * FROM tbl_users";
               PreparedStatement ps = conn.prepareStatement(query);
               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   String a = rs.getString("id");
                   String b = rs.getString("nama");
                   String c = rs.getString("username");
                   String d = rs.getString("password");
                   
                   String[] data = {a, b, c, d};
                   tabMode.addRow(data);
               }
               conn.close();

           } catch (SQLException e) {
               System.out.println("Error tabel users: " + e.getMessage());
           }
      }
      
      public void EditDataUsers (JTable tabel, JTextField id, JTextField nama, JTextField username, JTextField password) {
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
                  nama.setText("");
                  username.setText("");
                  password.setText("");
                  id.setText("");
                  
                  tampilDataUsers(tabel);
            } catch (SQLException ex) {
                  System.out.println("Eror edit data user\n" + ex);
            }
      }
      
      public void FormDataPengguna (JTable tabel, JTextField id, JTextField nama, JTextField username, JTextField password) {
            try {
                  int selectedRow = tabel.getSelectedRow();
                  String idUser = tabel.getValueAt(selectedRow, 0).toString();
                  System.out.println(idUser);
                  
                  Connection conn = new ConnectionDb().connect();
                  String query = "SELECT * FROM `tbl_users` WHERE `id` = ? ";
                  PreparedStatement ps = conn.prepareStatement(query);
                  ps.setString(1, idUser);
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

