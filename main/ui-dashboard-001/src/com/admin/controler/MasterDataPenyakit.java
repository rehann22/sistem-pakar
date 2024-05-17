package com.admin.controler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import koneksi.db.ConnectionDb;

public class MasterDataPenyakit {
      private DefaultTableModel tabMode;
      
      public void clearForm (JTextField kodePenyakit, JTextField namaPenyakit, JTextArea deskripsi, JTextArea gejala, JTextArea pencegahan, JTextField obat) {
            kodePenyakit.setText("");
            namaPenyakit.setText("");
            deskripsi.setText("");
            gejala.setText("");
            pencegahan.setText("");
            obat.setText("");
      }
      
      public void autoNumber(JTextField kodePeny) {
            try {
                Connection conn = new ConnectionDb().connect();
                String query = "SELECT kode_penyakit FROM tbl_penyakit ORDER BY kode_penyakit DESC LIMIT 1";
                PreparedStatement st = conn.prepareStatement(query);
                ResultSet rs = st.executeQuery(query);
                
                String kodePenyakit = "P01";
                if (rs.next()) {
                    kodePenyakit = rs.getString("kode_penyakit");
                    int kode = Integer.parseInt(kodePenyakit.substring(1)) + 1;
                    kodePenyakit = String.format("P%02d", kode);
                }
                
                kodePeny.setText(kodePenyakit);
               
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
      }
      
      public void setFocusToNamaPenyakit(JTextField namaPenyakit) {
            namaPenyakit.requestFocusInWindow();
      }
      
      public void simpanDataPenyakit (JTable tabel, JTextField kodePenyakit, JTextField namaPenyakit, JTextArea deskripsi, JTextArea gejala, JTextArea pencegahan, JTextField obat) {
            
            if (!kodePenyakit.getText().isEmpty() && !namaPenyakit.getText().isEmpty() && !deskripsi.getText().isEmpty() && !pencegahan.getText().isEmpty() && !obat.getText().isEmpty() && !gejala.getText().isEmpty()) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "INSERT INTO tbl_penyakit values (?,?,?,?,?,?)";
                        PreparedStatement st = conn.prepareStatement(query);
                        st.setString(1, kodePenyakit.getText());
                        st.setString(2, namaPenyakit.getText());
                        st.setString(3, deskripsi.getText());
                        st.setString(4, gejala.getText());
                        st.setString(5,pencegahan.getText());
                        st.setString(6, obat.getText());
                        st.executeUpdate();
                        
                        JOptionPane.showMessageDialog(null, "Data Tersimpan");
                        showTable(tabel);
                        clearForm(kodePenyakit, namaPenyakit, deskripsi, gejala, pencegahan, obat);
                        autoNumber(kodePenyakit);
                        namaPenyakit.requestFocus();
                        conn.close();
                        st.close();
                        
                  }catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Gagal Menyimpan Data");
                  }
            }else {
                  JOptionPane.showMessageDialog(null, "Data tidak boleh kosong");
            }
      }
      
      public void editDataPenyakit (JTable tabel, JTextField kodePenyakit, JTextField namaPenyakit, JTextArea deskripsi, JTextArea gejala, JTextArea pencegahan, JTextField obat) { 
            try {
                  
                  Connection conn = new ConnectionDb().connect();
                  String query = "UPDATE `tbl_penyakit` SET `nama_penyakit`=?, `deskripsi`=?, `gejala`=?, `pencegahan`=?, `obat`=? WHERE `kode_penyakit`=?";
                  PreparedStatement st = conn.prepareStatement(query);
                  
                  st.setString(1, namaPenyakit.getText());
                  st.setString(2, deskripsi.getText());
                  st.setString(3, gejala.getText());
                  st.setString(4,pencegahan.getText());
                  st.setString(5, obat.getText());
                  st.setString(6, kodePenyakit.getText());

                  st.executeUpdate();
                  JOptionPane.showMessageDialog(null, "Data Terubah");
                  clearForm(kodePenyakit, namaPenyakit, deskripsi, gejala, pencegahan, obat);
                  namaPenyakit.requestFocus();
                  showTable(tabel);
                  autoNumber(kodePenyakit);
                  
            } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Data gagal diubah");
                  System.out.println(ex);
            }
            
      }
      
      public void hapusPenyakit (JTable clickTable, JTextField kodePeny){
            int selectedRow = clickTable.getSelectedRow();
            String kodePenyakit = clickTable.getValueAt(selectedRow, 0).toString();
            System.out.println(kodePenyakit);
            
            int ok = JOptionPane.showConfirmDialog(null, "Hapus Data Penyakit", "Konfirmasi dialog",
                  JOptionPane.YES_NO_CANCEL_OPTION);
            if (ok==0) {
                  try {
                        Connection conn = new ConnectionDb().connect();
                        String query = "DELETE FROM `tbl_penyakit` WHERE `kode_penyakit`= ?";
                        PreparedStatement st = conn.prepareStatement(query);
                        
                        st.setString(1, kodePenyakit);
                        
                        st.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Data Terhapus");
                        showTable(clickTable);
                        autoNumber(kodePeny);

                  } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Data gagal dihapus");
                  }
            }
      }
      
      public void tampilFormEditPenyakit (JTable clickTable, JTextField kodePeny, JTextField namaPenyakit, JTextArea deskripsi, JTextArea gejala, JTextArea pencegahan, JTextField obat ) {
            try {
              int selectedRow = clickTable.getSelectedRow();
              String kodePenyakit = clickTable.getValueAt(selectedRow, 0).toString();
              System.out.println(kodePenyakit);
              
              Connection conn = new ConnectionDb().connect();
              String query = "SELECT * FROM `tbl_penyakit` WHERE `kode_penyakit` = ? ";
              PreparedStatement ps = conn.prepareStatement(query);
              ps.setString(1, kodePenyakit);
              ResultSet rs = ps.executeQuery();

              String[] data = new String[6];
              if (rs.next()) {
                  data[0] = rs.getString("kode_penyakit");
                  data[1] = rs.getString("nama_penyakit");
                  data[2] = rs.getString("deskripsi");
                  data[3] = rs.getString("gejala");
                  data[4] = rs.getString("pencegahan");
                  data[5] = rs.getString("obat");
              }
              
              kodePeny.setText(data[0]);
              namaPenyakit.setText(data[1]);
              deskripsi.setText((data[2]));
              gejala.setText((data[3]));
              pencegahan.setText((data[4]));
              obat.setText(data[5]);
              
              //tabPane.setSelectedIndex(6);
              conn.close();
              rs.close();

          } catch (SQLException ex) {
              System.out.println(ex);
              System.out.println("Error di displayDataOnLabel");
          }
      }
      
      
      public void showTable(JTable tabel) {
         Object[] rows = {"Kode Penyakit", "Nama Penyakit", "Deskripsi","Gejala", "Pencegahan", "Obat"};
         tabMode = new DefaultTableModel(null, rows);
         tabel.setModel(tabMode);
         
           try {
               Connection conn = new ConnectionDb().connect();
               String query = "SELECT * FROM tbl_penyakit";
               PreparedStatement ps = conn.prepareStatement(query);
               ResultSet rs = ps.executeQuery();

               while (rs.next()) {
                   String a = rs.getString("kode_penyakit");
                   String b = rs.getString("nama_penyakit");
                   String c = rs.getString("deskripsi");
                   String d = rs.getString("gejala");
                   String e = rs.getString("pencegahan");
                   String f = rs.getString("obat");

                   String[] data = {a, b, c, d, e, f};
                   tabMode.addRow(data);
               }
               conn.close();

           } catch (SQLException e) {
               System.out.println("Error dataTabel: " + e.getMessage());
           }
      }
      
}