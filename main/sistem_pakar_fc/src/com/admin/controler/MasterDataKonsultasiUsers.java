package com.admin.controler;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class MasterDataKonsultasiUsers {
      DefaultTableModel tabMode;
      
      public void tampilDataKonsultasiUsers (JTable tabel) {
            Object[] rows = {"Id Pengguna", "Nama", "Kode Konsultasi","Kode Penyakit", "Nama Penyakit", "Tanggal"};
            tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);
         
           try {
               Connection conn = new ConnectionDb().connect();
               String query = "SELECT tbl_hasil_diagnosa.id_user, tbl_users.nama, tbl_hasil_diagnosa.id_konsultasi, tbl_hasil_diagnosa.kode_penyakit, tbl_penyakit.nama_penyakit, tbl_hasil_diagnosa.tanggal FROM ((tbl_hasil_diagnosa INNER JOIN tbl_users ON tbl_hasil_diagnosa.id_user = tbl_users.id) INNER JOIN tbl_penyakit ON tbl_hasil_diagnosa.kode_penyakit = tbl_penyakit.kode_penyakit)";
               PreparedStatement ps = conn.prepareStatement(query);
               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   String a = rs.getString("id_user");
                   String b = rs.getString("nama");
                   String c = rs.getString("id_konsultasi");
                   String d = rs.getString("kode_penyakit");
                   String e = rs.getString("nama_penyakit");
                   String f = rs.getString("tanggal");
                   
                   String[] data = {a, b, c, d, e, f};
                   tabMode.addRow(data);
               }
               conn.close();

           } catch (SQLException e) {
               System.out.println("Error tabel konsultasi users: " + e.getMessage());
           }
           
      }
      
      public void tampilDataFilterUser(JTable tabel, String idUser) {
            Object[] rows = {"Id Pengguna", "Nama", "Kode Konsultasi", "Kode Penyakit", "Nama Penyakit", "Tanggal"};
            tabMode = new DefaultTableModel(null, rows);
            tabel.setModel(tabMode);

            try {
                Connection conn = new ConnectionDb().connect();
                // Ubah query untuk memfilter berdasarkan nama pengguna
                String query = "SELECT tbl_hasil_diagnosa.id_user, tbl_users.nama, tbl_hasil_diagnosa.id_konsultasi, tbl_hasil_diagnosa.kode_penyakit, tbl_penyakit.nama_penyakit, tbl_hasil_diagnosa.tanggal " +
                               "FROM ((tbl_hasil_diagnosa INNER JOIN tbl_users ON tbl_hasil_diagnosa.id_user = tbl_users.id) INNER JOIN tbl_penyakit ON tbl_hasil_diagnosa.kode_penyakit = tbl_penyakit.kode_penyakit) " +
                               "WHERE tbl_users.id = ?";
                PreparedStatement ps = conn.prepareStatement(query);
                // Masukkan parameter nama pengguna
                ps.setString(1, idUser);
                ResultSet rs = ps.executeQuery();

                while (rs.next()) {
                    String a = rs.getString("id_user");
                    String b = rs.getString("nama");
                    String c = rs.getString("id_konsultasi");
                    String d = rs.getString("kode_penyakit");
                    String e = rs.getString("nama_penyakit");
                    String f = rs.getString("tanggal");

                    String[] data = {a, b, c, d, e, f};
                    tabMode.addRow(data);
                }
                conn.close();

            } catch (SQLException e) {
                System.out.println("Error tabel konsultasi users: " + e.getMessage());
            }

}

      //menampilkan kode penyakit ke combobox
      
      public void TampilIdUsers(JComboBox idUser) {
            try {
                idUser.removeAllItems(); // Hapus semua item sebelum menambahkan yang baru
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT * FROM `tbl_users` ORDER BY id";
                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery();

                //idUser.addItem(null);
                idUser.addItem("Cetak Semua");

                while (rs.next()) {
                    idUser.addItem(rs.getString("id"));
                }

                rs.close();
                conn.close();

                idUser.setSelectedItem("Cetak Semua"); 
            } catch (SQLException ex) {
                System.out.println(ex);
                System.out.println("Eror tampil id user");
            }
      }

     
      
      public void pilihIdUser(JTable tabelKonsultasiUsers, JComboBox cbb_idUser) {
            int index = cbb_idUser.getSelectedIndex();

            switch (index) {
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                      tampilDataFilterUser(tabelKonsultasiUsers, cbb_idUser.getSelectedItem().toString());
                    break;
                default:
                      MasterDataKonsultasiUsers dataKonsultasi = new MasterDataKonsultasiUsers();
                      dataKonsultasi.tampilDataKonsultasiUsers(tabelKonsultasiUsers);
                    break;
            }
      }    

     
}
