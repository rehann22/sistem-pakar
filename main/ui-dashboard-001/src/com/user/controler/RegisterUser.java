package com.user.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import koneksi.db.ConnectionDb;

public class RegisterUser {
      
      public boolean clickRegister(String nama, String username, String password) {
            String id = autoNumber();
            boolean registrationSuccess = false; // Inisialisasi dengan nilai awal false

            if (verifyFields(nama, username, password)) {
                if (!checkUsername(username)) {
                    PreparedStatement ps;
                    String registerUserQuery = "INSERT INTO `tbl_users`(`id`, `nama`, `username`, `password`) VALUES (?,?,?,?)";

                    try {
                        Connection conn = new ConnectionDb().connect();
                        ps = conn.prepareStatement(registerUserQuery);

                        ps.setString(1, id);
                        ps.setString(2, nama);
                        ps.setString(3, username);
                        ps.setString(4, password);

                        if (ps.executeUpdate() != 0) {
                            JOptionPane.showMessageDialog(null, "Akun Anda telah dibuat");
                            registrationSuccess = true; // Registrasi berhasil, ubah nilai menjadi true
                        } else {
                            JOptionPane.showMessageDialog(null, "Terjadi kesalahan: periksa informasi Anda");
                        }

                        conn.close();
                        ps.close();

                    } catch (SQLException ex) {
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                        System.out.println("Eror Click Register");
                    }
                }
            }

            return registrationSuccess; // Kembalikan nilai boolean yang menunjukkan apakah registrasi berhasil atau tidak
        }

      
      //mengecek username apakah tersedia di database
      public boolean checkUsername(String username) {
            boolean username_exist = false; // Jika username sudah tersedia kembalikan nilai false
            String query = "SELECT * FROM `tbl_users` WHERE `username` = ?";

            try {
                Connection conn = new ConnectionDb().connect();
                PreparedStatement ps = conn.prepareStatement(query);
                ps.setString(1, username); // Atur parameter sebelum menjalankan query
                ResultSet rs = ps.executeQuery();

                if (rs.next()) {
                    username_exist = true;
                    JOptionPane.showMessageDialog(null, "Username Sudah Tersedia", "Username Failed", JOptionPane.INFORMATION_MESSAGE);
                }
                
                rs.close();
                conn.close();

            } catch (Exception ex) {
                System.out.println("Eror check username");
                System.out.println(ex);
            }

            return username_exist;
      }

      
      
      //verifikasi data tidak boleh kosong
      public boolean verifyFields (String nama, String username, String password) {
            
            if (nama.trim().equals("") || username.trim().equals("") || password.trim().equals("")) {
                  JOptionPane.showMessageDialog(null, "Data Tidak Boleh Kosong");
                  return false;
            }else {
                  return true;
            } 
            
      }
      
      
      private String autoNumber() {
            String idUsers = "Id01";

            try {
                Connection conn = new ConnectionDb().connect();
                Statement st = conn.createStatement();
                String query = "SELECT id FROM tbl_users ORDER BY id DESC LIMIT 1";
                ResultSet rs = st.executeQuery(query);

                if (rs.next()) {
                    String lastId = rs.getString("id");
                    // Mengambil bagian numerik dari ID terakhir
                    String numericPart = lastId.replaceAll("[^\\d]", ""); // Mengambil hanya angka dari string
                    int kode = Integer.parseInt(numericPart) + 1;
                    idUsers = "Id" + String.format("%02d", kode);
                }

                rs.close();
                st.close();
                conn.close();
            } catch (SQLException | NumberFormatException ex) {
                System.out.println(ex.getMessage());
            }

            return idUsers;
      }


}
